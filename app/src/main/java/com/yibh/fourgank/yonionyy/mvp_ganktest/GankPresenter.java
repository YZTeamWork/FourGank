package com.yibh.fourgank.yonionyy.mvp_ganktest;

import android.util.Log;

import com.yibh.fourgank.FourApp;
import com.yibh.fourgank.utils.NetUtil;
import com.yibh.fourgank.yonionyy.activity.GankTestActivity;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by yibh on 2016/9/5  13:05 .
 */

public class GankPresenter implements GankContract.Presenter {
    private GankContract.View mView;

    public GankPresenter(GankTestActivity gankTestActivity) {
        mView = gankTestActivity;
    }

    @Override
    public void getMeiz(int currPage, int avgCount) {
        mView.startLoad();
        if (!NetUtil.isConnected(FourApp.mContext)) {
            mView.onError("请检查网络!");
            return;
        }
        GankRetrofit.getGankService().getFuLi(currPage, avgCount)
                .map(fuliBean -> fuliBean.mMeiziList)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<FuliBean.Meiz>>() {

                    @Override
                    public void onCompleted() {
                        mView.endLoad();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onError(e.toString());
                    }

                    @Override
                    public void onNext(List<FuliBean.Meiz> meizList) {
                        Log.w("GankPresenter", "请求成功!");
                        mView.load(meizList);
                    }
                });
    }
}
