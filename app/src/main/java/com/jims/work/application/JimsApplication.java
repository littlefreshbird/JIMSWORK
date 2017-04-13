package com.jims.work.application;

import android.app.Application;

import com.jims.work.utils.Utils;

/**
 * Created by gong on 2016/12/27.
 */

public class JimsApplication extends Application {

    private static JimsApplication appContext;

    public static JimsApplication getInstance() {
        return appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appContext =this;
        Utils.init(this);

    }



}



