package com.amstrong.stephane.artisanplus.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.amstrong.stephane.artisanplus.R;

import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class AdapterPicture extends RecyclerView.Adapter<AdapterPicture.ButtonViewHolder>{
    Context context;
    LayoutInflater layoutInflater;
    int picture;
    List<Integer> lstPicture;
    View view;

    public AdapterPicture(Context context, List<Integer> lstPicture) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.lstPicture = lstPicture;
    }

    @NonNull
    @Override
    public ButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = layoutInflater.inflate(R.layout.row_picture,parent,false);
        ButtonViewHolder buttonViewHolder = new ButtonViewHolder(view);

        return buttonViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ButtonViewHolder holder, int position) {
        picture = lstPicture.get(position);
        holder.picture.setImageResource(picture);

        /*
        Picasso.get()
                .load(picture)
                .resize(600,200)
                .centerInside()
                .onlyScaleDown()
                .into(holder.picture);

        */
    }

    @Override
    public int getItemCount() {
        return lstPicture.size();
    }

    class ButtonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView picture;

        public ButtonViewHolder(@NonNull View itemView) {
            super(itemView);
            picture =itemView.findViewById(R.id.photo);

            picture.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            loadPhoto(picture,200,128);
        }

        private void loadPhoto(ImageView imageView, int width, int height) {

            ImageView tempImageView = imageView;


            AlertDialog.Builder imageDialog = new AlertDialog.Builder(context);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);

            View layout = inflater.inflate(R.layout.dialog_fullimage, (ViewGroup) itemView.findViewById(R.id.layout_root));
            ImageView image = (ImageView) layout.findViewById(R.id.fullimage);
            image.setImageDrawable(tempImageView.getDrawable());
            imageDialog.setView(layout);

            /*

            imageDialog.setPositiveButton(resources.getString(R.string.ok_button), new DialogInterface.OnClickListener(){

                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            */

            imageDialog.create();
            imageDialog.show();
        }
    }
}
