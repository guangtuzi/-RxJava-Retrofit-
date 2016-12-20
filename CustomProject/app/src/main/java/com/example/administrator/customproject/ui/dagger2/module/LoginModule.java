package com.example.administrator.customproject.ui.dagger2.module;


import com.example.administrator.customproject.ui.mvp.contract.LoginContract;

import dagger.Module;
import dagger.Provides;

@Module   //提供依赖对象的实例
public class LoginModule {
    private LoginContract.LoginView view;

    public LoginModule(LoginContract.LoginView view) {
        this.view = view;
    }

    @Provides
    public LoginContract.LoginView provideILogView() {
        return view;
    }
}