package com.charlesdrews.dontforget.weather;

import android.support.annotation.NonNull;

import com.charlesdrews.dontforget.BaseContract;
import com.charlesdrews.dontforget.weather.model.CurrentCondition;
import com.charlesdrews.dontforget.weather.model.DayForecast;
import com.charlesdrews.dontforget.weather.model.HourForecast;

import java.util.List;

import io.reactivex.Observable;

/**
 * Defines responsibilities of View and Presenter for the Weather feature
 * Created by charlie on 4/14/17.
 */

public interface WeatherContracts {

    int MAX_AGE_OF_WEATHER_DATA_IN_MIN = 60;

    interface View extends BaseContract.View<Presenter> {
        void showCurrentCondition(@NonNull CurrentCondition currentCondition);

        void showHourlyForecast(@NonNull List<HourForecast> hourlyForecast);

        void showDailyForecast(@NonNull List<DayForecast> dailyForecast);
    }

    interface Presenter extends BaseContract.Presenter {
        void onRefreshRequested();
    }

    interface DataSource {
        Observable<CurrentCondition> getCurrentCondition();

        Observable<List<HourForecast>> getHourlyForecast();

        Observable<List<DayForecast>> getDailyForecast();

        interface Local {
            CurrentCondition getCurrentCondition();

            List<HourForecast> getHourlyForecast();

            List<DayForecast> getDailyForecast();

            boolean saveCurrentCondition(@NonNull CurrentCondition currentCondition);

            boolean saveHourlyForecast(@NonNull List<HourForecast> hourlyForecast);

            boolean saveDailyForecast(@NonNull List<DayForecast> dailyForecast);
        }

        interface Remote {
            CurrentCondition getCurrentCondition();

            List<HourForecast> getHourlyForecast();

            List<DayForecast> getDailyForecast();
        }
    }
}
