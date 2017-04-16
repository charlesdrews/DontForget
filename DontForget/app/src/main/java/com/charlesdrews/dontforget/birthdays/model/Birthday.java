package com.charlesdrews.dontforget.birthdays.model;

import android.support.annotation.NonNull;

import java.util.Calendar;

/**
 * Created by charlie on 4/16/17.
 */

public class Birthday {
    public static final int UNKNOWN_YEAR = -1;

    private long mId;
    private String mName;
    private int mYearOfBirth, mMonthOfBirth, mDayOfBirth;
    private boolean mNotificationWanted;

    public Birthday(long id, @NonNull String name, int yearOfBirth, int monthOfBirth,
                    int dayOfBirth, boolean notificationWanted) {
        mId = id;
        mName = name;
        mYearOfBirth = verifyYearOfBirth(yearOfBirth);
        mName = name;

        if (monthOfBirth < 0 || monthOfBirth > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12, inclusive");
        }
        mMonthOfBirth = monthOfBirth;

        if (dayOfBirth < 0 || dayOfBirth > 31) {
            throw new IllegalArgumentException("Day must be between 1 and 31, inclusive");
        }
        mDayOfBirth = dayOfBirth;

        mNotificationWanted = notificationWanted;
    }

    public long getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(@NonNull String name) {
        mName = name;
    }

    public int getYearOfBirth() {
        return mYearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        mYearOfBirth = verifyYearOfBirth(yearOfBirth);
    }

    private int verifyYearOfBirth(int yearOfBirth) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (yearOfBirth <= currentYear) {
            return yearOfBirth;
        } else {
            return UNKNOWN_YEAR;
        }
    }

    public int getMonthOfBirth() {
        return mMonthOfBirth;
    }

    public void setMonthOfBirth(int monthOfBirth) {
        if (monthOfBirth > 0 && monthOfBirth < 13) {
            mMonthOfBirth = monthOfBirth;
        }
    }

    public int getDayOfBirth() {
        return mDayOfBirth;
    }

    public void setDayOfBirth(int dayOfBirth) {
        if (dayOfBirth > 0 && dayOfBirth < 32) {
            mDayOfBirth = dayOfBirth;
        }
    }

    public boolean isNotificationWanted() {
        return mNotificationWanted;
    }

    public void setNotificationWanted(boolean notificationWanted) {
        mNotificationWanted = notificationWanted;
    }
}
