package com.example.user.stackoverflowapiproject.sof;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.user.stackoverflowapiproject.R;
import com.example.user.stackoverflowapiproject.repository.NetworkService;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainView extends AppCompatActivity{
    @BindView(R.id.list) RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        SOFAdapter sofAdapter = new SOFAdapter();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(sofAdapter);
        recyclerView.setLayoutManager(layoutManager);

        SOFViewModel viewModel = ViewModelProviders.of(this).get(SOFViewModel.class);
        if (isNetworkAvailable()) {
            viewModel.setView(new NetworkService().getDataModel(), AndroidSchedulers.mainThread(), Schedulers.io());
        } else {
            Toast.makeText(this, R.string.no_network, Toast.LENGTH_SHORT).show();
        }

        viewModel.data.observe(this, stackResponses -> {
            sofAdapter.setResponseList(stackResponses);
            sofAdapter.notifyDataSetChanged();
        });
    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
