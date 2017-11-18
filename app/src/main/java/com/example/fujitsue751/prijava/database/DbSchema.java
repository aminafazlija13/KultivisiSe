package com.example.fujitsue751.prijava.database;

/**
 * Created by Fujitsu E751 on 24/05/2017.
 */

public class DbSchema {
    public static final class RezervacijeTable {
        public static final String NAME = "rezervacije";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DATE = "date";
            public static final String REZERVACIJA = "rezervacija";
            public static final String BROJULAZNICA = "broj_ulaznica";
        }
    }
}
