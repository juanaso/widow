package com.challenge.juan.widow.Home.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.challenge.juan.widow.Home.Presenters.HomePresenter;
import com.challenge.juan.widow.Home.Presenters.IHomePresenter;
import com.challenge.juan.widow.Login.Views.LoginActivity;
import com.challenge.juan.widow.R;


public class MainActivity extends AppCompatActivity implements IHomeView {
    Toolbar toolbar;
    Button logOutButton;
    Button revokeButton;
    private IHomePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new HomePresenter(this);
        Init();
        SetActions();
        presenter.setGoogleSignInActions();
    }

    private void Init() {
        toolbar = findViewById(R.id.toolbar);
        logOutButton = findViewById(R.id.MainActivityButtonLogout);
        revokeButton = findViewById(R.id.MainActivityButtonRevoke);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.addAuthStateListener();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.removeAuthStateListener();
    }

    private void SetActions() {
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.SignOut();
            }
        });

        revokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.revoke();
            }
        });

    }

    @Override
    public void goToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
