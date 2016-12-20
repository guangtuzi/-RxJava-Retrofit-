package com.example.administrator.customproject.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import rx.Subscription;

public class BaseActivity extends AppCompatActivity {
    private Subscription rxSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != rxSubscription && !rxSubscription.isUnsubscribed()) {
            rxSubscription.unsubscribe();
        }
    }
}
