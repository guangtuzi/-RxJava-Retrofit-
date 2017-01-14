package com.example.administrator.customproject.ui.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.customproject.application.AppHolder;
import com.example.administrator.customproject.dagger2.component.ActivityComponent;
import com.example.administrator.customproject.dagger2.component.DaggerActivityComponent;
import com.example.administrator.customproject.dagger2.module.ActivityModule;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Subscription;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {
    private Context context;
    private ActivityComponent activityComponent;
    private Subscription sbscription;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (0 != getContentViewId()) {
            setContentView(getContentViewId());
        }
        unbinder = ButterKnife.bind(this);
        injectDagger();
        initViews();
        initEvent();
    }

    public ActivityComponent activityComponent() {
        if (null == activityComponent) {
            activityComponent = DaggerActivityComponent
                    .builder()
                    .applicationComponent(AppHolder.get(this).getAppComponent())
                    .activityModule(new ActivityModule(this))
                    .build();
        }
        return activityComponent;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unbinder.unbind();
        unSubscription();
    }

    /**
     * 解绑Subscription
     */
    public void unSubscription() {
        if (null != sbscription && !sbscription.isUnsubscribed()) {
            sbscription.unsubscribe();
        }
    }

    protected abstract int getContentViewId();

    protected abstract void initViews();

    protected abstract void initEvent();

    protected abstract void injectDagger();
}
