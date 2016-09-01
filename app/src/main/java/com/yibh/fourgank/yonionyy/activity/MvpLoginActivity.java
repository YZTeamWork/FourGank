package com.yibh.fourgank.yonionyy.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.yibh.fourgank.R;
import com.yibh.fourgank.utils.ToastSnackUtil;
import com.yibh.fourgank.yonionyy.mvptest.iView.ILoginView;
import com.yibh.fourgank.yonionyy.mvptest.implPresenter.ILoginPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MvpLoginActivity extends AppCompatActivity implements ILoginView {

    @BindView(R.id.name_ed)
    EditText mNameEditText;

    @BindView(R.id.password_ed)
    EditText mPasswEditText;

    @BindView(R.id.login_bt)
    Button mLoginButton;

    @BindView(R.id.clear_bt)
    Button mClearButton;

    @BindView(R.id.login_pro)
    ProgressBar mProgressBar;

    private ILoginPresenterImpl mILoginPresenter;


    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MvpLoginActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_login);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        mILoginPresenter = new ILoginPresenterImpl(this);
    }

    @Override
    public void onClearText() {
        mNameEditText.setText("");
        mPasswEditText.setText("");
    }

    @Override
    public void onResult(boolean loginSuccessed) {
        if (loginSuccessed) {
            ToastSnackUtil.snackbarShort(mLoginButton, "登录成功!");
        } else {
            ToastSnackUtil.snackbarShort(mLoginButton, "就这样失败了 ^_^!");
        }
    }

    @Override
    public void onShowProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onHideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    @OnClick(R.id.login_bt)
    protected void onLogin(View view) {
        mILoginPresenter.onLogin(mNameEditText.getText().toString(), mPasswEditText.getText().toString());
    }

    @OnClick(R.id.clear_bt)
    protected void onClear(View view) {
        mILoginPresenter.onClear();
    }


}
