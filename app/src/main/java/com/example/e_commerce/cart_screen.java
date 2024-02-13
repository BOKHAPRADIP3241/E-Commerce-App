package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.e_commerce.Adaper.CartAdapter;
import com.example.e_commerce.Model.CategorylistModel;

import java.util.ArrayList;
import java.util.List;

public class cart_screen extends AppCompatActivity {
    RecyclerView recyclerViewcart;
    List<CategorylistModel> categorymodellist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_screen);
        recyclerViewcart = findViewById(R.id.cartrecycle);
        categorymodellist = new ArrayList<>();
        recyclerViewcart.setLayoutManager(new LinearLayoutManager(this));
        CartAdapter cartAdapter = new CartAdapter(cart_screen.this,categorymodellist);
        recyclerViewcart.setAdapter(cartAdapter);










    }
}