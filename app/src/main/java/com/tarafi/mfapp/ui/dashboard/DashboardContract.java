package com.tarafi.mfapp.ui.dashboard;

import com.tarafi.mfapp.models.Albums;

/**
 * Created by TARAFI Ahmed on 29/10/2017.
 */

public interface DashboardContract {
    interface DashboardView {
        void openGallery(String id);
    }

    interface DashboardPresenter {
        void openAlbumDetails(Albums item);
    }
}
