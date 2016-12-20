package com.example.administrator.customproject.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.customproject.R;
import com.example.administrator.customproject.dagger2.DaggerLoginComponent;
import com.example.administrator.customproject.ui.dagger2.module.LoginModule;
import com.example.administrator.customproject.ui.mvp.contract.LoginContract;
import com.example.administrator.customproject.ui.mvp.presenter.UserLoginPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginContract.LoginView {
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.login)
    Button login;

    @Inject
    UserLoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        DaggerLoginComponent.builder().loginModule(new LoginModule(this)).build().inject(this);
    }

    @OnClick(R.id.login)
    void login(View view) {
        String un = username.getText().toString();
        String pw = password.getText().toString();
        loginPresenter.login(LoginActivity.this, un, pw, "123456");
    }

    @Override
    public void toMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void clear() {
        username.setText("");
        password.setText("");
    }
}
