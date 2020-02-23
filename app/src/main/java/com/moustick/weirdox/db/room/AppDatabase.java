package com.moustick.weirdox.db.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Weirdo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract WeirdoDAO weirdoDAO();
}
