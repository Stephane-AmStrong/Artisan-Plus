package com.amstrong.stephane.artisanplus.activity;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.amstrong.stephane.artisanplus.R;
import com.amstrong.stephane.artisanplus.adapter.TelEditAdapter;
import com.amstrong.stephane.artisanplus.model.Entrepreneur;
import com.amstrong.stephane.artisanplus.model.Utilisateur;

public class ProfilEditlActivity extends AppCompatActivity {
    private Intent intent;
    private Entrepreneur entrepreneur;
    private Utilisateur utilisateur;
    private ImageView imgProfil;
    private Button btnImg,btnAddContact,btnAddAtelier;
    private EditText txtNom,txtPren;
    private Spinner txtSex;
    private RecyclerView contactRecyclerView,atelierRecyclerView;
    private TelEditAdapter  telEditAdapter;
    private AppBarLayout mAppBarLayout;
    private Toolbar toolbar;
    private CardView blockAtelier;

    private static final String TAG = "ProfilEditlActivity";
    private String userEditKey = ProfilReadActivity.keyUserEdit;
    private String artisanEditKey = ProfilReadActivity.keyEntrepreneurEdit;

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
        btnImg = findViewById(R.id.edit_btn_updatePicture);
        btnAddContact = findViewById(R.id.edit_btnTelphone);
        btnAddAtelier = findViewById(R.id.edit_btnAtelier);
        contactRecyclerView = findViewById(R.id.edit_recyclerTel);
        blockAtelier = findViewById(R.id.block_atelier);
    }

    private void load(){
        try {
            if (intent.getExtras().keySet().contains(userEditKey)){
                utilisateur = intent.getParcelableExtra(userEditKey);
                load(utilisateur);return;
            }

            if (intent.getExtras().keySet().contains(artisanEditKey)){
                entrepreneur = intent.getParcelableExtra(artisanEditKey);
                load(entrepreneur); return;
            }
        } catch (Exception e){
            Log.e(TAG, "load: erreur",e );
        }
    }

    private void load(Utilisateur utilisateur){
        imgProfil.setImageResource(utilisateur.getPhoto());
        txtNom.setText(utilisateur.getNom());
        txtPren.setText(utilisateur.getPrenom());
        setSpinText(txtSex,utilisateur.getSex());

        telEditAdapter = new TelEditAdapter(this,utilisateur.getLstContact());
        contactRecyclerView.setAdapter(telEditAdapter);
        contactRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        blockAtelier.setVisibility(View.GONE);
    }

    private void load(Entrepreneur entrepreneur){
        imgProfil.setImageResource(entrepreneur.getPhoto());
        txtNom.setText(entrepreneur.getNom());
        txtPren.setText(entrepreneur.getPrenom());
        setSpinText(txtSex,utilisateur.getSex());

        telEditAdapter = new TelEditAdapter(this, entrepreneur.getLstContact());
        contactRecyclerView.setAdapter(telEditAdapter);
        contactRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    public void setSpinText(Spinner spin, String text)
    {
        for(int i= 0; i < spin.getAdapter().getCount(); i++)
        {
            if(spin.getAdapter().getItem(i).toString().contains(text))
            {
                spin.setSelection(i);
            }
        }

    }

}
