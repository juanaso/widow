package com.challenge.juan.widow.FireBase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public abstract class FireBaseDataBaseManager {

    public DatabaseReference ref;
    final FirebaseDatabase database;
    public FireBaseDataBaseManager() {
        database = FirebaseDatabase.getInstance();
       try{
           ref = database.getReference("widowbase/database/widowbase/data");

       }catch (Exception e)
       {

           String a = "" ;
       }
    }
}
