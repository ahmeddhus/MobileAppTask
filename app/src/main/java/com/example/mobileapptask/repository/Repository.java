package com.example.mobileapptask.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.mobileapptask.data.models.MainModel;
import com.example.mobileapptask.data.retrofit.RetrofitClient;
import com.example.mobileapptask.data.retrofit.RetrofitService;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class Repository {

    private RetrofitClient retrofitClient;
    private static Repository repository;

    public static Repository getInstance() {
        if (repository == null) {
            repository = new Repository();
        }
        return repository;
    }

    private Repository() {
        retrofitClient = RetrofitService.getRetro().create(RetrofitClient.class);
    }

    public MutableLiveData<MainModel> getData() {

        final MutableLiveData<MainModel> newData = new MutableLiveData<>();

        CompositeDisposable disposable = new CompositeDisposable();

        disposable.add(
                retrofitClient.getData()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<MainModel>() {

                            @Override
                            public void onSuccess(MainModel mainModel) {
                                newData.setValue(mainModel);
                                Log.e("getData", "OK");
                            }

                            @Override
                            public void onError(Throwable e) {
                                newData.setValue(null);
                                if (e.getMessage() != null)
                                    Log.e("getDataFailure", e.getMessage());
                            }

                        })
        );
        return newData;
    }
}
