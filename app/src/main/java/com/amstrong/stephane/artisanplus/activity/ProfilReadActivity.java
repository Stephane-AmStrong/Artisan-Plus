package com.amstrong.stephane.artisanplus.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
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
import com.amstrong.stephane.artisanplus.adapter.TelReadAdapter;
import com.amstrong.stephane.artisanplus.model.Entrepreneur;
import com.amstrong.stephane.artisanplus.model.Utilisateur;

public class ProfilReadActivity extends AppCompatActivity {
    private Intent intent;
    private Entrepreneur entrepreneur;
    private Utilisateur utilisateur;
    private String atelierKey = EntrepriseActivity.keyProfilRead;
    private String userKey = MainActivity.keyUtilisater;
    private ImageView imgProfil;
    private TextView txtSex;
    private RecyclerView contactRecyclerView;
    private TelReadAdapter telReadAdapter;
    private Menu menu;
    private AppBarLayout mAppBarLayout;
    private Toolbar toolbar;

    public static final String keyUserEdit ="edituser_key";
    public static final String keyArtisanEdit ="editgeran_key";

    private static final String TAG = "ProfilReadActivity";

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
                intent = new Intent(ProfilReadActivity.this,ProfilEditlActivity.class);
                intent.putExtra(keyUserEdit,utilisateur);
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
            intent = new Intent(ProfilReadActivity.this,ProfilEditlActivity.class);
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
        intent = getIntent();

        imgProfil = findViewById(R.id.profil_img);
        txtSex = findViewById(R.id.profil_sex);
        contactRecyclerView = findViewById(R.id.profil_contactRecyclerView);
    }

    private void load(){

        try {
            if (intent.getExtras().keySet().contains(atelierKey)){
                entrepreneur = intent.getParcelableExtra(atelierKey);
                load(entrepreneur); return;
            }

            if (intent.getExtras().keySet().contains(userKey)){
                utilisateur = intent.getParcelableExtra(userKey);
                load(utilisateur);return;
            }
        } catch (Exception e){
            Log.e(TAG, "load: erreur",e );
        }
    }

    private void load(Entrepreneur entrepreneur){
        imgProfil.setImageResource(entrepreneur.getPhoto());

        setTitle(entrepreneur.getNom()+" "+ entrepreneur.getPrenom());
        txtSex.setText(entrepreneur.getSex());

        telReadAdapter = new TelReadAdapter(this, entrepreneur.getLstContact());
        contactRecyclerView.setAdapter(telReadAdapter);
        contactRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void load(Utilisateur utilisateur){
        imgProfil.setImageResource(utilisateur.getPhoto());
        setTitle(utilisateur.getNom()+" "+ utilisateur.getPrenom());
        txtSex.setText(utilisateur.getSex());

        telReadAdapter = new TelReadAdapter(this,utilisateur.getLstContact());
        contactRecyclerView.setAdapter(telReadAdapter);
        contactRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
