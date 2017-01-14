package com.example.administrator.customproject.ui.mvp.main;

import android.os.Bundle;

import com.example.administrator.customproject.R;
import com.example.administrator.customproject.ui.mvp.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initEvent() {

    }

    @Override
    protected void injectDagger() {

    }
}