package com.amstrong.stephane.artisanplus.activity;

import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.amstrong.stephane.artisanplus.R;
import com.amstrong.stephane.artisanplus.adapter.AdapterPicture;
import com.amstrong.stephane.artisanplus.data.ResultSet;
import com.amstrong.stephane.artisanplus.model.Entrepreneur;
import com.amstrong.stephane.artisanplus.model.Entreprise;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class EntrepriseActivity extends AppCompatActivity {

    private MapFragment mMapFragment ;
    private Intent intent,mapIntent;
    private Entreprise entreprise;
    private Entrepreneur entrepreneur;
    private List<Integer> lstPicture;
    private ImageView btnTel1,btnTel2,btnSMS1,btnSMS2;
    private TextView txtPicture;
    private CardView gerantRow;

    private String entrepriseKey = MainActivity.keyEntreprise;
    private RatingBar atlierRating;
    private ImageView imgAtelier,imgGerant;
    private TextView txtNomEntr,txtNomPrenom,txtTel1,txtTel2, txtDescriptEntr;
    private AdapterPicture adapterPicture;
    private RecyclerView recyclerPicture;
    private static final String TAG = "EntrepriseActivity";

    public static final String keyProfilRead ="profilread_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entreprise);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initialisation();

        loadEntreprise(entreprise, entrepreneur);

        // Map setting
        mMapFragment = MapFragment.newInstance();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.map_entreprise, mMapFragment);
        fragmentTransaction.commit();

        btnTel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", txtTel1.getText()+"", null));
                startActivity(intent);
            }
        });

        btnTel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", txtTel2.getText()+"", null));
                startActivity(intent);
            }
        });

        btnSMS1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = txtTel1.getText()+"";  // The number on which you want to send SMS
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", number, null)));
            }
        });

        btnSMS2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = txtTel2.getText()+"";  // The number on which you want to send SMS
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", number, null)));
            }
        });

        imgGerant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadPhoto(imgGerant,200,100);
            }
        });

        imgAtelier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadPhoto(imgAtelier,200,100);
            }
        });

        //entrepreneur
        gerantRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(EntrepriseActivity.this,ProfilReadActivity.class);
                intent.putExtra(keyProfilRead, entrepreneur);
                startActivity(intent);
            }
        });

        mMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {

                googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(LatLng latLng) {

                        startActivity(mapIntent);
                    }
                });
            }
        });
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


    private void initialisation(){
        intent = getIntent();
        mapIntent = new  Intent(this,MapsActivity.class);

        entreprise =intent.getParcelableExtra(entrepriseKey);
        lstPicture= entreprise.getLstPictures();
        entrepreneur = entreprise.getEntrepreneur();
        //
        imgAtelier =findViewById(R.id.atlier_img);
        imgGerant=findViewById(R.id.ger_img);
        atlierRating=findViewById(R.id.atlier_rating);
        txtNomEntr = findViewById(R.id.atlier_nom);
        txtDescriptEntr = findViewById(R.id.description_entreprise);
        txtPicture = findViewById(R.id.text_pictures);
        txtNomPrenom= findViewById(R.id.txt_ger_nom_prenoms);
        txtTel1= findViewById(R.id.txt_ger_tel1);
        txtTel2 = findViewById(R.id.txt_ger_tel2);
        recyclerPicture = findViewById(R.id.pictures_recycler);

        btnTel1 =findViewById(R.id.btn_ger_tel1);
        btnTel2 =findViewById(R.id.btn_ger_tel2);
        btnSMS1 =findViewById(R.id.btn_ger_sms1);
        btnSMS2 =findViewById(R.id.btn_ger_sms2);

        gerantRow = findViewById(R.id.block_gerant);
    }

    private void loadEntreprise(Entreprise entreprise, Entrepreneur entrepreneur){
        imgAtelier.setImageResource(entreprise.getImage());
        atlierRating.setRating(entreprise.getEtoile());
        imgGerant.setImageResource(entreprise.getEntrepreneur().getPhoto());
        /*

         Picasso.get()
                .load(entreprise.getEntrepreneur().getPhoto())
                .resize(600,200)
                .centerInside()
                .into(imgGerant);

        */
        txtNomEntr .setText(entreprise.getNom());
        txtDescriptEntr .setText(entreprise.getDescription());
        if(lstPicture.size()<1) {
            txtPicture .setText("Image ("+lstPicture.size()+")");
        } else {
            txtPicture .setText("Images ("+lstPicture.size()+")");
        }
        txtNomPrenom.setText(entrepreneur.getNom()+" "+ entrepreneur.getPrenom());
        txtTel1.setText(entrepreneur.getLstContact().get(0));
        if (entrepreneur.getLstContact().get(1).trim().isEmpty()){
            txtTel2.setVisibility(View.GONE);
        }
        txtTel2 .setText(entrepreneur.getLstContact().get(1));
        // chercher les entreprises apppartenant à ce entrepreneur
            entrepreneur.fetchEntreprise(new ResultSet().getLstEntreprise());
        //
        adapterPicture = new AdapterPicture(this, lstPicture);
        recyclerPicture.setAdapter(adapterPicture);
        recyclerPicture.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    private void loadPhoto(ImageView imageView, int width, int height) {

        ImageView tempImageView = imageView;


        AlertDialog.Builder imageDialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);

        View layout = inflater.inflate(R.layout.dialog_fullimage, (ViewGroup) findViewById(R.id.layout_root));
        ImageView image = (ImageView) layout.findViewById(R.id.fullimage);
        image.setImageDrawable(tempImageView.getDrawable());
        imageDialog.setView(layout);

        imageDialog.create();
        imageDialog.show();
    }


}
