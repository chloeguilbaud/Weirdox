package com.moustick.weirdox.database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WeirdosViewModel extends AndroidViewModel {

    private WeirdoDAO weirdoDAO;
    private LiveData<List<Weirdo>> weirdosLiveData;

    public WeirdosViewModel(@NonNull Application application) {
        super(application);
        weirdoDAO = WeirdoxDatabase.getDatabase(application).weirdoDAO();
        weirdosLiveData = weirdoDAO.getAll();
    }

    public LiveData<List<Weirdo>> getWeirdoList() {
        return weirdosLiveData;
    }

    public void insert(Weirdo... weirdos) {
        weirdoDAO.insert(weirdos);
    }

    public void update(Weirdo weirdo) {
        weirdoDAO.update(weirdo);
    }

    public void deleteAll() {
        weirdoDAO.deleteAll();
    }

}
