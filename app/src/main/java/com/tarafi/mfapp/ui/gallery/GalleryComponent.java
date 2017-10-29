package com.tarafi.mfapp.ui.gallery;

import com.tarafi.mfapp.ui.ActivityScope;

import dagger.Component;

/**
 * Created by TARAFI Ahmed on 29/10/2017.
 */

@ActivityScope
@Component(modules = GalleryModule.class)
public interface GalleryComponent {
    void inject(GalleryActivity activity);
}
