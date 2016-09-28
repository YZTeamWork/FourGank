package com.yibh.fourgank.yonionyy.observerPattern;

import java.util.List;

/**
 * Created by yibh on 2016/9/28 16:36 .
 * 未来数据展示
 */

public class ForcecastDisplay implements YObserver, DisplayElement {


    private WeatherData mWeatherData;
    private List<Float> mForecastTemperatures;

    public ForcecastDisplay(WeatherData mWeatherData) {
        this.mWeatherData = mWeatherData;
        mWeatherData.registerObserver(this);
    }

    @Override
    public void diplay() {
        for (int i = 2; i <= mForecastTemperatures.size() + 1; i++) {
            System.out.print("第" + i + "天数据:" + mForecastTemperatures.get(i - 2));
        }
    }

    @Override
    public void update() {
        mForecastTemperatures = mWeatherData.getForecastTemperatures();
        diplay();
    }
}
