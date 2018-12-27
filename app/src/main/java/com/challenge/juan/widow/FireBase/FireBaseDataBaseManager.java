package com.challenge.juan.widow.FireBase;
import com.challenge.juan.widow.Models.Book;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public abstract class FireBaseDataBaseManager {

    public FirebaseFirestore db;

    public FireBaseDataBaseManager() {
        db = FirebaseFirestore.getInstance();
    }
    public abstract void handleErrorMessage(String message);

    public void FireStoreUploadBook(Book book) {

        Map<String, Book> currentBook = new HashMap<>();
        currentBook.put("juanasoisawesome", book);
        final String title = book.getTitle();

        db.collection("books")
                .add(currentBook)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        handleErrorMessage("Book: "+ title+" Added" );
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        handleErrorMessage("Looks Like theres a mistake! Book: "+ title+" NOT Added" );

                    }
                });
    }
}
