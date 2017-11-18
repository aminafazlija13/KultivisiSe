package com.example.fujitsue751.prijava.model;


public class Korisnik {
    private int aId;
    private String aIme;
    private String aEmail;
    private String aLozinka;
    // vraca id
    public int getId(){

        return aId;
    }
    //stavlja id
    public void setId(int id){
        this.aId = id;
    }

    //vraca ime
    public String getIme(){

        return aIme;
    }

    //postavlja ime
    public void setIme(String ime){

        this.aIme = ime;
    }

    //vraca email
    public String getEmail(){

        return aEmail;
    }

    // stavlja mail
    public void  setEmail(String email){

        this.aEmail = email;
    }

    //vraca lozinku
    public String getLozinka(){

        return  aLozinka;
    }

    //postavlja lozinku
    public void setLozinka(String lozinka){

        this.aLozinka=lozinka;
    }
}
