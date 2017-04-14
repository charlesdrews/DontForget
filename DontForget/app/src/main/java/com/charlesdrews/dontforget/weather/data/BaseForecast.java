package com.charlesdrews.dontforget.weather.data;

import android.os.Build;
import android.text.Html;

/**
 * Parent class for both HourForecast and DayForecast
 * Created by charlie on 4/14/17.
 */

public class BaseForecast {
    protected static final String SNOWFLAKE = htmlToString("&#10052;");
    protected static final String RAINDROP = htmlToString("&#128167;");

    private static String htmlToString(String html) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(html, Html.FROM_HTML_MODE_COMPACT).toString();
        } else {
            return Html.fromHtml(html).toString();
        }
    }

    private String mIconUrl, mProbOfPrecip;

    public BaseForecast(String iconUrl, int probOfPrecip, boolean snowNotRain) {
        mIconUrl = iconUrl;
        mProbOfPrecip = (snowNotRain ? SNOWFLAKE : RAINDROP) + " " + probOfPrecip + "%";
    }

    public String getIconUrl() {
        return mIconUrl;
    }

    public String getProbOfPrecip() {
        return mProbOfPrecip;
    }
}
