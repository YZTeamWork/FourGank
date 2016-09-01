package com.yibh.fourgank.yonionyy.mvptest.iView;

/**
 * Created by yibh on 2016/9/1  17:17.
 */

public interface ILoginView {
    void onClearText();
    void onResult(boolean loginSuccessed);

    void onShowProgressBar();
    void onHideProgressBar();
}
