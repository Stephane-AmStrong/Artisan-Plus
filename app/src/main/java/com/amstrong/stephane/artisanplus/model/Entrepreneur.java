package com.amstrong.stephane.artisanplus.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class Entrepreneur extends Utilisateur implements Parcelable {
    private String passWord;
    private List<Entreprise> lstEntreprise;

    public Entrepreneur(int photo, String id, String nom, String prenom, String sex, String contact, String passWord) {
        super(photo, id, nom, prenom, sex, contact);
        this.passWord = passWord;
        this.lstEntreprise = new ArrayList<>();
    }

    public Entrepreneur(int photo, String id, String nom, String prenom, String sex, List<String> lstContact, String passWord) {
        super(photo, id, nom, prenom, sex, lstContact);
        this.passWord = passWord;
        this.lstEntreprise = new ArrayList<>();
    }

    public Entrepreneur(int photo, String id, String nom, String prenom, String sex, String contact) {
        super(photo, id, nom, prenom, sex, contact);
    }

    protected Entrepreneur(Parcel in) {
        super(in);
        passWord = in.readString();
        this.lstEntreprise = in.createTypedArrayList(Entreprise.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(passWord);
        parcel.writeTypedList(lstEntreprise);
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

    public List<Entreprise> getLstEntreprise() {
        return lstEntreprise;
    }

    public void setLstEntreprise(List<Entreprise> lstEntreprise) {
        this.lstEntreprise = lstEntreprise;
    }

    public void addEntreprise(Entreprise entreprise){
        lstEntreprise.add(entreprise);
    }

    public void fetchEntreprise(List<Entreprise> lstEntreprise){
        for (Entreprise entreprise: lstEntreprise ) {
            if (this.getId().equals(entreprise.getEntrepreneur().getId())) addEntreprise(entreprise);
        }
    }
}
