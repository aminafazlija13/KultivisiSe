package com.example.fujitsue751.prijava.aktivnosti;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.fujitsue751.prijava.R;

import org.w3c.dom.Text;

/**
 * Created by Fujitsu E751 on 11/05/2017.
 */

public class KorisnikActivity extends AppCompatActivity {

    private TextView aTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_korisnik);

        aTextView = (TextView) findViewById(R.id.text1);
        String nameFromIntent = getIntent().getStringExtra(" EMAIL ");
        aTextView.setText("Dobro došli " + nameFromIntent);
    }
}