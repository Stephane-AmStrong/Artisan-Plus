package com.amstrong.stephane.artisanplus.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Utilisateur implements Parcelable {
    private int photo;
    private String id;
    private String nom, prenom,sex;
    private List<String> lstContact;
    private List<Entreprise> historique;

    public Utilisateur(int photo, String id, String nom, String prenom, String sex, String contact) {
        this.photo = photo;
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.sex = sex;
        this.lstContact = new ArrayList<>();
        this.historique = new ArrayList<>();
        this.addTel(contact);
    }

    public Utilisateur(int photo, String id, String nom, String prenom, String sex, List<String> lstContact) {
        this.photo = photo;
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.sex = sex;
        this.lstContact = lstContact;
        this.historique = new ArrayList<>();
    }

    public Utilisateur(int photo, String id, String nom, String prenom, String sex, List<String> lstContact, List<Entreprise> historique) {
        this.photo = photo;
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.sex = sex;
        this.lstContact = lstContact;
        this.historique = historique;
    }

    //

    public void addToHistoric(Entreprise entreprise){
        historique.add(0,entreprise);
    }

    public void addTel(String tel){
        lstContact.add(tel);
    }
//

    protected Utilisateur(Parcel in) {
        photo = in.readInt();
        id = in.readString();
        nom = in.readString();
        prenom = in.readString();
        sex = in.readString();
        lstContact = in.createStringArrayList();
        historique = in.createTypedArrayList(Entreprise.CREATOR);
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
        parcel.writeInt(photo);
        parcel.writeString(id);
        parcel.writeString(nom);
        parcel.writeString(prenom);
        parcel.writeString(sex);
        parcel.writeStringList(lstContact);
        parcel.writeTypedList(historique);
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public List<Entreprise> getHistorique() {
        return historique;
    }

    public void setHistorique(List<Entreprise> historique) {
        this.historique = historique;
    }
}
