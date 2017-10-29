package com.tarafi.mfapp.ui.dashboard;

import com.tarafi.mfapp.ui.ActivityScope;

import dagger.Component;

/**
 * Created by TARAFI Ahmed on 29/10/2017.
 */

@ActivityScope
@Component(modules = DashboardModule.class)
public interface DashboardComponent {
    void inject(DashboardActivity activity);
}
