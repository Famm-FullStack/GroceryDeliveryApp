package com.example.grocerydeliveryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {

    private RecyclerView productRecyclerView;
    private ArrayList<Item> itemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        itemList = new ArrayList<>();
        itemList.add(new Item(R.drawable.suger, "Fine Grain Suger", 4.8));
        itemList.add(new Item(R.drawable.rice, "Rice", 5));

        productRecyclerView = findViewById(R.id.productRecyclerView);
        productRecyclerView.setHasFixedSize(true);
        productRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ProductRecyclerViewAdapter adapter = new ProductRecyclerViewAdapter(this, itemList);
        productRecyclerView.setAdapter(adapter);

    }
}