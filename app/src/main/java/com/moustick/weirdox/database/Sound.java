package com.moustick.weirdox.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "sound",
        indices = {@Index(value = "title", unique = true)})
public class Sound {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "sid")
    public int id;

    @ColumnInfo(name = "title")
    @NonNull
    public String title;

    @ColumnInfo(name = "audio")
    @NonNull
    public String audio;

    @ColumnInfo(name = "weirdoId")
    public int weirdoId;


    public Sound(@NonNull String title, @NonNull String audio, int weirdoId) {
        this.title = title;
        this.audio = audio;
        this.weirdoId = weirdoId;
    }

    @Override
    public String toString() {
        return "Sound{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", audio='" + audio + '\'' +
                ", weirdoId=" + weirdoId +
                '}';
    }

}
