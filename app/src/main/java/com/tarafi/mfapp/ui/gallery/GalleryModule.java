package com.tarafi.mfapp.ui.gallery;

import com.tarafi.mfapp.ui.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TARAFI Ahmed on 29/10/2017.
 */
@Module
public class GalleryModule {
    GalleryContract.GalleryView galleryView;

    public GalleryModule(GalleryContract.GalleryView view) {
        this.galleryView = view;
    }

    @Provides
    @ActivityScope
    GalleryContract.GalleryView getDashboardView() {
        return this.galleryView;
    }

    @Provides
    @ActivityScope
    GalleryContract.GalleryPresenter getDashboardPresenter(GalleryContract.GalleryView view) {
        return new GalleryPresenter(view);
    }
}
