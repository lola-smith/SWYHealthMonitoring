package com.example.mac.swyhealthmonitoring.database;

import com.example.mac.swyhealthmonitoring.entities.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class DatabaseManager {

    private static DatabaseManager instance;
    public static String userID;

    private DatabaseManager(){}

    public static DatabaseManager getInstance(){
        if(instance == null)
            instance = new DatabaseManager();
        return instance;
    }


    public void insertUser(User user){
        DatabaseReference usersTable = FirebaseDatabase.getInstance().getReference("users");
        userID = usersTable.push().getKey();

        usersTable.child(userID).setValue(user);
    }


    public void readData(){
        DatabaseReference usersTable = FirebaseDatabase.getInstance().getReference("users");
        usersTable.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<User> userList = (List<User>) dataSnapshot.getValue();
                for (User user : userList){

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

}
