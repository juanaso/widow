package com.challenge.juan.widow.Login.Views;

import com.google.android.gms.common.api.GoogleApiClient;

public interface ILoginView {
    void goToHome();
    void showToast(String message);
    void startGoogleSignInIntent(GoogleApiClient googleApiClient);
}
