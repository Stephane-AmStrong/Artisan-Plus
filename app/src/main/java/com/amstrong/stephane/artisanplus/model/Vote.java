package com.amstrong.stephane.artisanplus.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Vote implements Parcelable {
    private int id;
    private int note;
    private String comment;
    private Utilisateur utilisateur;
    private Entreprise entreprise;

    public Vote(int id, int note, String comment, Utilisateur utilisateur, Entreprise entreprise) {
        this.id = id;
        this.note = note;
        this.comment = comment;
        this.utilisateur = utilisateur;
        this.entreprise = entreprise;
    }

    protected Vote(Parcel in) {
        id = in.readInt();
        note = in.readInt();
        comment = in.readString();
        entreprise = in.readParcelable(Entreprise.class.getClassLoader());
    }

    public static final Creator<Vote> CREATOR = new Creator<Vote>() {
        @Override
        public Vote createFromParcel(Parcel in) {
            return new Vote(in);
        }

        @Override
        public Vote[] newArray(int size) {
            return new Vote[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeInt(note);
        parcel.writeString(comment);
        parcel.writeParcelable(entreprise, i);
    }
}
