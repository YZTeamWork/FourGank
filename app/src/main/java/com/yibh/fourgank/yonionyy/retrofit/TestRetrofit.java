package com.yibh.fourgank.yonionyy.retrofit;

import com.yibh.fourgank.BuildConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yibh on 2016/9/7  11:20 .
 */

public class TestRetrofit {
    public static String BASE_URL = "http://172.16.11.32:6010/";
    //    public static String BASE_URL = "http://101.200.12.239:7990/tsp-dispatcher/";
    private static TestService mTestService;
    private static Object mObject = new Object();


    static OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            //这里只作为拦截器使用,查看传输的数据
            Response response = null;

            response = chain.proceed(chain.request());

            return response;
        }
    }).build();

    public static TestService get() {
        if (null == mTestService) {
            synchronized (mObject) {
                if (null == mTestService) {
                    mTestService = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .client(client)
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
//                            .addConverterFactory(new ToStringConverterFactory())
                            .build().create(TestService.class);
                }
            }
        }
        return mTestService;
    }


}
