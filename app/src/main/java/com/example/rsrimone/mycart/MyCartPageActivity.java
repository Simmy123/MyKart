package com.example.rsrimone.mycart;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

public class MyCartPageActivity extends AppCompatActivity {

    Product product;
    RecyclerView myCartRecyclerView;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart_page);
        myCartRecyclerView = findViewById(R.id.my_cart_recycler_view);

        sharedPreferences = getApplicationContext().getSharedPreferences("ItemList", MODE_PRIVATE);

        if (sharedPreferences.contains("item_name")){
            product = (Product) getFromGson("product");
        }
        MyCartDisplayAdapter myCartDisplayAdapter = new MyCartDisplayAdapter(product);
        myCartRecyclerView.setAdapter(myCartDisplayAdapter);
    }
    private Object getFromGson(String product) {
        Gson gson = new Gson();
        String json = sharedPreferences.getString(product, "");
        return gson.fromJson(json, Product.class);
    }
}
