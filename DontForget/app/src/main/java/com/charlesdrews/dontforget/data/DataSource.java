package com.charlesdrews.dontforget.data;

import android.support.annotation.NonNull;

import com.charlesdrews.dontforget.birthdays.BirthdaysContract;
import com.charlesdrews.dontforget.birthdays.model.Birthday;
import com.charlesdrews.dontforget.tasks.TasksContract;
import com.charlesdrews.dontforget.tasks.model.Task;
import com.charlesdrews.dontforget.weather.WeatherContracts;
import com.charlesdrews.dontforget.weather.model.CurrentCondition;
import com.charlesdrews.dontforget.weather.model.DayForecast;
import com.charlesdrews.dontforget.weather.model.HourForecast;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * Data source implementation that will pull from local and remote sources as needed,
 * and convert their output to Observables
 * Created by charlie on 4/16/17.
 */

public class DataSource implements WeatherContracts.DataSource, TasksContract.DataSource,
        BirthdaysContract.DataSource {

    private static final DataSource INSTANCE = new DataSource();

    private boolean mInitialized = false;
    private WeatherContracts.DataSource.Local mWeatherLocal;
    private WeatherContracts.DataSource.Remote mWeatherRemote;
    private TasksContract.DataSource.Local mTasksLocal;
    private BirthdaysContract.DataSource.Local mBirthdaysLocal;
    private BirthdaysContract.DataSource.Remote mBirthdaysRemote;

    private DataSource() {
        // Empty private constructor
    }

    public static DataSource getInstance(WeatherContracts.DataSource.Local weatherLocal,
                                         WeatherContracts.DataSource.Remote weatherRemote,
                                         TasksContract.DataSource.Local tasksLocal,
                                         BirthdaysContract.DataSource.Local birthdaysLocal,
                                         BirthdaysContract.DataSource.Remote birthdaysRemote) {
        if (!INSTANCE.mInitialized) {
            INSTANCE.mWeatherLocal = weatherLocal;
            INSTANCE.mWeatherRemote = weatherRemote;
            INSTANCE.mTasksLocal = tasksLocal;
            INSTANCE.mBirthdaysLocal = birthdaysLocal;
            INSTANCE.mBirthdaysRemote = birthdaysRemote;

            INSTANCE.mInitialized = true;
        }

        return INSTANCE;
    }


    // ---------------------------------------------------------------------------------------
    // WeatherContracts.DataSource methods
    // ---------------------------------------------------------------------------------------
    @Override
    public Observable<CurrentCondition> getCurrentCondition() {
        //TODO
        return null;
    }

    @Override
    public Observable<List<HourForecast>> getHourlyForecast() {
        //TODO
        return null;
    }

    @Override
    public Observable<List<DayForecast>> getDailyForecast() {
        //TODO
        return null;
    }


    // ---------------------------------------------------------------------------------------
    // TasksContracts.DataSource methods
    // ---------------------------------------------------------------------------------------
    @Override
    public Observable<List<Task>> getTasks() {
        //TODO
        return null;
    }

    @Override
    public Completable saveTask(@NonNull Task task) {
        //TODO
        return null;
    }

    @Override
    public Completable updateTask(@NonNull Task task) {
        //TODO
        return null;
    }

    @Override
    public Completable deleteTask(@NonNull Task task) {
        //TODO
        return null;
    }

    @Override
    public Completable deleteTask(long taskId) {
        //TODO
        return null;
    }


    // ---------------------------------------------------------------------------------------
    // BirthdaysContracts.DataSource methods
    // ---------------------------------------------------------------------------------------
    @Override
    public Observable<List<Birthday>> getBirthdays() {
        //TODO
        return null;
    }

    @Override
    public Completable updateBirthday(@NonNull Birthday birthday) {
        //TODO
        return null;
    }
}
