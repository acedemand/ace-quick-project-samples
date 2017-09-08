package com.acedemand;

import com.acedemand.dao.weather.GlobalWeather;
import com.acedemand.dao.weather.GlobalWeatherSoap;

/**
 * Created by Pamir on 5/7/2015.
 */
public class Program {
    public static void main(String[] args) {
        GlobalWeather weather = new GlobalWeather();
        GlobalWeatherSoap port = weather.getPort(GlobalWeather.GlobalWeatherSoap12,GlobalWeatherSoap.class);
        String response = port.getCitiesByCountry("tr");
        System.out.println("response = " + response);
    }
}
