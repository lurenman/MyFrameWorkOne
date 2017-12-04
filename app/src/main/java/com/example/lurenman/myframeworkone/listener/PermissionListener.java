package com.example.lurenman.myframeworkone.listener;

import java.util.List;

/**
 *
 * 权限申请回调的接口
 */
public interface PermissionListener {

    void onGranted();

    void onDenied(List<String> deniedPermissions);
}
