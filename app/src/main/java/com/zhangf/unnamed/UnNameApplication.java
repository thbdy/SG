package com.zhangf.unnamed;

import android.app.Application;

public class UnNameApplication extends Application{
    private static UnNameApplication unnameApplicaiton;

    public static UnNameApplication getUnnameApplicaiton() {
        return unnameApplicaiton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
