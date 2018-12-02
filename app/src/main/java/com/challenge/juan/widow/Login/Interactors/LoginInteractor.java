package com.challenge.juan.widow.Login.Interactors;

import android.support.v7.app.AppCompatActivity;

import com.challenge.juan.widow.FireBase.FireBaseLoginManager;
import com.challenge.juan.widow.Login.Presenters.ILoginPresenter;
import com.challenge.juan.widow.Login.Presenters.LoginPresenter;

public class LoginInteractor extends FireBaseLoginManager implements ILoginInteractor {


    private ILoginPresenter presenter;

    public LoginInteractor(LoginPresenter presenter, AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        this.presenter = presenter;
    }

    @Override
    public void handleFirebaseSignInResult(boolean isLoged) {
        if(isLoged)
            presenter.goToHome();
    }

    @Override
    public void setGoogleSignInActions() {
        SetGoogleSignInActions();
    }

    @Override
    public void startGoogleSignIn() {
        presenter.startGoogleSignInIntent(googleApiClient);
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




}
