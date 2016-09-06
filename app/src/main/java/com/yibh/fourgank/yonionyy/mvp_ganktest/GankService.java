package com.yibh.fourgank.yonionyy.mvp_ganktest;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by yibh on 2016/9/5  11:22 .
 */

public interface GankService {
    /**
     * http://gank.io/api/data/福利/10/1
     */

    @GET("福利/{page}/{currCount}")
    Observable<FuliBean> getFuLi(@Path("page")int page,@Path("currCount")int currCount);

}
