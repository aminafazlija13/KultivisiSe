package com.example.fujitsue751.prijava.aktivnosti;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fujitsue751.prijava.R;

public class SplashScreen extends Activity {

    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {


            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // Ova metoda će se izvršiti nakon isteka vremena i pokrenit će se prijavaActivity
                Intent i = new Intent(SplashScreen.this, prijavaActivity.class);
                startActivity(i);

                // zatvara ovu aktivnost
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}