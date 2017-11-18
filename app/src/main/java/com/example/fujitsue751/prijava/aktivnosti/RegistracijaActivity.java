package com.example.fujitsue751.prijava.aktivnosti;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.example.fujitsue751.prijava.R;
import com.example.fujitsue751.prijava.helper.Valdacija;
import com.example.fujitsue751.prijava.model.Korisnik;
import com.example.fujitsue751.prijava.sql.BazaHelper;

/**
 * Created by Fujitsu E751 on 11/05/2017.
 */

public class RegistracijaActivity extends AppCompatActivity implements View.OnClickListener {

        private final AppCompatActivity aAppCompatActivity = RegistracijaActivity.this;

        private NestedScrollView aNestedScrollView;

        private TextInputLayout aTextInputLayoutIme;
        private TextInputLayout aTextInputLayoutEmail;
        private TextInputLayout aTextInputLayoutLozinka;
        private TextInputLayout aTextInputLayoutPotvrdiLozinku;

        private TextInputEditText aTextInputEditTextIme;
        private TextInputEditText aTextInputEditTextEmail;
        private TextInputEditText aTextInputEditTextLozinka;
        private TextInputEditText aTextInputEditTextPotvrdiLozinku;

        private AppCompatButton aAppCompatButtonRegistracija;
        private AppCompatTextView aAppCompatTextViewLinkPrijava;

    private Valdacija aValdacija;
    private BazaHelper aBazaHelper;
    private Korisnik aKorisnik;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registracija);
        getSupportActionBar().hide();

        initViews();
        initListeners();
        initObjects();
    }

    private void initViews(){

        aNestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);

        aTextInputLayoutIme = (TextInputLayout) findViewById(R.id.LayoutIme);
        aTextInputLayoutLozinka = (TextInputLayout) findViewById(R.id.LayoutLozinka);
        aTextInputLayoutEmail = (TextInputLayout) findViewById(R.id.LayoutEmail);
        aTextInputLayoutPotvrdiLozinku = (TextInputLayout) findViewById(R.id.LayoutPorvrdaLozinka);

        aTextInputEditTextIme = (TextInputEditText) findViewById(R.id.ime);
        aTextInputEditTextEmail = (TextInputEditText) findViewById(R.id.email);
        aTextInputEditTextLozinka = (TextInputEditText) findViewById(R.id.lozinka);
        aTextInputEditTextPotvrdiLozinku = (TextInputEditText) findViewById(R.id.potvrdiLozinka);

        aAppCompatButtonRegistracija = (AppCompatButton) findViewById(R.id.dugme_registracija);
        aAppCompatTextViewLinkPrijava = (AppCompatTextView) findViewById(R.id.linkPrijava);

    }

    private void initListeners(){
        aAppCompatButtonRegistracija.setOnClickListener(this);
        aAppCompatTextViewLinkPrijava.setOnClickListener(this);
    }

    private void initObjects(){

        aBazaHelper = new BazaHelper(aAppCompatActivity);
        aValdacija = new Valdacija(aAppCompatActivity);
        aKorisnik = new Korisnik();
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            // ukoliko kliknemo na
            case R.id.dugme_registracija:
                postDataToSQLite();
                break;
            case R.id.linkPrijava:
                finish();
                break;

        }
    }

    private void  postDataToSQLite(){
        if(!aValdacija.EditTextPopunjen( aTextInputEditTextIme, aTextInputLayoutIme, getString(R.string.greska_poruka_ime))){
            return;
        }

        if (!aValdacija.EditTextPopunjen(aTextInputEditTextEmail, aTextInputLayoutEmail, getString(R.string.greska_poruka_email))){
            return;
        }
        if(!aValdacija.EditTextEmail( aTextInputEditTextEmail, aTextInputLayoutEmail, getString(R.string.greska_poruka_email))){
            return;
        }

        if(!aValdacija.EditTextOdgovara(aTextInputEditTextLozinka, aTextInputEditTextPotvrdiLozinku, aTextInputLayoutPotvrdiLozinku, getString(R.string.greska_lozinka_neodgovara))){
            return;
        }
        if(!aBazaHelper.checkUser(aTextInputEditTextEmail.getText().toString().trim())){
          aKorisnik.setIme(aTextInputEditTextIme.getText().toString().trim());
          aKorisnik.setEmail(aTextInputEditTextEmail.getText().toString().trim());
          aKorisnik.setLozinka(aTextInputEditTextLozinka.getText().toString().trim());

            aBazaHelper.addUser(aKorisnik);
            Snackbar.make(aNestedScrollView, getString(R.string.uspjesno_poruka), Snackbar.LENGTH_LONG).show();
        }
        else {
            Snackbar.make(aNestedScrollView, getString(R.string.greska_email_postoji), Snackbar.LENGTH_LONG).show();
        }

    }

    private void emptyInputEditText(){
        aTextInputEditTextIme.setText(null);
        aTextInputEditTextEmail.setText(null);
        aTextInputEditTextPotvrdiLozinku.setText(null);
        aTextInputEditTextLozinka.setText(null);
    }



}


