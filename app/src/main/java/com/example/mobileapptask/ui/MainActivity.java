package com.example.mobileapptask.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mobileapptask.R;
import com.example.mobileapptask.data.models.AttractionsModel;
import com.example.mobileapptask.data.models.EventsModel;
import com.example.mobileapptask.data.models.HotSpotsModel;
import com.example.mobileapptask.viewmodel.TheViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.hotspot_recycler)
    RecyclerView hotspot_rv;
    @BindView(R.id.events_recycler)
    RecyclerView events_rv;
    @BindView(R.id.attractions_recycler)
    RecyclerView attractions_rv;

    private List<HotSpotsModel> hotSpotsModels;
    private List<EventsModel> eventsModels;
    private List<AttractionsModel> attractionsModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getData();
    }

    private void getData() {
        TheViewModel viewModel = ViewModelProviders.of(this).get(TheViewModel.class);
        viewModel.init();

        viewModel.getData().observe(this, mainModel -> {
            if (mainModel != null) {
                this.hotSpotsModels = mainModel.getData().getHot_spots();
                this.eventsModels = mainModel.getData().getEvents();
                this.attractionsModels = mainModel.getData().getAttractions();

                setRV_hotspot(hotSpotsModels);
                setRV_events(eventsModels);
                setRV_attractions(attractionsModels);
            }
        });
    }

    private void setRV_hotspot(List<HotSpotsModel> hotSpotsModels) {

        HotSpotsAdapter hotSpotsAdapter = new HotSpotsAdapter(MainActivity.this, hotSpotsModels);
        hotspot_rv.setAdapter(hotSpotsAdapter);
        hotspot_rv.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
    }


    private void setRV_events(List<EventsModel> eventsModels) {

        EventsAdapter eventsAdapter = new EventsAdapter(MainActivity.this, eventsModels);
        events_rv.setAdapter(eventsAdapter);
        events_rv.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
    }


    private void setRV_attractions(List<AttractionsModel> attractionsModels) {

        AttractionsAdapter attractionsAdapter = new AttractionsAdapter(MainActivity.this, attractionsModels);
        attractions_rv.setAdapter(attractionsAdapter);
        attractions_rv.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
    }

}
