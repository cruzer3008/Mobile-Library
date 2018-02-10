package com.example.sadanand.mylibrary;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profile_Activity extends AppCompatActivity implements View.OnClickListener {


    private FirebaseAuth firebaseAuth;
    private TextView textviewuseremail;
    private Button buttonLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user=firebaseAuth.getCurrentUser();
        textviewuseremail=(TextView)findViewById(R.id.textView5);
        String s=user.getEmail();
        textviewuseremail.setText("Welcome    "+ s.substring(0,10).toUpperCase() );
        buttonLogout=(Button)findViewById(R.id.button4);

        buttonLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
if(v==buttonLogout){
    firebaseAuth.signOut();
    finish();
    startActivity(new Intent(this,LoginActivity.class));
}
    }
    public void clickCounter(View view){
        Intent i = new Intent(getApplicationContext(),counter.class);
        startActivity(i);
    }

    public void clickMyBooks(View view){
        Intent i = new Intent(getApplicationContext(),mybooks.class);
        startActivity(i);
    }

    public void clickAbout(View view){
        Intent i = new Intent(getApplicationContext(),about.class);
        startActivity(i);
    }
}
