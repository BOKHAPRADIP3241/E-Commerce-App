package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.e_commerce.Adaper.CarousalAdapter;
import com.example.e_commerce.Adaper.CtegoryAdapter;
import com.example.e_commerce.Adaper.RecentAdapter;
import com.example.e_commerce.Model.CategoryModel;
import com.example.e_commerce.Model.RecentModel;
import com.example.e_commerce.databinding.ActivityMainBinding;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView,recyclerView1;
    CtegoryAdapter ctegoryAdapter;
    List<String>CategoryList;
    ActivityMainBinding binding;

    private ImageCarousel imageCarousel;
    private CarousalAdapter adapter;
    String url = "https://tutorials.mianasad.com/ecommerce/";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        textView = findViewById(R.id.txtdescription);
        recyclerView= findViewById(R.id.recycle1);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,4));
        binding.recycle2.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
        getcarousal();
        getcategory();
        getrecentitem();




        CategoryList = new ArrayList<>();


//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(url)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        CategoryInterface categoryInterface = retrofit.create(CategoryInterface.class);
//        Call<List<CategoryModel>> call = categoryInterface.getlistcategory();
//        call.enqueue(new Callback<List<CategoryModel>>() {
//            @Override
//            public void onResponse(Call<List<CategoryModel>> call, Response<List<CategoryModel>> response) {
//                Log.e("response-get",response.body().toString());
//                List<CategoryModel> categorydata = response.body();
//                ctegoryAdapter = new CtegoryAdapter(categorydata);
//                recyclerView.setAdapter(ctegoryAdapter);
//
//            }
//
//            @Override
//            public void onFailure(Call<List<CategoryModel>> call, Throwable t) {
//
//            }
//        });

    }
    void getcarousal(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET,Constants.GET_OFFERS_URL,response -> {
            try {
                JSONObject object = new JSONObject(response);
                if (object.getString("status").equals("success")){
                    JSONArray jsonArray = object.getJSONArray("news_infos");
                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        binding.carsoul.addData(new CarouselItem(Constants.NEWS_IMAGE_URL + jsonObject.getString("image"),jsonObject.getString("title")));

                    }

                }

            }catch (JSONException e){
                e.printStackTrace();

            }
        },error -> {});
             requestQueue.add(request);
    }
    void getcategory(){
        List<CategoryModel> categoryModels = new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET,Constants.GET_CATEGORIES_URL,response -> {
            try {
                JSONObject object = new JSONObject(response);
                if (object.getString("status").equals("success")){
                    JSONArray jsonArray = object.getJSONArray("categories");
                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        CategoryModel categoryModel = new CategoryModel(jsonObject.getString("name"),Constants.CATEGORIES_IMAGE_URL + jsonObject.getString("icon"),jsonObject.getString("color"),jsonObject.getString("brief"),jsonObject.getInt("id"));

                        categoryModels.add(categoryModel);
                        recyclerView.setAdapter(new CtegoryAdapter(categoryModels,MainActivity.this));




                    }

                }

            }catch (JSONException e){
                e.printStackTrace();

            }
        },error -> {});
        requestQueue.add(request);
    }
    void getrecentitem(){
        List<RecentModel> recentModels = new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET,Constants.GET_PRODUCTS_URL,response -> {
            try {
                JSONObject object = new JSONObject(response);
                if (object.getString("status").equals("success")){
                    JSONArray jsonArray = object.getJSONArray("products");
                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Log.e("recentproduct",jsonObject.toString());


                        RecentModel recentModel = new RecentModel(jsonObject.getString("name"),Constants.PRODUCTS_IMAGE_URL+jsonObject.getString("image"),jsonObject.getString("price"),jsonObject.getInt("id"));

                        recentModels.add(recentModel);
                        binding.recycle2.setAdapter(new RecentAdapter(recentModels,MainActivity.this));




                    }

                }

            }catch (JSONException e){
                e.printStackTrace();

            }
        },error -> {});
        requestQueue.add(request);
    }

}