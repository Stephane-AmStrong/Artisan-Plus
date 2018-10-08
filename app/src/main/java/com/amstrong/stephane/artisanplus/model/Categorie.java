package com.amstrong.stephane.artisanplus.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Categorie implements Parcelable {
    private int Id;
    private String Libelle,Detail;

    public Categorie(int id, String libelle, String detail) {
        Id = id;
        Libelle = libelle;
        Detail = detail;
    }

    public Categorie(String libelle) {
        Libelle = libelle;
    }

    protected Categorie(Parcel in) {
        Id = in.readInt();
        Libelle = in.readString();
        Detail = in.readString();
    }

    public static final Creator<Categorie> CREATOR = new Creator<Categorie>() {
        @Override
        public Categorie createFromParcel(Parcel in) {
            return new Categorie(in);
        }

        @Override
        public Categorie[] newArray(int size) {
            return new Categorie[size];
        }
    };

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String libelle) {
        Libelle = libelle;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(Id);
        parcel.writeString(Libelle);
        parcel.writeString(Detail);
    }
}
