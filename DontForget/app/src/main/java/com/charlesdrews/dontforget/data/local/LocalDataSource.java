package com.charlesdrews.dontforget.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import com.charlesdrews.dontforget.birthdays.BirthdaysContract;
import com.charlesdrews.dontforget.birthdays.model.Birthday;
import com.charlesdrews.dontforget.data.DataSource;
import com.charlesdrews.dontforget.tasks.TasksContract;
import com.charlesdrews.dontforget.tasks.model.Task;
import com.charlesdrews.dontforget.weather.WeatherContract;
import com.charlesdrews.dontforget.weather.model.CurrentCondition;
import com.charlesdrews.dontforget.weather.model.DayForecast;
import com.charlesdrews.dontforget.weather.model.HourForecast;

import java.util.List;

/**
 * Helper for local SQLite database
 * Created by charlie on 4/16/17.
 */

public class LocalDataSource extends SQLiteOpenHelper implements DataSource {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "dontforget.db";

    private static LocalDataSource sInstance;

    private LocalDataSource(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static LocalDataSource getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new LocalDataSource(context.getApplicationContext());
        }
        return sInstance;
    }


    // ----------------------------------------------------------------------------------------
    // SQLiteOpenHelper methods
    // ----------------------------------------------------------------------------------------
    @Override
    public void onCreate(SQLiteDatabase db) {
        //TODO
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //TODO
    }


    // ----------------------------------------------------------------------------------------
    // WeatherContract.DataProvider.Local methods
    // ----------------------------------------------------------------------------------------
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


    // ----------------------------------------------------------------------------------------
    // TasksContract.DataProvider.Local methods
    // ----------------------------------------------------------------------------------------
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


    // ----------------------------------------------------------------------------------------
    // BirthdaysContract.DataProvider.Local methods
    // ----------------------------------------------------------------------------------------
    @Override
    public List<Birthday> getBirthdays() {
        //TODO
        return null;
    }

    @Override
    public boolean saveBirthday(@NonNull Birthday birthday) {
        //TODO
        return false;
    }
}
