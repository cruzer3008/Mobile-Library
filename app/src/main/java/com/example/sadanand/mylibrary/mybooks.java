package com.example.sadanand.mylibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class mybooks extends AppCompatActivity implements View.OnClickListener {

    private DatabaseReference mDatabase;
    public ListView muserList;
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth auth;
    private Button returnButton;

    public ArrayList<String> mBookname = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mybooks);
               mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("User Book Details").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        muserList = (ListView) findViewById(R.id.listview1);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mBookname);

        muserList.setAdapter(arrayAdapter);
        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                UserInfomation user = (UserInfomation) dataSnapshot.getValue(UserInfomation.class);
                String userstring = String.valueOf(user);
                mBookname.add(userstring);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

    }

    @Override
    public void onClick(View v) {
        if (v == returnButton) {
    mBookname.clear();;
    muserList.setAdapter(null);
        }
    }
}
