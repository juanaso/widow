package com.challenge.juan.widow.Home.Interactors;

import android.support.v7.app.AppCompatActivity;

import com.challenge.juan.widow.FireBase.FireBaseLoginManager;
import com.challenge.juan.widow.Home.Presenters.HomePresenter;
import com.challenge.juan.widow.Home.Presenters.IHomePresenter;

public class HomeInteractor extends FireBaseLoginManager implements IHomeInteractor {

    private IHomePresenter presenter;

    public HomeInteractor(HomePresenter homePresenter, AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        this.presenter = homePresenter;
    }

    @Override
    public void setGoogleSignInActions() {
        SetGoogleSignInActions();
    }

    @Override
    public void addAuthStateListener() {
        firebaseAuth.addAuthStateListener(firebaseAuthListener);
    }

    @Override
    public void removeAuthStateListener() {
        if(firebaseAuthListener != null){
            firebaseAuth.removeAuthStateListener(firebaseAuthListener);
        }
    }

    @Override
    public void SignOut() {
        AccountSignOut();
    }

    @Override
    public void revoke() {
        AccountRevoke();
    }

    @Override
    public void handleFirebaseSignInResult(boolean isLoged) {
       if(!isLoged){
         presenter.goToLogin();
       }
    }
}
