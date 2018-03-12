package com.app.sunilmvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import com.app.sunilmvp.R;
import com.app.sunilmvp.model.Model;
import com.app.sunilmvp.utils.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginView {
    @BindView(R.id.btn_login)
    Button btnLogin;

    LoginPresenter mLoginPresenter = new LoginPresenterImpl(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        //get
        //set
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        mLoginPresenter.onLogin();
    }

    @Override
    public void onFetchStart() {
        showProgress();
    }

    @Override
    public void onFetchProgress(Model model) {
        dismissProgress();
    }

    @Override
    public void onFetchComplete(int i) {
        dismissProgress();
    }

    @Override
    public void onFetchFailed() {
        dismissProgress();
    }
}
