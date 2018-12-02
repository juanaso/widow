package com.challenge.juan.widow;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends ActivityBase {
    Toolbar toolbar;
    Button logOutButton;
    Button revokeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
        SetActions();
       // SetGoogleSignInActions();


        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(this.getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions)
                .build();

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){

                }else{
                    GoToLoginActivity();
                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        //CheckIfLogedIn();
        firebaseAuth.addAuthStateListener(firebaseAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(firebaseAuthListener != null){
            firebaseAuth.removeAuthStateListener(firebaseAuthListener);
        }
    }

    private void Init() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        logOutButton = findViewById(R.id.MainActivityButtonLogout);
        revokeButton = findViewById(R.id.MainActivityButtonRevoke);
    }

    private void SetActions() {
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AccountSignOut(googleApiClient);
            }
        });
    /*
        revokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AccountRevoke();
            }
        });
        */
    }

    @Override
    public void handleSignInResult(GoogleSignInResult result) {
        if(result.isSuccess()){
        }else{
            GoToLoginActivity();
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        //TODO
    }
}