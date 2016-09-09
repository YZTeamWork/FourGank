package com.yibh.fourgank.yonionyy.retrofit;

import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by yibh on 2016/9/7  11:15 .
 */

public interface TestService {

    /**
     * public static String BASE_URL = "http://172.16.11.32:6010/";
     * public static String ADD_API = "api/report/add";  //文件保存的日志
     *
     * @return
     * @Headers("Content-Type: application/json")
     * //
     */
//    @Headers({
//            "Content-Type: application/json;chartset=utf-8",
//            "mac: 08:00:27:d9:db:76",
//            "checkCode: 51f39eee65bd21598d1a04835b9d5383"
//    })
    @Headers({
            "Content-Type: application/json;chartset=utf-8",
            "mac: 08:00:27:d9:db:76",
            "checkCode: 51f39eee65bd21598d1a04835b9d5383"
    })
//    @POST("post.sc")
    @POST("api/report/add")
    Observable<Object> getRequest(@Body Object obj);
//    Observable<ResultBean> getRequest(@Header("checkCode") String checkCode,@Header("mac") String currMac,@Body Object obj);
}
