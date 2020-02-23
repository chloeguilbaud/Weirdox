package com.moustick.weirdox.database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WeirdosViewModel extends AndroidViewModel {

    private WeirdoDAO weirdoDAO;
    private LiveData<List<Weirdo>> directorsLiveData;

    public WeirdosViewModel(@NonNull Application application) {
        super(application);
        weirdoDAO = WeirdoxDatabase.getDatabase(application).weirdoDAO();
        directorsLiveData = weirdoDAO.getAll();
    }

    public LiveData<List<Weirdo>> getDirectorList() {
        return directorsLiveData;
    }

    public void insert(Weirdo... directors) {
        weirdoDAO.insert(directors);
    }

    public void update(Weirdo director) {
        weirdoDAO.update(director);
    }

    public void deleteAll() {
        weirdoDAO.deleteAll();
    }

}
