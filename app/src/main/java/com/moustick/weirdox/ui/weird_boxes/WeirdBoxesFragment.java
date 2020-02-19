package com.moustick.weirdox.ui.weird_boxes;

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

public class WeirdBoxesFragment extends Fragment {

    private WeirdBoxesViewModel weirdBoxesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        weirdBoxesViewModel =
                ViewModelProviders.of(this).get(WeirdBoxesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_weird_boxes, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        weirdBoxesViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}