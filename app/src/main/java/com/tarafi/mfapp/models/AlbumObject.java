package com.tarafi.mfapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by TARAFI Ahmed on 29/10/2017.
 */

public class AlbumObject {
    @SerializedName("data")
    private ArrayList<Albums> mAlbums;

    public ArrayList<Albums> getmAlbums() {
        return mAlbums;
    }
}
