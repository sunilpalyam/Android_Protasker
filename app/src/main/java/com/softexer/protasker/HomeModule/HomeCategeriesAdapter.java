package com.softexer.protasker.HomeModule;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softexer.protasker.R;


public class HomeCategeriesAdapter extends RecyclerView.Adapter<HomeCategeriesAdapter.ViewHolder> {

    Context context;
    onClickInterface onClickedCategorylist;

   /* public HomeCategeriesAdapter(Context context) {
        this.context = context;

    }*/

    public HomeCategeriesAdapter(Context context, onClickInterface onClickedCategorylist) {
        this.context = context;
        this.onClickedCategorylist = onClickedCategorylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.homecategeriesinfo, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {



        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onClickedCategorylist!=null) {
                    onClickedCategorylist.onClickedCategorylist(position,view);

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView texview;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.categery_profile);
            texview = itemView.findViewById(R.id.repairs);

        }
    }


    public interface onClickInterface{
        void onClickedCategorylist(int position,View v);

    }
}
