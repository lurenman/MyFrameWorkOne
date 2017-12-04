package com.example.lurenman.myframeworkone.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/27 0027.
 */

public class Env {
    //改变状态栏的
    public static void initSystemBar(Activity activity, int resourceColor) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(activity, true);
        }
        SystemBarTintManager tintManager = new SystemBarTintManager(activity);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setStatusBarTintResource(resourceColor);//通知栏所需颜色
    }

    @TargetApi(19)
    private static void setTranslucentStatus(Activity activity, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    /**
     * 判断是都有底部虚拟键
     *
     * @return
     */
    public static int getVirtualBarHeigh(Activity activity) {
        int vh = 0;
        WindowManager windowManager = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        try {
            @SuppressWarnings("rawtypes")
            Class c = Class.forName("android.view.Display");
            @SuppressWarnings("unchecked") Method method = c.getMethod("getRealMetrics", DisplayMetrics.class);
            method.invoke(display, dm);
            vh = dm.heightPixels - windowManager.getDefaultDisplay().getHeight();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vh;
    }

    /**
     * 根据时间对比转换为文字信息
     */
    public static String timeConvertDescribe(String convertTime) {

        if (TextUtils.isEmpty(convertTime)) {
            return "未知";
        }
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar calendar = Calendar.getInstance();
            calendar.get(Calendar.DAY_OF_MONTH);
            long now = calendar.getTimeInMillis();
            Date date = df.parse(convertTime);// 上次记录的时间
            calendar.setTime(date);
            long past = calendar.getTimeInMillis();
            // 相差的秒数
            long time = (now - past) / 1000;
            if (time < 60) {
                convertTime = "1分钟前";
            } else if (time > 60 && time < 3600) { // 1小时内
                convertTime = time / 60 + "分钟前";
            } else if (time >= 3600 && time < 3600 * 24) {
                convertTime = time / 3600 + "小时前";
            } else if (time >= 3600 * 24 && time < 3600 * 48) {
                convertTime = "昨天";
            } else if (time >= 3600 * 48 && time < 3600 * 72) {
                convertTime = "前天";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return convertTime;
    }
}
