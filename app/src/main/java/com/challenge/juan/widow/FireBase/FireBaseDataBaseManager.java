package com.challenge.juan.widow.FireBase;
import android.support.annotation.NonNull;

import com.challenge.juan.widow.Models.Book;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;


public abstract class FireBaseDataBaseManager {

    public FirebaseFirestore db;

    public FireBaseDataBaseManager() {
        db = FirebaseFirestore.getInstance();
    }
    public abstract void handleErrorMessage(String message);

    public void uploadBook(Book book) {

        getBook("books");
        /*
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
                */
    }

    public void getBook(String BookParameter){
        db.collection(BookParameter)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                              Map<String, Object>a = document.getData();
                              a = new HashMap<>(a);
                              HashMap<String, String> b = (HashMap<String, String> )a.get("juanasoisawesome");
                              String title = b.get("title");
                              Book book = new Book(b.get("author"),b.get("title"),b.get("fotoUrl"));
                            }
                        } else {
                                handleErrorMessage( "Error getting documents." + task.getException());
                        }
                    }
                });

    }
}
