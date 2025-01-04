package com.projectbp3.appcookbook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerview_adapter2 extends RecyclerView.Adapter<recyclerview_adapter2.ViewHolder> {

    private ArrayList<recyclerview_list2> recyclerview_list2;
    private Context context;

    public recyclerview_adapter2(ArrayList<recyclerview_list2> recyclerview_list2, Context context) {
        this.recyclerview_list2 = recyclerview_list2;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_list, parent, false);
        return new ViewHolder(view); // FIX: Use correct ViewHolder
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        recyclerview_list2 item = recyclerview_list2.get(position);

        holder.imageView.setImageResource(recyclerview_list2.get(position).getImage());
        holder.title.setText(recyclerview_list2.get(position).getTitle());
        holder.premis.setText(recyclerview_list2.get(position).getPremis());
        holder.timer.setText(recyclerview_list2.get(position).getTimer());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, detail_resep.class);
            intent.putExtra("image2", item.getImage2());
            intent.putExtra("title", item.getTitle());
            intent.putExtra("timer", item.getTimer());
            intent.putExtra("bahan", item.getBahan());
            intent.putExtra("langkah", item.getLangkah());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return recyclerview_list2.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView premis;
        TextView title;
        TextView timer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            premis = itemView.findViewById(R.id.premis);
            title = itemView.findViewById(R.id.title);
            timer = itemView.findViewById(R.id.timer);
        }
    }

}
