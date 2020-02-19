package com.example.mobileapptask.data.models;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.example.mobileapptask.R;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import java.util.List;

public class EventsModel {

    @SerializedName("name")
    private String name;
    @SerializedName("photos")
    private List<String> photos;
    @SerializedName("categories")
    private List<CategoryModel> categories;

    public String getName() {
        return name;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public String getCategories() {
        if (!categories.isEmpty())
            return categories.get(0).getName();

        CategoryModel categoryModel = new CategoryModel("");
        categories.add(categoryModel);
        return "";
    }

    @BindingAdapter({"bind:photos"})
    public static void loadImage(ImageView view, List<String> photos) {
        if (!photos.isEmpty())
            Picasso.get()
                    .load(photos.get(0))
                    .placeholder(R.drawable.ic_image_black_24dp)
                    .into(view);
    }
}
