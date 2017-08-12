package com.example.segundoauqui.zooapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final String TAG = "Categories";
    DataBaseHelper dataBaseHelper;
    private String[] item;
    ListView listview;
    private String test;
    String[] ids;

    Main3Activity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        dataBaseHelper = new DataBaseHelper(this);

        Log.d(TAG, "onCreate: " + test);
        listview = (ListView) findViewById(R.id.listview);
        //initFoodList();
        ArrayList<Categories> categories = dataBaseHelper.getCategories();
        item = new String[categories.size()];
        ids = new String[categories.size()];
        for (int i = 0; i < categories.size(); i++) {
            item[i] = "Category: " + categories.get(i).getCategories() + "\n" +
                    "Description: " + categories.get(i).getDescription() + "\n";
            ids[i] = String.valueOf(categories.get(i).getId());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, item);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(this);
        listview.setAdapter(adapter);


        listview.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//        Intent intent = new Intent(this, SecondActivity.class);
//        intent.putExtra(getString(R.string.ID),categories.get(i));
//        startActivity(intent);
//        intent.putExtra("ID", ids[position]);


        Intent intent = new Intent(this, Main3Activity.class);
        intent.putExtra("ID", ids[position]);
        startActivity(intent);
        final String item = ((TextView) view).getText().toString();

        Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();
    }
}