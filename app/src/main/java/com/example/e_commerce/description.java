package com.example.e_commerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.e_commerce.Model.CategorylistModel;
import com.example.e_commerce.Model.RecentModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import de.hdodenhof.circleimageview.CircleImageView;

public class description extends AppCompatActivity {

CircleImageView circleImageView;
TextView textView;
Button addbutton;
ConstraintLayout constraintLayout;
    private RecentModel currentproduct;
   ImageView imageViewaction;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cartaction,menu);
        MenuItem menuItem = menu.findItem(R.id.cart);
        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem item) {
                Intent intent = new Intent(getApplicationContext(), cart_screen.class);

                startActivity(intent);
                return true;
            }
        });
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        constraintLayout = findViewById(R.id.const_layout);
        circleImageView = findViewById(R.id.profile_image);
        textView = findViewById(R.id.txtdescription);
        addbutton = findViewById(R.id.buttonadd);
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addbutton.setBackgroundColor(getResources().getColor(R.color.gray));

//                Intent intent = new Intent(getApplicationContext(), View.class);
//                intent.putExtra("name",currentproduct.getName());
//                intent.putExtra("image",currentproduct.getImage());
//                intent.putExtra("price",currentproduct.getPrice());
//                intent.putExtra("id",currentproduct.getId());
//                startActivity(intent);
            }
        });
        int id = getIntent().getIntExtra("id",0);
        String image = getIntent().getStringExtra("image");
        String name = getIntent().getStringExtra("name");
        Glide.with(this).load(image).into(circleImageView);
        description(id);
        getSupportActionBar().setTitle(name);

    }
    void description(int id){

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET,Constants.GET_PRODUCT_DETAILS_URL+id, response -> {
            try {
                JSONObject object = new JSONObject(response);
                if (object.getString("status").equals("success")){
                    JSONObject jsonObject = object.getJSONObject("product");
                    String description = jsonObject.getString("description");
                    textView.setText(Html.fromHtml(description));
                    currentproduct = new RecentModel(jsonObject.getString("name"), Constants.PRODUCTS_IMAGE_URL+jsonObject.getString("image"),jsonObject.getString("price"),jsonObject.getInt("id"));
                    }



            }catch (JSONException e){
                e.printStackTrace();

            }
        },error -> {});
        requestQueue.add(request);
    }

}