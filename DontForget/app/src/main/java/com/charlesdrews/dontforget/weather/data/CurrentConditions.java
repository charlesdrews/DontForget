package com.charlesdrews.dontforget.weather.data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by charlie on 4/13/17.
 */

public class CurrentConditions {
    private String mDate, mTime12, mTime24;
    private String mConditionDesc, mIconUrl, mLocation;
    private int mTempF, mTempC;

    public CurrentConditions(String conditionDesc, String iconUrl, String location, int tempF, int tempC) {
        Date now = new Date();
        mDate = new SimpleDateFormat("EEEE, MMM d", Locale.getDefault()).format(now);
        mTime12 = new SimpleDateFormat("h:mm a", Locale.getDefault()).format(now);
        mTime24 = new SimpleDateFormat("H:mm", Locale.getDefault()).format(now);

        mConditionDesc = conditionDesc;
        mIconUrl = iconUrl;
        mLocation = location;
        mTempF = tempF;
        mTempC = tempC;
    }

    public String getDate() {
        return mDate;
    }

    public String getTime12() {
        return mTime12;
    }

    public String getTime24() {
        return mTime24;
    }

    public String getConditionDesc() {
        return mConditionDesc;
    }

    public String getIconUrl() {
        return mIconUrl;
    }

    public String getLocation() {
        return mLocation;
    }

    public int getTempF() {
        return mTempF;
    }

    public int getTempC() {
        return mTempC;
    }
}
