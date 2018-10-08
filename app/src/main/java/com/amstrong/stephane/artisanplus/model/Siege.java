package com.amstrong.stephane.artisanplus.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Siege implements Parcelable {

    private int id;
    private String nom;
    final double latitude;
    final double longitude;


    public Siege(int id, String nom, double latitude, double longitude) {
        this.id = id;
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    protected Siege(Parcel in) {
        id = in.readInt();
        nom = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
    }

    public static final Creator<Siege> CREATOR = new Creator<Siege>() {
        @Override
        public Siege createFromParcel(Parcel in) {
            return new Siege(in);
        }

        @Override
        public Siege[] newArray(int size) {
            return new Siege[size];
        }
    };

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

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(nom);
        parcel.writeDouble(latitude);
        parcel.writeDouble(longitude);
    }
}
