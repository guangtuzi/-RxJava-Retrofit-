package com.example.administrator.customproject.dagger2.module;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Administrator on 2017/1/12.
 */

@Module
public class ApiModule {
    Context mContext;

    public ApiModule(Context mContext) {
        this.mContext = mContext;
    }

    @Provides
    @Singleton
    @Named("api")
    OkHttpClient provideApiOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS) //
                .readTimeout(15, TimeUnit.SECONDS) //
                .writeTimeout(15, TimeUnit.SECONDS);

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(logging);
        return builder.build();
    }
}
