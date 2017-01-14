package com.example.dagger2testmodule;

import android.app.Activity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2017/1/14.
 */
@Singleton
@Component(modules = HumanModule.class)
public interface HumanComponent {
    Human provideHuman();// 这里不能传入参数

    void inject(Activity activity);
}
