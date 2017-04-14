package com.charlesdrews.dontforget.weather.data;

/**
 * Models a weather forecast for a specified day
 * Created by charlie on 4/14/17.
 */

public class DayForecast extends BaseForecast {
    private String mDate, mHighLowF, mHighLowC;

    public DayForecast(String monthName, int day, int highF, int lowF, int highC, int lowC,
                       String iconUrl, int probOfPrecip, boolean snowNotRain) {
        super(iconUrl, probOfPrecip, snowNotRain);

        mDate = ((monthName.length() > 2) ? monthName.substring(0, 3) : monthName) + " " + day;

        mHighLowF = highF + "°/" + lowF + "°";
        mHighLowC = highC + "°/" + lowC + "°";
    }

    public String getDate() {
        return mDate;
    }

    public String getHighLowF() {
        return mHighLowF;
    }

    public String getHighLowC() {
        return mHighLowC;
    }
}
