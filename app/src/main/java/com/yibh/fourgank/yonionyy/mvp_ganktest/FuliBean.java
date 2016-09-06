package com.yibh.fourgank.yonionyy.mvp_ganktest;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * Created by yibh on 2016/9/2  17:54 .
 */

public class FuliBean {
    /**
     * {
     "error": false,
     "results": [
     {
     "_id": "57c6dcd0421aa9125fa3edc5",
     "createdAt": "2016-08-31T21:34:08.961Z",
     "desc": "9-1",
     "publishedAt": "2016-09-01T11:31:19.288Z",
     "source": "chrome",
     "type": "福利",
     "url": "http://ww3.sinaimg.cn/large/610dc034jw1f7d97id9mbj20u00u0q4g.jpg",
     "used": true,
     "who": ""
     }
     ]
     }
     */


    @SerializedName("error")
    public boolean mError;

    @SerializedName("results")
    public List<Meiz> mMeiziList;

    public class Meiz{
        @SerializedName("_id")
        public String mId;

        @SerializedName("createdAt")
        public Date mCreatedDate;   //创建时间

        @SerializedName("desc")
        public String mDesc;    //描述

        @SerializedName("publishedAt")
        public Date mPublishedDate; //提交时间

        @SerializedName("source")
        public String mSource;  //来源

        @SerializedName("type")
        public String mType;    //分类

        @SerializedName("url")
        public String mUrl;

        @SerializedName("used")
        public boolean mUsed;

        @SerializedName("who")
        public String mWho;

    }

}
