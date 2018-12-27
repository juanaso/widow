package com.challenge.juan.widow.UploadBook.Interactors;

import android.util.Log;

import com.challenge.juan.widow.FireBase.FireBaseDataBaseManager;
import com.challenge.juan.widow.Models.Book;
import com.challenge.juan.widow.UploadBook.Presenters.IUploadBookPresenter;
import com.challenge.juan.widow.UploadBook.Presenters.UploadBookPresenter;
import com.challenge.juan.widow.UploadBook.Views.UploadBookActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class UploadBookInteractor extends FireBaseDataBaseManager implements IUploadBookInteractor {

    IUploadBookPresenter presenter;
    FirebaseFirestore db;


    public UploadBookInteractor(UploadBookPresenter presenter, UploadBookActivity view) {
        this.presenter = presenter;

        db = FirebaseFirestore.getInstance();

    }

    @Override
    public void uploadBook(Book book) {

        DatabaseReference usersRef = ref.child("users");

        Map<String, Book> currentBook = new HashMap<>();
        currentBook.put("juanasoisawesome", book);

// Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("first", "Ada");
        user.put("last", "Lovelace");
        user.put("born", 1815);

// Add a new document with a generated ID
        db.collection("books")
                .add(currentBook)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        //Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        //Log.w(TAG, "Error adding document", e);
                    }
                });
    }
}
