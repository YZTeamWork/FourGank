package com.yibh.fourgank.yonionyy.observerPattern;

/**
 * Created by yibh on 2016/9/28 16:14 .
 * 当前数据展示
 */

public class CurrentDisplay implements DisplayElement, YObserver {

    private WeatherData mWeatherData;
    private float mTemperature;  //温度
    private float mHumidity; //湿度
    private float mPressure; //气压

    public CurrentDisplay(WeatherData mWeatherData) {
        this.mWeatherData = mWeatherData;
        this.mWeatherData.registerObserver(this);
    }

    @Override
    public void diplay() {
        System.out.print("当前数据: " + mTemperature + "  " + mHumidity + "  " + mPressure + "\n");
    }

    @Override
    public void update() {
        mTemperature = mWeatherData.getTemperature();
        mHumidity = mWeatherData.getHumidity();
        mPressure = mWeatherData.getPressure();
        diplay();
    }
}
