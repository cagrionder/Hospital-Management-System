package com.example.firebasekayit;

public class User {

    public String tc;
    public String ad, soyad;
    public String cinsiyet;
    public String tarih;
    public String telefon;
    public String eMail;
    public String adres;
    public String sifre;

    public User() {

    }

    public User(String sifre) {
        this.sifre = sifre;
    }

    public User(String ad, String soyad, String cinsiyet, String tarih, String telefon, String eMail, String adres, String sifre) {
        this.ad = ad;
        this.soyad = soyad;
        this.cinsiyet = cinsiyet;
        this.tarih = tarih;
        this.telefon = telefon;
        this.eMail = eMail;
        this.adres = adres;
        this.sifre = sifre;
    }
}
