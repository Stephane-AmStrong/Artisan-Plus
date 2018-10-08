package com.amstrong.stephane.artisanplus.model;

public class User {
    private int picture;
    private int id;
    private String nom,preboms,sex,login,passWord;

    public User(int picture, int id, String nom, String preboms, String sex, String login, String passWord) {
        this.picture = picture;
        this.id = id;
        this.nom = nom;
        this.preboms = preboms;
        this.sex = sex;
        this.login = login;
        this.passWord = passWord;
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

    public String getPreboms() {
        return preboms;
    }

    public void setPreboms(String preboms) {
        this.preboms = preboms;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
