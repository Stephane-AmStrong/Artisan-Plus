package com.amstrong.stephane.artisanplus.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Utilisateur implements Parcelable {
    private int picture;
    private int id;
    private String nom, prenom,sex;
    private List<String> lstContact;

    public Utilisateur(int picture, int id, String nom, String prenom, String sex, String contact) {
        this.picture = picture;
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.sex = sex;
        this.lstContact = new ArrayList<>();
        lstContact.add(contact);
    }

    public void ajouter(String contact){
        lstContact.add(contact);
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<String> getLstContact() {
        return lstContact;
    }

    public void setLstContact(List<String> lstContact) {
        this.lstContact = lstContact;
    }

    protected Utilisateur(Parcel in) {
        picture = in.readInt();
        id = in.readInt();
        nom = in.readString();
        prenom = in.readString();
        sex = in.readString();
        lstContact = in.createStringArrayList();
    }

    public static final Creator<Utilisateur> CREATOR = new Creator<Utilisateur>() {
        @Override
        public Utilisateur createFromParcel(Parcel in) {
            return new Utilisateur(in);
        }

        @Override
        public Utilisateur[] newArray(int size) {
            return new Utilisateur[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(picture);
        parcel.writeInt(id);
        parcel.writeString(nom);
        parcel.writeString(prenom);
        parcel.writeString(sex);
        parcel.writeStringList(lstContact);
    }
}
