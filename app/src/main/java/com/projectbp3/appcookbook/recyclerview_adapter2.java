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

    private boolean usePopularLayout;

    private static final int TYPE_LIST = 0;
    private static final int TYPE_POPULAR = 1;

    public static final ArrayList<String> bookmarkedItems = new ArrayList<>();
    private ArrayList<recyclerview_list2> recyclerview_list2;
    private Context context;

    public recyclerview_adapter2(ArrayList<recyclerview_list2> recyclerview_list2, Context context, boolean usePopularLayout) {
        this.recyclerview_list2 = recyclerview_list2;
        this.context = context;
        this.usePopularLayout = usePopularLayout;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_POPULAR) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_populer, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_list, parent, false);
        }
        return new ViewHolder(view); // FIX: Use correct ViewHolder
    }

    @Override
    public int getItemViewType(int position) {
        if (usePopularLayout) {
            return TYPE_POPULAR; // Layout populer
        } else {
            return TYPE_LIST; // Layout biasa
        }
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        recyclerview_list2 item = recyclerview_list2.get(position);

        if (getItemViewType(position) == TYPE_POPULAR) {
            // Bind untuk layout populer
            holder.imageView.setImageResource(item.getImage());
            holder.title.setText(item.getTitle());
            holder.timer.setText(item.getTimer());
        } else {
            // Bind untuk layout list biasa
            holder.imageView.setImageResource(item.getImage());
            holder.title.setText(item.getTitle());
            holder.premis.setText(item.getPremis());
            holder.timer.setText(item.getTimer());
        }

        // Update bookmark
        updateBookmarkIcon(holder, item);

        // Bookmark click listener
        holder.bookmark.setOnClickListener(v -> {
            if (bookmarkedItems.contains(item.getUniqueId())) {
                bookmarkedItems.remove(item.getUniqueId());
            } else {
                bookmarkedItems.add(item.getUniqueId());
            }
            updateBookmarkIcon(holder, item);
        });

        // Detail klik
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
        TextView premis, title, timer;
        ImageView bookmark;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            premis = itemView.findViewById(R.id.premis);
            title = itemView.findViewById(R.id.title);
            timer = itemView.findViewById(R.id.timer);
            bookmark = itemView.findViewById(R.id.bookmark);
        }
    }

    private void updateBookmarkIcon(ViewHolder holder, recyclerview_list2 item) {
        boolean isBookmarked = bookmarkedItems.contains(item.getUniqueId());
        holder.bookmark.setImageResource(
                isBookmarked ? R.drawable.baseline_bookmark_24_white
                        : R.drawable.baseline_bookmark_border_24_white
        );
    }


}
