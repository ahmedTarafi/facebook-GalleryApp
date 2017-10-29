package com.tarafi.mfapp.ui.gallery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.tarafi.mfapp.R;
import com.tarafi.mfapp.models.Gallery;

/**
 * Created by TARAFI Ahmed on 29/10/2017.
 */

public class GalleryDialog extends DialogFragment {
    private Gallery mGallery;

    public GalleryDialog() {
    }

    public static GalleryDialog newInstance() {
        GalleryDialog mDialog = new GalleryDialog();
        return mDialog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_FRAME, android.R.style.Theme_Holo_Light);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialog, container, false);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        Bundle mBundle = getArguments();
        mGallery = (Gallery) mBundle.getSerializable("item");
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView imageView = (ImageView)view.findViewById(R.id.imageViewfs);
        String mPic = mGallery.getmPicture();
        Glide.with(GalleryDialog.this)
                .load(mPic)
                .into(imageView);
    }
}
