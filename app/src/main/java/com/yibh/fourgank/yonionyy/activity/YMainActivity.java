package com.yibh.fourgank.yonionyy.activity;

import android.content.Context;
import android.content.Intent;
import android.widget.Button;

import com.yibh.fourgank.R;

import butterknife.BindView;
import butterknife.OnClick;

public class YMainActivity extends BaseActivity {

    @BindView(R.id.bt_lambda)
    Button mButton_lam;

    public static void startYMainActivity(Context context) {
        Intent intent = new Intent(context, YMainActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_ymain;
    }

    @Override
    protected void initData() {}

    @OnClick(R.id.bt_lambda)
    protected void startLamAct(){
        YYActivity.startYYActivity(this);
    }

}
