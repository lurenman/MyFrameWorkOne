package com.example.lurenman.myframeworkone.module.software.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.lurenman.myframeworkone.R;
import com.example.lurenman.myframeworkone.base.BaseFragment;
import com.example.lurenman.myframeworkone.base.BasePresenter;

/**
 * @author: baiyang.
 * Created on 2017/11/28.
 */

public class SoftwareFragment extends BaseFragment {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private String[] mTitle = new String[10];
    private FragmentAdapter mAdapter;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_software;
    }

    @Override
    protected void initViews(View rootView) {
        mTabLayout = (TabLayout) rootView.findViewById(R.id.tl);
        mViewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
    }

    @Override
    protected void initVariables() {
        for (int i = 0; i < 10; i++) {
            mTitle[i] = "title" + i;
        }
        mAdapter = new FragmentAdapter(this.getChildFragmentManager());//解决了那个viewPager重名的bug
    }

    @Override
    protected void initEnvent() {
        super.initEnvent();
        mTabLayout.setTabsFromPagerAdapter(mAdapter);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    protected void loadData() {

    }

    private class FragmentAdapter extends FragmentStatePagerAdapter {
        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            SoftchildFragment softchildFragment = new SoftchildFragment();
            return softchildFragment;
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
