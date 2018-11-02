package com.example.rsrimone.mycart;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MyCartPageActivity extends AppCompatActivity {

    List<Product> productList;
    Product product;
    RecyclerView myCartRecyclerView;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart_page);
        myCartRecyclerView = findViewById(R.id.my_cart_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        myCartRecyclerView.setLayoutManager(layoutManager);

        sharedPreferences = getApplicationContext().getSharedPreferences("ItemList", MODE_PRIVATE);
        productList = new ArrayList<>();

        if (sharedPreferences.contains("product")){
            product = (Product) getFromGson("product");
        }

        productList.add(product);
        MyCartDisplayAdapter myCartDisplayAdapter = new MyCartDisplayAdapter(productList);
        myCartRecyclerView.setAdapter(myCartDisplayAdapter);
    }
    private Object getFromGson(String product) {
        Gson gson = new Gson();
        String json = sharedPreferences.getString(product, "");
        return gson.fromJson(json, Product.class);
    }
}
