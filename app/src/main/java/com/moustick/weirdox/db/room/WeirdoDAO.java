package com.moustick.weirdox.db.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WeirdoDAO {

    @Query("SELECT * FROM weirdo")
    List<Weirdo> getAll();

    @Query("SELECT * FROM weirdo WHERE uid IN (:weirdoIds)")
    List<Weirdo> loadAllByIds(int[] weirdoIds);

    @Query("SELECT * FROM weirdo WHERE name LIKE :name LIMIT 1")
    Weirdo findByName(String name);

    @Insert
    void insertAll(Weirdo... weirdos);

    @Delete
    void delete(Weirdo weirdo);

}
