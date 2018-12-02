package com.challenge.juan.widow.Login.Presenters;

import android.content.Intent;

import com.google.android.gms.common.api.GoogleApiClient;

public interface ILoginPresenter {
    void doLogin();
    void goToHome();
    void showToast(String message);
    void handleActivityResult(Intent data, int requestCode);
    void setGoogleSignInActions();
    void startGoogleSignIn();
    void startGoogleSignInIntent(GoogleApiClient googleApiClient);
    void addAuthStateListener();
    void removeAuthStateListener();
}
