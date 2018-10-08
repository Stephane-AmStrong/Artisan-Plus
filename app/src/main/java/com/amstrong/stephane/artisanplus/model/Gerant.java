package com.amstrong.stephane.artisanplus.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Gerant implements Parcelable{
    int picture;
    int id;
    private String nom,prenom,sex,tel1,tel2;

    public Gerant(int picture, int id, String nom, String prenom, String sex) {
        this.picture = picture;
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.sex = sex;
    }

    public Gerant(int picture, int id, String nom, String prenom, String tel1, String tel2) {
        this.picture = picture;
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.tel1 = tel1;
        this.tel2 = tel2;
    }

    protected Gerant(Parcel in) {
        picture = in.readInt();
        id = in.readInt();
        nom = in.readString();
        prenom = in.readString();
        sex = in.readString();
        tel1 = in.readString();
        tel2 = in.readString();
    }

    public static final Creator<Gerant> CREATOR = new Creator<Gerant>() {
        @Override
        public Gerant createFromParcel(Parcel in) {
            return new Gerant(in);
        }

        @Override
        public Gerant[] newArray(int size) {
            return new Gerant[size];
        }
    };

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

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

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
        parcel.writeString(tel1);
        parcel.writeString(tel2);
    }
}
