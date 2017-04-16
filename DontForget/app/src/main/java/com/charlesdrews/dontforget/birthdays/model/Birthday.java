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
    private int mYearOfBirth, mMonth, mDay;
    private boolean mNotificationWanted;

    public Birthday(long id, @NonNull String name, int yearOfBirth, int month,
                    int day, boolean notificationWanted) {
        mId = id;
        mName = name;
        mYearOfBirth = verifyYearOfBirth(yearOfBirth);
        mName = name;

        if (month < 0 || month > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12, inclusive");
        }
        mMonth = month;

        if (day < 0 || day > 31) {
            throw new IllegalArgumentException("Day must be between 1 and 31, inclusive");
        }
        mDay = day;

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

    public int getMonth() {
        return mMonth;
    }

    public void setMonth(int month) {
        if (month > 0 && month < 13) {
            mMonth = month;
        }
    }

    public int getDay() {
        return mDay;
    }

    public void setDay(int day) {
        if (day > 0 && day < 32) {
            mDay = day;
        }
    }

    /**
     * Determine whether this birthday has already occurred during the current calendar year.
     *
     * @param daysToLookBack - If > 0 then return this year for birthdays up to this many days ago.
     * @return If birthday is after today, or within the last daysToLookBack days, this year,
     * else next year.
     */
    public int getYearOfNextBirthday(int daysToLookBack) {
        Calendar threshold = Calendar.getInstance();
        int currentYear = threshold.get(Calendar.YEAR);

        threshold.add(Calendar.DAY_OF_MONTH, -daysToLookBack);

        Calendar birthday = Calendar.getInstance();
        birthday.set(currentYear, mMonth, mDay);

        if (birthday.before(threshold)) {
            return currentYear + 1;
        } else {
            return currentYear;
        }
    }

    public boolean isNotificationWanted() {
        return mNotificationWanted;
    }

    public void setNotificationWanted(boolean notificationWanted) {
        mNotificationWanted = notificationWanted;
    }
}
