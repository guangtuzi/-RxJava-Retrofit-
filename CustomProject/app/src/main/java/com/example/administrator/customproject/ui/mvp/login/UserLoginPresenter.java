package com.example.administrator.customproject.ui.mvp.login;

import android.content.Context;

import com.example.administrator.customproject.dagger2.scope.ActivityContext;
import com.example.administrator.customproject.db.DBManager;
import com.example.administrator.customproject.db.User;
import com.example.administrator.customproject.net.Api;
import com.example.administrator.customproject.net.ProgressSubscriber;
import com.example.administrator.customproject.net.SubscriberOnNextListener;

import javax.inject.Inject;

/**
 * Created by Administrator on 2016/11/2.
 */

public class UserLoginPresenter implements LoginContract.LoginPresenter {
    private Context context;
    private LoginContract.LoginView view;

    @Inject
    Api api;

    @Inject
    public UserLoginPresenter(@ActivityContext Context context) {
        this.context = context;
    }

    public void login(Context context, String username, String password, String deviceId) {
        DBManager.getInstance().getSession().getUserDao().save(new User(username, password));
        view.toMainActivity();
        api.login(
                username,
                password,
                deviceId,
                new ProgressSubscriber<>(
                        new SubscriberOnNextListener() {
                            @Override
                            protected void onNext(Object o) {
                                view.toMainActivity();
                            }
                        }, context)
        );
    }

    @Override
    public void attachView(LoginActivity view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }
}
