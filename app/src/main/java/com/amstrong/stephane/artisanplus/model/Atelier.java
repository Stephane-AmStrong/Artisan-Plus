package com.amstrong.stephane.artisanplus.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Atelier implements Parcelable{

    private int image;
    private int id;
    private String nom;
    private Categorie categorie;
    private float etoile;
    private List<Activite> lstActivite;
    private List<Integer> lstPictures = new ArrayList<Integer>();
    private Gerant gerant;

    public Atelier(int image, int id, String nom, Categorie categorie, float etoile, List<Activite> lstActivite, Gerant gerant) {
        this.image = image;
        this.id = id;
        this.nom = nom;
        this.categorie = categorie;
        this.etoile = etoile;
        this.lstActivite = lstActivite;
        this.gerant = gerant;
    }

    public Atelier(int image, int id, String nom, float etoile, List<Activite> lstActivite, Gerant gerant) {
        this.image = image;
        this.id = id;
        this.nom = nom;
        this.etoile = etoile;
        this.lstActivite = lstActivite;
        this.gerant = gerant;
    }

    protected Atelier(Parcel in) {
        image = in.readInt();
        id = in.readInt();
        nom = in.readString();
        categorie = in.readParcelable(Categorie.class.getClassLoader());
        etoile = in.readFloat();
        lstActivite = in.createTypedArrayList(Activite.CREATOR);
        in.readList(lstPictures,null);
        gerant = in.readParcelable(Gerant.class.getClassLoader());
    }

    public static final Creator<Atelier> CREATOR = new Creator<Atelier>() {
        @Override
        public Atelier createFromParcel(Parcel in) {
            return new Atelier(in);
        }

        @Override
        public Atelier[] newArray(int size) {
            return new Atelier[size];
        }
    };

    //
    public void addPicture(int picture){
        lstPictures.add(picture);
    }

    public void deletePicture(int picture){

        lstPictures.remove(picture);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(image);
        parcel.writeInt(id);
        parcel.writeString(nom);
        parcel.writeParcelable(categorie, i);
        parcel.writeFloat(etoile);
        parcel.writeTypedList(lstActivite);
        parcel.writeList(lstPictures);
        parcel.writeParcelable(gerant, i);
    }
    //


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
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

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public float getEtoile() {
        return etoile;
    }

    public void setEtoile(float etoile) {
        this.etoile = etoile;
    }

    public List<Activite> getLstActivite() {
        return lstActivite;
    }

    public void setLstActivite(List<Activite> lstActivite) {
        this.lstActivite = lstActivite;
    }

    public List<Integer> getLstPictures() {
        return lstPictures;
    }

    public void setLstPictures(List<Integer> lstPictures) {
        this.lstPictures = lstPictures;
    }

    public Gerant getGerant() {
        return gerant;
    }

    public void setGerant(Gerant gerant) {
        this.gerant = gerant;
    }
}
