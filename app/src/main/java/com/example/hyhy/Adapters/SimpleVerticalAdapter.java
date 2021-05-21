package com.example.hyhy.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hyhy.Buy_Activity;
import com.example.hyhy.Models.PlateModel;
import com.example.hyhy.Models.SimpleVerticalModel;
import com.example.hyhy.R;

import java.util.List;

public class SimpleVerticalAdapter extends RecyclerView.Adapter<SimpleVerticalAdapter.PlaceViewHolder> {

    private List<SimpleVerticalModel> simpleVerticalModelList;
    private Context context;

    public SimpleVerticalAdapter(List<SimpleVerticalModel> simpleVerticalModelList, Context context) {
        this.simpleVerticalModelList = simpleVerticalModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.simple_vertical_slider,viewGroup,false);
        return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder holder, int position) {
        SimpleVerticalModel simpleVerticalModel = simpleVerticalModelList.get(position);

        Glide.with(context).load(simpleVerticalModel.getPro_img()).into(holder.pro_img);
        holder.simple_title.setText(simpleVerticalModel.getSimple_title());
        holder.simple_description.setText(simpleVerticalModel.getSimple_description());
        holder.simple_saleoff.setText(simpleVerticalModel.getSimple_saleoff());
        holder.tv_ratting.setText(simpleVerticalModel.getTv_ratting());
        holder.buy_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Buy_Activity.class);
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return simpleVerticalModelList.size();
    }

    public class PlaceViewHolder extends RecyclerView.ViewHolder {
        private ImageView pro_img;
        private TextView simple_title,simple_description,simple_saleoff,tv_ratting;
        private Button buy_product;
        public PlaceViewHolder(@NonNull View itemView) {
            super(itemView);

            pro_img = (ImageView) itemView.findViewById(R.id.pro_img);
            simple_title = itemView.findViewById(R.id.simple_title);
            simple_description = itemView.findViewById(R.id.simple_description);
            simple_saleoff = itemView.findViewById(R.id.simple_saleoff);
            tv_ratting = itemView.findViewById(R.id.tv_ratting);
            buy_product = itemView.findViewById(R.id.buy_product);

        }
    }
}

