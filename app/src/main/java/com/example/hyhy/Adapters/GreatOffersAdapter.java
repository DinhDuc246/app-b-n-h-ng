package com.example.hyhy.Adapters;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.example.hyhy.Models.GreatOffersModel;

import com.example.hyhy.R;

import java.util.List;

public class GreatOffersAdapter extends RecyclerView.Adapter<GreatOffersAdapter.PlaceViewHolder> {

    private List<GreatOffersModel> greatOffersModelList;
    private Context context;

    public GreatOffersAdapter(List<GreatOffersModel> greatOffersModelList, Context context) {
        this.greatOffersModelList = greatOffersModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_horizontal_great_offers,viewGroup,false);
        return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder holder, int position) {
        GreatOffersModel greatOffersModel = greatOffersModelList.get(position);

        Glide.with(context).load(greatOffersModel.getOffer_img()).into(holder.offer_img);
        holder.text_title.setText(greatOffersModel.getText_title());
        holder.text_description.setText(greatOffersModel.getText_description());
        holder.text_saleoff.setText(greatOffersModel.getText_saleoff());
        holder.text_ratting.setText(greatOffersModel.getText_ratting());

    }

    @Override
    public int getItemCount() {
        return greatOffersModelList.size();
    }

    public class PlaceViewHolder extends RecyclerView.ViewHolder {
        private ImageView offer_img;
        private TextView text_title,text_description,text_saleoff,text_ratting;
        public PlaceViewHolder(@NonNull View itemView) {
            super(itemView);

            offer_img =  itemView.findViewById(R.id.offer_img);
            text_title = itemView.findViewById(R.id.text_title);
            text_description = itemView.findViewById(R.id.text_description);
            text_saleoff = itemView.findViewById(R.id.text_saleoff);
            text_ratting = itemView.findViewById(R.id.text_ratting);
        }
    }
}


