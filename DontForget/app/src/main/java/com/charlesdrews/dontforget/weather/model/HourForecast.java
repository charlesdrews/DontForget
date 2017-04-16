package com.charlesdrews.dontforget.weather.model;

/**
 * Models a weather forecast for a specified hour
 * Created by charlie on 4/14/17.
 */

public class HourForecast extends BaseForecast {
    private String mTime12, mTime24, mTempF, mTempC;

    public HourForecast(int hour, String iconUrl, int tempF, int tempC, int probOfPrecip, boolean snowNotRain) {
        super(iconUrl, probOfPrecip, snowNotRain);

        mTime12 = (hour > 12) ? (hour - 12) + " am" : hour + " pm";
        mTime24 = hour + ":00";
        mTempF = tempF + "°";
        mTempC = tempC + "°";
    }

    public String getTime12() {
        return mTime12;
    }

    public String getTime24() {
        return mTime24;
    }

    public String getTempF() {
        return mTempF;
    }

    public String getTempC() {
        return mTempC;
    }
}
