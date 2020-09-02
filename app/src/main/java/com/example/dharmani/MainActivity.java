package com.example.dharmani;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.dharmani.Adapter.RecycleAdapter;
import com.example.dharmani.Adapter.RecycleAdapterTop;
import com.example.dharmani.Model.Colors;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerViewtop, recyclerViewDown;
    ArrayList<Colors> colorsList;
    RecycleAdapterTop adapterTop;
    RecycleAdapter adapter;
    String[] colorArray = {"Red", "Green", "Yellow", "Blue", "Orange", "Pink", "Purple"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewDown = findViewById(R.id.recycle_down);
        recyclerViewDown.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerViewtop = findViewById(R.id.recycle_top);
        colorsList = new ArrayList<>();
        adddata();
        addValue();
        recyclerViewtop.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        adapter = new RecycleAdapter(MainActivity.this, colorsList);
        recyclerViewDown.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }

    private void adddata() {
        for (int i = 0; i < colorArray.length; i++) {
            Colors colors = new Colors();
            colors.setColors(colorArray[i]);
            colorsList.add(colors);


        }

    }

    private void addValue() {
        ArrayList<Colors> colorsArrayList=new ArrayList<>();
        colorsArrayList.clear();
        Intent i=getIntent();
        String colorName=i.getStringExtra("name");
        Colors colors=new Colors();
        colors.setColors(colorName);
        colorsArrayList.add(colors);
        adapterTop=new RecycleAdapterTop(MainActivity.this,colorsArrayList);
        recyclerViewtop.setAdapter(adapterTop);
        adapterTop.notifyDataSetChanged();

    }

}