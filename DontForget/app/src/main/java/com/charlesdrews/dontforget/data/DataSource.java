package com.charlesdrews.dontforget.data;

import com.charlesdrews.dontforget.birthdays.BirthdaysContract;
import com.charlesdrews.dontforget.tasks.TasksContract;
import com.charlesdrews.dontforget.weather.WeatherContract;

/**
 * Our data provider will need to implement all of the required data source interfaces
 * Created by charlie on 4/16/17.
 */

public interface DataSource extends WeatherContract.DataSource, TasksContract.DataSource,
        BirthdaysContract.DataSource {

    // nothing to add
}
