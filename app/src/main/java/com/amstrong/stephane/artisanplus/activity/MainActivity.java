package com.amstrong.stephane.artisanplus.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.amstrong.stephane.artisanplus.R;
import com.amstrong.stephane.artisanplus.adapter.AtelierAdapter;
import com.amstrong.stephane.artisanplus.adapter.ButtonAdapter;
import com.amstrong.stephane.artisanplus.data.ResultSet;
import com.amstrong.stephane.artisanplus.model.Atelier;
import com.amstrong.stephane.artisanplus.model.Categorie;

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
    private Intent intentEntreprise;
    private Intent intentRechercher;

    private ResultSet resultSet;

    public static final String keyEntreprise ="entreprise_key";
    public static final String keyRechercher="rechercher_key";
    private Atelier atelier;
    private Categorie categorie;

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
        fetchColor(this);
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
            startActivity(intentRechercher);
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profil) {
            // Handle the camera action
        } else if (id == R.id.nav_profil) {

        } else if (id == R.id.nav_favoris) {

        } else if (id == R.id.nav_recent) {

        } else if (id == R.id.nav_business) {

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

        intentEntreprise = new Intent(this,AtelierActivity.class);
        intentRechercher = new Intent(this,RechercherActivity.class);
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

    private void fetchColor(final Context context) {
        TypedValue typedValue = new TypedValue();

        TypedArray a = context.obtainStyledAttributes(typedValue.data, new int[] { R.attr.colorPrimary,R.attr.colorPrimaryDark,R.attr.colorAccent });
        colorPrimary = a.getColor(0, 0);
        colorPrimaryDark = a.getColor(1, 0);
        colorAccent = a.getColor(2, 0);

        a.recycle();

        //return color;

    }

    public void callEntrepriseActivity(int position ){
        atelier = lstAtelier.get(position);
        intentEntreprise.putExtra(keyEntreprise, atelier);
        intentRechercher.putExtra(keyEntreprise, atelier);
        startActivity(intentEntreprise);
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

}
