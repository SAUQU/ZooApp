package com.example.segundoauqui.zooapp;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by segundoauqui on 8/12/17.
 */

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.ViewHolder>{

    private static final String TAG = "FoodListAdapter";
    List<MyContacs> foodList = new ArrayList<>();

    public FoodListAdapter(List<MyContacs> foodList) {
        this.foodList = foodList;
    }



    FoodListAdapter foodListAdapter;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvDishname;
        TextView tvRating;
        TextView tvCalories;
        TextView tvPrice;


        public ViewHolder(View itemView) {
            super(itemView);

            tvDishname = (TextView) itemView.findViewById(R.id.tvFoodName);
            tvRating = (TextView) itemView.findViewById(R.id.tvFoodRating);
            tvPrice = (TextView) itemView.findViewById(R.id.tvFoodPrice);
            tvCalories = (TextView) itemView.findViewById(R.id.tvFoodCalories);

        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Log.d(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main3, parent, false);

        return new ViewHolder(view);


    }






    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Log.d(TAG, "onBindViewHolder: ");

        final MyContacs food = foodList.get(position);
        holder.tvDishname.setText(food.getName());
        holder.tvCalories.setText(String.valueOf(food.getClase()));
        holder.tvRating.setText(String.valueOf(food.getOrder()));
        holder.tvPrice.setText(String.valueOf(food.getRange()));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Main2Activity.class);
                intent.putExtra("FOOD", food);
                v.getContext().startActivity(intent);
            }
        });



    }


    @Override
    public int getItemCount() {
        return foodList.size();
    }





}
