package com.yibh.fourgank.yonionyy.retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yibh on 2016/8/24  11:45.
 */

public class ResultBean {

    /**
     * 状态码对应的具体信息
     * 0    成功
     * 1    失败
     * -1   action参数值错误
     * -2   mac地址错误
     * -3   校验码无效
     * -4   汇报数据有误
     */

    @SerializedName("status")
    public int mResultStatus; //返回的状态码

    @SerializedName("info")
    public String mResultInfo; //具体信息
}
