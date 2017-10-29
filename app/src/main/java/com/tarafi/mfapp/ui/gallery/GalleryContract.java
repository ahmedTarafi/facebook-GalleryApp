package com.tarafi.mfapp.ui.gallery;

import com.tarafi.mfapp.models.Gallery;

/**
 * Created by TARAFI Ahmed on 29/10/2017.
 */

public interface GalleryContract {
    interface GalleryView {
        void showImageFS(Gallery item);
    }

    interface GalleryPresenter {
    }
}
