package com.moustick.weirdox.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAssistant extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "weirdo_db";

    DBAssistant(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("TEST: onCreate");
        db.execSQL("CREATE TABLE weirdo (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, avatar TEXT)");
        //db.execSQL("INSERT INTO weirdo VALUES ('cindy', 'un avatar')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("TEST: onUpgrade");
        for (int indexVersion = oldVersion; indexVersion < newVersion; indexVersion++) {
            int nextVersion = indexVersion+1;
            switch (nextVersion) {
                case 2:
                    // Mise à jour pour la version 2
                    break;
                case 3:
                    // Mise à jour pour la version 3
                    break;
            }
        }
    }

    public String getDatabaseName() {
        return DB_NAME;
    }

}
