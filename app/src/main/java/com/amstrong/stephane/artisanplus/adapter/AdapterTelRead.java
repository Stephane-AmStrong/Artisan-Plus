package com.amstrong.stephane.artisanplus.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amstrong.stephane.artisanplus.R;
import com.amstrong.stephane.artisanplus.activity.ProfilReadActivity;

import java.util.List;

public class AdapterTelRead extends RecyclerView.Adapter<AdapterTelRead.TelReadViewHolder>{
    private Context context;
    private LayoutInflater layoutInflater;
    private List<String> lstContact;
    private String contact;
    private View view;
    private ProfilReadActivity profilReadActivity;


    public AdapterTelRead(Context context, List<String> lstContact) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.lstContact = lstContact;
        this.profilReadActivity = (ProfilReadActivity) context;
    }

    @NonNull
    @Override
    public TelReadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = layoutInflater.inflate(R.layout.row_phone_read,parent,false);
        TelReadViewHolder telReadViewHolder = new TelReadViewHolder(view);
        return telReadViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TelReadViewHolder holder, int position) {
        holder.txtTel.setText(lstContact.get(position));
    }

    @Override
    public int getItemCount() {
        return lstContact.size();
    }

    class TelReadViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txtTel;

        public TelReadViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTel =itemView.findViewById(R.id.read_tel);
            //txtTel.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
