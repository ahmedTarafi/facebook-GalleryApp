package com.tarafi.mfapp.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by TARAFI Ahmed on 29/10/2017.
 */

public class Albums {
    @SerializedName("created_time")
    private String mCreated_time;
    @SerializedName("name")
    private String mName;
    @SerializedName("id")
    private String mId;

    public String getmCreated_time() {
        return mCreated_time;
    }

    public String getmName() {
        return mName;
    }

    public String getmId() {
        return mId;
    }
}
