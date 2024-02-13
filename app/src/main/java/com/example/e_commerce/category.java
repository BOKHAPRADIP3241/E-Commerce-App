package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.e_commerce.Adaper.CategorylistAdapter;
import com.example.e_commerce.Adaper.CtegoryAdapter;
import com.example.e_commerce.Model.CategoryModel;
import com.example.e_commerce.Model.CategorylistModel;
import com.example.e_commerce.Model.RecentModel;
import com.example.e_commerce.databinding.ActivityCategoryBinding;
import com.example.e_commerce.databinding.ActivityMainBinding;

import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class category extends AppCompatActivity {
    ActivityCategoryBinding binding;
    List<RecentModel> categorymodellist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        categorymodellist= new ArrayList<>();
        binding.recyclecategory.setLayoutManager(new GridLayoutManager(category.this,2));
       int catid = getIntent().getIntExtra("catid",0);
       String categoryname = getIntent().getStringExtra("categoryname");
       getSupportActionBar().setTitle(categoryname);
      getcategorylist(catid);


    }

    void getcategorylist(int catid){
        List<CategorylistModel> categorylistModels = new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET,Constants.GET_PRODUCTS_URL+"?category_id="+catid, response -> {
            try {
                JSONObject object = new JSONObject(response);
                if (object.getString("status").equals("success")){
                    JSONArray jsonArray = object.getJSONArray("products");
                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        CategorylistModel categorylistModel = new CategorylistModel(jsonObject.getString("name"),Constants.PRODUCTS_IMAGE_URL+jsonObject.getString("image"),jsonObject.getString("status"),jsonObject.getDouble("price"),jsonObject.getDouble("price_discount"),jsonObject.getInt("stock"),jsonObject.getInt("id"));

                        categorylistModels.add(categorylistModel);
                        binding.recyclecategory.setAdapter(new CategorylistAdapter(categorylistModels,category.this));

                    }

                }

            }catch (JSONException e){
                e.printStackTrace();

            }
        },error -> {});
        requestQueue.add(request);
    }
}