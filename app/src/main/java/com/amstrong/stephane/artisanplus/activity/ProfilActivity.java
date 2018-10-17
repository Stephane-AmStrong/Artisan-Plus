package com.amstrong.stephane.artisanplus.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
    private String atelierKey = AtelierActivity.keyProfil;
    private String userKey = MainActivity.keyUtilisater;
    private ImageView imgProfil;
    private TextView txtSex;
    private RecyclerView contactRecyclerView;
    private TelephoneAdapter telephoneAdapter;
    private List<String> lstTelephone;
    private Menu menu;
    private AppBarLayout mAppBarLayout;
    private Toolbar toolbar;

    private static final String TAG = "ProfilActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(ProfilActivity.this,EditProfilActivity.class);
                startActivity(intent);
            }
        });

        mAppBarLayout = findViewById(R.id.app_bar);
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    isShow = true;
                    showOption(R.id.action_edit);
                } else if (isShow) {
                    isShow = false;
                    hideOption(R.id.action_edit);
                }
            }
        });

        init();
        load();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.menu_profil,menu);
        hideOption(R.id.action_edit);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_edit) {
            intent = new Intent(ProfilActivity.this,EditProfilActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    private void hideOption(int id) {
        MenuItem item = menu.findItem(id);
        item.setVisible(false);
    }

    private void showOption(int id) {
        MenuItem item = menu.findItem(id);
        item.setVisible(true);
    }

    private void init(){
        lstTelephone = new ArrayList<>();
        //
        intent = getIntent();

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

        setTitle(gerant.getNom()+" "+gerant.getPrenom());
        txtSex.setText(gerant.getSex());

        telephoneAdapter = new TelephoneAdapter(this,gerant.getLstContact());
        contactRecyclerView.setAdapter(telephoneAdapter);
        contactRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void load(Utilisateur utilisateur){
        imgProfil.setImageResource(utilisateur.getPicture());
        setTitle(utilisateur.getNom()+" "+ utilisateur.getPrenom());
        txtSex.setText(utilisateur.getSex());

        telephoneAdapter = new TelephoneAdapter(this,utilisateur.getLstContact());
        contactRecyclerView.setAdapter(telephoneAdapter);
        contactRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
