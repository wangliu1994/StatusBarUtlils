package com.winnie.utils.statusbarutlils;

import android.content.res.Resources;

import java.lang.reflect.Method;

/**
 * Created by winnie
 */
public final class ScreenUtils {

    /**
     * 获取屏幕宽度
     */
    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    /**
     * 获取屏幕高度
     */
    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    /**
     * 获取状态栏高度
     */
    public static int getStatusBarHeight() {
        Resources res = Resources.getSystem();
        int resId = res.getIdentifier("status_bar_height", "dimen", "android");
        if (resId > 0) {
            return res.getDimensionPixelSize(resId);
        }
        return dp2px(25);
    }

    /**
     * 获取虚拟按钮高度
     */
    public static int getNavigationBarHeight() {
        if(!hasNavBar()){
            return 0;
        }
        Resources res = Resources.getSystem();
        int navigationBarHeight = 0;
        int id = res.getIdentifier("navigation_bar_height", "dimen", "android");
        if (id > 0) {
            navigationBarHeight = res.getDimensionPixelSize(id);
        }
        return navigationBarHeight;
    }


    public static boolean hasNavBar() {
        boolean hasNavigationBar = false;
        Resources res = Resources.getSystem();
        int id = res.getIdentifier("config_showNavigationBar", "bool", "android");
        if (id > 0) {
            hasNavigationBar = res.getBoolean(id);
        }
        try {
            Class systemPropertiesClass = Class.forName("android.os.SystemProperties");
            Method m = systemPropertiesClass.getMethod("get", String.class);
            String navBarOverride = (String) m.invoke(systemPropertiesClass, "qemu.hw.mainkeys");
            if ("1".equals(navBarOverride)) {
                hasNavigationBar = false;
            } else if ("0".equals(navBarOverride)) {
                hasNavigationBar = true;
            }
        } catch (Exception e) {

        }
        return hasNavigationBar;
    }

    /**
     * DP 转 PX
     */
    public static int dp2px(float dipValue) {
        Resources res = Resources.getSystem();
        return (int) (dipValue * res.getDisplayMetrics().density);
    }

    /**
     * 根据宽高比判断是否是竖屏
     */
    public static boolean portraitScreen() {
        return getScreenWidth() < getScreenHeight();
    }

    /**
     * 根据宽高比判断是否是横屏
     */
    public static boolean landscapeScreen() {
        return getScreenWidth() > getScreenHeight();
    }
}
