package com.amstrong.stephane.artisanplus.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.amstrong.stephane.artisanplus.R;
import com.amstrong.stephane.artisanplus.activity.ProfilReadActivity;

import java.util.List;

public class TelEditAdapter extends RecyclerView.Adapter<TelEditAdapter.TelEditViewHolder>{
    private Context context;
    private LayoutInflater layoutInflater;
    private List<String> lstContact;
    private String contact;
    private View view;
    private ProfilReadActivity profilReadActivity;


    public TelEditAdapter(Context context, List<String> lstContact) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.lstContact = lstContact;
        this.profilReadActivity = (ProfilReadActivity) context;
    }

    @NonNull
    @Override
    public TelEditViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = layoutInflater.inflate(R.layout.row_phone_edit,parent,false);
        TelEditViewHolder telEditViewHolder = new TelEditViewHolder(view);
        return telEditViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TelEditViewHolder holder, int position) {
        holder.txtTel.setText(lstContact.get(position));
    }

    @Override
    public int getItemCount() {
        return lstContact.size();
    }

    class TelEditViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        EditText txtTel;

        public TelEditViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTel =itemView.findViewById(R.id.edit_tel);
            //txtTel.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
