package com.amstrong.stephane.artisanplus.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import android.widget.Toast;

import com.amstrong.stephane.artisanplus.R;
import com.amstrong.stephane.artisanplus.adapter.PictureAdapter;
import com.amstrong.stephane.artisanplus.model.Atelier;
import com.amstrong.stephane.artisanplus.model.Gerant;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.MapFragment;

import java.util.List;

public class AtelierActivity extends AppCompatActivity {

    private MapFragment mMapFragment ;
    private Intent intent;
    private Atelier atelier;
    private Gerant gerant;
    private List<Integer> lstPicture;
    private ImageView btnTel1,btnTel2,btnSMS1,btnSMS2;
    private TextView txtPicture;

    private String entrepriseKey = MainActivity.keyEntreprise;
    private RatingBar atlierRating;
    private ImageView imgAtelier,imgGerant;
    private TextView txtNomEntr,txtNomPrenom,txtTel1,txtTel2, txtDescriptEntr;
    private PictureAdapter pictureAdapter;
    private RecyclerView pictureRecycler;
    private Fragment fragment;
    private Intent intentRechercher;
    private static final String TAG = "AtelierActivity";
    private static final int ERROR_DIALOG_REQUEST=9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atelier);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initialisation();

        loadEntreprise(atelier,gerant);

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


    private void initialisation(){
        intent = getIntent();
        atelier =intent.getParcelableExtra(entrepriseKey);
        lstPicture= atelier.getLstPictures();
        gerant= atelier.getGerant();
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
        pictureRecycler = findViewById(R.id.pictures_recycler);

        btnTel1 =findViewById(R.id.btn_ger_tel1);
        btnTel2 =findViewById(R.id.btn_ger_tel2);
        btnSMS1 =findViewById(R.id.btn_ger_sms1);
        btnSMS2 =findViewById(R.id.btn_ger_sms2);

        intentRechercher = new Intent(this,RechercherActivity.class);
    }

    private void loadEntreprise(Atelier atelier, Gerant gerant){
        imgAtelier.setImageResource(atelier.getImage());
        atlierRating.setRating(atelier.getEtoile());
        imgGerant.setImageResource(atelier.getGerant().getPicture());
        /*

         Picasso.get()
                .load(atelier.getGerant().getPicture())
                .resize(600,200)
                .centerInside()
                .into(imgGerant);

        */
        txtNomEntr .setText(atelier.getNom());
        txtDescriptEntr .setText(atelier.getDescription());
        if(lstPicture.size()<1) {
            txtPicture .setText("Image ("+lstPicture.size()+")");
        } else {
            txtPicture .setText("Images ("+lstPicture.size()+")");
        }
        txtNomPrenom.setText(gerant.getNom()+" "+gerant.getPrenom());
        txtTel1.setText(gerant.getTel1());
        txtTel2 .setText(gerant.getTel2());

        //
        pictureAdapter = new PictureAdapter(this, lstPicture);
        pictureRecycler.setAdapter(pictureAdapter);
        pictureRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
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
