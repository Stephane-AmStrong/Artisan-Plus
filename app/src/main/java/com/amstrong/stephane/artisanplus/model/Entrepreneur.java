package com.amstrong.stephane.artisanplus.model;

import android.os.Parcel;
import java.util.List;

public class Entrepreneur extends Utilisateur{
    private String passWord;

    public Entrepreneur(int photo, String id, String nom, String prenom, String sex, String contact, String passWord) {
        super(photo, id, nom, prenom, sex, contact);
        this.passWord = passWord;
    }

    public Entrepreneur(int photo, String id, String nom, String prenom, String sex, List<String> lstContact, String passWord) {
        super(photo, id, nom, prenom, sex, lstContact);
        this.passWord = passWord;
    }

    public Entrepreneur(int photo, String id, String nom, String prenom, String sex, String contact) {
        super(photo, id, nom, prenom, sex, contact);
    }

    public Entrepreneur(Parcel in, String passWord) {
        super(in);
        this.passWord = passWord;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(passWord);
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
