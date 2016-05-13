package com.example.android.sunshine.app;

/**
 * Created by Meow on 2016/5/13.
 */
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherDataParser {

    /**
     * Given a string of the form returned by the api call:
     * http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7
     * retrieve the maximum temperature for the day indicated by dayIndex
     * (Note: 0-indexed, so 0 would refer to the first day).
     */

    public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex)
            throws JSONException {
         String LOG_TAG =  WeatherDataParser.class.getSimpleName();
        // TODO: add parsing code here
        JSONObject jsObj= new JSONObject(weatherJsonStr);
        JSONArray dayList = (JSONArray) jsObj.getJSONArray("list");
        JSONObject dayInfo =dayList.getJSONObject(dayIndex);

        JSONObject tempInfo = dayInfo.getJSONObject("temp");
        double dTempMax =tempInfo.getDouble("max");


        return dTempMax;
    }

}