package com.tarafi.mfapp.ui.dashboard;

import com.tarafi.mfapp.models.Albums;

import javax.inject.Inject;

/**
 * Created by TARAFI Ahmed on 29/10/2017.
 */

public class DashboardPresenter implements DashboardContract.DashboardPresenter {
    private DashboardContract.DashboardView mDashboardView;
    @Inject
    public DashboardPresenter(DashboardContract.DashboardView view) {
        mDashboardView = view;
    }

    @Override
    public void openAlbumDetails(Albums item) {
        mDashboardView.openGallery(item.getmId());
    }
}
