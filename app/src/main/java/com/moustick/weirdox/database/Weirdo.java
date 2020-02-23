package com.moustick.weirdox.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "weirdo",
        indices = {@Index(value = "name", unique = true)})
public class Weirdo {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "wid")
    public int id;

    @ColumnInfo(name = "name")
    @NonNull
    public String name;

    @ColumnInfo(name = "avatar")
    @NonNull
    public String avatar;

    public Weirdo(@NonNull String name, @NonNull String avatar) {
        this.name = name;
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Weirdo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }

}
