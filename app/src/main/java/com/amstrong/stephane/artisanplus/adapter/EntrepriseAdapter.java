package com.amstrong.stephane.artisanplus.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.amstrong.stephane.artisanplus.R;
import com.amstrong.stephane.artisanplus.activity.MainActivity;
import com.amstrong.stephane.artisanplus.model.Entreprise;
import com.squareup.picasso.Picasso;

import java.util.List;

public class EntrepriseAdapter extends RecyclerView.Adapter<EntrepriseAdapter.ArtisanViewHolder> {
    private LayoutInflater inflater;
    private Context context;
    private Entreprise entreprise;
    private MainActivity mainActivity;
    private View view;
    private List<Entreprise> lstEntreprise;

    public EntrepriseAdapter(Context context, List<Entreprise> lstEntreprise) {
        this.context = context;
        inflater=LayoutInflater.from(context);
        this.lstEntreprise = lstEntreprise;
        this.mainActivity = (MainActivity) context;
    }



    @NonNull
    @Override
    public ArtisanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = inflater.inflate(R.layout.row_entreprise,parent,false);
        ArtisanViewHolder artisanViewHolder = new ArtisanViewHolder(view);
        return artisanViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ArtisanViewHolder holder, int position) {
        entreprise = lstEntreprise.get(position);

        Picasso.get()
                .load(entreprise.getImage())
                .resize(120,120)
                .centerCrop()
                .into(holder.imgAtelier);

        holder.txtEntrNom.setText(entreprise.getNom());
        holder.txtEntrCateg.setText(entreprise.getCategorie().getLibelle());
        holder.txtDescription.setText(entreprise.getDescription());
        holder.ratingBar.setRating(entreprise.getEtoile());
    }

    @Override
    public int getItemCount() {
        return lstEntreprise.size();
    }

    class ArtisanViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imgAtelier;
        TextView txtEntrNom,txtEntrCateg, txtDescription;
        RatingBar ratingBar;
        CardView rowEntreprise;

        public ArtisanViewHolder(@NonNull View itemView) {
            super(itemView);

            imgAtelier = itemView.findViewById(R.id.ger_img);
            txtEntrNom = itemView.findViewById(R.id.ent_nom);
            txtEntrCateg = itemView.findViewById(R.id.atlier_categorie);
            txtDescription = itemView.findViewById(R.id.atlier_descript);
            rowEntreprise = itemView.findViewById(R.id.row_entreprise);
            ratingBar = itemView.findViewById(R.id.ent_rating);
            rowEntreprise.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mainActivity.callEntrepriseActivity(getAdapterPosition());
        }
    }
}
