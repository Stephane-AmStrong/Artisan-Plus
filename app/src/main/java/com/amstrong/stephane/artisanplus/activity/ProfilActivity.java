package com.amstrong.stephane.artisanplus.activity;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amstrong.stephane.artisanplus.R;
import com.amstrong.stephane.artisanplus.model.Gerant;
import com.amstrong.stephane.artisanplus.model.Utilisateur;

public class ProfilActivity extends AppCompatActivity {
    private Intent intent;
    private Gerant gerant;
    private Utilisateur utilisateur;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private String atelierKey = AtelierActivity.keyProfil;
    private String userKey = MainActivity.keyUtilisater;
    private ImageView imgProfil;
    private TextView txtTel1,txtTel2,txtSex;

    private static final String TAG = "ProfilActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        init();
        load();
    }

    private void init(){
        intent = getIntent();

        collapsingToolbarLayout = findViewById(R.id.collapsingToolBar);
        imgProfil = findViewById(R.id.profil_img);
        txtTel1 = findViewById(R.id.profil_tel1);
        txtTel2 = findViewById(R.id.profil_tel2);
        txtSex = findViewById(R.id.profil_sex);

    }

    private void load(){
        //String key = intent.getExtras().keySet();

        try {
            if (intent.getExtras().keySet().contains(atelierKey)){
                gerant = intent.getParcelableExtra(atelierKey);
                load(gerant); return;
            }

            if (intent.getExtras().keySet().contains(userKey)){
                utilisateur = intent.getParcelableExtra(userKey);
                load(utilisateur);return;
            }
        } catch (Exception e){
            Log.e(TAG, "load: erreur",e );
        }
    }


    private void load(int photo,String nom,String tel1,String tel2,String sex){
        imgProfil.setImageResource(photo);
        collapsingToolbarLayout.setTitle(nom);
        txtTel1.setText(tel1);
        txtTel2.setText(tel2);
        txtSex.setText(sex);
    }

    private void load(Gerant gerant){
        imgProfil.setImageResource(gerant.getPicture());
        collapsingToolbarLayout.setTitle(gerant.getNom()+" "+gerant.getPrenom());
        txtTel1.setText(gerant.getTel1());
        txtTel2.setText(gerant.getTel2());
        txtSex.setText(gerant.getSex());
    }

    private void load(Utilisateur utilisateur){
        imgProfil.setImageResource(utilisateur.getPicture());
        collapsingToolbarLayout.setTitle(utilisateur.getNom()+" "+ utilisateur.getPrenom());
        txtTel1.setText(utilisateur.getTel());
        txtTel2.setVisibility(View.GONE);
        txtSex.setText(utilisateur.getSex());
    }



}
