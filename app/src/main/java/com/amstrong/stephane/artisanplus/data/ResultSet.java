package com.amstrong.stephane.artisanplus.data;



import com.amstrong.stephane.artisanplus.R;
import com.amstrong.stephane.artisanplus.model.Entrepreneur;
import com.amstrong.stephane.artisanplus.model.Entreprise;
import com.amstrong.stephane.artisanplus.model.Categorie;
import com.amstrong.stephane.artisanplus.model.Utilisateur;

import java.util.ArrayList;
import java.util.List;

public class ResultSet {

    private List<Entreprise> lstEntreprise;
    private Entreprise entreprise;
    private Entrepreneur entrepreneur;
    private List<Categorie> lstCategorie;
    private List<Utilisateur>lstUser;
    private List<Entrepreneur>lstEntrepreneur;
    private List<Entreprise> lstEntrepriseMatching;

    public ResultSet() {
        lstEntreprise = new ArrayList<>();
        lstCategorie = new ArrayList<>();
        lstUser = new ArrayList<>();
        lstEntrepreneur = new ArrayList<>();
        lstEntrepriseMatching =new ArrayList<>();
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
    private String[] ids = {"E0001","E0002","E0003","E0004","E0005","E0006","E0007","E0008","E0009","E00010"};
    private String[] nomAtelier ={"BIO & Fils","TALO Mahouton","KOSSOU Alurgie","ALIGBO","MIDJO","DASILVA","DE SOUZA","SAGBO","ALISONTO","ADOUKONON"};
    private String[] nomCategories ={"Salon de beauté","Construction & BTP","Salon de beauté","Patisserie","Commerce Général"};
    private String[] lesDescription ={"Salon de coiffure,Décoration intérieur et Commerce de pagne","Construction,Menuserie et Charpenterie","Couture,Stylisme et recyclage","Boulangerie,Vente de pain et fabrique de gateau","Super Marché,vente de divers et vente de cosmétique","Salon de coiffure,Décoration intérieur et Commerce de pagne","Construction,Menuserie et Charpenterie","Couture,Stylisme et recyclage","Boulangerie,Vente de pain et fabrique de gateau","Super Marché,vente de divers et vente de cosmétique"};

    private String[] nomUser ={"BIO","TALO","Alurgie","ALIGBO","MIDJO","DASILVA","DE SOUZA","SAGBO","ALISONTO","ADOUKONON"};
    private String[] prenUser ={"Olivia","Sophia","Jack","Emily","Noah","Mia","Isabella","Alfie","George","Oscar"};
    private String [] sexUser = {"Féminin","Féminin","Masculin","Féminin","Masculin","Féminin","Féminin","Masculin","Masculin","Masculin"};
    private String [] tel1User = {"97 45 56 75","99 34 65 25","92 45 56 78","96 34 64 87","90 21 35 76","67 34 65 76","94 32 46 86","91 45 76 32","95 35 75 90","62 85 96 35"};
    private String [] tel2User = {"61 45 56 75","90 34 65 25","92 45 56 78","96 34 53 87","91 21 35 76","69 34 65 76","74 32 46 86","91 45 76 32","95 35 75 90","62 85 96 35"};    private String [] pwdGerant = {"papa","maman","fils","filston","toto","isnogood","ismytree","colosuc","nicoledon","nipo"};

    public List<Entrepreneur> getEntrepreneur(){
        for (int i =0;i<imgGerant.length;i++){
            entrepreneur =new Entrepreneur(imgGerant[i],ids[i], nomUser[i], prenUser[i], sexUser[i], tel1User[i],pwdGerant[i]);
            entrepreneur.addTel(tel2User[i]);
            lstEntrepreneur.add(entrepreneur);
        }
        lstUser.addAll(lstEntrepreneur);
        lstUser.add(new Utilisateur(R.drawable.profil_12,"U00011","KODJO","Paulin","Masculin","98 76 54 45"));
        return lstEntrepreneur;
    }

    public List<Entreprise> getEntreprise(){
        lstEntreprise = new ArrayList<>();

        getEntrepreneur();

        for (int i = 0; i< imgAtelier.length; i++){
            List<Categorie> lstProfess = new ArrayList<>();

            // descritpion
            lstProfess.add(new Categorie(lesDescription[i]));

            entreprise = new Entreprise(imgAtelier[i],i, nomAtelier[i],lesDescription[i], ratings[i],lstEntrepreneur.get(i));

            for (int j=0;j<tabPicture[i].length;j++){
                entreprise.addPicture(tabPicture[i][j]);
            }

            lstEntreprise.add(entreprise);
        }
        return lstEntreprise;
    }

    public List<Categorie> getCategories(){
        lstCategorie = new ArrayList<>();
        for (int i = 0; i< nomCategories.length; i++){
            lstCategorie.add(new Categorie(i,nomCategories[i],nomCategories[i]));
        }
        return lstCategorie;
    }

    public List<Entreprise> addAteliersMatching(Categorie categorie){
        for (Entreprise entreprise : lstEntreprise) {
            if (entreprise.getCategorie().equals(categorie)) lstEntrepriseMatching.add(entreprise);
        }
        return lstEntrepriseMatching;
    }

    public List<Entreprise> removeAteliersMatching(Categorie categorie){
        for (Entreprise entreprise : lstEntreprise) {
            if (entreprise.getCategorie().equals(categorie)) lstEntrepriseMatching.remove(entreprise);
        }
        if (lstEntrepriseMatching.size()==0) return lstEntreprise;
        return lstEntrepriseMatching;
    }

    private void setCategories(){
        int index =0;
        for (int i=0;i<imgAtelier.length/nomCategories.length;i++){
            for (int j=0;j<nomCategories.length;j++){
                lstEntreprise.get(index).setCategorie(lstCategorie.get(j));
                index++;
            }
        }
    }

    private void setPicturesUp(){
        for (int i = 0; i< tabPicture.length; i++){
            entreprise = lstEntreprise.get(i);
            for (int j=0;j<tabPicture[i].length;j++){
                entreprise.addPicture(tabPicture[i][j]);
            }
        }
    }

    public List<Entreprise> getLstEntreprise() {
        return lstEntreprise;
    }

    public List<Categorie> getLstCategorie() {
        return lstCategorie;
    }


}
