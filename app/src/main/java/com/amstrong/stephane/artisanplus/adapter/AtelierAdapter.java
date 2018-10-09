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
import com.amstrong.stephane.artisanplus.model.Atelier;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AtelierAdapter extends RecyclerView.Adapter<AtelierAdapter.ArtisanViewHolder> {
    private LayoutInflater inflater;
    private Context context;
    private Atelier atelier;
    private MainActivity mainActivity;
    private View view;
    private List<Atelier> lstAtelier;

    public AtelierAdapter(Context context, List<Atelier> lstAtelier) {
        this.context = context;
        inflater=LayoutInflater.from(context);
        this.lstAtelier = lstAtelier;
        this.mainActivity = (MainActivity) context;
    }



    @NonNull
    @Override
    public ArtisanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = inflater.inflate(R.layout.row_atelier,parent,false);
        ArtisanViewHolder artisanViewHolder = new ArtisanViewHolder(view);
        return artisanViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ArtisanViewHolder holder, int position) {
            atelier = lstAtelier.get(position);

            Picasso.get()
                    .load(atelier.getImage())
                    .resize(120,120)
                    .centerCrop()
                    .into(holder.imgAtelier);

            holder.txtEntrNom.setText(atelier.getNom());
            holder.txtDescription.setText(atelier.getDescription());

            holder.ratingBar.setRating(atelier.getEtoile());
    }

    @Override
    public int getItemCount() {
        return lstAtelier.size();
    }

    class ArtisanViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imgAtelier;
        TextView txtEntrNom, txtDescription;
        RatingBar ratingBar;
        CardView rowEntreprise;

        public ArtisanViewHolder(@NonNull View itemView) {
            super(itemView);

            imgAtelier = itemView.findViewById(R.id.ger_img);
            txtEntrNom = itemView.findViewById(R.id.ent_nom);
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
