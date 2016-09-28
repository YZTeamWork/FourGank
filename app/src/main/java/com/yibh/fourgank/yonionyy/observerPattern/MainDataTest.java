package com.yibh.fourgank.yonionyy.observerPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yibh on 2016/9/28 16:51 .
 */

public class MainDataTest {
    public static void main(String[] strings) {
        WeatherData weatherData = new WeatherData();

        new CurrentDisplay(weatherData);
        new ForcecastDisplay(weatherData);

        List<Float> forecastData = new ArrayList<>();
        forecastData.add(24f);
        forecastData.add(29f);
        forecastData.add(30f);
        forecastData.add(18f);
        weatherData.setMeasurements(25f,0.5f,1f,forecastData);
    }

}
