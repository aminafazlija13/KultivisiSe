package com.example.fujitsue751.prijava.aktivnosti;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.TextView;

import com.example.fujitsue751.prijava.R;
import com.example.fujitsue751.prijava.helper.Valdacija;
import com.example.fujitsue751.prijava.sql.BazaHelper;

public class prijavaActivity extends AppCompatActivity implements View.OnClickListener{

    private final AppCompatActivity aActivity = prijavaActivity.this;

    private NestedScrollView aNestedScrollView;

    private TextInputLayout aTextInputEmail;
    private TextInputLayout aTextInputLozinka;

    private TextInputEditText aTextInputEditEmail;
    private TextInputEditText aTextInputEditLozinka;

    private AppCompatButton aAppCompatButton;

    private AppCompatTextView aAppCompatTextView;

    private Valdacija aValdacija;
    private BazaHelper aBazaHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prijava);
        getSupportActionBar().hide();

        initViews();
        initListeners();
        initObjects();
    }

    private void initViews(){

        aNestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);

        aTextInputEmail = (TextInputLayout) findViewById(R.id.LayoutEmail);
        aTextInputLozinka = (TextInputLayout) findViewById(R.id.LayoutLozinka);

        aTextInputEditEmail = (TextInputEditText) findViewById(R.id.email);
        aTextInputEditLozinka = (TextInputEditText) findViewById(R.id.lozinka);

        aAppCompatButton = (AppCompatButton) findViewById(R.id.dugme_prijava);
        aAppCompatTextView = (AppCompatTextView) findViewById(R.id.linkRegistracija);

    }

    private void initListeners(){

        aAppCompatButton.setOnClickListener(this);
        aAppCompatTextView.setOnClickListener(this);
    }

    private void initObjects(){

        aBazaHelper = new BazaHelper(aActivity);
        aValdacija = new Valdacija(aActivity);
    }

    @Override
    //ukoliko kliknemo prijava da provjeri podatke u bazi
    public void onClick(View v){
        switch (v.getId()){
            case R.id.dugme_prijava:
                verifyFromSQLite();
                break;
            // ukoliko kliknemo na rgitraciju da nam otvori novu aktivnost RegistracijaActivity
            case R.id.linkRegistracija:
                Intent intentRegistracija = new Intent(getApplicationContext(), RegistracijaActivity.class);
                startActivity(intentRegistracija);
                break;

        }
    }

    private void verifyFromSQLite(){
        if(!aValdacija.EditTextPopunjen(aTextInputEditEmail, aTextInputEmail, getString(R.string.greska_poruka_email))){
            return;
        }
        if (!aValdacija.EditTextEmail(aTextInputEditEmail, aTextInputEmail, getString(R.string.greska_poruka_email))){
            return;
        }
        if(!aValdacija.EditTextPopunjen(aTextInputEditLozinka, aTextInputLozinka, getString(R.string.greska_poruka_lozinka))){
            return;
        }
        if(aBazaHelper.checkUser(aTextInputEditEmail.getText().toString().trim()
                ,aTextInputEditLozinka.getText().toString().trim())){
            Intent accountsIntent = new Intent(aActivity, MainActivity.class);
            accountsIntent.putExtra(" EMAIL ", aTextInputEditEmail.getText().toString().trim());
            emptyInputEditText();
            prijavaActivity.this.finish();
            startActivity(accountsIntent);
        }
        else {
            Snackbar.make(aNestedScrollView, getString(R.string.greska_email_lozinka), Snackbar.LENGTH_LONG).show();
        }

    }

    private void emptyInputEditText(){
        aTextInputEditEmail.setText(null);
        aTextInputEditLozinka.setText(null);
    }


}
