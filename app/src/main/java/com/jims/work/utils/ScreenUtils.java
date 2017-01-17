package com.jims.work.utils;

import android.content.Context;
import android.view.WindowManager;

/**
 * Created by gong on 2017/1/17.
 */
public class ScreenUtils {

    public static int getScreenWidth(Context context) {
        WindowManager windowMgr = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        return windowMgr.getDefaultDisplay().getWidth();
    }

    public static int getScreenHeight(Context context) {
        WindowManager windowMgr = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        return windowMgr.getDefaultDisplay().getHeight();
    }

    private ScreenUtils() {
    }
}
