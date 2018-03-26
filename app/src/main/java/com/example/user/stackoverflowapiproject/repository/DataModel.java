package com.example.user.stackoverflowapiproject.repository;

import com.example.user.stackoverflowapiproject.model.PayloadResponse;

import java.util.Observable;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DataModel {
    @GET("/2.2/users")
    io.reactivex.Observable<PayloadResponse> getStackOverflowPosts(@Query(NetworkService.SITE) String site);
}
