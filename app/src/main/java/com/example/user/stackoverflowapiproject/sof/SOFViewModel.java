package com.example.user.stackoverflowapiproject.sof;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.user.stackoverflowapiproject.model.StackResponse;
import com.example.user.stackoverflowapiproject.repository.DataModel;
import com.example.user.stackoverflowapiproject.repository.NetworkService;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class SOFViewModel extends ViewModel {

    private static final String TAG = "SOFViewModel";
    private DataModel model;
    private Scheduler androidScheduler;
    private Scheduler processScheduler;
    private CompositeDisposable cd = new CompositeDisposable();
    public MutableLiveData<List<StackResponse>> data = new MutableLiveData<>();

    void setView(DataModel model, Scheduler processScheduler, Scheduler androidScheduler) {
        this.model = model;
        this.androidScheduler = androidScheduler;
        this.processScheduler = processScheduler;
        loadData();
    }

    private void loadData() {
        if (data.getValue() == null || data.getValue().size() == 0) {
            Disposable disposable = model
                    .getStackOverflowPosts(NetworkService.STACKOVERFLOW)
                    .subscribeOn(androidScheduler)
                    .observeOn(processScheduler)
                    .subscribe(response -> data.postValue(response.getItems()),
                            error -> Log.e(TAG, error.toString()));
            cd.add(disposable);
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        cd.dispose();
    }
}