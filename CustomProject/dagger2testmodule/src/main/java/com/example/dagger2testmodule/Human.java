package com.example.dagger2testmodule;

import android.app.Activity;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/1/14.
 */

public class Human {
    private Activity activity;

    @Inject
    public Human(Activity activity) {
        this.activity = activity;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setLoginActivity(Activity activity) {
        this.activity = activity;
    }
}
