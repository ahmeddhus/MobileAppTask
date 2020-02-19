package com.example.mobileapptask.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileapptask.R;
import com.example.mobileapptask.data.models.AttractionsModel;
import com.example.mobileapptask.databinding.AttractionsItemBinding;


import java.util.List;

public class AttractionsAdapter extends RecyclerView.Adapter<AttractionsAdapter.ItemViewHolder> {

    private Context context;
    private List<AttractionsModel> items;

    public AttractionsAdapter(Context context, List<AttractionsModel> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public AttractionsAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AttractionsItemBinding attractionsItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.attractions_item, parent, false);

        return new AttractionsAdapter.ItemViewHolder(attractionsItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AttractionsAdapter.ItemViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        if (items == null)
            return 0;
        return items.size();
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {
        AttractionsItemBinding attractionsItemBinding;

        public ItemViewHolder(@NonNull AttractionsItemBinding itemView) {
            super(itemView.getRoot());
            attractionsItemBinding = itemView;
        }

        void bind(int position) {
            AttractionsModel results = items.get(position);
            attractionsItemBinding.setItem(results);
        }
    }
}
