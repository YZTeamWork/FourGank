package com.yibh.fourgank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
<<<<<<< HEAD
import android.widget.Button;

import com.yibh.fourgank.yonionyy.activity.YMainActivity;
=======
import android.widget.TextView;
>>>>>>> yibh_branch

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
<<<<<<< HEAD
    @BindView(R.id.bt_yibh)
    Button mButton_yibh;
=======
    @BindView(R.id.test_tx)
    TextView mTextView;
>>>>>>> yibh_branch

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
<<<<<<< HEAD

        initData();
    }

    private void initData() {
        mButton_yibh.setOnClickListener(view ->YMainActivity.startYMainActivity(this) );
=======
        mTextView.setOnClickListener(view -> {});
>>>>>>> yibh_branch
    }
}
