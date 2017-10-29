package com.tarafi.mfapp.ui.login;

import com.tarafi.mfapp.ui.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TARAFI Ahmed on 29/10/2017.
 */
@Module
public class LoginModule {
    LoginContract.LoginView mViewLogin;

    public LoginModule(LoginContract.LoginView view) {
        this.mViewLogin = view;
    }

    @Provides
    @ActivityScope
    LoginContract.LoginView getLoginView() {
        return this.mViewLogin;
    }

    @Provides
    @ActivityScope
    LoginContract.LoginPresenter getLoginPresenter(LoginContract.LoginView view) {
        return new LoginPresenter(view);
    }
}
