package com.amstrong.stephane.artisanplus.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amstrong.stephane.artisanplus.R;
import com.amstrong.stephane.artisanplus.activity.Profil2Activity;
import com.amstrong.stephane.artisanplus.activity.ProfilActivity;

import java.util.List;

public class TelephoneAdapter extends RecyclerView.Adapter<TelephoneAdapter.TelephoneViewHolder>{
    private Context context;
    private LayoutInflater layoutInflater;
    private List<String> lstContact;
    private String contact;
    private View view;
    private ProfilActivity profilActivity;


    public TelephoneAdapter(Context context, List<String> lstContact) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.lstContact = lstContact;
        this.profilActivity = (ProfilActivity) context;
    }

    @NonNull
    @Override
    public TelephoneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = layoutInflater.inflate(R.layout.row_telephone,parent,false);
        TelephoneViewHolder telephoneViewHolder = new TelephoneViewHolder(view);
        return telephoneViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TelephoneViewHolder holder, int position) {
        holder.txtTel.setText(lstContact.get(position));
    }

    @Override
    public int getItemCount() {
        return lstContact.size();
    }

    class TelephoneViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txtTel;

        public TelephoneViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTel =itemView.findViewById(R.id.view_tel);
            //txtTel.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
