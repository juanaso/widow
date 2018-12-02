package com.challenge.juan.widow.Home.Presenters;

import com.challenge.juan.widow.Home.Interactors.HomeInteractor;
import com.challenge.juan.widow.Home.Interactors.IHomeInteractor;
import com.challenge.juan.widow.Home.Views.IHomeView;
import com.challenge.juan.widow.Home.Views.MainActivity;

public class HomePresenter implements IHomePresenter {

    private IHomeInteractor interactor;
    private IHomeView view;

    public HomePresenter(MainActivity view) {
        this.view = view;
        interactor = new HomeInteractor(this,view);
    }

    @Override
    public void setGoogleSignInActions() {
        interactor.setGoogleSignInActions();
    }

    @Override
    public void revoke() {
        interactor.revoke();
    }

    @Override
    public void SignOut() {
        interactor.SignOut();
    }

    @Override
    public void goToLogin() {
        view.goToLogin();
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
