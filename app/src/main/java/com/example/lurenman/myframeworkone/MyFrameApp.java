package com.example.lurenman.myframeworkone;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;

/**
 * @author: baiyang.
 * Created on 2017/11/28.
 */

public class MyFrameApp extends Application {
    //以下属性应用于整个应用程序，合理利用资源，减少资源浪费
    public static Context mContext;//上下文
    private static Thread mMainThread;//主线程
    private static long mMainThreadId;//主线程id
    private static Looper mMainLooper;//循环队列
    private static Handler mHandler;//主线程Handler
    @Override
    public void onCreate() {
        super.onCreate();
        //对全局属性赋值
        mContext = getApplicationContext();
        mMainThread = Thread.currentThread();
        mMainThreadId = android.os.Process.myTid();
        mHandler = new Handler();
    }



    public static Thread getmMainThread() {
        return mMainThread;
    }

    public static void setmMainThread(Thread mMainThread) {
        MyFrameApp.mMainThread = mMainThread;
    }

    public static long getmMainThreadId() {
        return mMainThreadId;
    }

    public static void setmMainThreadId(long mMainThreadId) {
        MyFrameApp.mMainThreadId = mMainThreadId;
    }

    public static Looper getmMainLooper() {
        return mMainLooper;
    }

    public static void setmMainLooper(Looper mMainLooper) {
        MyFrameApp.mMainLooper = mMainLooper;
    }

    public static Handler getmHandler() {
        return mHandler;
    }

    public static void setmHandler(Handler mHandler) {
        MyFrameApp.mHandler = mHandler;
    }
    /**
     * 重启当前应用
     */
    public static void restart() {
        Intent intent = mContext.getPackageManager().getLaunchIntentForPackage(mContext.getPackageName());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        mContext.startActivity(intent);
    }
}
