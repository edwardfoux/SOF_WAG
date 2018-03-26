package com.example.user.stackoverflowapiproject.sof;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.stackoverflowapiproject.R;
import com.example.user.stackoverflowapiproject.model.StackResponse;

import java.util.ArrayList;
import java.util.List;

public class SOFAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<StackResponse> responseList = new ArrayList<>();

    public void setResponseList(List<StackResponse> responseList) {
        this.responseList = responseList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sof_vh, parent, false);
        return new SOFViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SOFViewHolder stackResponseVH = (SOFViewHolder) holder;
        StackResponse stackResponse = responseList.get(position);
        stackResponseVH.setup(stackResponse);
    }

    @Override
    public int getItemCount() {
        return responseList.size();
    }
}
