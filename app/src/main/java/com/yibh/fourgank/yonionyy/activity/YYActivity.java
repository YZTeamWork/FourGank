package com.yibh.fourgank.yonionyy.activity;

import android.content.Context;
import android.content.Intent;

import com.yibh.fourgank.R;

/**
 * java8 lambda 语法测试
 */
public class YYActivity extends BaseActivity {

    public static void startYYActivity(Context context) {
        Intent intent = new Intent(context, YYActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_yy;
    }

    @Override
    protected void initData() {

    }


}
