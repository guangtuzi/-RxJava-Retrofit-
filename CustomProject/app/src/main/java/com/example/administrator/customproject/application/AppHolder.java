package com.example.administrator.customproject.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2016/12/13.
 */

public class AppHolder extends Application {

    private AppComponent appComponent;

    public static AppHolder get(Context context) {
        return (AppHolder) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public AppComponent getAppComponent() {
        if (null != appComponent) {
            // TODO
        }
        return appComponent;
    }
}
