package com.example.administrator.customproject.ui.mvp.biz;


import com.example.administrator.customproject.netWork.ProgressSubscriber;
import com.example.administrator.customproject.netWork.response.LoginResponse;

public interface IUserBiz {
    void login(ProgressSubscriber<LoginResponse> subscriber, String username, String password, String deviceId);
}
