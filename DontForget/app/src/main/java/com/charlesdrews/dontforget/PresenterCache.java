package com.charlesdrews.dontforget;

import android.util.SparseArray;

import com.charlesdrews.dontforget.birthdays.BirthdaysContract;
import com.charlesdrews.dontforget.birthdays.BirthdaysPresenter;
import com.charlesdrews.dontforget.data.DataSource;
import com.charlesdrews.dontforget.summary.SummaryContract;
import com.charlesdrews.dontforget.summary.SummaryPresenter;
import com.charlesdrews.dontforget.tasks.TasksContract;
import com.charlesdrews.dontforget.tasks.TasksPresenter;
import com.charlesdrews.dontforget.weather.WeatherContract;
import com.charlesdrews.dontforget.weather.WeatherPresenter;

/**
 * Preserve presenters across device rotations by storing them in this singleton
 * Created by charlie on 4/14/17.
 */

public class PresenterCache {
    private static final PresenterCache INSTANCE = new PresenterCache();

    private SparseArray<BaseContract.Presenter> mPresenters;

    public static PresenterCache getInstance() {
        return INSTANCE;
    }

    private PresenterCache() {
        mPresenters = new SparseArray<>(MainActivity.NUM_FRAGMENTS);
    }

    public BaseContract.Presenter getPresenter(int presenterType, DataSource dataSource,
                                               BaseContract.View<?> view) {

        BaseContract.Presenter presenter = mPresenters.get(presenterType, null);

        if (presenter == null) {
            switch (presenterType) {
                case MainActivity.DAILY_SUMMARY:
                    presenter = new SummaryPresenter(dataSource, (SummaryContract.View) view);
                    break;
                case MainActivity.WEATHER:
                    presenter = new WeatherPresenter(dataSource, (WeatherContract.View) view);
                    break;
                case MainActivity.TASKS:
                    presenter = new TasksPresenter(dataSource, (TasksContract.View) view);
                    break;
                case MainActivity.BIRTHDAYS:
                    presenter = new BirthdaysPresenter(dataSource, (BirthdaysContract.View) view);
                    break;
                default:
                    return null;
            }
            mPresenters.put(presenterType, presenter);
        }
        return presenter;
    }

    public void removePresenter(int presenterType) {
        mPresenters.delete(presenterType);
    }

    public void clearAllPresenters() {
        mPresenters.clear();
    }
}
