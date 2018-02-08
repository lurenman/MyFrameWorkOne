package com.example.lurenman.myframeworkone.model.api;

import com.example.lurenman.myframeworkone.BuildConfig;
import com.example.lurenman.myframeworkone.MyFrameApp;
import com.example.lurenman.myframeworkone.utils.NetWorkUtils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 缓存处理参照
 * https://github.com/hytcyjb/yjboretrofitcsdndemo
 * 下面HTTP 504 Unsatisfiable Request (only-if-cached) 这个错误需要服务器配合
 * https://www.jianshu.com/p/b1979c25634f
 */
public class DAL {
    private BaseAPIService baseAPIService;
    private final String BASE_URL="http://admin.hkshijue.com/";
   //private final String BASE_URL="http://lbs.sougu.net.cn/";
    private static final class Holder {
        private static final DAL INSTANCE = new DAL();
    }
    public static DAL getInstance() {
        return Holder.INSTANCE;
    }
    private static final Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = chain -> {

        Request request = chain.request();
        if (!NetWorkUtils.isNetworkAvailable(MyFrameApp.mContext)) {
            //此处设置过期时间为t(s);t（s）之前获取在线时缓存的信息(此处t=60)，t（s）之后就不获取了
            //这是设置在多长时间范围内获取缓存里面
//            CacheControl FORCE_CACHE1 = new CacheControl.Builder()
//                    .onlyIfCached()
//                    .maxStale(60, TimeUnit.SECONDS)//CacheControl.FORCE_CACHE--是int型最大值
//                    .build();
//            request = request.newBuilder()
//                    .cacheControl(FORCE_CACHE1)//此处设置了t秒---修改了系统方法
//                    .build();
            //无网时一直请求有网请求好的缓存数据，不设置过期时间
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
        }

        Response response = chain.proceed(request);

        if (NetWorkUtils.isNetworkAvailable(MyFrameApp.mContext)) {
            /**
             * If you have problems in testing on which side is problem (server or app).
             * You can use such feauture to set headers received from server.
             */
         //   int maxAge = 60 * 60; // 有网络时,设置缓存超时时间1个小时
            int maxAge = 0; // 0代表实时获取数据
            response = response.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    .header("Cache-Control", "public, max-age=" + maxAge)//设置缓存超时时间
                    .build();
        } else {
            int maxStale =60 * 60 * 24 * 28;//无网络时，设置超时为4周
            response = response.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .build();
        }
        return response;
    };
    public BaseAPIService baseAPIService() {
        if (baseAPIService == null) {
            File httpCacheDirectory = new File(MyFrameApp.mContext.getExternalCacheDir(), "responses");
            Cache cache = new Cache(httpCacheDirectory, 10 * 1024 * 1024);//缓存10MB
            OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
            httpClientBuilder.cache(cache);//设置缓存
            httpClientBuilder.connectTimeout(60, TimeUnit.SECONDS);
            httpClientBuilder.readTimeout(60, TimeUnit.SECONDS);
            httpClientBuilder.writeTimeout(60, TimeUnit.SECONDS);
            //没网络时的拦截器
            httpClientBuilder.addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR);
            //有网络时的拦截器
            httpClientBuilder.addNetworkInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR);
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                httpClientBuilder.interceptors().add(interceptor);
            }
            Retrofit retrofit = new Retrofit.Builder()
                    .client(httpClientBuilder.build())
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//支持RxJava
                    .build();
            baseAPIService = retrofit.create(BaseAPIService.class);
        }
        return baseAPIService;
    }
}

