package com.moustick.weirdox.ui.sounds;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SoundsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SoundsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}