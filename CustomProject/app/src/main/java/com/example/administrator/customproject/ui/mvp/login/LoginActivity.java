package com.example.administrator.customproject.ui.mvp.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.customproject.R;
import com.example.administrator.customproject.ui.mvp.BaseActivity;
import com.example.administrator.customproject.ui.mvp.main.MainActivity;

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
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_login;
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

    @Override
    public void initViews() {
        username.setText("用户名");
        password.setText("密  码");
    }

    @Override
    public void initEvent() {
        login.setOnClickListener(v -> {
            String un = username.getText().toString();
            String pw = password.getText().toString();
            loginPresenter.login(LoginActivity.this, un, pw, "123456");
        });
    }

    @Override
    public void injectDagger() {
        activityComponent().inject(this);
        loginPresenter.attachView(this);
    }
}
