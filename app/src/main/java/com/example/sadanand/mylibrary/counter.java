package com.example.sadanand.mylibrary;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class counter extends AppCompatActivity implements View.OnClickListener{
    public static int Ccount = 5;
    public static int COAcount = 5;
    public static int DScount = 5;
    public static int JAVAcount = 5;
     public String book;
    private Button issueCButton;
    private Button issueDSButton;
    private Button issueJavaButton;
    private Button issueCoaButton;
    private Button buttonSave;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;
    private  FirebaseAuth.AuthStateListener mAuth;
    private DatabaseReference databaseReference;
    SharedPreferences sharedPreferences;

    public static final String counting = "count";
    SharedPreferences myprefs;


    public static final String MYpreferences = "MyPrefsFile";


    public void issueC(View view){
        if(Ccount>0) {

            book=" Elements of C programming";
            Ccount--;
            /*SharedPreferences.Editor editor= sharedPreferences.edit();
            editor.putInt(counting,Ccount);
            editor.apply();
            Toast.makeText(counter.this, "thanks for issuing", Toast.LENGTH_SHORT).show();
            editor.commit();*/
        }
        else{
            Toast.makeText(this, "Please come Later , All copies aready issued !!", Toast.LENGTH_SHORT).show();
        }
    }
    public void returnC(View view) {
        if (Ccount < 5) {
            Ccount++;
            book="No Books Issued";
        } else {
            Toast.makeText(this, "Such a scenario can't exist in reality !!", Toast.LENGTH_SHORT).show();
        }
    }

    public void issueDS(View view){
        if(DScount>0) {
            DScount--;
            book="Data Structures";
        }
        else{
            Toast.makeText(this, "Please come Later , All copies aready issued !!", Toast.LENGTH_SHORT).show();
        }
    }
    public void returnDS(View view) {
        if (DScount < 5) {
            DScount++;
            book="No Books Issued";
        } else {
            Toast.makeText(this, "Such a scenario can't exist in reality !!", Toast.LENGTH_SHORT).show();
        }
    }

    public void issueCOA(View view){
        if(COAcount>0) {
            COAcount--;
            book="Computer organization& architecture by WILLIAM STALLINGS";
        }
        else{
            Toast.makeText(this, "Please come Later , All copies aready issued !!", Toast.LENGTH_SHORT).show();
        }
    }
    public void returnCOA(View view) {
        if (COAcount < 5) {
            COAcount++;
            book="No Books Issued";

        } else {
            Toast.makeText(this, "Such a scenario can't exist in reality !!", Toast.LENGTH_SHORT).show();
        }
    }

    public void issueJAVA(View view){
        if(JAVAcount>0) {
            JAVAcount--;
            book="JAVA-THE COMPLETE REFERENCE";
        }
        else{
            Toast.makeText(this, "Please come Later , All copies aready issued !!", Toast.LENGTH_SHORT).show();
        }
    }
    public void returnJAVA(View view) {
        if (JAVAcount < 5) {
            JAVAcount++;
            book="No Books Issued";
        } else {
            Toast.makeText(this, "Such a scenario can't exist in reality !!", Toast.LENGTH_SHORT).show();
        }
    }


    public void remainingcopiesC(View view) {

        ImageView book = (ImageView)findViewById(R.id.cBook);
        if (Ccount <= 0) {
            Toast.makeText(this, "Please come Later , All copies aready issued !!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Remaining Copies " + Ccount, Toast.LENGTH_SHORT).show();
        }
    }
    public void remainingcopiesCOA(View view) {

        ImageView book = (ImageView) findViewById(R.id.coa1);
        if (COAcount <= 0) {
            Toast.makeText(this, "Please come Later , All copies aready issued !!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Remaining Copies " + COAcount, Toast.LENGTH_SHORT).show();
        }
    }
    public void remainingcopiesDS(View view) {
        ImageView book = (ImageView) findViewById(R.id.dsBook);
        if (DScount <= 0) {
            Toast.makeText(this, "Please come Later , All copies aready issued !!", Toast.LENGTH_SHORT).show();
        }

        else{
            Toast.makeText(this, "Remaining Copies " + DScount, Toast.LENGTH_SHORT).show();
        }
    }
    public void remainingcopiesJAVA(View view) {
        if (COAcount <= 0) {
            Toast.makeText(this, "Please come Later , All copies aready issued !!", Toast.LENGTH_SHORT).show();
        } else {

            ImageView book = (ImageView) findViewById(R.id.javaBook);
            Toast.makeText(this, "Remaining Copies " + JAVAcount, Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        issueCButton = (Button) findViewById(R.id.Cissue);
        issueCoaButton = (Button) findViewById(R.id.COAissue);
        issueJavaButton = (Button) findViewById(R.id.JAVAissue);
        issueDSButton = (Button) findViewById(R.id.DSissue);
        buttonSave = (Button) findViewById(R.id.button7);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        buttonSave.setOnClickListener(this);
        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();

    }
    private void saveUserInformation(){
            int c=1;
                String name=book;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String d=dateFormat.format(date);
        UserInfomation userInfomation=new UserInfomation(c,d,name);
        if (user!= null) {

            databaseReference.child(user.getUid()).setValue(userInfomation);

            Toast.makeText(this, "Books added...", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Books cant be added...", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        if(v==buttonSave){
            saveUserInformation();
        }

    }
}

