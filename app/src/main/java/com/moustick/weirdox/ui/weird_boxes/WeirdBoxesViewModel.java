package com.moustick.weirdox.ui.weird_boxes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WeirdBoxesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public WeirdBoxesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}