package com.yibh.fourgank.yonionyy.activity;

import android.content.Context;
import android.content.Intent;
import android.widget.Button;

import com.yibh.fourgank.R;
import com.yibh.fourgank.utils.ToastSnackUtil;

import butterknife.BindView;

/**
 * java8 lambda 语法测试
 */
public class YLambdaActivity extends BaseActivity {

    @BindView(R.id.but1)
    Button mButton1;

    public static void startYYActivity(Context context) {
        Intent intent = new Intent(context, YLambdaActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_yy;
    }

    @Override
    protected void initData() {
        //普通的点击
        mButton1.setOnClickListener(v -> ToastSnackUtil.snackbarShort(mButton1, "我是第一个点击!"));
    }


}
