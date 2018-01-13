package com.sanjay.lovepics.api;

import com.sanjay.lovepics.model.AlbumsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by User on 1/9/2018.
 */

public interface Service {
    @GET("/api/saracasam/")
    Call<AlbumsResponse> getAlbums();
}