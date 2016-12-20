package com.example.administrator.customproject.ui.dagger2;


import com.example.administrator.customproject.ui.dagger2.scope.PerActivity;

import dagger.Component;


@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    //all of the project
}
