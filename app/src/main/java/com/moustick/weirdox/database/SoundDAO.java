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
public interface SoundDAO {

    @Query("SELECT * FROM sound")
    LiveData<List<Sound>> getAll();

    @Query("SELECT * FROM sound WHERE sid = :id LIMIT 1")
    Sound findById(int id);

    @Query("SELECT * FROM sound WHERE title LIKE :title LIMIT 1")
    Sound findByName(String title);

    @Query("SELECT * FROM sound WHERE sid IN (:soundIds)")
    List<Sound> loadAllByIds(int[] soundIds);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(Sound director);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Sound... sounds);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void update(Sound sound);

    @Delete
    void delete(Sound sound);

    @Query("DELETE FROM sound")
    void deleteAll();

}
