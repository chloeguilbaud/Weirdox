package com.moustick.weirdox.db.roomtest;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MovieDao {
    @Query("SELECT * FROM movie WHERE mid = :id LIMIT 1")
    Movie findDirectorById(int id);
    @Query("SELECT * FROM movie WHERE title = :fullName LIMIT 1")
    Movie findDirectorByName(String fullName);
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(Movie movie);
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Movie... movies);
    @Update(onConflict = OnConflictStrategy.IGNORE)
    void update(Movie movie);
    @Query("DELETE FROM movie")
    void deleteAll();
    @Query("SELECT * FROM movie ORDER BY title ASC")
    LiveData<List<Movie>> getAllMovies();
}
