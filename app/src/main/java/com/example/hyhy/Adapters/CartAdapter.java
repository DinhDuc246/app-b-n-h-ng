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
import com.example.hyhy.Models.CartModel;
import com.example.hyhy.Models.SimpleVerticalModel;
import com.example.hyhy.R;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.PlaceViewHolder> {

    private List<CartModel> cartModelList;
    private Context context;

    public CartAdapter(List<CartModel> cartModelList, Context context) {
        this.cartModelList = cartModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item_cart,viewGroup,false);
        return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder holder, int position) {
        CartModel cartModel = cartModelList.get(position);

        Glide.with(context).load(cartModel.getImg_cart()).into(holder.img_cart);
        holder.number_cart.setText(cartModel.getNumber_cart());
        holder.title_cart.setText(cartModel.getTitle_cart());
        holder.tv_price.setText(cartModel.getTv_price());

    }

    @Override
    public int getItemCount() {
        return cartModelList.size();
    }

    public class PlaceViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_cart;
        private TextView number_cart,title_cart,tv_price;
        public PlaceViewHolder(@NonNull View itemView) {
            super(itemView);

            img_cart =  itemView.findViewById(R.id.img_cart);
            number_cart = itemView.findViewById(R.id.number_cart);
            title_cart = itemView.findViewById(R.id.title_cart);
            tv_price = itemView.findViewById(R.id.tv_price);
        }
    }
}


