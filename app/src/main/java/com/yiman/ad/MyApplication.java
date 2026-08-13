package com.yiman.ad;

import android.app.Application;

public class MyApplication extends Application {
    public static Application myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        //广告初始化参照：AdbidAdLoad.init
    }
}
