package com.example.dagger2testmodule;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/1/14.
 */

@Module
public class HumanModule {
    private Activity activity;

    public HumanModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    public Activity provideActivity() {
        return activity;
    }
}
