package com.amstrong.stephane.artisanplus.activity;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amstrong.stephane.artisanplus.R;
import com.amstrong.stephane.artisanplus.adapter.TelephoneAdapter;
import com.amstrong.stephane.artisanplus.model.Gerant;
import com.amstrong.stephane.artisanplus.model.Utilisateur;

import java.util.ArrayList;
import java.util.List;

public class ProfilActivity extends AppCompatActivity {
    private Intent intent;
    private Gerant gerant;
    private Utilisateur utilisateur;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private String atelierKey = AtelierActivity.keyProfil;
    private String userKey = MainActivity.keyUtilisater;
    private ImageView imgProfil;
    private TextView txtSex;
    private RecyclerView contactRecyclerView;
    private TelephoneAdapter telephoneAdapter;
    private List<String> lstTelephone;

    private static final String TAG = "ProfilActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        init();
        load();
    }

    private void init(){
        lstTelephone = new ArrayList<>();
        //
        intent = getIntent();

        collapsingToolbarLayout = findViewById(R.id.collapsingToolBar);
        imgProfil = findViewById(R.id.profil_img);
        txtSex = findViewById(R.id.profil_sex);
        contactRecyclerView = findViewById(R.id.profil_contactRecyclerView);
    }

    private void load(){

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

    private void load(Gerant gerant){
        imgProfil.setImageResource(gerant.getPicture());
        collapsingToolbarLayout.setTitle(gerant.getNom()+" "+gerant.getPrenom());
        txtSex.setText(gerant.getSex());

        telephoneAdapter = new TelephoneAdapter(this,gerant.getLstContact());
        contactRecyclerView.setAdapter(telephoneAdapter);
        contactRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void load(Utilisateur utilisateur){
        imgProfil.setImageResource(utilisateur.getPicture());
        collapsingToolbarLayout.setTitle(utilisateur.getNom()+" "+ utilisateur.getPrenom());
        txtSex.setText(utilisateur.getSex());

        telephoneAdapter = new TelephoneAdapter(this,utilisateur.getLstContact());
        contactRecyclerView.setAdapter(telephoneAdapter);
        contactRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }



}
