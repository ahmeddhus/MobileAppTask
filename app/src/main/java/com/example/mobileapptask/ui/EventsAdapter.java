package com.example.mobileapptask.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileapptask.R;
import com.example.mobileapptask.data.models.AttractionsModel;
import com.example.mobileapptask.data.models.EventsModel;
import com.example.mobileapptask.databinding.AttractionsItemBinding;
import com.example.mobileapptask.databinding.EventsItemBinding;

import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ItemViewHolder> {

    private Context context;
    private List<EventsModel> items;

    public EventsAdapter(Context context, List<EventsModel> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public EventsAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        EventsItemBinding eventsItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.events_item, parent, false);

        return new EventsAdapter.ItemViewHolder(eventsItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsAdapter.ItemViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        if (items == null)
            return 0;
        return items.size();
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {
        EventsItemBinding eventsItemBinding;

        public ItemViewHolder(@NonNull EventsItemBinding itemView) {
            super(itemView.getRoot());
            eventsItemBinding = itemView;
        }

        void bind(int position) {
            EventsModel results = items.get(position);
            eventsItemBinding.setItem(results);
        }
    }
}
