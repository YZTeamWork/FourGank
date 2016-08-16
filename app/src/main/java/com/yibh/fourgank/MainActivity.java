package com.yibh.fourgank;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.yibh.fourgank.yonionyy.activity.YMainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bt_yibh)
    Button mButton_yibh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        mButton_yibh.setOnClickListener(view ->YMainActivity.startYMainActivity(this) );
        mTextView.setOnClickListener(view -> {});
        mTextView.setText("我是测试");
    }
}
