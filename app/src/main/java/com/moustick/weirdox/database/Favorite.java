package com.moustick.weirdox.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "favorite",
        indices = {@Index(value = "title", unique = true)})
public class Favorite {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "fid")
    public int id;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "sound_id")
    public int soundId;

    public Favorite(String title, int soundId) {
        this.soundId = soundId;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", soundId=" + soundId +
                '}';
    }

}
