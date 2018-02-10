package com.example.sadanand.mylibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.text.method.*;
public class about extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_about);

        TextView textView = (TextView) findViewById(R.id.info);
        textView.setMovementMethod(new ScrollingMovementMethod());


    }

    public void librarian(View v){
        Intent i = new Intent(getApplicationContext(),Librarian.class);
        startActivity(i);
    }

    public void photos(View v){
        Intent i = new Intent(getApplicationContext(),Photos.class);
        startActivity(i);
    }



    /*public void appear2 (View view){

        ImageView libr = (ImageView)findViewById(R.id.libr);
        ImageView libr2 = (ImageView)findViewById(R.id.libr2);
        libr.animate().alpha(0f).setDuration(1000);
        libr2.animate().alpha(1f).setDuration(1000);

    }

    public void appear3 (View view){

        ImageView libr2 = (ImageView)findViewById(R.id.libr2);
        ImageView libr3 = (ImageView)findViewById(R.id.libr3);
        libr2.animate().alpha(0f).setDuration(1000);
        libr3.animate().alpha(1f).setDuration(1000);

    }

    public void appear4 (View view){

        ImageView libr3 = (ImageView)findViewById(R.id.libr3);
        ImageView libr4 = (ImageView)findViewById(R.id.libr4);
        libr3.animate().alpha(0f).setDuration(1000);
        libr4.animate().alpha(1f).setDuration(1000);

    }

    public void appear1 (View view){

        ImageView libr4 = (ImageView)findViewById(R.id.libr4);
        ImageView libr = (ImageView)findViewById(R.id.libr);
        libr4.animate().alpha(0f).setDuration(1000);
        libr.animate().alpha(1f).setDuration(1000);

    }*/



}
