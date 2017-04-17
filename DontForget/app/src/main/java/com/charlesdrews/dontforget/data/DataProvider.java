package com.charlesdrews.dontforget.data;

import android.support.annotation.NonNull;

import com.charlesdrews.dontforget.birthdays.BirthdaysContract;
import com.charlesdrews.dontforget.birthdays.model.Birthday;
import com.charlesdrews.dontforget.tasks.model.Task;
import com.charlesdrews.dontforget.weather.WeatherContract;
import com.charlesdrews.dontforget.weather.model.CurrentCondition;
import com.charlesdrews.dontforget.weather.model.DayForecast;
import com.charlesdrews.dontforget.weather.model.HourForecast;

import java.util.List;

/**
 * Data source implementation that will pull from local and remote sources as needed,
 * and convert their output to Observables
 * Created by charlie on 4/16/17.
 */

public class DataProvider implements DataSource {

    private static final DataProvider INSTANCE = new DataProvider();

    private boolean mInitialized = false;
    private DataSource mLocalDataSource;
    private WeatherContract.DataSource mWeatherRemote;
    private BirthdaysContract.DataSource mBirthdaysRemote;

    private DataProvider() {
    }

    public static DataProvider getInstance(DataSource localDataSource,
                                           WeatherContract.DataSource weatherRemote,
                                           BirthdaysContract.DataSource birthdaysRemote) {
        if (!INSTANCE.mInitialized) {
            INSTANCE.mLocalDataSource = localDataSource;
            INSTANCE.mWeatherRemote = weatherRemote;
            INSTANCE.mBirthdaysRemote = birthdaysRemote;

            INSTANCE.mInitialized = true;
        }

        return INSTANCE;
    }


    // ---------------------------------------------------------------------------------------
    // WeatherContract.DataProvider methods
    // ---------------------------------------------------------------------------------------
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

    @Override
    public boolean saveCurrentCondition(@NonNull CurrentCondition currentCondition) {
        //TODO
        return false;
    }

    @Override
    public boolean saveHourlyForecast(@NonNull List<HourForecast> hourlyForecast) {
        //TODO
        return false;
    }

    @Override
    public boolean saveDailyForecast(@NonNull List<DayForecast> dailyForecast) {
        //TODO
        return false;
    }


    // ---------------------------------------------------------------------------------------
    // TasksContracts.DataProvider methods
    // ---------------------------------------------------------------------------------------
    @Override
    public List<Task> getTasks() {
        //TODO
        return null;
    }

    @Override
    public boolean saveTask(@NonNull Task task) {
        //TODO
        return false;
    }

    @Override
    public boolean deleteTask(@NonNull Task task) {
        //TODO
        return false;
    }

    @Override
    public boolean deleteTask(long taskId) {
        //TODO
        return false;
    }


    // ---------------------------------------------------------------------------------------
    // BirthdaysContracts.DataProvider methods
    // ---------------------------------------------------------------------------------------
    @Override
    public List<Birthday> getBirthdays() {
        List<Birthday> birthdays = mLocalDataSource.getBirthdays();

        if (birthdays.isEmpty()) {
            birthdays = mBirthdaysRemote.getBirthdays();

            for (Birthday birthday : birthdays) {
                mLocalDataSource.saveBirthday(birthday);
            }
        }

        return birthdays;
    }

    @Override
    public boolean saveBirthday(@NonNull final Birthday birthday) {
        return mLocalDataSource.saveBirthday(birthday);
    }
}
