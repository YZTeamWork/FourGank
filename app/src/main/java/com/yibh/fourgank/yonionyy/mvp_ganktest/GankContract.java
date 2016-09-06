package com.yibh.fourgank.yonionyy.mvp_ganktest;

import java.util.List;

/**
 * Created by yibh on 2016/9/2  17:29 .
 */

public interface GankContract {
    interface View extends BaseView{
        void startLoad();
        void endLoad();
        void onError(String errMsg);
        void load(List<FuliBean.Meiz> meizList);

    }

    interface Presenter extends BasePresenter{
        void getMeiz(int currPage,int avgCount);
    }
}
