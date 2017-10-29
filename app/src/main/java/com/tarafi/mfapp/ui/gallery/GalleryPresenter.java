package com.tarafi.mfapp.ui.gallery;

import com.tarafi.mfapp.models.Gallery;

import javax.inject.Inject;

/**
 * Created by TARAFI Ahmed on 29/10/2017.
 */

public class GalleryPresenter implements GalleryContract.GalleryPresenter {
    private GalleryContract.GalleryView mView;
    @Inject
    public GalleryPresenter(GalleryContract.GalleryView view) {
        mView = view;
    }

    public void showImage(Gallery item) {
        mView.showImageFS(item);
    }
}
