package com.example.fujitsue751.prijava;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class onama extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onama);


        Typeface myTypeFace = Typeface.createFromAsset(getAssets(),"Lobster_1.3.otf");

        TextView myTextView = (TextView) findViewById(R.id.miIme);
        myTextView.setTypeface(myTypeFace);
        TextView myTextView1 = (TextView) findViewById(R.id.miMail);
        myTextView1.setTypeface(myTypeFace);
        TextView myTextView2 = (TextView) findViewById(R.id.miMail2);
        myTextView2.setTypeface(myTypeFace);
    }
}
