package com.example.mobileapptask.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileapptask.R;
import com.example.mobileapptask.data.models.HotSpotsModel;
import com.example.mobileapptask.databinding.HotspotItemBinding;

import java.util.List;

public class HotSpotsAdapter extends RecyclerView.Adapter<HotSpotsAdapter.ItemViewHolder>
{
    private Context context;
    private List<HotSpotsModel> items;

    public HotSpotsAdapter(Context context, List<HotSpotsModel> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public HotSpotsAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        HotspotItemBinding hotspotItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.hotspot_item, parent, false);

        return new HotSpotsAdapter.ItemViewHolder(hotspotItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull HotSpotsAdapter.ItemViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        if (items == null)
            return 0;
        return items.size();
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {
        HotspotItemBinding hotspotItemBinding;

        public ItemViewHolder(@NonNull HotspotItemBinding itemView) {
            super(itemView.getRoot());
            hotspotItemBinding = itemView;
        }

        void bind(int position) {
            HotSpotsModel results = items.get(position);
            hotspotItemBinding.setItem(results);
        }

    }
}
