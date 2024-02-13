package com.example.e_commerce.Adaper;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.e_commerce.Model.CategorylistModel;
import com.example.e_commerce.R;
import com.example.e_commerce.cart_screen;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private List<CategorylistModel> catregorymodellist;

    public CartAdapter(cart_screen cart_screen, List<CategorylistModel> catregorymodellist) {
        this.catregorymodellist = catregorymodellist;
    }

    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.cartitem,parent,false);
        return new CartAdapter.ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {
        CategorylistModel cartitem = catregorymodellist.get(position);
        holder.textViewname.setText(cartitem.getName());
        holder.textViewprice.setText(Double.toString(cartitem.getPrice()));
        Glide.with(holder.imageView).load(catregorymodellist.get(position).getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return catregorymodellist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewname;
        TextView textViewprice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iamgecart);
            textViewname = itemView.findViewById(R.id.imagenamecart);
            textViewprice = itemView.findViewById(R.id.carttotal);
        }
    }
}
