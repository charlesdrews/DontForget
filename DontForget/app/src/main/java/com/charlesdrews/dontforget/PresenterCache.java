package com.charlesdrews.dontforget;

import android.util.SparseArray;

import com.charlesdrews.dontforget.birthdays.BirthdaysPresenter;
import com.charlesdrews.dontforget.summary.SummaryPresenter;
import com.charlesdrews.dontforget.tasks.TasksPresenter;
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

    public BaseContract.Presenter getPresenter(int presenterType) {
        BaseContract.Presenter presenter = mPresenters.get(presenterType, null);

        if (presenter == null) {
            switch (presenterType) {
                case MainActivity.DAILY_SUMMARY:
                    presenter = new SummaryPresenter();
                    break;
                case MainActivity.WEATHER:
                    presenter = new WeatherPresenter();
                    break;
                case MainActivity.TASKS:
                    presenter = new TasksPresenter();
                    break;
                case MainActivity.BIRTHDAYS:
                    presenter = new BirthdaysPresenter();
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

    }
}
