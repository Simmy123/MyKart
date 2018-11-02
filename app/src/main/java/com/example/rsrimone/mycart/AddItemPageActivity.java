package com.example.rsrimone.mycart;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

import static android.view.inputmethod.EditorInfo.IME_ACTION_DONE;

public class AddItemPageActivity extends Activity {

    Button goToCartButton;
    FloatingActionButton addToCart;
    EditText itemBrandName;
    EditText itemCount;
    RadioGroup itemTypeRadioGroup;
    RadioButton importedItem;
    RadioButton nonImportedItem;
    TextView itemPrice;
    Product product;
    List<Product> productList;
    Gson gson;
    Double price = 0.0;
    public SharedPreferences sharedPreferences;
    private String itemType;

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
        itemPrice = findViewById(R.id.item_price);

        final ArrayAdapter<CharSequence> dropDownAdapter = ArrayAdapter.createFromResource(this, R.array.select_item_dropdown, android.R.layout.simple_spinner_dropdown_item);
        itemName.setAdapter(dropDownAdapter);

        sharedPreferences = getApplicationContext().getSharedPreferences("ItemList", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product = new Product(itemBrandName.getText().toString(),
                        itemType,
                        importedItem.isChecked(),
                        Double.valueOf(itemPrice.getText().toString()),
                        Integer.valueOf(itemCount.getText().toString()));

                editor.putString("product", convertToJson(product));
                editor.commit();

                itemBrandName.setText("");
                itemCount.setText("");
                itemPrice.setText("");
                itemName.setAdapter(dropDownAdapter);
                importedItem.setChecked(false);
                nonImportedItem.setChecked(false);
            }
        });

        goToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MyCartPageActivity.class);
                startActivity(intent);
            }
        });

        itemName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                itemType = parent.getItemAtPosition(position).toString();
                switch (position) {
                    case 0:
                        price = 10.0;
                        break;
                    case 1:
                        price = 11.0;
                        break;
                    case 2:
                        price = 12.0;
                        break;
                    case 3:
                        price = 13.0;
                        break;
                    case 4:
                        price = 14.0;
                        break;
                    case 5:
                        price = 15.0;
                        break;
                    case 6:
                        price = 16.0;
                        break;
                    case 7:
                        price = 17.0;
                        break;
                    case 8:
                        price = 18.0;
                        break;
                    default:
                        price = 0.0;
                }

                if (!itemType.contentEquals("") && !itemCount.getText().toString().contentEquals("")) {
                    price = price * (Double.valueOf(itemCount.getText().toString()));
                }
                itemPrice.setText("" + price);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        itemCount.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == IME_ACTION_DONE) {
                    if(itemCount.getText().toString().equals("0"))
                    {
                        itemCount.setError("Minimum of 1 should be selected");
                        itemCount.setText("1");
                    }
                    price = price * (Double.valueOf(itemCount.getText().toString()));
                    itemPrice.setText("" + price);
                    itemCount.clearFocus();
                    itemBrandName.clearFocus();
                    return true;
                } else {
                    return false;
                }
            }
        });
    }

    private String convertToJson(Object product) {
        gson = new Gson();
        String json = gson.toJson(product);
        return json;
    }

}
