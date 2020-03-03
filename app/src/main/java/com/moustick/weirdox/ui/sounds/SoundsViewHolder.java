package com.moustick.weirdox.ui.sounds;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SoundsViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;

    public SoundsViewHolder(@NonNull TextView itemView) {
        super(itemView);
        textView = itemView;
    }

    public void setText(String text) {
        this.textView.setText(text);
    }

}
