package com.tarafi.mfapp.ui.dashboard;

import com.tarafi.mfapp.ui.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TARAFI Ahmed on 29/10/2017.
 */

@Module
public class DashboardModule {

    DashboardContract.DashboardView viewDashboard;

    public DashboardModule(DashboardContract.DashboardView view) {
        this.viewDashboard = view;
    }

    @Provides
    @ActivityScope
    DashboardContract.DashboardView getDashboardView() {
        return this.viewDashboard;
    }

    @Provides
    @ActivityScope
    DashboardContract.DashboardPresenter getDashboardPresenter(DashboardContract.DashboardView view) {
        return new DashboardPresenter(view);
    }
}
