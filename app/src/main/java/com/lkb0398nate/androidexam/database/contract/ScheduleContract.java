
package com.lkb0398nate.androidexam.database.contract;

import android.provider.BaseColumns;

/**
 * Created by kb on 2015-09-18.
 */
public final class ScheduleContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public ScheduleContract() {
    }

    /* Inner class that defines the table contents */
    public static abstract class ScheduleEntry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_HOUR = "nickname";
        public static final String COLUMN_NAME_MINUTE = "email";
        public static final String COLUMN_NAME_CONTENTS = "password";
    }
}
