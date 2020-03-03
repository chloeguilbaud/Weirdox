package com.moustick.weirdox.ui.sounds;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.moustick.weirdox.R;
import com.moustick.weirdox.database.Sound;

import java.util.List;

public class SoundsAdapter extends RecyclerView.Adapter<SoundsViewHolder> {


    private LiveData<List<Sound>> sounds;

    public SoundsAdapter(LiveData<List<Sound>> sounds) {
        this.sounds = sounds;
    }

    @Override
    public SoundsViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);

        SoundsViewHolder vh = new SoundsViewHolder((TextView) v.findViewById(R.id.textV));
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(SoundsViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.setText(sounds.getValue().get(position).title);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        if(sounds.getValue() != null) {
            return sounds.getValue().size();
        } return 0;
    }

    public void setSoundList(List<Sound> sounds) {
        //this.sounds.getValue().se
    }

}
