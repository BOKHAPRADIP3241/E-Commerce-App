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
import com.example.e_commerce.MainActivity;
import com.example.e_commerce.Model.CategoryModel;
import com.example.e_commerce.R;
import com.example.e_commerce.category;

import java.util.List;

public class CtegoryAdapter extends RecyclerView.Adapter<CtegoryAdapter.ViewHolder> {
    private List<CategoryModel> CategoryList;

    public CtegoryAdapter(List<CategoryModel> categoryList, MainActivity mainActivity) {
        this.CategoryList = categoryList;
    }

    @NonNull
    @Override
    public CtegoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item,parent,false);
        return new ViewHolder(item);

    }

    @Override
    public void onBindViewHolder(@NonNull CtegoryAdapter.ViewHolder holder, int position) {
        CategoryModel categoryitem = CategoryList.get(position);
        holder.textView.setText(categoryitem.getName());
        Glide.with(holder.imageView).load(CategoryList.get(position).getIcon()).into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), category.class);
                intent.putExtra("catid",categoryitem.getId());
                intent.putExtra("categoryname",categoryitem.getName());
                v.getContext().startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return CategoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imagecategory);
            textView = itemView.findViewById(R.id.txtviewcategory);

        }
    }
}
