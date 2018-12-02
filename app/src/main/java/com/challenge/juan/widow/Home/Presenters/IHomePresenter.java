package com.challenge.juan.widow.Home.Presenters;

public interface IHomePresenter {
    void setGoogleSignInActions();
    void revoke();
    void SignOut();
    void goToLogin();
    void addAuthStateListener();
    void removeAuthStateListener();
}
