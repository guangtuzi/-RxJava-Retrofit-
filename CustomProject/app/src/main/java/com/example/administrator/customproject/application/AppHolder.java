package com.example.administrator.customproject.application;

import android.app.Application;
import android.content.Context;

import com.example.administrator.customproject.dagger2.component.ApplicationComponent;
import com.example.administrator.customproject.dagger2.component.DaggerApplicationComponent;
import com.example.administrator.customproject.dagger2.module.ApiModule;
import com.example.administrator.customproject.dagger2.module.ApplicationModule;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

public class AppHolder extends Application {
    private static Context context;
    private ApplicationComponent mAppComponent;
    private static final String TAG = "CustomPro";

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();

        Logger.init(TAG).logLevel(LogLevel.FULL);// 初始化日志

    }

    public static AppHolder get(Context context) {
        return (AppHolder) context.getApplicationContext();
    }

    public ApplicationComponent getAppComponent() {
        if (null == mAppComponent) {
            mAppComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .apiModule(new ApiModule(this))
                    .build();
        }
        return mAppComponent;
    }

    public void setAppComponent(ApplicationComponent mAppComponent) {
        this.mAppComponent = mAppComponent;
    }

    public static Context getContext() {
        return context;
    }
}
