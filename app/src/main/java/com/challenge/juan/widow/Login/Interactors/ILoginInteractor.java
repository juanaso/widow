package com.challenge.juan.widow.Login.Interactors;

import android.content.Intent;

public interface ILoginInteractor {
    void handleActivityResult(Intent data, int requestCode);
    void setGoogleSignInActions();
    void startGoogleSignIn();
    void addAuthStateListener();
    void removeAuthStateListener();
}
