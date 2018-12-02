package com.challenge.juan.widow.Home.Interactors;

public interface IHomeInteractor {
    void setGoogleSignInActions();
    void addAuthStateListener();
    void removeAuthStateListener();
    void SignOut();
    void revoke();
}
