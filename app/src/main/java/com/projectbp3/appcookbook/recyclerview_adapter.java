package com.projectbp3.appcookbook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerview_adapter extends RecyclerView.Adapter<recyclerview_adapter.ViewHolder> {

    private ArrayList<recyclerview_list> recyclerview_list;
    private Context context;

    public recyclerview_adapter(ArrayList<recyclerview_list> recyclerview_list, Context context) {
        this.recyclerview_list = recyclerview_list;
        this.context = context;
    }

    @NonNull
    @Override
    public recyclerview_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerview_adapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(recyclerview_list.get(position).getImage());
        holder.textView.setText(recyclerview_list.get(position).getTitle());

        Fragment destinationFragment = recyclerview_list.get(position).getDestinationFragment();

        holder.cardView.setOnClickListener(e -> {
            if (context instanceof AppCompatActivity) {
                AppCompatActivity activity = (AppCompatActivity) context;
                activity.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_layout, destinationFragment) // R.id.frame_layout adalah container fragment
                        .addToBackStack(null) // Menambahkan ke BackStack untuk navigasi "kembali"
                        .commit();
            }
        });
    }


    @Override
    public int getItemCount() {
        return recyclerview_list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
