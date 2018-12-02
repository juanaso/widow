package com.challenge.juan.widow.FireBase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.challenge.juan.widow.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public abstract class FireBaseLoginManager implements GoogleApiClient.OnConnectionFailedListener {

    private AppCompatActivity appCompatActivity;
    public GoogleApiClient googleApiClient;
    public FirebaseAuth firebaseAuth;
    public FirebaseAuth.AuthStateListener firebaseAuthListener;
    public static final int SIGN_IN_CODE = 777;


    public FireBaseLoginManager(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    public abstract void handleFirebaseSignInResult(boolean isLoged);

    public void SetGoogleSignInActions(){

        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(appCompatActivity.getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        googleApiClient = new GoogleApiClient.Builder(appCompatActivity)
                .enableAutoManage(appCompatActivity,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions)
                .build();
        setFirebaseAuthentication();
    }

    public void setFirebaseAuthentication()
    {
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    handleFirebaseSignInResult(true);
                }else{
                    handleFirebaseSignInResult(false);
                }
            }
        };
    }


    public void handleActivityResult(Intent data, int requestCode) {
        if(requestCode == SIGN_IN_CODE){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    public void handleSignInResult(GoogleSignInResult result) {
        if(result.isSuccess()){
            firebaseAuthWithGoogle(result.getSignInAccount());
        }else{
            //TODO
            //presenter.showToast("not log");
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount signInAccount) {
        AuthCredential credential = GoogleAuthProvider.getCredential(signInAccount.getIdToken(),null);
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(appCompatActivity, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(!task.isSuccessful()){
                    //TODO
                    //presenter.showToast("Firebase is not aunteticated");
                }
            }
        });
    }
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    public void AccountSignOut() {
        firebaseAuth.signOut();
        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                if(status.isSuccess()){
                    handleFirebaseSignInResult(false);
                }else{
                    // Toast.makeText(getApplicationContext(), "cannot sign out",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void AccountRevoke() {
        firebaseAuth.signOut();
        Auth.GoogleSignInApi.revokeAccess(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                if(status.isSuccess()){
                    //GoToLoginActivity();
                }else{
                    //Toast.makeText(getApplicationContext(), "cannot Revoke",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
