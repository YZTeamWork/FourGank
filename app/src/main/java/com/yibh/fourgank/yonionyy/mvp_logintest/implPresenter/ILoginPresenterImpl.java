package com.yibh.fourgank.yonionyy.mvp_logintest.implPresenter;

import android.os.Handler;

import com.yibh.fourgank.yonionyy.mvp_logintest.iView.ILoginView;
import com.yibh.fourgank.yonionyy.mvp_logintest.model.User;
import com.yibh.fourgank.yonionyy.mvp_logintest.presenter.ILoginPresenter;

/**
 * Created by yibh on 2016/9/1  17:40.
 */

public class ILoginPresenterImpl implements ILoginPresenter {
    private ILoginView mILoginView;

    private User mUser;

    public ILoginPresenterImpl(ILoginView iLoginView) {
        this.mILoginView = iLoginView;
        mUser = new User("yibh", "你猜");
    }

    @Override
    public void onClear() {
        mILoginView.onClearText();
    }

    @Override
    public void onLogin(String name, String passWord) {

        mILoginView.onShowProgressBar();

        boolean isLoginS = false;
        if (name.equals(mUser.mName) && passWord.equals(mUser.mPassWord)) {
            isLoginS = true;
        }

        boolean finalIsLoginS = isLoginS;

        //模拟验证过程
        new Handler().postDelayed(() -> {
            mILoginView.onResult(finalIsLoginS);
            mILoginView.onHideProgressBar();
        }, 3000);

    }
}
