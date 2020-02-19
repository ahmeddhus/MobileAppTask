package com.example.mobileapptask.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mobileapptask.data.models.MainModel;
import com.example.mobileapptask.repository.Repository;

public class TheViewModel extends ViewModel {

    private MutableLiveData<MainModel> mutableLiveData;
    private Repository repository;

    public void init(){
        if (mutableLiveData != null)
            return;

        repository = Repository.getInstance();
    }

    public LiveData<MainModel> getData(){
        mutableLiveData = repository.getData();
        return mutableLiveData;
    }
}
