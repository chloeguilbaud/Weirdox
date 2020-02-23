package com.moustick.weirdox.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DBHelper {

    private static DBAssistant dbAssistant;
    private static SQLiteDatabase sqLiteDatabase;
    private static boolean open = false;

    /**
     * Creates and opens database
     *
     * @param context
     */
    public static SQLiteDatabase openDataBase(Context context) {
        // Database creation (DBAssistant calls: onCreate(), onUpgrade() and onOpen())
        dbAssistant = new DBAssistant(context);
        sqLiteDatabase = dbAssistant.getWritableDatabase();
        open = true;
        return sqLiteDatabase;
    }

    public static void closeDataBase() {
        dbAssistant.close();
        sqLiteDatabase.close();
        open = false;
    }

    public static String getDatabaseName() {
        return dbAssistant.getDatabaseName();
    }

}
