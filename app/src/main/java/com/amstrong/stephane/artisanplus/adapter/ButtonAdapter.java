package com.amstrong.stephane.artisanplus.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.amstrong.stephane.artisanplus.R;
import com.amstrong.stephane.artisanplus.activity.MainActivity;
import com.amstrong.stephane.artisanplus.model.Categorie;

import java.util.List;

public class ButtonAdapter extends RecyclerView.Adapter<ButtonAdapter.ButtonViewHolder>{
    private Context context;
    private LayoutInflater layoutInflater;
    private Categorie categorie;
    private List<Categorie> lstCategorie;
    private View view;
    private MainActivity mainActivity;
    private SparseBooleanArray selectedItems;


    public ButtonAdapter(Context context, List<Categorie> lstCategorie) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.lstCategorie = lstCategorie;
        selectedItems = new SparseBooleanArray(lstCategorie.size());
        this.mainActivity = (MainActivity) context;
    }

    @NonNull
    @Override
    public ButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = layoutInflater.inflate(R.layout.row_bouton,parent,false);
        ButtonViewHolder buttonViewHolder = new ButtonViewHolder(view);

        return buttonViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ButtonViewHolder holder, int position) {
        categorie = lstCategorie.get(position);
        holder.btnProfession.setText(categorie.getLibelle());
        holder.rowButton.setSelected(false);
        holder.rowButton.setSelected(selectedItems.get(position, false));
    }

    @Override
    public int getItemCount() {
        return lstCategorie.size();
    }

    class ButtonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView btnProfession;
        CardView rowButton;

        public ButtonViewHolder(@NonNull View itemView) {
            super(itemView);

            btnProfession =itemView.findViewById(R.id.btn_profession);
            rowButton =itemView.findViewById(R.id.layout_bouton);

            btnProfession.setOnClickListener(this);
            rowButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (selectedItems.get(getAdapterPosition(), false)) {
                selectedItems.delete(getAdapterPosition());
                rowButton.setSelected(false);
                mainActivity.removeAteliers(getAdapterPosition());

            }else {
                selectedItems.put(getAdapterPosition(), true);
                rowButton.setSelected(true);
                mainActivity.addAteliers(getAdapterPosition());
            }

        }
    }
}
