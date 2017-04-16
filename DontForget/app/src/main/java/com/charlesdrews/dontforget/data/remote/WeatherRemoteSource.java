package com.charlesdrews.dontforget.data.remote;

import com.charlesdrews.dontforget.BuildConfig;
import com.charlesdrews.dontforget.weather.WeatherContracts;
import com.charlesdrews.dontforget.weather.model.CurrentCondition;
import com.charlesdrews.dontforget.weather.model.DayForecast;
import com.charlesdrews.dontforget.weather.model.HourForecast;

import java.util.List;

/**
 * Created by charlie on 4/16/17.
 */

public class WeatherRemoteSource implements WeatherContracts.DataSource.Remote {

    private static final String FORECAST_BASE_URL =
            String.format("http://api.wunderground.com/api/%s/", BuildConfig.WU_API_KEY);

    @Override
    public CurrentCondition getCurrentCondition() {
        //TODO
        return null;
    }

    @Override
    public List<HourForecast> getHourlyForecast() {
        //TODO
        return null;
    }

    @Override
    public List<DayForecast> getDailyForecast() {
        //TODO
        return null;
    }
}
