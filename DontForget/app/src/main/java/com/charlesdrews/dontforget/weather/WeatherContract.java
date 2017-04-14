package com.charlesdrews.dontforget.weather;

import android.support.annotation.NonNull;

import com.charlesdrews.dontforget.BaseContract;
import com.charlesdrews.dontforget.weather.data.CurrentCondition;
import com.charlesdrews.dontforget.weather.data.DayForecast;
import com.charlesdrews.dontforget.weather.data.HourForecast;

import java.util.List;

/**
 * Defines responsibilities of View and Presenter for the Weather feature
 * Created by charlie on 4/14/17.
 */

public interface WeatherContract {

    interface View extends BaseContract.View<Presenter> {
        void showCurrentCondition(@NonNull CurrentCondition currentCondition);
        void showHourlyForecast(@NonNull List<HourForecast> hourlyForecast);
        void showDailyForecast(@NonNull List<DayForecast> dailyForecast);
    }

    interface Presenter extends BaseContract.Presenter {
        void onRefreshRequested();
    }
}
