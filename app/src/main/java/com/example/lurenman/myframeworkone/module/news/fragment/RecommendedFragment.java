package com.example.lurenman.myframeworkone.module.news.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.lurenman.myframeworkone.MyFrameApp;
import com.example.lurenman.myframeworkone.R;
import com.example.lurenman.myframeworkone.base.BaseFragment;
import com.example.lurenman.myframeworkone.constants.Constant;
import com.example.lurenman.myframeworkone.model.entities.RefreshRecommendEntity;
import com.example.lurenman.myframeworkone.module.news.activity.NewsWebViewActivity;
import com.example.lurenman.myframeworkone.module.news.adapter.RecommendAdapter;
import com.example.lurenman.myframeworkone.module.news.presenter.NewsRecommendPresenter;
import com.example.lurenman.myframeworkone.module.news.viewmodel.INewsRecommendView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: baiyang.
 * Created on 2017/11/29.
 */

public class RecommendedFragment extends BaseFragment<NewsRecommendPresenter> implements INewsRecommendView {
    private static final String TAG = "RecommendedFragment";
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private RecommendAdapter mRecommendAdapter;
    private List<RefreshRecommendEntity.DataBean> mDataLists = new ArrayList<>();//请求返回的实体集合

    @Override
    protected NewsRecommendPresenter createPresenter() {
        return new NewsRecommendPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_recommended;
    }

    @Override
    protected void initViews(View rootView) {
        mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipeLayout);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.pf_RecyclerView);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 100, 223));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
    }

    @Override
    protected void initVariables() {
        mRecommendAdapter = new RecommendAdapter(R.layout.rv_item_recommend, mDataLists);
        mRecyclerView.setAdapter(mRecommendAdapter);
    }

    @Override
    protected void initEnvent() {
        super.initEnvent();
        //刷新
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.pageIndex = 0;
                mPresenter.pageSize = 5;
                referesh();
            }
        });
        //加载更多
        mRecommendAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.pageIndex++;
                LoadMore();
            }
        });
        mRecommendAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                RefreshRecommendEntity.DataBean adapterItem = (RefreshRecommendEntity.DataBean) adapter.getItem(position);
                Intent intent = new Intent(getActivity(), NewsWebViewActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("webViewUrl", Constant.HTTPURL_NEWDETAIL +adapterItem.getFID());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void loadData() {
        //第一看到的时候调用刷新功能
        mSwipeRefreshLayout.setRefreshing(true);//这个东西第一次就是显示用的
        // mPresenter.getNetData();
        referesh();
    }

    private void referesh() {
        //逻辑层请求数据
       // mRecommendAdapter.setEnableLoadMore(false);//这里的作用是防止下拉刷新的时候还可以上拉加载
        mPresenter.getNetData(NewsRecommendPresenter.REFFESH);
    }

    private void LoadMore() {
        mPresenter.getNetData(NewsRecommendPresenter.LOAD);
    }

    @Override
    public void onGetSuccess(RefreshRecommendEntity refreshRecommendEntity, int state) {
        Log.e(TAG, "onGetSuccess: " + refreshRecommendEntity.toString());

        switch (state) {
            case NewsRecommendPresenter.REFFESH:
                if (refreshRecommendEntity != null) {    //获取成功
                    if (refreshRecommendEntity.getResultCode() == 200) {
                        List<RefreshRecommendEntity.DataBean> data = refreshRecommendEntity.getData();
                        if (data != null && !data.isEmpty()) {
                            //当有数据的时候在clear一下 用户体验
                            mDataLists.clear();
                            mDataLists.addAll(data);
                        }
                    } else {
                        //这块可以返回服务器的返回信息等
                        Toast.makeText(MyFrameApp.mContext, "服务器返回异常", Toast.LENGTH_SHORT).show();
                    }
                }
                mRecommendAdapter.setNewData(mDataLists);
               // mRecommendAdapter.setEnableLoadMore(true);//恢复加载更多功能
                mSwipeRefreshLayout.setRefreshing(false);
                break;
            //加载更多的状态
            case NewsRecommendPresenter.LOAD:
                if (refreshRecommendEntity != null) {
                    if (refreshRecommendEntity.getResultCode() == 200) {
                        List<RefreshRecommendEntity.DataBean> data = refreshRecommendEntity.getData();
                        if (data != null && !data.isEmpty()) {
                            //用这个添加数据不要用mDataLists.addAll(data)这个，否则会造成数据混乱
                            mRecommendAdapter.addData(data);
                            if (data.size() < mPresenter.pageSize) {
                                mRecommendAdapter.loadMoreEnd(false);//如果数据不够5条了就显示没有更多数据了
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(MyFrameApp.mContext, "没有更多数据了", Toast.LENGTH_SHORT).show();
                                    }
                                }, 500);

                            } else {
                                mRecommendAdapter.loadMoreComplete();
                            }
                        }
                    } else {
                        //这块可以返回服务器的返回信息等
                        Toast.makeText(MyFrameApp.mContext, "服务器返回异常", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "onError: " + e.getMessage());
        mSwipeRefreshLayout.setRefreshing(false);
        mRecommendAdapter.setEnableLoadMore(true);//恢复加载更多功能
    }
}
