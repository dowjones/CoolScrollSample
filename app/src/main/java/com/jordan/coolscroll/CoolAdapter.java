package com.jordan.coolscroll;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CoolAdapter extends RecyclerView.Adapter<CoolAdapter.ViewHolder> {
    private static final int LIST_SIZE = 50;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        ViewHolder(View v) {
            super(v);
            this.textView = v.findViewById(R.id.text_view);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ConstraintLayout textLayout = (ConstraintLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_layout, parent, false);
        return new ViewHolder(textLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int height = (int) (Math.random() * LIST_SIZE * 10);
        holder.textView.setHeight(height);
        holder.textView.setText(height + " px");

        int r = (int) (Math.random() * 255);
        int g = (int) (Math.random() * 255);
        int b = (int) (Math.random() * 255);
        holder.itemView.setBackgroundColor(Color.argb(255, r, g, b));
    }

    @Override
    public int getItemCount() {
        return LIST_SIZE;
    }
}

