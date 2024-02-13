package com.example.e_commerce.Adaper;

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
import com.example.e_commerce.Model.RecentModel;
import com.example.e_commerce.R;
import com.example.e_commerce.category;
import com.example.e_commerce.description;

import java.util.List;

public class CategorylistAdapter extends RecyclerView.Adapter<CategorylistAdapter.ViewHolder> {
    private List<CategorylistModel> catregorymodellist;

    public CategorylistAdapter(List<CategorylistModel> catregorymodellist, category category) {
        this.catregorymodellist = catregorymodellist;
    }

    @NonNull
    @Override
    public CategorylistAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list,parent,false);
        return new CategorylistAdapter.ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull CategorylistAdapter.ViewHolder holder, int position) {
        CategorylistModel recentitem = catregorymodellist.get(position);
        holder.textView1.setText(recentitem.getName());
        holder.textView2.setText(Double.toString(recentitem.getPrice()));
        Glide.with(holder.imageView).load(catregorymodellist.get(position).getImage()).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), description.class);
                intent.putExtra("id",recentitem.getId());
                intent.putExtra("name",recentitem.getName());
                intent.putExtra("image",recentitem.getImage());
                intent.putExtra("price",recentitem.getPrice());
                v.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return catregorymodellist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1,textView2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.categoryimage);
            textView1=itemView.findViewById(R.id.txtname);
            textView2=itemView.findViewById(R.id.txtprice);
        }
    }
}
