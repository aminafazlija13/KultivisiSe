package com.example.fujitsue751.prijava;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Muzeji extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muzeji);



        Typeface myTypeFace = Typeface.createFromAsset(getAssets(),"Lobster_1.3.otf");

        TextView myTextView = (TextView) findViewById(R.id.ZemaljskiNaziv);
        myTextView.setTypeface(myTypeFace);



        TextView myTextView3 = (TextView) findViewById(R.id.HistorijskiNaziv);
        myTextView3.setTypeface(myTypeFace);

        TextView myTextView1 = (TextView) findViewById(R.id.MRTNaziv);
        myTextView1.setTypeface(myTypeFace);
        
    }
}
