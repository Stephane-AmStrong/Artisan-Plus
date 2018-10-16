package com.amstrong.stephane.artisanplus.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.amstrong.stephane.artisanplus.R;
import com.amstrong.stephane.artisanplus.adapter.AtelierAdapter;
import com.amstrong.stephane.artisanplus.adapter.ButtonAdapter;
import com.amstrong.stephane.artisanplus.data.ResultSet;
import com.amstrong.stephane.artisanplus.model.Atelier;
import com.amstrong.stephane.artisanplus.model.Categorie;
import com.amstrong.stephane.artisanplus.model.Utilisateur;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static int colorPrimary,colorPrimaryDark,colorAccent;
    private AtelierAdapter atelierAdapter;
    private ButtonAdapter buttonAdapter;
    private RecyclerView artisanRecyclerView;
    private RecyclerView categorieRecyclerView;
    private List<Categorie> lstCategorie;
    private List<Atelier> lstAtelier;
    private Intent intent;

    private ResultSet resultSet;
    private static final String TAG = "MainActivity";
    private static final int ERROR_DIALOG_REQUEST=9001;
    public static final String keyEntreprise ="entreprise_key";
    public static final String keyRechercher="rechercher_key";
    public static final String keyUtilisater="utilisateur_key";
    private Atelier atelier;
    private Categorie categorie;
    private Utilisateur utilisateur;
    private Dialog myDialog;
    private LinearLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initialisation();
        load();
        //

        //connection
        connected();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
        }

        if (id == R.id.action_search) {
            intent = new Intent(this,RechercherActivity.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profil) {
            // profil
            intent = new Intent(this,ProfilActivity.class);
            intent.putExtra(keyUtilisater,utilisateur);
            startActivity(intent);

        } else if (id == R.id.nav_favoris) {

        } else if (id == R.id.nav_recent) {

        } else if (id == R.id.nav_business) {
            //business
            //showCustomDialog();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void initialisation(){
        //init data
        resultSet = new ResultSet();

        lstAtelier = resultSet.getLstAtelier();
        lstCategorie = resultSet.getLstCategorie();

        // RecyclerViewer
        categorieRecyclerView = findViewById(R.id.lst_profession);
        artisanRecyclerView = findViewById(R.id.lst_atelier);

        // custom dialog initialisation

    }

    private void connected(){
        utilisateur = new Utilisateur(R.drawable.profil_12,1,"KODJO","Paulin","Masculin","98 76 54 45");
    }

    private void load(){

        //
        atelierAdapter = new AtelierAdapter(this, lstAtelier);
        buttonAdapter = new ButtonAdapter(this, lstCategorie);

        artisanRecyclerView.setAdapter(atelierAdapter);
        categorieRecyclerView.setAdapter(buttonAdapter);

        artisanRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        categorieRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }


    public void callEntrepriseActivity(int position ){
        atelier = lstAtelier.get(position);
        intent = new Intent(this,AtelierActivity.class);
        intent.putExtra(keyEntreprise, atelier);
        intent.putExtra(keyEntreprise, atelier);
        startActivity(intent);
    }

    public void addAteliers(int categoriePosition){
        categorie = lstCategorie.get(categoriePosition);
        load(resultSet.addAteliersMatching(categorie));
    }

    public void removeAteliers(int categoriePosition){
        categorie = lstCategorie.get(categoriePosition);
        load(resultSet.removeAteliersMatching(categorie));
    }

    private void load(List<Atelier> ateliers){
        atelierAdapter = new AtelierAdapter(this, ateliers);
        artisanRecyclerView.setAdapter(atelierAdapter);
    }

    public void showCustomDialog( View view){
        TextView txtMessage,btnClose;
        Button btnSubmit,btnCancel;
        myDialog.setContentView(R.layout.dialog_message);
        txtMessage = findViewById(R.id.diag_message);
        btnClose = findViewById(R.id.diag_btnCancel);
        btnSubmit = findViewById(R.id.diag_btnOk);
        btnCancel = findViewById(R.id.diag_btnCancel);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });

        txtMessage.setText("vous n'avez pas encore de boutique voulez vous souscrire?");
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }


}
