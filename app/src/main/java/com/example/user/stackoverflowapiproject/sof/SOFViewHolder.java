package com.example.user.stackoverflowapiproject.sof;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.user.stackoverflowapiproject.R;
import com.example.user.stackoverflowapiproject.model.StackResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.annotations.Nullable;

public class SOFViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.image) ImageView imageView;
    @BindView(R.id.progress) ProgressBar progressBar;
    @BindView(R.id.name) TextView name;
    @BindView(R.id.location) TextView location;
    @BindView(R.id.badge_silver_value) TextView silver;
    @BindView(R.id.badge_gold_value) TextView gold;
    @BindView(R.id.badge_bronze_value) TextView bronze;
    @BindView(R.id.button) Button button;

    private StackResponse stackResponse;

    public SOFViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        button.setOnClickListener(__ -> startAction());
    }

    public void setup(StackResponse stackResponse) {
        this.stackResponse = stackResponse;
        progressBar.setVisibility(View.VISIBLE);
        name.setText(stackResponse.getDisplay_name());
        location.setText(stackResponse.getLocation());
        location.setText(stackResponse.getLocation());
        gold.setText(String.valueOf(stackResponse.getBadge_counts().getGold()));
        silver.setText(String.valueOf(stackResponse.getBadge_counts().getSilver()));
        bronze.setText(String.valueOf(stackResponse.getBadge_counts().getBronze()));

        Glide
                .with(imageView)
                .load(stackResponse.getProfile_image())
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .thumbnail(.1f)
                .into(imageView);
    }

    private void startAction() {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(stackResponse.getWebsite_url()));
        button.getContext().startActivity(i);
    }
}
