package com.example.lurenman.myframeworkone.base;

import android.content.Context;
import android.os.Bundle;

import com.example.lurenman.myframeworkone.R;
import com.example.lurenman.myframeworkone.listener.PermissionListener;
import com.example.lurenman.myframeworkone.utils.Env;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * @author: baiyang.
 * Created on 2017/11/28.
 */

public abstract class BaseActivity<T extends BasePresenter> extends SwipeBackActivity implements EasyPermissions.PermissionCallbacks {
    protected T mPresenter;
    protected Bundle savedInstanceState;
    protected Context mContext;
    public PermissionListener mPermissionListener;//权限申请
    private final int PERMISSION_CODE = 100;//设置的统一权限请求码

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        this.savedInstanceState = savedInstanceState;
        Env.initSystemBar(this, R.color.colorPrimary);//继承SwipeBackActivity的activity默认状态栏透明色
        //发现下面设不设置都无所谓的
        SwipeBackLayout mSwipeBackLayout = getSwipeBackLayout();
        int flag4 = SwipeBackLayout.EDGE_LEFT;    //全部
        //设置滑动模式
        mSwipeBackLayout.setEdgeTrackingEnabled(flag4);
        mSwipeBackLayout.setEnableGesture(true);
        mPresenter = createPresenter();
        initViews();
        initVariables();
        initEnvent();
    }

    //用于创建Presenter和判断是否使用MVP模式(由子类实现)
    protected abstract T createPresenter();

    protected abstract void initViews();

    protected abstract void initVariables();

    protected void initEnvent() {
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    //-----------------------封装EventBus-------------------
    public void registerEventBus(Object subscribe) {
        if (!isEventBusRegisted(subscribe)) {
            EventBus.getDefault().register(subscribe);
        }
    }

    public void unregisterEventBus(Object subscribe) {
        if (isEventBusRegisted(subscribe)) {
            EventBus.getDefault().unregister(subscribe);
        }
    }

    public boolean isEventBusRegisted(Object subscribe) {
        return EventBus.getDefault().isRegistered(subscribe);
    }
    //-----------------------封装权限申请-------------------

    /**
     * 申请运行时权限
     */
    public void requestRuntimePermission(String[] permissions, PermissionListener permissionListener) {
        mPermissionListener = permissionListener;
        List<String> permissionList = new ArrayList<>();
        for (String permission : permissions) {
            //先核实是否有这个权限，如果没有就添加到permissionList中
            if (!EasyPermissions.hasPermissions(mContext, permission)) {
                permissionList.add(permission);
            }
        }
        //这个"需要相关权限"根据需要暂定
        if (!permissionList.isEmpty()) {
            EasyPermissions.requestPermissions(mContext, "需要相关权限", PERMISSION_CODE, permissionList.toArray(new String[permissionList.size()]));
        } else {
            mPermissionListener.onGranted();
        }

    }

    //把请求权限回调交个EasyPermissions
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        if (requestCode == PERMISSION_CODE) {
            mPermissionListener.onGranted();
        }
    }

    //权限被禁止，只要没有权限对话框消失就调用此方法
    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        if (requestCode == PERMISSION_CODE) {
            mPermissionListener.onDenied(perms);//把禁止的权限传过去
        }

    }
}
