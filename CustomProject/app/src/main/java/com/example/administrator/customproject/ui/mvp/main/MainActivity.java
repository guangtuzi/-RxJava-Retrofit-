package com.example.administrator.customproject.ui.mvp.main;

import android.os.Bundle;

import com.example.administrator.customproject.R;
import com.example.administrator.customproject.db.DBManager;
import com.example.administrator.customproject.db.User;
import com.example.administrator.customproject.ui.mvp.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        User user = DBManager.getInstance().getSession().getUserDao().queryBuilder().list().get(0);
        long count = DBManager.getInstance().getSession().getUserDao().queryBuilder().count();
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