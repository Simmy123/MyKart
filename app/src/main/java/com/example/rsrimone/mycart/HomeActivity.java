package com.example.rsrimone.mycart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeActivity extends AppCompatActivity {

    private ArrayList<HashMap<String,Integer>> listOfItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        populateList();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        ListItemAdapter listItemAdapter = new ListItemAdapter(this,listOfItems);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),1);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(listItemAdapter);
    }

    private void populateList() {
        listOfItems = new ArrayList<HashMap<String, Integer>>();

        HashMap<String,Integer> item1 = new HashMap<>();
        item1.put("item_title",R.string.item_title1);
        item1.put("item_price",R.string.price1);
        item1.put("is_food",R.string.is_true);
        item1.put("is_import",R.string.is_true);
        item1.put("item_image",R.drawable.book1);
        listOfItems.add(item1);

        HashMap<String,Integer> item3 = new HashMap<>();
        item3.put("item_title",R.string.item_title3);
        item3.put("item_price",R.string.price3);
        item3.put("is_food",R.string.is_true);
        item3.put("is_import",R.string.is_false);
        item3.put("item_image",R.drawable.perfume);
        listOfItems.add(item3);

        HashMap<String,Integer> item5 = new HashMap<>();
        item5.put("item_title",R.string.item_title5);
        item5.put("item_price",R.string.price5);
        item5.put("is_food",R.string.is_false);
        item5.put("item_image",R.drawable.book1);
        item5.put("is_import",R.string.is_true);
        listOfItems.add(item5);

        HashMap<String,Integer> item4 = new HashMap<>();
        item4.put("item_title",R.string.item_title4);
        item4.put("item_price",R.string.price4);
        item4.put("is_food",R.string.is_false);
        item4.put("is_import",R.string.is_false);
        item4.put("item_image",R.drawable.perfume);
        listOfItems.add(item4);

        HashMap<String,Integer> item2 = new HashMap<>();
        item2.put("item_title",R.string.item_title2);
        item2.put("item_price",R.string.price2);
        item2.put("is_food",R.string.is_true);
        item2.put("is_import",R.string.is_true);
        item2.put("item_image",R.drawable.food);
        listOfItems.add(item2);

        HashMap<String,Integer> item6 = new HashMap<>();
        item6.put("item_title",R.string.item_title1);
        item6.put("item_price",R.string.price1);
        item6.put("is_food",R.string.is_false);
        item6.put("item_image",R.drawable.book1);
        item6.put("is_import",R.string.is_false);
        listOfItems.add(item6);

        HashMap<String,Integer> item7 = new HashMap<>();
        item7.put("item_title",R.string.item_title3);
        item7.put("item_price",R.string.price3);
        item7.put("is_food",R.string.is_false);
        item7.put("is_import",R.string.is_true);
        item7.put("item_image",R.drawable.perfume);
        listOfItems.add(item7);

        HashMap<String,Integer> item8 = new HashMap<>();
        item8.put("item_title",R.string.item_title5);
        item8.put("item_price",R.string.price5);
        item8.put("is_food",R.string.is_false);
        item8.put("is_import",R.string.is_false);
        item8.put("item_image",R.drawable.book1);
        listOfItems.add(item5);

        HashMap<String,Integer> item9 = new HashMap<>();
        item9.put("item_title",R.string.item_title4);
        item9.put("item_price",R.string.price4);
        item9.put("is_food",R.string.is_false);
        item9.put("is_import",R.string.is_true);
        item9.put("item_image",R.drawable.perfume);
        listOfItems.add(item9);

        HashMap<String,Integer> item10 = new HashMap<>();
        item10.put("item_title",R.string.item_title2);
        item10.put("item_price",R.string.price2);
        item10.put("is_import",R.string.is_true);
        item10.put("is_food",R.string.is_true);
        item10.put("item_image",R.drawable.food);
        listOfItems.add(item10);

        HashMap<String,Integer> item11 = new HashMap<>();
        item11.put("item_title",R.string.item_title1);
        item11.put("item_price",R.string.price1);
        item11.put("is_food",R.string.is_false);
        item11.put("is_import",R.string.is_true);
        item11.put("item_image",R.drawable.book1);
        listOfItems.add(item11);

        HashMap<String,Integer> item12 = new HashMap<>();
        item12.put("item_title",R.string.item_title3);
        item12.put("is_food",R.string.is_false);
        item12.put("item_price",R.string.price3);
        item12.put("item_image",R.drawable.perfume);
        item12.put("is_import",R.string.is_false);
        listOfItems.add(item12);

        HashMap<String,Integer> item13 = new HashMap<>();
        item13.put("item_title",R.string.item_title5);
        item13.put("item_price",R.string.price5);
        item13.put("is_import",R.string.is_true);
        item13.put("is_food",R.string.is_false);
        item13.put("item_image",R.drawable.book1);
        listOfItems.add(item13);

        HashMap<String,Integer> item14 = new HashMap<>();
        item14.put("item_title",R.string.item_title4);
        item14.put("item_price",R.string.price4);
        item14.put("is_food",R.string.is_false);
        item14.put("is_import",R.string.is_true);
        item14.put("item_image",R.drawable.perfume);
        listOfItems.add(item14);

        HashMap<String,Integer> item15 = new HashMap<>();
        item15.put("item_title",R.string.item_title2);
        item15.put("item_price",R.string.price2);
        item15.put("is_food",R.string.is_true);
        item15.put("is_import",R.string.is_false);
        item15.put("item_image",R.drawable.food);
        listOfItems.add(item15);

        HashMap<String,Integer> item16 = new HashMap<>();
        item16.put("item_title",R.string.item_title1);
        item16.put("item_price",R.string.price1);
        item16.put("is_food",R.string.is_false);
        item16.put("is_import",R.string.is_false);
        item16.put("item_image",R.drawable.book1);
        listOfItems.add(item16);
    }
}
