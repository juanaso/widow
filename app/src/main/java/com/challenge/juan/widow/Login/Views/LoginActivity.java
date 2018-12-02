package com.challenge.juan.widow.Login.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;
import com.challenge.juan.widow.Login.Presenters.ILoginPresenter;
import com.challenge.juan.widow.Login.Presenters.LoginPresenter;
import com.challenge.juan.widow.Home.Views.MainActivity;
import com.challenge.juan.widow.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

import static com.challenge.juan.widow.Login.Interactors.LoginInteractor.SIGN_IN_CODE;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    private SignInButton googleSignInButton;
    private Toolbar toolbar;
    private ILoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter(this);
        Init();
        SetActions();
        presenter.setGoogleSignInActions();
    }

    private void Init() {
        toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        googleSignInButton = findViewById(R.id.GoogleSignInButton);
    }

    private void SetActions() {

        googleSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.startGoogleSignIn();
            }
        });
    }
    @Override
    public void startGoogleSignInIntent(GoogleApiClient googleApiClient) {
        Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(intent,SIGN_IN_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        presenter.handleActivityResult(data,requestCode);
    }

    @Override
    public void goToHome() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
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

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show();
    }
}
