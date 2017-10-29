package com.tarafi.mfapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by TARAFI Ahmed on 29/10/2017.
 */

public class PhotoObject {
    @SerializedName("data")
    private ArrayList<Gallery> mGallery;

    public ArrayList<Gallery> getmGallery() {
        return mGallery;
    }
}
