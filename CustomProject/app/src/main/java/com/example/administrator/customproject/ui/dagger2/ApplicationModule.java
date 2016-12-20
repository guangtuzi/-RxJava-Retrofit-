package com.example.administrator.customproject.ui.dagger2;


import android.content.Context;

import com.example.administrator.customproject.application.AppHolder;
import com.example.administrator.customproject.ui.dagger2.scope.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Anthony on 2016/6/13.
 * Class Note:
 * Application Module，
 */
@Module
public class ApplicationModule {
    protected final AppHolder mApplication;

    public ApplicationModule(AppHolder application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    AppHolder provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    @Singleton
    Context provideContext() {
        return mApplication;
    }
}