package com.yibh.fourgank.yonionyy.activity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.yibh.fourgank.R;
import com.yibh.fourgank.yonionyy.retrofit.TTTBean;
import com.yibh.fourgank.yonionyy.retrofit.TestBean;
import com.yibh.fourgank.yonionyy.retrofit.TestRetrofit;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;
import com.yolanda.nohttp.rest.Response;
import com.yolanda.nohttp.rest.SimpleResponseListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.OnClick;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
*   Created by yibh on 2016/9/9  10:12 .
 *  这是测试retrofit/nohttp的post请求
*/
public class RetrofitTestActivity extends BaseActivity {

    public static void startNewActivity(Context context){
        Intent intent = new Intent(context,RetrofitTestActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_retrofit_test;
    }

    @Override
    protected void initData() {

    }

    @OnClick(R.id.bt1)
    protected void retrofitTest(View view) {
        String mTest = "{\"userid\":114107,\"action\":\"powerOff\",\"runtime\":444}";


        String mTest1 = "{\n" +
                "    \"id\": \"\",\n" +
                "    \"serviceId\": \"1000\",\n" +
                "    \"type\": \"service\",\n" +
                "    \"time\": \"1455588106089\",\n" +
                "    \"remark\": \"\",\n" +
                "    \"vin\": \"AAAAAAAA\",\n" +
                "    \"deviceid\": \"AAAAAAAA\",\n" +
                "    \"body\": {\n" +
                "        \"area\": \"北京\"\n" +
                "    }\n" +
                "}";


//        mac: 08:00:27:d9:db:76
//        checkCode: 51f39eee65bd21598d1a04835b9d5383
//        new TestBean(114107,"powerOff",555);
        Map<String, Object> sMap = new HashMap<>();
        sMap.put("userid", 114107);
        sMap.put("action", "powerOff");
        sMap.put("runtime", 20);

        Map<String, Object> bodyMap = new HashMap<String, Object>();
        bodyMap.put("area", "北京");

        Map<String, Object> mapJson = new HashMap<String, Object>();
        mapJson.put("id", "");
        mapJson.put("serviceId", "1000");
        mapJson.put("type", "service");
        mapJson.put("time", String.valueOf(System.currentTimeMillis()));
        mapJson.put("remark", "");
        mapJson.put("vin", "AAAAAAAA");
        mapJson.put("deviceid", "AAAAAAAA");
        mapJson.put("body", bodyMap);

        TTTBean tttBean = new TTTBean("", "1000", "service"
                , String.valueOf(System.currentTimeMillis()), ""
                , "AAAAAAAA", "AAAAAAAA"
                , new TTTBean.BodyBean("北京"));
        String powerOff = new Gson().toJson(new TestBean(114107, "powerOff", 777));
        String y = "[" + powerOff + "]";
        ArrayList<String> strings = new ArrayList<>();
        strings.add(powerOff);

        TestRetrofit.get().getRequest(new Gson().toJson(strings).toString()
        )
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Object>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.w("onError", e.getMessage().toString());
                    }

                    @Override
                    public void onNext(Object o) {

                        Log.w("onNext", "服务器有返回,可断点查看具体返回信息");
                    }
                });

    }

    @OnClick(R.id.bt2)
    protected void noHttpTest(View view) {
        //以下是使用NoHttp进行的post请求,可以达到要求
        String url = "http://172.16.11.32:6010/api/report/add";
        Request<String> stringRequest = NoHttp.createStringRequest(url, RequestMethod.POST);
        stringRequest.setDefineRequestBodyForJson("[" + new Gson().toJson(new TestBean(114107, "powerOff", 999)) + "]");
        stringRequest.addHeader("mac", "08:00:27:d9:db:76");
        stringRequest.addHeader("checkCode", "51f39eee65bd21598d1a04835b9d5383");
        RequestQueue requestQueue = NoHttp.newRequestQueue();
        requestQueue.add(0, stringRequest, new SimpleResponseListener<String>() {
            @Override
            public void onSucceed(int what, Response<String> response) {
                Log.w("onSucceed","服务器有返回,可断点查看具体返回信息");
            }

            @Override
            public void onFailed(int what, Response<String> response) {
                Log.w("onFailed", response.getException().getMessage());
            }
        });
    }

}
