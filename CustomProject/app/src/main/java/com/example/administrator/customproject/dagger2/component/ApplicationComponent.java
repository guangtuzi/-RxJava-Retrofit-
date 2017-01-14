package com.example.administrator.customproject.dagger2.component;

import android.app.Application;
import android.content.Context;

import com.example.administrator.customproject.application.AppHolder;
import com.example.administrator.customproject.dagger2.module.ApiModule;
import com.example.administrator.customproject.dagger2.module.ApplicationModule;
import com.example.administrator.customproject.dagger2.scope.ApplicationContext;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;

@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface ApplicationComponent {

    void inject(AppHolder application);

    @ApplicationContext
    Context context();

    Application application();

    @Named("api")
    OkHttpClient getOkHttpClient();
}
