package com.amstrong.stephane.artisanplus.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.amstrong.stephane.artisanplus.R;
import com.amstrong.stephane.artisanplus.model.Activite;

import java.util.List;

public class ActiviteAdapter extends RecyclerView.Adapter<ActiviteAdapter.ActiviteViewHolder>{
    Context context;
    LayoutInflater layoutInflater;
    Activite activite;
    List<Activite> lstActivite;
    View view;

    public ActiviteAdapter(Context context, List<Activite> lstActivite) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.lstActivite = lstActivite;
    }

    @NonNull
    @Override
    public ActiviteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = layoutInflater.inflate(R.layout.row_entrepise_activity,parent,false);
        ActiviteViewHolder activiteViewHolder = new ActiviteViewHolder(view);

        return activiteViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ActiviteViewHolder holder, int position) {
        activite = lstActivite.get(position);

        holder.txtNumero.setText("N° "+(position+1)+":");
        holder.txtActivite.setText(activite.getCategorie().getLibelle());
    }

    @Override
    public int getItemCount() {
        return lstActivite.size();
    }

    class ActiviteViewHolder extends RecyclerView.ViewHolder {

        TextView txtNumero,txtActivite;

        public ActiviteViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNumero =itemView.findViewById(R.id.txt_rownumero);
            txtActivite =itemView.findViewById(R.id.txt_rowactivite);
        }
    }
}
