package com.challenge.juan.widow.Login.Presenters;

import android.content.Intent;

import com.challenge.juan.widow.Login.Interactors.ILoginInteractor;
import com.challenge.juan.widow.Login.Interactors.LoginInteractor;
import com.challenge.juan.widow.Login.Views.ILoginView;
import com.challenge.juan.widow.Login.Views.LoginActivity;
import com.google.android.gms.common.api.GoogleApiClient;

public class LoginPresenter implements ILoginPresenter {

    private ILoginInteractor interactor;
    private ILoginView view;

    public LoginPresenter(LoginActivity view) {
        this.view = view;
        interactor = new LoginInteractor(this,view);
    }

    @Override
    public void goToHome() {
        view.goToHome();
    }

    @Override
    public void showToast(String message) {
        view.showToast(message);
    }

    @Override
    public void handleActivityResult(Intent data, int requestCode) {
        interactor.handleActivityResult(data,requestCode);
    }

    @Override
    public void setGoogleSignInActions() {
        interactor.setGoogleSignInActions();
    }

    @Override
    public void startGoogleSignIn() {
        interactor.startGoogleSignIn();
    }

    @Override
    public void startGoogleSignInIntent(GoogleApiClient googleApiClient) {
        view.startGoogleSignInIntent(googleApiClient);
    }

    @Override
    public void addAuthStateListener() {
        interactor.addAuthStateListener();
    }

    @Override
    public void removeAuthStateListener() {
        interactor.removeAuthStateListener();
    }
}
