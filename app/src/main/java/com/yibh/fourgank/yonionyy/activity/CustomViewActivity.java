package com.yibh.fourgank.yonionyy.activity;

import android.content.Context;
import android.content.Intent;

import com.yibh.fourgank.R;

/**
*   Created by yibh on 2016/9/13  16:48 .
*/
public class CustomViewActivity extends BaseActivity {

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context, CustomViewActivity.class);
        return intent;
    }



    @Override
    public int getContentViewId() {
        return R.layout.activity_custom_view;
    }

    @Override
    protected void initData() {

    }
}
