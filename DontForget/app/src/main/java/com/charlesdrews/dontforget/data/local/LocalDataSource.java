package com.charlesdrews.dontforget.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
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

/**
 * Helper for local SQLite database
 * Created by charlie on 4/16/17.
 */

public class LocalDataSource extends SQLiteOpenHelper implements WeatherContracts.DataSource.Local,
        TasksContract.DataSource.Local, BirthdaysContract.DataSource.Local {

    public LocalDataSource(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        //TODO
        super(context, name, factory, version);
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
    // WeatherContract.DataSource.Local methods
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
    // TasksContract.DataSource.Local methods
    // ----------------------------------------------------------------------------------------
    @Override
    public List<Task> getTasks() {
        //TODO
        return null;
    }

    @Override
    public long saveTask(@NonNull Task task) {
        //TODO
        return 0;
    }

    @Override
    public boolean updateTask(@NonNull Task task) {
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
    // BirthdaysContract.DataSource.Local methods
    // ----------------------------------------------------------------------------------------
    @Override
    public List<Birthday> getBirthdays() {
        //TODO
        return null;
    }

    @Override
    public long saveBirthday(Birthday birthday) {
        //TODO
        return 0;
    }

    @Override
    public boolean updateBirthday(Birthday birthday) {
        //TODO
        return false;
    }
}
