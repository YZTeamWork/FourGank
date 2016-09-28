package com.yibh.fourgank.yonionyy.observerPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yibh on 2016/9/23 18:58 .
 * 观察者模式,参考: http://gold.xitu.io/post/57de12355bbb50005e648bd8
 */

public class WeatherData implements Subject {
    private List<YObserver> mYObservers;

    private float temperature;  //温度
    private float humidity; //湿度
    private float pressure; //气压
    private List<Float> forecastTemperatures;   //未来几天的温度

    public WeatherData() {
        this.mYObservers = new ArrayList<>();
    }

    @Override
    public void registerObserver(YObserver yObserver) {
        this.mYObservers.add(yObserver);
    }

    @Override
    public void removeObserver(YObserver yObserver) {
        this.mYObservers.remove(yObserver);
    }

    @Override
    public void notifyObserver() {
        for (YObserver yObserver : mYObservers) {
            yObserver.update();
        }
    }

    public void measurementsChanged() {
        notifyObserver();
    }

    /**
     * 设置数据,并通知刷新
     * @param temperature
     * @param humidity
     * @param pressure
     * @param forecastTemperatures
     */
    public void setMeasurements(float temperature, float humidity, float pressure, List<Float> forecastTemperatures) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.forecastTemperatures = forecastTemperatures;
        measurementsChanged();
    }

    public List<YObserver> getmYObservers() {
        return mYObservers;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public List<Float> getForecastTemperatures() {
        return forecastTemperatures;
    }
}
