package com.tarafi.mfapp.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by TARAFI Ahmed on 29/10/2017.
 */

public class Gallery implements Serializable {
    @SerializedName("id")
    private String mId;
    @SerializedName("picture")
    private String mPicture;

    public String getmId() {
        return mId;
    }

    public String getmPicture() {
        return mPicture;
    }
}
