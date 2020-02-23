package com.moustick.weirdox.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WeirdoDAO {

    @Query("SELECT * FROM weirdo")
    LiveData<List<Weirdo>> getAll();

    @Query("SELECT * FROM weirdo WHERE wid = :id LIMIT 1")
    Weirdo findById(int id);

    @Query("SELECT * FROM weirdo WHERE name LIKE :name LIMIT 1")
    Weirdo findByName(String name);

    @Query("SELECT * FROM weirdo WHERE wid IN (:weirdoIds)")
    List<Weirdo> loadAllByIds(int[] weirdoIds);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(Weirdo director);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Weirdo... weirdos);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void update(Weirdo weirdo);

    @Delete
    void delete(Weirdo weirdo);

    @Query("DELETE FROM weirdo")
    void deleteAll();

}
