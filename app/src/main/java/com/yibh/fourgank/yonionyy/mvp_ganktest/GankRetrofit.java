package com.yibh.fourgank.yonionyy.mvp_ganktest;

import com.yibh.fourgank.FourApp;
import com.yibh.fourgank.utils.NetUtil;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yibh on 2016/9/5  11:30 .
 */

public class GankRetrofit {

    private static Object mObject = new Object();

    private static String URL = "http://gank.io/api/data/";
    private static GankService mGankService;


    private static File httpCacheDirectory = new File(FourApp.mContext.getCacheDir(), "fourgankCache");
    private static int cacheSize = 10 * 1024 * 1024; // 10 MiB
    private static Cache cache = new Cache(httpCacheDirectory, cacheSize);


    private static final Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Response originalResponse = chain.proceed(chain.request());
            if (NetUtil.isConnected(FourApp.mContext)) {
                int maxAge = 60; // 在线缓存在1分钟内可读取
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .removeHeader("Cache-Control")
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build();
            } else {
                int maxStale = 60 * 60 * 24 * 14; // 离线时缓存保存2周
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .removeHeader("Cache-Control")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
        }
    };


    private static OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
            .retryOnConnectionFailure(true) //出现错误进行重新连接
            .addNetworkInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
            .addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
            .connectTimeout(10, TimeUnit.SECONDS)
            .cache(cache)
            .build();


    public static GankService getGankService() {
        if (null == mGankService) {
            synchronized (mObject) {
                if (null == mGankService) {
                    Retrofit mRetrofit = new Retrofit.Builder()
                            .baseUrl(URL)
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(mOkHttpClient)
                            .build();
                    mGankService = mRetrofit.create(GankService.class);
                }
            }
        }
        return mGankService;
    }


}
