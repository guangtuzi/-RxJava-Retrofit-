package com.example.administrator.customproject.ui.mvp.presenter;

import android.content.Context;

import com.example.administrator.customproject.netWork.ProgressSubscriber;
import com.example.administrator.customproject.netWork.SubscriberOnNextListener;
import com.example.administrator.customproject.ui.mvp.BaseView;
import com.example.administrator.customproject.ui.mvp.biz.IUserBiz;
import com.example.administrator.customproject.ui.mvp.biz.UserBiz;
import com.example.administrator.customproject.ui.mvp.contract.LoginContract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2016/11/2.
 */

public class UserLoginPresenter implements LoginContract.LoginPresenter {
    private LoginContract.LoginView view;
    private IUserBiz biz;

    @Inject
    public UserLoginPresenter(LoginContract.LoginView view) {
        biz = new UserBiz();
    }

    public void login(Context context, String username, String password, String deviceId) {
        biz.login(new ProgressSubscriber<>(new SubscriberOnNextListener() {
            @Override
            protected void onNext(Object o) {
                view.toMainActivity();
            }
        }, context), username, password, deviceId);
    }

    @Override
    public void attachView(BaseView view) {

    }

    @Override
    public void detachView() {

    }
}
