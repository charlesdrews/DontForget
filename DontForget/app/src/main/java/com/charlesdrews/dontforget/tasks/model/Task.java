package com.charlesdrews.dontforget.tasks.model;

import android.support.annotation.NonNull;

import com.charlesdrews.dontforget.tasks.TasksContract;

/**
 * Models an individual task to be completed by the user
 * Created by charlie on 4/16/17.
 */

public class Task implements Comparable<Task> {
    private long mId, mUnixTimestamp;
    private int mTimeOfDay;
    private boolean mCompleted;
    private String mTitle, mDescription;

    public Task(long id, long unixTimestamp, int timeOfDay, boolean completed, String title, String description) {
        mId = id;
        mUnixTimestamp = unixTimestamp;
        mTimeOfDay = verifyTimeOfDay(timeOfDay);
        mCompleted = completed;
        mTitle = title;
        mDescription = description;
    }

    public long getId() {
        return mId;
    }

    public long getUnixTimestamp() {
        return mUnixTimestamp;
    }

    public void setUnixTimestamp(long unixTimestamp) {
        if (unixTimestamp > 0) {
            mUnixTimestamp = unixTimestamp;
        }
    }

    public int getTimeOfDay() {
        return mTimeOfDay;
    }

    public void setTimeOfDay(int timeOfDay) {
        mTimeOfDay = verifyTimeOfDay(timeOfDay);
    }

    public boolean isCompleted() {
        return mCompleted;
    }

    public void setCompleted(boolean completed) {
        mCompleted = completed;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(@NonNull String title) {
        mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(@NonNull String description) {
        mDescription = description;
    }

    @Override
    public int compareTo(@NonNull Task o) {
        if (this.isCompleted() && !o.isCompleted()) {
            return -1;
        } else if (!this.isCompleted() && o.isCompleted()) {
            return 1;
        } else if (this.getUnixTimestamp() == o.getUnixTimestamp()) {
            return this.getTimeOfDay() - o.getTimeOfDay();
        } else {
            return (int) (this.getUnixTimestamp() - o.getUnixTimestamp());
        }
    }

    private int verifyTimeOfDay(int timeOfDay) {
        switch (timeOfDay) {
            case TasksContract.BEFORE_WORK:
            case TasksContract.LUNCHTIME:
            case TasksContract.AFTER_WORK:
            case TasksContract.EVENING:
                return timeOfDay;
            default:
                return TasksContract.BEFORE_WORK;
        }
    }
}
