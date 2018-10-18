package com.amstrong.stephane.artisanplus.activity;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.amstrong.stephane.artisanplus.R;
import com.amstrong.stephane.artisanplus.adapter.TelReadAdapter;
import com.amstrong.stephane.artisanplus.model.Gerant;
import com.amstrong.stephane.artisanplus.model.Utilisateur;

public class ProfiEditlActivity extends AppCompatActivity {
    private Intent intent;
    private Gerant gerant;
    private Utilisateur utilisateur;
    private ImageView imgProfil;
    private EditText txtNom,txtPren;
    private Spinner txtSex;
    private RecyclerView contactRecyclerView;
    private TelReadAdapter telReadAdapter;
    private AppBarLayout mAppBarLayout;
    private Toolbar toolbar;

    private static final String TAG = "ProfiEditlActivity";
    private String userEditKey = ProfilReadActivity.keyUserEdit;
    private String artisanEditKey = ProfilReadActivity.keyArtisanEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profil);

        init();
        load();
    }

    private void init(){
        intent = getIntent();

        imgProfil = findViewById(R.id.edit_photo);
        txtNom = findViewById(R.id.edit_nom);
        txtPren = findViewById(R.id.edit_pren);
        txtSex = findViewById(R.id.edit_sex);
        contactRecyclerView = findViewById(R.id.profil_contactRecyclerView);
    }

    private void load(){

        try {
            if (intent.getExtras().keySet().contains(artisanEditKey)){
                gerant = intent.getParcelableExtra(artisanEditKey);
                load(gerant); return;
            }

            if (intent.getExtras().keySet().contains(userEditKey)){
                utilisateur = intent.getParcelableExtra(userEditKey);
                load(utilisateur);return;
            }
        } catch (Exception e){
            Log.e(TAG, "load: erreur",e );
        }
    }

    private void load(Gerant gerant){
        imgProfil.setImageResource(gerant.getPicture());

        setTitle(gerant.getNom()+" "+gerant.getPrenom());
        txtSex.setText(gerant.getSex());

        telReadAdapter = new TelReadAdapter(this,gerant.getLstContact());
        contactRecyclerView.setAdapter(telReadAdapter);
        contactRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void load(Utilisateur utilisateur){
        imgProfil.setImageResource(utilisateur.getPicture());
        setTitle(utilisateur.getNom()+" "+ utilisateur.getPrenom());
        txtSex.setText(utilisateur.getSex());

        telReadAdapter = new TelReadAdapter(this,utilisateur.getLstContact());
        contactRecyclerView.setAdapter(telReadAdapter);
        contactRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
