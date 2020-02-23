package com.moustick.weirdox.database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.moustick.weirdox.db.roomtest.Director;
import com.moustick.weirdox.db.roomtest.DirectorDao;
import com.moustick.weirdox.db.roomtest.MoviesDatabase;

import java.util.List;

public class WeirdosViewModel extends AndroidViewModel {

    private DirectorDao directorDao;
    private LiveData<List<Director>> directorsLiveData;

    public WeirdosViewModel(@NonNull Application application) {
        super(application);
        directorDao = MoviesDatabase.getDatabase(application).directorDao();
        directorsLiveData = directorDao.getAllDirectors();
    }

    public LiveData<List<Director>> getDirectorList() {
        return directorsLiveData;
    }

    public void insert(Director... directors) {
        directorDao.insert(directors);
    }

    public void update(Director director) {
        directorDao.update(director);
    }

    public void deleteAll() {
        directorDao.deleteAll();
    }

}
