package com.example.administrator.customproject.ui.dagger2;

import android.content.Context;

import com.example.administrator.customproject.application.AppHolder;
import com.example.administrator.customproject.ui.dagger2.scope.ApplicationContext;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Anthony on 2016/6/13.
 * Class Note:
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(AppHolder application);

    @ApplicationContext
    Context context();

    AppHolder application();
}
