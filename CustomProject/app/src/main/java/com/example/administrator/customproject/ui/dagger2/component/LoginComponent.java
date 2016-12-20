package com.example.administrator.customproject.ui.dagger2.component;


import com.example.administrator.customproject.ui.activity.LoginActivity;
import com.example.administrator.customproject.ui.dagger2.module.LoginModule;

import dagger.Component;

@Component(modules = LoginModule.class)
public interface LoginComponent {
    // MainComponent接口中提供的inject()方法的参数是LoginActivity，这个参数的含义是LoginPresenter要在什么地方注入。
    LoginActivity inject(LoginActivity activity);
}