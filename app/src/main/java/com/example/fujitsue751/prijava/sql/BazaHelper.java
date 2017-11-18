package com.example.fujitsue751.prijava.sql;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.fujitsue751.prijava.model.Korisnik;

import java.security.PrivilegedAction;

public class BazaHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "UserMenager.db";

    private static final String TABLE_USER = "korisnik";

    private static final String COLUMN_USER_ID = "korisnik_id";
    private static final String COLUMN_USER_NAME = "korisnik_ime";
    private static final String COLUMN_USER_EMAIL = "korisnik_email";
    private static final String COLUMN_USER_PASSWORD = "korisnik_lozinka";

    //kreiramo tabelu

    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + " ( "
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + " ) ";

    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

   public BazaHelper(Context context){

       super(context, DATABASE_NAME, null, DATABASE_VERSION);
   }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_USER_TABLE);
        onCreate(db);
    }
    // dodavanje korisnika
    public void addUser(Korisnik korisnik){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues vrijednost = new ContentValues();
        vrijednost.put(COLUMN_USER_NAME, korisnik.getIme());
        vrijednost.put(COLUMN_USER_EMAIL, korisnik.getEmail());
        vrijednost.put(COLUMN_USER_PASSWORD, korisnik.getLozinka());

        db.insert(TABLE_USER, null, vrijednost);
        db.close();

    }

    public boolean checkUser(String email){
        String[] columns = {
                COLUMN_USER_ID
        };

        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_USER_EMAIL + " =?";
        String[] selectionArgs = { email };

        Cursor aCursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = aCursor.getCount();
        aCursor.close();
        db.close();
        if (cursorCount > 0 ){

            return true;
        }

        return false;
    }

    public boolean checkUser(String email, String lozinka){
        String[] columns = {
                COLUMN_USER_ID
        };

        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_USER_EMAIL + " =? " + " AND " + COLUMN_USER_PASSWORD + " =? ";
        String[] selectionArgs = { email, lozinka };

        Cursor aCursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = aCursor.getCount();
        aCursor.close();
        db.close();
        if (cursorCount > 0 ){

            return true;
        }

        return false;
    }
}
