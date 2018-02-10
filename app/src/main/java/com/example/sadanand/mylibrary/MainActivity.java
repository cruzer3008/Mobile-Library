package com.example.sadanand.mylibrary;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
private Button ButtonRegister;
    private EditText editTextemail;
    private EditText editTextpassword;
    private TextView textViewSignin;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
        ButtonRegister=(Button)findViewById(R.id.button2);
        editTextemail=(EditText)findViewById(R.id.editText);
        editTextpassword=(EditText)findViewById(R.id.editText2);
        textViewSignin=(TextView)findViewById(R.id.textView2);
    ButtonRegister.setOnClickListener(this);
        textViewSignin.setOnClickListener(this);

    }
    private void registeruser() {
        String email=editTextemail.getText().toString().trim();
        String password=editTextpassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            //email is empty
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            //password i empty
            Toast.makeText(this, " Please enter password",Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Registering User....");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //user registers succesfully
                            Toast.makeText(MainActivity.this, "Registered Succesfully!! Press on sign in", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        } else {
                            Toast.makeText(MainActivity.this, "Could not Register.Please try again!!...", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
    @Override
    public void onClick(View v) {
        if(v==ButtonRegister){
            registeruser();
        }
        if(v==textViewSignin){
            //will open login activity
            startActivity(new Intent(this,LoginActivity.class));
        }

    }
}
