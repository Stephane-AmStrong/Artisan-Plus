package com.amstrong.stephane.artisanplus.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Entrepreneur extends Utilisateur implements Parcelable {
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

    protected Entrepreneur(Parcel in) {
        super(in);
        passWord = in.readString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(passWord);
    }

    public static final Creator<Entrepreneur> CREATOR = new Creator<Entrepreneur>() {

        @Override
        public Entrepreneur createFromParcel(Parcel in) {
            return new Entrepreneur(in);
        }

        @Override
        public Entrepreneur[] newArray(int size) {
            return new Entrepreneur[size];
        }
    };

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }


}
