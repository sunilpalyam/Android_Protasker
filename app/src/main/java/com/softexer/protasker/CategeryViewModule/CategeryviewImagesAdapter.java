package com.softexer.protasker.CategeryViewModule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.softexer.protasker.R;

public class CategeryviewImagesAdapter extends RecyclerView.Adapter<CategeryviewImagesAdapter.ViewHolder> {

    Context context;

    public CategeryviewImagesAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.categeryviewimagesinfo, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_list;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img_list = itemView.findViewById(R.id.img_views);

        }
    }
}
