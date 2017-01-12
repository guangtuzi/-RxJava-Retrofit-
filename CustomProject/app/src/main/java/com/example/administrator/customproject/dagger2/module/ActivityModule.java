package com.example.administrator.customproject.dagger2.module;


import android.app.Activity;
import android.content.Context;

import com.example.administrator.customproject.dagger2.scope.ActivityContext;
import com.example.administrator.customproject.dagger2.scope.PerActivity;
import com.example.administrator.customproject.net.Api;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @ActivityContext
    Context providesContext() {
        return mActivity;
    }

    @Provides
    @PerActivity
    public Api provideApi(@Named("api") OkHttpClient okHttpClient, @ActivityContext Context mContext) {
        return new Api(okHttpClient, mContext);
    }
}
