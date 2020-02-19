package com.moustick.weirdox.ui.sounds;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.moustick.weirdox.R;

public class SoundsFragment extends Fragment {

    private SoundsViewModel soundsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        soundsViewModel =
                ViewModelProviders.of(this).get(SoundsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_sounds, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        soundsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}