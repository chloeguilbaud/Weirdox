package com.moustick.weirdox.ui.sounds;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.moustick.weirdox.R;
import com.moustick.weirdox.database.Sound;
import com.moustick.weirdox.database.SoundsViewModelHe;
import com.moustick.weirdox.ui.weird_boxes.WeirdBoxesFragment;

import java.util.List;

public class SoundsFragment extends Fragment {

    private SoundsViewModel soundsViewModel;
    private SoundsViewModelHe soundsViewModelHe;
    private Context context;

    private RecyclerView recyclerView;
    private SoundsAdapter soundsAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public static WeirdBoxesFragment newInstance() {
        return new WeirdBoxesFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

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

        View view = inflater.inflate(R.layout.fragment_sounds, container, false);

        recyclerView = view.findViewById(R.id.fragment_sounds_recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        soundsAdapter = new SoundsAdapter(soundsViewModelHe.getSoundList());
        recyclerView.setAdapter(soundsAdapter);

        return view;

        //return root;
    }

    private void initData() {
        soundsViewModelHe = ViewModelProviders.of(this).get(SoundsViewModelHe.class);
        soundsViewModelHe.getSoundList().observe(this, new Observer<List<Sound>>() {
            @Override
            public void onChanged(@Nullable List<Sound> sounds) {
                soundsAdapter.setSoundList(sounds);
            }
        });
    }

    public void removeData() {
        if (soundsViewModelHe != null) {
            soundsViewModelHe.deleteAll();
        }
    }

}