package com.example.fujitsue751.prijava.helper;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import android.support.design.widget.TextInputLayout;



public class Valdacija {

private Context aContext;

    public Valdacija(Context context){

        this.aContext = context;
    }

    public boolean EditTextPopunjen(TextInputEditText textInputEditText, TextInputLayout textInputLayout, String poruka){
        String Vrijednost = textInputEditText.getText().toString().trim();
        //ukoliko nismo popunili neko polje ispise se poruka
        if(Vrijednost.isEmpty()){

            textInputLayout.setError(poruka);
            hideKeyBoardFrom(textInputEditText);
            return false;
        }
        else{

            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    // provjerava da li je mail unesen ispravno
    public boolean EditTextEmail(TextInputEditText textInputEditText, TextInputLayout textInputLayout, String poruka) {
        String Vrijednost = textInputEditText.getText().toString().trim();
        //ukoliko nismo unijeli mail ili nismo unijeli u formatu maila ispise se poruka
        if (Vrijednost.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(Vrijednost).matches()) {

            textInputLayout.setError(poruka);
            hideKeyBoardFrom(textInputEditText);
            return false;

        } else {

            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    public boolean EditTextOdgovara(TextInputEditText textInputEditText1, TextInputEditText textInputEditText2, TextInputLayout textInputLayout, String poruka){
        String Vrijednost1 = textInputEditText1.getText().toString().trim();
        String Vrijednost2 = textInputEditText2.getText().toString().trim();

        if(!Vrijednost1.contentEquals(Vrijednost2)){
            textInputLayout.setError(poruka);
            hideKeyBoardFrom(textInputEditText2);
            return false;

        }
        else{
            textInputLayout.setErrorEnabled(false);
        }
        return true;
}

    private void  hideKeyBoardFrom(View view) {

        InputMethodManager imm = (InputMethodManager) aContext.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }


}