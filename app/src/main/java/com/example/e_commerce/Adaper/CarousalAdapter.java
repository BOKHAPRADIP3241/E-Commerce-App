package com.example.e_commerce.Adaper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.e_commerce.Model.CarousalModel;
import com.example.e_commerce.R;

import java.util.List;

public class CarousalAdapter extends PagerAdapter {
    private Context context;
    private int[] images;

    public CarousalAdapter(Context context, int[] images) {
        this.context = context;
        this.images = images;
    }

    public CarousalAdapter(List<CarousalModel> carousal) {
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.carousalimage,container,false);

        ImageView imageView =view.findViewById(R.id.imagecarousal);
        imageView.setImageResource(images[position]);
        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }
}
