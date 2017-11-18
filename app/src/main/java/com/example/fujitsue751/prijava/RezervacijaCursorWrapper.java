package com.example.fujitsue751.prijava;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.fujitsue751.prijava.database.DbSchema;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Fujitsu E751 on 24/05/2017.
 */


public class RezervacijaCursorWrapper extends CursorWrapper {
    public RezervacijaCursorWrapper(Cursor cursor) {
        super(cursor);
    }
    public Rezervacija getRezervacija() {
        String uuidString = getString(getColumnIndex(DbSchema.RezervacijeTable.Cols.UUID));
        String title = getString(getColumnIndex(DbSchema.RezervacijeTable.Cols.TITLE));
        String brojulaznica = getString(getColumnIndex(DbSchema.RezervacijeTable.Cols.BROJULAZNICA));
        long date = getLong(getColumnIndex(DbSchema.RezervacijeTable.Cols.DATE));
        int isRezervacija = getInt(getColumnIndex(DbSchema.RezervacijeTable.Cols.REZERVACIJA));
        Rezervacija rezervacija = new Rezervacija(UUID.fromString(uuidString));
        rezervacija.setTitle(title);
        rezervacija.setBrojUlaznica(brojulaznica);
        rezervacija.setDate(new Date(date));
        rezervacija.setRezervacija(isRezervacija != 0);
        return rezervacija;
    }
}