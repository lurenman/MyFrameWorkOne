package com.example.lurenman.myframeworkone.module.news.viewmodel;

import com.example.lurenman.myframeworkone.model.entities.RefreshRecommendEntity;

/**
 * @author: baiyang.
 * Created on 2017/11/30.
 */

public interface INewsRecommendView {
    //state这个是刷新状态还是加载状态
    void onGetSuccess(RefreshRecommendEntity entity,int state);

    void onError(Throwable e);
}
