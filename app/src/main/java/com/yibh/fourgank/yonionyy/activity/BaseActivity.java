package com.yibh.fourgank.yonionyy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_base);
        if (getContentViewId() != -1) {
            setContentView(getContentViewId());
            ButterKnife.bind(this);
        }

        initData();
    }

//    public int getContentViewId() {
//        return -1;
//    }

    public abstract int getContentViewId();

    protected abstract void initData();

}
