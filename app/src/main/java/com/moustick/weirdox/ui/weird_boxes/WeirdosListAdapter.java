package com.moustick.weirdox.ui.weird_boxes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.moustick.weirdox.R;
import com.moustick.weirdox.database.Weirdo;

import java.util.List;

public class WeirdosListAdapter extends ArrayAdapter<Weirdo> {


    public WeirdosListAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public WeirdosListAdapter(@NonNull Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public WeirdosListAdapter(@NonNull Context context, int resource, @NonNull Weirdo[] objects) {
        super(context, resource, objects);
    }

    public WeirdosListAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull Weirdo[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public WeirdosListAdapter(@NonNull Context context, int resource, @NonNull List<Weirdo> objects) {
        super(context, resource, objects);
    }

    public WeirdosListAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<Weirdo> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vue;
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vue = inflater.inflate(R.layout.weird_item, parent, false);
        } else {
            vue = convertView;
        }
        TextView titre = vue.findViewById(R.id.weirdo_box_item);
        Weirdo weirdo = getItem(position);
        titre.setText(weirdo.name);
        return vue;
    }


}
