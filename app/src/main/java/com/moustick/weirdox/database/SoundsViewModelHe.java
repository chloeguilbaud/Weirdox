package com.moustick.weirdox.database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class SoundsViewModelHe extends AndroidViewModel {

    private SoundDAO soundDAO;
    private LiveData<List<Sound>> soundsLiveData;

    public SoundsViewModelHe(@NonNull Application application) {
        super(application);
        soundDAO = WeirdoxDatabase.getDatabase(application).soundDAO();
        soundsLiveData = soundDAO.getAll();
    }

    public LiveData<List<Sound>> getSoundList() {
        return soundsLiveData;
    }

    public void insert(Sound... sounds) {
        soundDAO.insert(sounds);
    }

    public void update(Sound sound) {
        soundDAO.update(sound);
    }

    public void deleteAll() {
        soundDAO.deleteAll();
    }

}
