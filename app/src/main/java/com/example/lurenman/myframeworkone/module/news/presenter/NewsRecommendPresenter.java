package com.example.lurenman.myframeworkone.module.news.presenter;

import android.util.Log;

import com.example.lurenman.myframeworkone.base.BasePresenter;
import com.example.lurenman.myframeworkone.model.entities.RefreshRecommendEntity;
import com.example.lurenman.myframeworkone.module.news.viewmodel.INewsRecommendView;

import rx.Subscriber;

/**
 * @author: baiyang.
 * Created on 2017/11/30.
 */

public class NewsRecommendPresenter extends BasePresenter<INewsRecommendView> {
    private static final String TAG = "NewsRecommendPresenter";
    public int pageIndex = 0;//请求的页数索引
    public int pageSize = 5;//每页请求的size
    public static final int REFFESH = 1;
    public static final int LOAD = 2;

    public NewsRecommendPresenter(INewsRecommendView view) {
        super(view);
    }

    public void getNetData(final int state) {
        rxjavaRequestApi(mAPIService.getRefreshRecommended(Integer.toString(pageIndex), Integer.toString(pageSize)), new Subscriber<RefreshRecommendEntity>() {
            @Override
            public void onCompleted() {
                Log.e(TAG, "onCompleted:------- ");
            }

            @Override
            public void onError(Throwable e) {
                mView.onError(e);
            }

            @Override
            public void onNext(RefreshRecommendEntity entity) {
                mView.onGetSuccess(entity, state);
            }
        });
    }
}
