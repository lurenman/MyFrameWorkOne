package com.example.lurenman.myframeworkone.module.news.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lurenman.myframeworkone.R;
import com.example.lurenman.myframeworkone.model.entities.RefreshRecommendEntity;
import com.example.lurenman.myframeworkone.utils.Env;

import java.util.List;

/**
 * @author: baiyang.
 * Created on 2017/11/30.
 */

public class RecommendAdapter extends BaseQuickAdapter<RefreshRecommendEntity.DataBean,BaseViewHolder> {
    public RecommendAdapter(int layoutResId, @Nullable List<RefreshRecommendEntity.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RefreshRecommendEntity.DataBean item) {
        String FID = TextUtils.isEmpty(item.getFID()) ? "" : item.getFID();
        String Name = TextUtils.isEmpty(item.getTitle()) ? "" : item.getTitle();
        String ReleaseTime = TextUtils.isEmpty(item.getReleaseTime()) ? "" : item.getReleaseTime();
        String Image=TextUtils.isEmpty(item.getImage()) ? "" : item.getImage();
        String classificationName=TextUtils.isEmpty(item.getClassificationName()) ? "" : item.getClassificationName();
        int Number = item.getNumber();
        helper.setText(R.id.tv_title,Name);
        helper.setText(R.id.tv_looknum,Number + "");
        helper.setText(R.id.tv_time, Env.timeConvertDescribe(ReleaseTime));
        helper.setText(R.id.tv_classificationName,classificationName);
        ImageView imageView =(ImageView) helper.getView(R.id.iv_img);
        Glide.with(mContext).load(Image).centerCrop()
                .placeholder(R.drawable.defaultimg).error(R.drawable.defaultimg).into(imageView);

    }
}
