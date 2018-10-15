package com.amstrong.stephane.artisanplus.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Vote implements Parcelable {
    private int id;
    private int note;
    private String comment;
    private Utilisateur utilisateur;
    private Atelier atelier;

    public Vote(int id, int note, String comment, Utilisateur utilisateur, Atelier atelier) {
        this.id = id;
        this.note = note;
        this.comment = comment;
        this.utilisateur = utilisateur;
        this.atelier = atelier;
    }

    protected Vote(Parcel in) {
        id = in.readInt();
        note = in.readInt();
        comment = in.readString();
        atelier = in.readParcelable(Atelier.class.getClassLoader());
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

    public Atelier getAtelier() {
        return atelier;
    }

    public void setAtelier(Atelier atelier) {
        this.atelier = atelier;
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
        parcel.writeParcelable(atelier, i);
    }
}
