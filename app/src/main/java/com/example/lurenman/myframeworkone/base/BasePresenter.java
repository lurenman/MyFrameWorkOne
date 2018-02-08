package com.example.lurenman.myframeworkone.base;

import android.widget.Toast;

import com.example.lurenman.myframeworkone.MyFrameApp;
import com.example.lurenman.myframeworkone.model.api.BaseAPIService;
import com.example.lurenman.myframeworkone.model.api.DAL;
import com.example.lurenman.myframeworkone.utils.NetWorkUtils;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * @author: baiyang.
 * Created on 2017/11/28.
 */

public class BasePresenter<V> {
    //供子类用的APIService
    protected BaseAPIService mAPIService = DAL.getInstance().baseAPIService();
    protected V mView;
    private CompositeSubscription mCompositeSubscription;

    public BasePresenter(V view) {
        attachView(view);
    }

    //这块把mvp 中的view层接口传过来
    public void attachView(V view) {
        mView = view;
    }

    public void detachView() {
        mView = null;
        onUnsubscribe();
    }


/*      这块统一rxjava请求添加到CompositeSubscription中
      注意 .subscribeOn(Schedulers.io()) */

    public void rxjavaRequestApi(Observable observable, Subscriber subscriber) {
        //
        if (!NetWorkUtils.isNetworkAvailable(MyFrameApp.mContext)) {
            //网络不可用弹出提示
            Toast.makeText(MyFrameApp.mContext, "网络不可用", Toast.LENGTH_SHORT).show();
           // return;
        }
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }

    //RXjava取消注册，以避免内存泄露
    public void onUnsubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }
}
