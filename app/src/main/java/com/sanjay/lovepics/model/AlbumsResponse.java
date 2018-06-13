package com.sanjay.lovepics.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by User on s1/9/2018.
 */

public class AlbumsResponse {

    @SerializedName("wallpapers")
    @Expose
    private List<Album> albums;

    public List<Album> getAlbums(){
        return albums;
    }
    public void setAlbums(List<Album>albums){
        this.albums = albums;
    }
}
