package com.yibh.fourgank.yonionyy.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.yibh.fourgank.R;
import com.yibh.fourgank.utils.ToastSnackUtil;
import com.yibh.fourgank.yonionyy.mvp_ganktest.FuliBean;
import com.yibh.fourgank.yonionyy.mvp_ganktest.GankAdapter;
import com.yibh.fourgank.yonionyy.mvp_ganktest.GankContract;
import com.yibh.fourgank.yonionyy.mvp_ganktest.GankPresenter;

import java.util.List;

import butterknife.BindView;

/**
 * Created by yibh on 2016/9/2  14:06 .
 */
public class GankTestActivity extends BaseActivity implements GankContract.View {

    @BindView(R.id.fuli_recy)
    RecyclerView mRecyclerView;
    private GankAdapter mGankAdapter;
    private GankPresenter mGankPresenter;
    private int currPage = 1;

    /**
     * 到本页面
     */
    public static void startGankTActivity(Context context) {
        Intent intent = new Intent(context, GankTestActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_gank_test;
    }

    @Override
    protected void initData() {
        mGankPresenter = new GankPresenter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mGankAdapter = new GankAdapter();
        mRecyclerView.setAdapter(mGankAdapter);

        mGankPresenter.getMeiz(10, currPage);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (!ViewCompat.canScrollVertically(recyclerView, 1)) {
                    mGankPresenter.getMeiz(10, ++currPage);
                }
            }

        });
    }

    @Override
    public void startLoad() {
        ToastSnackUtil.snackbarShort(mRecyclerView,"开始加载...");
    }

    @Override
    public void endLoad() {

    }

    @Override
    public void onError(String errMsg) {
        ToastSnackUtil.snackbarLong(mRecyclerView, "出现异常,请求数据失败!" + errMsg);
    }

    @Override
    public void load(List<FuliBean.Meiz> meizList) {
        Log.w("load", "请求成功!");
        mGankAdapter.onRefresh(meizList);
    }


}
