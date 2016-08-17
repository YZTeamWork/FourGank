package com.yibh.fourgank;

import android.app.Application;
import android.content.Context;

/**
 * Created by yibh on 2016/8/17  19:39.
 */

public class FourApp extends Application{
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        this.mContext=this;
    }
}
