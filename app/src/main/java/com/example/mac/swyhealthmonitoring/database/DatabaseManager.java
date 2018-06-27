package com.example.mac.swyhealthmonitoring.database;

import android.provider.ContactsContract;

import com.example.mac.swyhealthmonitoring.entities.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public class DatabaseManager {

    private static DatabaseManager instance;
    public static String userID;
    public static User currentUser = null;

    private DatabaseManager() {
    }

    public static DatabaseManager getInstance() {
        if (instance == null)
            instance = new DatabaseManager();
        return instance;
    }


    public Completable insertUser(User user) {
        return Completable.fromCallable(() -> {
            DatabaseReference usersTable = FirebaseDatabase.getInstance().getReference("users");
            userID = usersTable.push().getKey();

            usersTable.child(userID).setValue(user);
            DatabaseManager.currentUser = user;
            return true;
        });
    }


    public void readData() {
        DatabaseReference usersTable = FirebaseDatabase.getInstance().getReference("users");
        usersTable.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<User> userList = (List<User>) dataSnapshot.getValue();
                if (userList != null)
                    for (User user : userList) {

                    }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


    public Single<String> getUserId(String email) {
        DatabaseReference usersTable = FirebaseDatabase.getInstance().getReference("users");
        return Single.create(observer -> {
            usersTable.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    try {

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            User user = snapshot.getValue(User.class);
                            if (user != null && user.getEmail().equals(email)) {
                                observer.onSuccess(snapshot.getKey());
                                DatabaseManager.currentUser = user;
                            }
                        }
                        if (!observer.isDisposed())
                            observer.onError(new Throwable("No User"));

                    } catch (ClassCastException ex) {
                        if (!observer.isDisposed())
                            observer.onError(new Throwable("No User"));
                    }
                }


                @Override
                public void onCancelled(DatabaseError databaseError) {
                    observer.onError(new Throwable("No User"));
                }
            });
        });


    }


    public Completable editUser(User user) {
        return Completable.fromCallable(() -> {
            DatabaseReference usersTable = FirebaseDatabase.getInstance().getReference("users");
            usersTable.child(DatabaseManager.userID).setValue(user);
            return true;
        });
    }


}
