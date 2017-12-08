package com.example.lurenman.myframeworkone.module.news.fragment;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.example.lurenman.myframeworkone.R;
import com.example.lurenman.myframeworkone.base.BaseFragment;
import com.example.lurenman.myframeworkone.base.BasePresenter;
import com.example.lurenman.myframeworkone.views.ColorFlipPagerTitleView;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

/**
 * @author: baiyang.
 * Created on 2017/11/28.
 */

public class NewsFragment extends BaseFragment{
    private static final String TAG = "NewsFragment";
    private String[] mTitle;
    private MagicIndicator magicIndicator;
    private ViewPager mViewPager;
    private FragmentAdapter mFragmentAdapter;


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initViews(View rootView) {
        magicIndicator = (MagicIndicator) rootView.findViewById(R.id.magic_indicator);
        mViewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
    }

    @Override
    protected void initVariables() {
        mTitle= new String[]{"推荐", "娱乐", "视频", "直播", "图片", "段子", "游戏", "精华", "关注"};
      //  mFragmentAdapter=new FragmentAdapter(getActivity().getSupportFragmentManager());
        mFragmentAdapter=new FragmentAdapter(this.getChildFragmentManager());
        mViewPager.setAdapter(mFragmentAdapter);
    }

    @Override
    protected void initEnvent() {
        super.initEnvent();
        initIndicator();



    }
    //初始化magicIndicator
    private void initIndicator() {
        magicIndicator.setBackgroundColor(Color.parseColor("#fafafa"));
        CommonNavigator commonNavigator = new CommonNavigator(mActivity);
        commonNavigator.setScrollPivotX(0.65f);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mTitle == null ? 0 : mTitle.length;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                SimplePagerTitleView simplePagerTitleView = new ColorFlipPagerTitleView(context);
                simplePagerTitleView.setText(mTitle[index]);
                simplePagerTitleView.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
                simplePagerTitleView.setNormalColor(Color.parseColor("#9e9e9e"));
                simplePagerTitleView.setSelectedColor(getResources().getColor(R.color.textBlack));
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mViewPager.setCurrentItem(index);
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setMode(LinePagerIndicator.MODE_EXACTLY);
                indicator.setLineHeight(UIUtil.dip2px(context, 3));
                indicator.setLineWidth(UIUtil.dip2px(context, 14));
                indicator.setRoundRadius(UIUtil.dip2px(context, 3));
                indicator.setStartInterpolator(new AccelerateInterpolator());
                indicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
                indicator.setColors(getResources().getColor(R.color.colorPrimary));
                return indicator;
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, mViewPager);
    }


    @Override
    protected void loadData() {
        //请求网络数据

    }



    private class FragmentAdapter extends FragmentStatePagerAdapter {
        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    RecommendedFragment recommendedFragment = new RecommendedFragment();
                    return recommendedFragment;
                default:
                    NewsPublicFragment newsPublicFragment = new NewsPublicFragment();
                    return newsPublicFragment;
            }

        }

        @Override
        public int getCount() {
            return mTitle.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return mTitle[position];
        }
    }
}
