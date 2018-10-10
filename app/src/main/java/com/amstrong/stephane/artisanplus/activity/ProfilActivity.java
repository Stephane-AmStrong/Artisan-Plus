package com.amstrong.stephane.artisanplus.activity;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.amstrong.stephane.artisanplus.R;
import com.amstrong.stephane.artisanplus.model.Atelier;
import com.amstrong.stephane.artisanplus.model.Gerant;

public class ProfilActivity extends AppCompatActivity {
    private Intent intent;
    private Gerant gerant;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private String atelierKey = AtelierActivity.keyProfil;
    private ImageView imgProfil;
    private TextView txtTel1,txtTel2,txtSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        init();
        load(gerant);
    }

    private void init(){
        intent = getIntent();
        gerant = intent.getParcelableExtra(atelierKey);

        collapsingToolbarLayout = findViewById(R.id.collapsingToolBar);
        imgProfil = findViewById(R.id.profil_img);
        txtTel1 = findViewById(R.id.profil_tel1);
        txtTel2 = findViewById(R.id.profil_tel2);
        txtSex = findViewById(R.id.profil_sex);

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
}
