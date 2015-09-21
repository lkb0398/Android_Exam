
package com.lkb0398nate.androidexam.database.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.lkb0398nate.androidexam.database.contract.UserContract;

/**
 * Created by kb on 2015-09-18. 내가 만들었다.
 */
public class UserDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "User.db";
    public static final int DATABASE_VERSION = 1;
    private static final String SQL_CREATE_ENTRIES = " CREATE TABLE "
            + UserContract.UserEntry.TABLE_NAME + " (" +
            " " + UserContract.UserEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " " + UserContract.UserEntry.COLUMN_NAME_NICKNAME + " TEXT NOT NULL, " +
            " " + UserContract.UserEntry.COLUMN_NAME_EMAIL + " TEXT NOT NULL UNIQUE, " +
            " " + UserContract.UserEntry.COLUMN_NAME_PASSWORD + " TEXT NOT NULL " +
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

    public long inser(String nickname, String email, String password) {
        // Gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(UserContract.UserEntry.COLUMN_NAME_NICKNAME, nickname);
        values.put(UserContract.UserEntry.COLUMN_NAME_EMAIL, email);
        values.put(UserContract.UserEntry.COLUMN_NAME_PASSWORD, password);

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(UserContract.UserEntry.TABLE_NAME, null, values);

        return newRowId;
    }

    public Cursor query() {

        SQLiteDatabase db = getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.

        // 컬럼명 정의
        String[] projection = {
                UserContract.UserEntry._ID,
                UserContract.UserEntry.COLUMN_NAME_NICKNAME,
                UserContract.UserEntry.COLUMN_NAME_EMAIL,
                UserContract.UserEntry.COLUMN_NAME_PASSWORD
        };

        Cursor c = db.query(
                UserContract.UserEntry.TABLE_NAME, // 테이블 명
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
        values.put(UserContract.UserEntry.COLUMN_NAME_PASSWORD, newPassword);

        // E-mail 이 ? 와 같다면
        String selection = UserContract.UserEntry.COLUMN_NAME_EMAIL + " = ?";
        // ? 에 들어갈 값을 바인딩.
        String[] selectionArgs = {
                String.valueOf(email)
        };

        int count = db.update(
                UserContract.UserEntry.TABLE_NAME,
                values,
                selection,
                selectionArgs);

        return count;
    }

}
