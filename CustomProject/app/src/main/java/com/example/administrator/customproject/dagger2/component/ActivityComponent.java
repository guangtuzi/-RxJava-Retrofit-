package com.example.administrator.customproject.dagger2.component;


import com.example.administrator.customproject.dagger2.module.ActivityModule;
import com.example.administrator.customproject.dagger2.scope.PerActivity;
import com.example.administrator.customproject.net.Api;
import com.example.administrator.customproject.ui.mvp.login.LoginActivity;

import dagger.Component;


@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Api getApi();

    void inject(LoginActivity loginActivity);
}
