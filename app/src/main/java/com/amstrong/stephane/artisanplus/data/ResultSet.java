package com.amstrong.stephane.artisanplus.data;



import com.amstrong.stephane.artisanplus.R;
import com.amstrong.stephane.artisanplus.model.Atelier;
import com.amstrong.stephane.artisanplus.model.Categorie;
import com.amstrong.stephane.artisanplus.model.Gerant;

import java.util.ArrayList;
import java.util.List;

public class ResultSet {

    private List<Atelier> lstAtelier;
    private Atelier atelier;
    private Gerant gerant;
    private List<Categorie> lstCategorie;
    private List<Gerant>lstGeran;
    private List<Atelier> lstAtelierMatching;

    public ResultSet() {
        lstAtelier = new ArrayList<>();
        lstCategorie = new ArrayList<>();
        lstGeran = new ArrayList<>();
        lstAtelierMatching=new ArrayList<>();
        this.getEntreprise();
        getCategories();
        setCategories();
    }

    private int [] imgGerant = {R.drawable.profil_1,R.drawable.profil_2,R.drawable.profil_3,R.drawable.profil_4,R.drawable.profil_5,R.drawable.profil_6,R.drawable.profil_7,R.drawable.profil_8,R.drawable.profil_9,R.drawable.profil_10};
    private int [] imgAtelier = {R.drawable.bckgrnd_1,R.drawable.bckgrnd_2,R.drawable.bckgrnd_3,R.drawable.bckgrnd_4,R.drawable.bckgrnd_5,R.drawable.bckgrnd_6,R.drawable.bckgrnd_7,R.drawable.bckgrnd_8,R.drawable.bckgrnd_9,R.drawable.bckgrnd_10};

    private int [][] tabPicture = {
            {R.drawable.bckgrnd_1,R.drawable.pictur_1,R.drawable.pictur_2,R.drawable.pictur_3,R.drawable.pictur_4},
            {R.drawable.bckgrnd_2,R.drawable.pictur_5,R.drawable.pictur_6,R.drawable.pictur_7,R.drawable.pictur_8},
            {R.drawable.bckgrnd_3,R.drawable.pictur_9,R.drawable.pictur_10,R.drawable.pictur_11,R.drawable.pictur_12},
            {R.drawable.bckgrnd_4,R.drawable.pictur_13,R.drawable.pictur_14,R.drawable.pictur_15,R.drawable.pictur_16},
            {R.drawable.bckgrnd_5,R.drawable.pictur_17,R.drawable.pictur_18,R.drawable.pictur_19,R.drawable.pictur_20},
            {R.drawable.bckgrnd_6,R.drawable.pictur_21,R.drawable.pictur_22,R.drawable.pictur_23,R.drawable.pictur_24},
            {R.drawable.bckgrnd_7,R.drawable.pictur_25,R.drawable.pictur_26,R.drawable.pictur_27,R.drawable.pictur_28},
            {R.drawable.bckgrnd_8,R.drawable.pictur_29,R.drawable.pictur_30,R.drawable.pictur_31,R.drawable.pictur_32},
            {R.drawable.bckgrnd_9,R.drawable.pictur_33,R.drawable.pictur_34,R.drawable.pictur_35,R.drawable.pictur_36},
            {R.drawable.bckgrnd_10,R.drawable.pictur_37,R.drawable.pictur_38,R.drawable.pictur_39,R.drawable.pictur_40,R.drawable.pictur_41,R.drawable.pictur_42}
    };

    private float [] ratings = {3,2,1,4,4,2,5,4,1,5};
    private int[] ids = {1,2,3,4,5,6,7,8,9,10};
    private String[] nomAtelier ={"BIO & Fils","TALO Mahouton","KOSSOU Alurgie","ALIGBO","MIDJO","DASILVA","DE SOUZA","SAGBO","ALISONTO","ADOUKONON"};
    private String[] nomGerant ={"BIO","TALO","Alurgie","ALIGBO","MIDJO","DASILVA","DE SOUZA","SAGBO","ALISONTO","ADOUKONON"};
    private String[] prenomGerant ={"Olivia","Sophia","Jack","Emily","Noah","Mia","Isabella","Alfie","George","Oscar"};
    private String [] sexGerant = {"Féminin","Féminin","Masculin","Féminin","Masculin","Féminin","Féminin","Masculin","Masculin","Masculin"};
    private String[] nomCategories ={"Salon de beauté","Construction & BTP","Salon de beauté","Patisserie","Commerce Général"};
<<<<<<< HEAD
    private String[][] lesProfession ={{"Salon de coiffure","Décoration intérieur","Commerce de pagne"},{"Construction","Menuserie","Charpenterie"},{"Couture","Stylisme","recyclage"},{"Boulangerie","Vente de pain","Vente de gateau"},{"Super Marché","vente de divers","vente de cosmétique"},{"Salon de coiffure","Décoration intérieur","Commerce de pagne"},{"Construction","Menuserie","Charpenterie"},{"Couture","Stylisme","recyclage"},{"Boulangerie","Vente de pain","Vente de gateau"},{"Super Marché","vente de divers","vente de cosmétique"}};
    //private String[][] lesDescriptions ={{"Salon de coiffure,Décoration intérieur et Commerce de pagne"},{"Construction,Menuserie et Charpenterie"},{"Couture,Stylisme et recyclage"},{"Boulangerie,Vente de pain et fabrique de gateau"},{"Super Marché,vente de divers et vente de cosmétique"},{"Salon de coiffure,Décoration intérieur et Commerce de pagne"},{"Construction,Menuserie et Charpenterie"},{"Couture,Stylisme et recyclage"},{"Boulangerie,Vente de pain et fabrique de gateau"},{"Super Marché,vente de divers et vente de cosmétique"}};
=======
    private String[] lesDescription ={"Salon de coiffure,Décoration intérieur et Commerce de pagne","Construction,Menuserie et Charpenterie","Couture,Stylisme et recyclage","Boulangerie,Vente de pain et fabrique de gateau","Super Marché,vente de divers et vente de cosmétique","Salon de coiffure,Décoration intérieur et Commerce de pagne","Construction,Menuserie et Charpenterie","Couture,Stylisme et recyclage","Boulangerie,Vente de pain et fabrique de gateau","Super Marché,vente de divers et vente de cosmétique"};
<<<<<<< HEAD
>>>>>>> beta
=======

>>>>>>> beta
    public List<Gerant> getGerant(){
        lstGeran = new ArrayList<>();
        for (int i =0;i<imgGerant.length;i++){
            gerant =new Gerant(imgGerant[i],ids[i], nomGerant[i],prenomGerant[i],sexGerant[i],"95 55 66 87");
            gerant.ajouter("97 54 43 32");
            lstGeran.add(gerant);
        }
        return lstGeran;
    }

    public List<Atelier> getEntreprise(){
        lstAtelier = new ArrayList<>();

        getGerant();

        for (int i = 0; i< imgAtelier.length; i++){
            List<Categorie> lstProfess = new ArrayList<>();

            // descritpion
            lstProfess.add(new Categorie(lesDescription[i]));

            atelier = new Atelier(imgAtelier[i],ids[i], nomAtelier[i],lesDescription[i], ratings[i],lstGeran.get(i));

            for (int j=0;j<tabPicture[i].length;j++){
                atelier.addPicture(tabPicture[i][j]);
            }

            lstAtelier.add(atelier);
        }
        return lstAtelier;
    }

    public List<Categorie> getCategories(){
        lstCategorie = new ArrayList<>();
        for (int i = 0; i< nomCategories.length; i++){
            lstCategorie.add(new Categorie(i,nomCategories[i],nomCategories[i]));
        }
        return lstCategorie;
    }

    public List<Atelier> addAteliersMatching(Categorie categorie){
        for (Atelier atelier:lstAtelier) {
            if (atelier.getCategorie().equals(categorie)) lstAtelierMatching.add(atelier);
        }
        return lstAtelierMatching;
    }

    public List<Atelier> removeAteliersMatching(Categorie categorie){
        for (Atelier atelier:lstAtelier) {
            if (atelier.getCategorie().equals(categorie)) lstAtelierMatching.remove(atelier);
        }
        if (lstAtelierMatching.size()==0) return lstAtelier;
        return lstAtelierMatching;
    }

    private void setCategories(){
        int index =0;
        for (int i=0;i<imgAtelier.length/nomCategories.length;i++){
            for (int j=0;j<nomCategories.length;j++){
                lstAtelier.get(index).setCategorie(lstCategorie.get(j));
                index++;
            }
        }
    }

    private void setPicturesUp(){
        for (int i = 0; i< tabPicture.length; i++){
            atelier = lstAtelier.get(i);
            for (int j=0;j<tabPicture[i].length;j++){
                atelier.addPicture(tabPicture[i][j]);
            }
        }
    }

    public List<Atelier> getLstAtelier() {
        return lstAtelier;
    }

    public List<Categorie> getLstCategorie() {
        return lstCategorie;
    }

    public List<Gerant> getLstGeran() {
        return lstGeran;
    }

}
