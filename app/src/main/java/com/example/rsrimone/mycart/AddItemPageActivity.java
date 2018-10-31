package com.example.rsrimone.mycart;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class AddItemPageActivity extends Activity {

    private SharedPreferences sharedPreferences;
    Button goToCartButton;
    FloatingActionButton addToCart;
    EditText itemBrandName;
    EditText itemCount;
    RadioGroup itemTypeRadioGroup;
    RadioButton importedItem;
    RadioButton nonImportedItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item_page);

        final Spinner itemName;

        itemName = findViewById(R.id.select_item_spinner);
        itemBrandName = findViewById(R.id.product_brand_name);
        itemCount = findViewById(R.id.item_count);
        itemTypeRadioGroup = findViewById(R.id.item_type);
        importedItem = findViewById(R.id.imported_item);
        nonImportedItem = findViewById(R.id.non_imported_item);
        goToCartButton = findViewById(R.id.go_to_cart);
        addToCart = findViewById(R.id.add_item_button);

        ArrayAdapter<CharSequence> dropDownAdapter =  ArrayAdapter.createFromResource(this,R.array.select_item_dropdown,android.R.layout.simple_spinner_dropdown_item);
        itemName.setAdapter(dropDownAdapter);

        sharedPreferences = getApplicationContext().getSharedPreferences("ItemList",MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("item_name",itemBrandName.getText().toString());
                System.out.println("----------Item Name   "+itemBrandName.getText());
                editor.commit();
                itemBrandName.setText("");
                itemCount.setText("");
            }
        });


        goToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sharedPreferences.contains("item_name")){
                    Toast.makeText(AddItemPageActivity.this, "Item Name is "+sharedPreferences.getString("item_name","hello"), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
