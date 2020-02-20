package com.example.mobileapptask.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.mobileapptask.R;
import com.example.mobileapptask.data.models.AttractionsModel;
import com.example.mobileapptask.data.models.EventsModel;
import com.example.mobileapptask.data.models.HotSpotsModel;
import com.example.mobileapptask.viewmodel.TheViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.hotspot_recycler)
    RecyclerView hotspot_rv;
    @BindView(R.id.events_recycler)
    RecyclerView events_rv;
    @BindView(R.id.attractions_recycler)
    RecyclerView attractions_rv;

    @BindView(R.id.linearlayout_main)
    LinearLayout linearLayout;

    //BottomNavigation
    @BindView(R.id.bottom_navigation)
    LinearLayout bottomnavigation_layout;
    @BindView(R.id.home_bottom)
    ImageView home_bottom;
    @BindView(R.id.search_bottom)
    ImageView search_bottom;
    @BindView(R.id.notifications_bottom)
    ImageView notifications_bottom;
    @BindView(R.id.profile_bottom)
    ImageView profile_bottom;

    //Floating action buttons
    @BindView(R.id.hotspot_floating)
    LinearLayout hotspot_floating;
    @BindView(R.id.attractions_floating)
    LinearLayout attractions_floating;
    @BindView(R.id.events_floating)
    LinearLayout events_floating;
    @BindView(R.id.map_floating)
    LinearLayout map_floating;

    boolean shown = false;
    private Animation fab_open, fab_close;

    private List<HotSpotsModel> hotSpotsModels;
    private List<EventsModel> eventsModels;
    private List<AttractionsModel> attractionsModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        getData();
    }

    private void init() {
        ButterKnife.bind(this);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
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

    @OnClick(R.id.floatingActionButton)
    public void floatingAction() {
        if (!shown) {
            openFloatingButtons();

        } else {
            closeFloatingButtons();
        }
    }

    private void openFloatingButtons() {
        hotspot_floating.setVisibility(View.VISIBLE);
        hotspot_floating.startAnimation(fab_open);

        attractions_floating.setVisibility(View.VISIBLE);
        attractions_floating.startAnimation(fab_open);

        events_floating.setVisibility(View.VISIBLE);
        events_floating.startAnimation(fab_open);

        map_floating.setVisibility(View.VISIBLE);
        map_floating.startAnimation(fab_open);

        linearLayout.setAlpha((float) 0.4);
        bottomnavigation_layout.setAlpha((float) 0.4);

        shown = true;
    }


    private void closeFloatingButtons() {
        hotspot_floating.setVisibility(View.GONE);
        hotspot_floating.startAnimation(fab_close);

        attractions_floating.setVisibility(View.GONE);
        attractions_floating.startAnimation(fab_close);

        events_floating.setVisibility(View.GONE);
        events_floating.startAnimation(fab_close);

        map_floating.setVisibility(View.GONE);
        map_floating.startAnimation(fab_close);

        linearLayout.setAlpha(1);
        bottomnavigation_layout.setAlpha(1);

        shown = false;
    }

    @OnClick({R.id.home_bottom})
    public void homeBottom_action() {
        home_bottom.setImageResource(R.drawable.home_bottom_icon);
        search_bottom.setImageResource(R.drawable.search_grey_bottom_icon);
        notifications_bottom.setImageResource(R.drawable.notification_grey_bottom_icon);
        profile_bottom.setImageResource(R.drawable.profile_grey_bottom_icon);
    }

    @OnClick({R.id.search_bottom})
    public void searchBottom_action() {
        home_bottom.setImageResource(R.drawable.home_grey_bottom_icon);
        search_bottom.setImageResource(R.drawable.search_bottom_icon);
        notifications_bottom.setImageResource(R.drawable.notification_grey_bottom_icon);
        profile_bottom.setImageResource(R.drawable.profile_grey_bottom_icon);
    }

    @OnClick({R.id.notifications_bottom})
    public void notificationsBottom_action() {
        home_bottom.setImageResource(R.drawable.home_grey_bottom_icon);
        search_bottom.setImageResource(R.drawable.search_grey_bottom_icon);
        notifications_bottom.setImageResource(R.drawable.notification_bottom_icon);
        profile_bottom.setImageResource(R.drawable.profile_grey_bottom_icon);
    }

    @OnClick({R.id.profile_bottom})
    public void profileBottom_action() {
        home_bottom.setImageResource(R.drawable.home_grey_bottom_icon);
        search_bottom.setImageResource(R.drawable.search_grey_bottom_icon);
        notifications_bottom.setImageResource(R.drawable.notification_grey_bottom_icon);
        profile_bottom.setImageResource(R.drawable.profile_bottom_icon);
    }

    @Override
    public void onBackPressed() {
        if (shown)
            closeFloatingButtons();
        else
            super.onBackPressed();
    }
}
















