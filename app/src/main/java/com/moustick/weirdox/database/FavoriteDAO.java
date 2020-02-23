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
public interface FavoriteDAO {

    @Query("SELECT * FROM favorite")
    LiveData<List<Favorite>> getAll();

    @Query("SELECT * FROM favorite WHERE fid = :id LIMIT 1")
    Favorite findById(int id);

    @Query("SELECT * FROM favorite WHERE title LIKE :title LIMIT 1")
    Favorite findByName(String title);

    @Query("SELECT * FROM favorite WHERE fid IN (:favoriteIds)")
    List<Favorite> loadAllByIds(int[] favoriteIds);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(Favorite director);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Favorite... favorites);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void update(Favorite favorite);

    @Delete
    void delete(Favorite favorite);

    @Query("DELETE FROM favorite")
    void deleteAll();

}
