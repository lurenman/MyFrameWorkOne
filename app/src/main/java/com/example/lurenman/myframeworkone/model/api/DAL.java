package com.example.lurenman.myframeworkone.model.api;

import com.example.lurenman.myframeworkone.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DAL {
    private BaseAPIService baseAPIService;
    private final String BASE_URL="http://admin.hkshijue.com/";
    private static final class Holder {
        private static final DAL INSTANCE = new DAL();
    }
    public static DAL getInstance() {
        return Holder.INSTANCE;
    }

    public BaseAPIService baseAPIService() {
        if (baseAPIService == null) {
            OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
            httpClientBuilder.connectTimeout(60, TimeUnit.SECONDS);
            httpClientBuilder.readTimeout(60, TimeUnit.SECONDS);
            httpClientBuilder.writeTimeout(60, TimeUnit.SECONDS);
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

