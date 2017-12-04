package com.example.lurenman.myframeworkone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.lurenman.myframeworkone.base.BaseFragment;
import com.example.lurenman.myframeworkone.module.ebooks.fragment.EbooksFragment;
import com.example.lurenman.myframeworkone.module.games.fragment.GamesFragment;
import com.example.lurenman.myframeworkone.module.manager.fragment.ManagerFragment;
import com.example.lurenman.myframeworkone.module.news.fragment.NewsFragment;
import com.example.lurenman.myframeworkone.module.software.fragment.SoftwareFragment;
import com.example.lurenman.myframeworkone.utils.Env;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<BaseFragment> mFragments;
    private List<BaseFragment> visiableFragments = new ArrayList<>();
    private RadioGroup Rg_group;
    private long exitTime;
    private DrawerLayout dl_drawer;
    private ImageView iv_user_center;//上面那个用户中心头像

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Env.initSystemBar(this, R.color.colorPrimary);
        initViews();
        initVariables();
        initEnvent();
    }

    private void initViews() {
        Rg_group = (RadioGroup) findViewById(R.id.Rg_group);
        dl_drawer = (DrawerLayout) findViewById(R.id.dl_drawer);
        iv_user_center = (ImageView) findViewById(R.id.iv_user_center);

    }

    private void initVariables() {
        mFragments = new ArrayList<>(5);
        mFragments.add(new NewsFragment());
        mFragments.add(new GamesFragment());
        mFragments.add(new SoftwareFragment());
        mFragments.add(new EbooksFragment());
        mFragments.add(new ManagerFragment());
    }

    private void initEnvent() {
        Rg_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int position = group.indexOfChild(group.findViewById(checkedId));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                Fragment fragment = mFragments.get(position);
                if (fragment.isAdded()) {
                    transaction.show(fragment);
                } else {
                    transaction.add(R.id.fl_content, fragment);
                    visiableFragments.add((BaseFragment) fragment);
                }
                for (Fragment fragment1 : visiableFragments) {
                    if (fragment1 != fragment) {
                        if (fragment1.isVisible()) {
                            transaction.hide(fragment1);
                            transaction.addToBackStack(null);
                        }
                    }
                }
                transaction.commit();
            }
        });
        ((RadioButton) Rg_group.getChildAt(0)).setChecked(true);
        iv_user_center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dl_drawer.openDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                this.finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
