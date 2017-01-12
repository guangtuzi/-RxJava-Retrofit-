package com.example.administrator.customproject.ui.mvp.login;

import com.example.administrator.customproject.ui.mvp.BasePresenter;
import com.example.administrator.customproject.ui.mvp.BaseView;

/**
 * Created by Administrator on 2016/12/13.
 */

public interface LoginContract {
    interface LoginPresenter extends BasePresenter<LoginActivity> {

    }

    interface LoginView extends BaseView {
        void toMainActivity();

        void clear();
    }
}
