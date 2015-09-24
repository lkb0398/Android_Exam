
package com.lkb0398nate.androidexam.database.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.lkb0398nate.androidexam.database.contract.ScheduleContract;

/**
 * Created by kb on 2015-09-18. 내가 만들었다.
 */
public class UserDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "User.db";
    public static final int DATABASE_VERSION = 1;
    private static final String SQL_CREATE_ENTRIES = " CREATE TABLE "
            + ScheduleContract.ScheduleEntry.TABLE_NAME + " (" +
            " " + ScheduleContract.ScheduleEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " " + ScheduleContract.ScheduleEntry.COLUMN_NAME_HOUR + " TEXT NOT NULL, " +
            " " + ScheduleContract.ScheduleEntry.COLUMN_NAME_MINUTE + " TEXT NOT NULL UNIQUE, " +
            " " + ScheduleContract.ScheduleEntry.COLUMN_NAME_CONTENTS + " TEXT NOT NULL " +
            ");";

    public UserDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insert(String nickname, String email, String password) {
        // Gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(ScheduleContract.ScheduleEntry.COLUMN_NAME_HOUR, nickname);
        values.put(ScheduleContract.ScheduleEntry.COLUMN_NAME_MINUTE, email);
        values.put(ScheduleContract.ScheduleEntry.COLUMN_NAME_CONTENTS, password);

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(ScheduleContract.ScheduleEntry.TABLE_NAME, null, values);

        return newRowId;
    }

    public Cursor query() {

        SQLiteDatabase db = getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.

        // 컬럼명 정의
        String[] projection = {
                ScheduleContract.ScheduleEntry._ID,
                ScheduleContract.ScheduleEntry.COLUMN_NAME_HOUR,
                ScheduleContract.ScheduleEntry.COLUMN_NAME_MINUTE,
                ScheduleContract.ScheduleEntry.COLUMN_NAME_CONTENTS
        };

        Cursor c = db.query(
                ScheduleContract.ScheduleEntry.TABLE_NAME, // 테이블 명
                projection, // 컬럼명 배열
                null, // WHERE 절의 컬럼명
                null, // WHERE 절의 값
                null, // group by (그룹명)
                null, // having (그룹명)
                null // order by (정렬)
                );

        return c;

    }

    public int update(String email, String newPassword) {

        SQLiteDatabase db = getReadableDatabase();

        // 패스워드 변경
        ContentValues values = new ContentValues();
        values.put(ScheduleContract.ScheduleEntry.COLUMN_NAME_CONTENTS, newPassword);

        // E-mail 이 ? 와 같다면
        String selection = ScheduleContract.ScheduleEntry.COLUMN_NAME_MINUTE + " = ?";
        // ? 에 들어갈 값을 바인딩.
        String[] selectionArgs = {
                String.valueOf(email)
        };

        int count = db.update(
                ScheduleContract.ScheduleEntry.TABLE_NAME,
                values,
                selection,
                selectionArgs);

        return count;
    }

    public boolean delete(String email) {

        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("Delete .....");

        // Define 'where' part of query.
        String selection = ScheduleContract.ScheduleEntry.COLUMN_NAME_MINUTE + " = '" + email + "'";
        // 지울 조건
        // Issue SQL statement.
        int deleted = db.delete(ScheduleContract.ScheduleEntry.TABLE_NAME, selection, null);

        return deleted == 0;
    }

}
