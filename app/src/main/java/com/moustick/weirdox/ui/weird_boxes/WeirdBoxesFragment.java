package com.moustick.weirdox.ui.weird_boxes;

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
import androidx.recyclerview.widget.RecyclerView;

import com.moustick.weirdox.R;
import com.moustick.weirdox.database.Weirdo;
import com.moustick.weirdox.database.WeirdosViewModel;

import java.util.List;

public class WeirdBoxesFragment extends Fragment {

    private WeirdosListAdapter weirdosListAdapter;
    private WeirdosViewModel weirdosViewModel;
    private Context context;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private WeirdBoxesViewModel weirdBoxesViewModel;

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
        //initData();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

//        View view = inflater.inflate(R.layout.fragment_weird_boxes, container, false);

        /*recyclerView = view.findViewById(R.id.fragment_weirdo_boxes_recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyAdapter(myDataset);
        recyclerView.setAdapter(mAdapter);

        return view;*/

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

    private void initData() {
        weirdosViewModel = ViewModelProviders.of(this).get(WeirdosViewModel.class);
        weirdosViewModel.getWeirdoList().observe(this, new Observer<List<Weirdo>>() {
            @Override
            public void onChanged(@Nullable List<Weirdo> weirdos) {
                weirdosListAdapter.setWeirdoList(weirdos);
            }
        });
    }

    public void removeData() {
        if (weirdosViewModel != null) {
            weirdosViewModel.deleteAll();
        }
    }


}