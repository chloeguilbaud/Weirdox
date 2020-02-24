package com.moustick.weirdox.ui.weird_boxes;

import android.content.Context;
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
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.moustick.weirdox.R;
import com.moustick.weirdox.database.Weirdo;
import com.moustick.weirdox.database.WeirdosViewModel;
import com.moustick.weirdox.database.WeirdoxDatabase;

import java.util.List;

public class WeirdBoxesFragment extends Fragment {

    private WeirdosListAdapter weirdosListAdapter;
    private WeirdosViewModel weirdosViewModel;
    private Context context;

    private WeirdBoxesViewModel weirdBoxesViewModel;

    public static WeirdBoxesFragment newInstance() {
        return new WeirdBoxesFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        weirdosListAdapter = new WeirdosListAdapter(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_weird_boxes, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_directors);
        recyclerView.setAdapter(weirdosListAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        return view;

        /*weirdBoxesViewModel =
                ViewModelProviders.of(this).get(WeirdBoxesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_weird_boxes, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        weirdBoxesViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;*/
    }

    private void initData() {
        weirdosViewModel = ViewModelProviders.of(this).get(WeirdosViewModel.class);
        weirdosViewModel.getWeirdoList().observe(this, new Observer<List<Weirdo>>() {
            @Override
            public void onChanged(@Nullable List<Weirdo> directors) {
                weirdosListAdapter.setWeirdoList(directors);
            }
        });
    }
    public void removeData() {
        if (weirdosViewModel != null) {
            weirdosViewModel.deleteAll();
        }
    }



}