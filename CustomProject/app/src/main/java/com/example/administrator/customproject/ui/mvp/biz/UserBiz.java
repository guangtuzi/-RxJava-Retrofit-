package com.example.administrator.customproject.ui.mvp.biz;


import com.example.administrator.customproject.netWork.Api;
import com.example.administrator.customproject.netWork.ProgressSubscriber;
import com.example.administrator.customproject.netWork.response.LoginResponse;

public class UserBiz implements IUserBiz {
    @Override
    public void login(ProgressSubscriber<LoginResponse> subscriber, String username, String password, String deviceId) {
        Api.getInstance().login(subscriber, username, password, deviceId);
    }
}