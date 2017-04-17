package com.charlesdrews.dontforget.data.remote;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;

import com.charlesdrews.dontforget.birthdays.BirthdaysContract;
import com.charlesdrews.dontforget.birthdays.model.Birthday;

import java.util.ArrayList;
import java.util.List;

/**
 * Retrieve contact names and birthdays from the Contacts content provider
 * Created by charlie on 4/16/17.
 */

public class BirthdaysRemoteSource implements BirthdaysContract.DataSource {

    private static final Uri URI = ContactsContract.Data.CONTENT_URI;

    private ContentResolver mContentResolver;

    public BirthdaysRemoteSource(@NonNull ContentResolver contentResolver) {
        mContentResolver = contentResolver;
    }

    @Override
    public List<Birthday> getBirthdays() {

        List<Birthday> birthdays = new ArrayList<>();

        String[] projection = new String[]{
                ContactsContract.Data._ID,
                //ContactsContract.Contacts.LOOKUP_KEY,
                ContactsContract.Data.DISPLAY_NAME_PRIMARY,
                ContactsContract.Data.CONTACT_ID,
                ContactsContract.CommonDataKinds.Event.CONTACT_ID,
                ContactsContract.CommonDataKinds.Event.START_DATE
        };

        String selection = ContactsContract.Data.MIMETYPE + " = ? AND " +
                ContactsContract.CommonDataKinds.Event.TYPE + " = ?";

        String[] selectionArgs = new String[]{
                ContactsContract.CommonDataKinds.Event.CONTENT_ITEM_TYPE,
                String.valueOf(ContactsContract.CommonDataKinds.Event.TYPE_BIRTHDAY)
        };

        Cursor cursor = mContentResolver.query(URI, projection, selection, selectionArgs, null);

        if (cursor !=null && cursor.moveToFirst()) {
            int idColNum = cursor.getColumnIndex(ContactsContract.Data.CONTACT_ID);
            //int lookupKeyColNum = cursor.getColumnIndex(ContactsContract.Contacts.LOOKUP_KEY);
            int nameColNum = cursor.getColumnIndex(ContactsContract.Data.DISPLAY_NAME_PRIMARY);
            int birthdayColNum = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Event.START_DATE);


            while (!cursor.isAfterLast()) {
                int[] yearMonthDay = getBirthdayParts(cursor.getString(birthdayColNum));
                final int birthYear = yearMonthDay[0]; // will be -1 if not known
                int month = yearMonthDay[1];
                int day = yearMonthDay[2];

                final int id = cursor.getInt(idColNum);
                final String name = cursor.getString(nameColNum);

                birthdays.add(new Birthday(id, name, birthYear, month, day, true));

                cursor.moveToNext();
            }

            cursor.close();
        }

        return birthdays;
    }

    @Override
    public boolean saveBirthday(@NonNull Birthday birthday) {
        return false;
    }

    /**
     * Parses birthday from format provided by Contacts Provider into array of parts.
     *
     * @param birthday - String from query
     * @return [Y, M, D] if input formatted YYYY-MM-DD] else [-1,M,D] if input formatted --MM-DD
     */
    public static int[] getBirthdayParts(String birthday) {
        int[] yearMonthDay = new int[3];
        String[] parts = birthday.split("-");

        if (parts.length > 3) { // year not known; input was --MM-DD; parts is [,,MM,DD]
            yearMonthDay[0] = -1;
            yearMonthDay[1] = Integer.parseInt(parts[2]);
            yearMonthDay[2] = Integer.parseInt(parts[3]);
        } else { // year know; input was YYYY-MM-DD; parts is [YYYY,MM,DD]
            yearMonthDay[0] = Integer.parseInt(parts[0]);
            yearMonthDay[1] = Integer.parseInt(parts[1]);
            yearMonthDay[2] = Integer.parseInt(parts[2]);
        }

        return yearMonthDay;
    }
}
