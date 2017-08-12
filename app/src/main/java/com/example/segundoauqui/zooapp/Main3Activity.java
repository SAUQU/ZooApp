package com.example.segundoauqui.zooapp;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {


    private static final String TAG = "Tag";
    //List<Food> foodList = new ArrayList<>();

    List<MyContacs> animalList;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    FoodListAdapter foodListAdapter;
    RecyclerView rvFoodList;
    String id;

    DataBaseHelper databasehelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent = getIntent();
        id = getIntent().getStringExtra("ID");

        rvFoodList = (RecyclerView) findViewById(R.id.rvFoodList);
        initFoodList();
        layoutManager = new LinearLayoutManager(this);
        itemAnimator = new DefaultItemAnimator();
        rvFoodList.setLayoutManager(layoutManager);
        rvFoodList.setItemAnimator(itemAnimator);

        foodListAdapter = new FoodListAdapter(animalList);
        rvFoodList.setAdapter(foodListAdapter);
        foodListAdapter.notifyDataSetChanged();




    }

    private void initFoodList() {

        Intent intent = getIntent();
        databasehelper = new DataBaseHelper(this);
        Log.d(TAG, "initAnimalsList: " + intent.getStringExtra("ID"));
        animalList = databasehelper.getMyContacs(intent.getStringExtra("ID"));

//        Intent intent = new Intent(this, Main2Activity.class);
////        intent.putExtra("Title", );
////        intent.putExtra("Content",);
//        startActivity(intent);
//        startActivity(intent);

//        foodList.add(new Food("Burger", 12, 300, 4.5));
//        foodList.add(new Food("Pizza", 34, 340, 4.9));
//        foodList.add(new Food("Soup", 14, 500, 4.1));
//        foodList.add(new Food("Fried rice", 15, 600, 2.5));

    }




}
