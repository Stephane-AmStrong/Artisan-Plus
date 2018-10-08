package com.amstrong.stephane.artisanplus.model;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint("ParcelCreator")
public class Activite implements Parcelable{

    private Atelier atelier;
    private int order;
    private Categorie categorie;

    public Activite(Atelier atelier, int order, Categorie categorie) {
        this.atelier = atelier;
        this.order = order;
        this.categorie = categorie;
    }

    public Activite(int order, Categorie categorie) {
        this.order = order;
        this.categorie = categorie;
    }


    protected Activite(Parcel in) {
        atelier = in.readParcelable(Atelier.class.getClassLoader());
        order = in.readInt();
        categorie = in.readParcelable(Categorie.class.getClassLoader());
    }

    public static final Creator<Activite> CREATOR = new Creator<Activite>() {
        @Override
        public Activite createFromParcel(Parcel in) {
            return new Activite(in);
        }

        @Override
        public Activite[] newArray(int size) {
            return new Activite[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(atelier, i);
        parcel.writeInt(order);
        parcel.writeParcelable(categorie, i);
    }

    public Atelier getAtelier() {
        return atelier;
    }

    public void setAtelier(Atelier atelier) {
        this.atelier = atelier;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
