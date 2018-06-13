package com.sanjay.lovepics.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by User on s1/9/2018.
 */

public class Album {
    @SerializedName("imagename")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String numOfSongs;
    @SerializedName("imagepath")
    @Expose
    private String thumbnail;

    public Album() {
    }

    public Album(String name, String numOfSongs, String thumbnail) {
        this.name = name;
        this.numOfSongs = numOfSongs;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumOfSongs() {
        return numOfSongs;
    }

    public void setNumOfSongs(String numOfSongs) {
        this.numOfSongs = numOfSongs;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
