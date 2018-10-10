package com.amstrong.stephane.artisanplus.activity;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.amstrong.stephane.artisanplus.R;

public class ProfilActivity extends AppCompatActivity {
    CollapsingToolbarLayout collapsingToolbarLayout;
    ImageView photo;
    TextView txtTel1,txtTel2,sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        init();
    }

    private void init(){
        collapsingToolbarLayout = findViewById(R.id.collapsingToolBar);
        photo = findViewById(R.id.profil_img);
        txtTel1 = findViewById(R.id.profil_tel1);
        txtTel2 = findViewById(R.id.profil_tel2);
        sex = findViewById(R.id.profil_sex);

    }

    private void load(int photo,String nom,String tel1,String tel2,String sex){
        collapsingToolbarLayout.setTitle(nom);
    }
}
