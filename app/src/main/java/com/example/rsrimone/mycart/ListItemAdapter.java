package com.example.rsrimone.mycart;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ListItemHolder> {

    ArrayList<HashMap<String, Integer>> listOfItems;
    Activity activity;

    private final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            System.out.println("----Details------");
        }
    };

    public ListItemAdapter(Activity activity,ArrayList<HashMap<String, Integer>> listOfItems) {
        this.listOfItems = listOfItems;
        this.activity = activity;
    }

    @Override
    public ListItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_home_list_item,parent,false);
        view.setOnClickListener(onClickListener);
        return new ListItemHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListItemHolder holder, final int position) {
        holder.itemName.setText(listOfItems.get(position).get("item_title"));
        holder.imageView.setImageResource(listOfItems.get(position).get("item_image"));
        holder.price.setText(listOfItems.get(position).get("item_price"));

        holder.itemName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Item is addded into Cart", Toast.LENGTH_SHORT).show();
                Double priceInclusiveOfTax=0.0;
                if (listOfItems.get(position).get("is_import") == 1) {
                    priceInclusiveOfTax = (listOfItems.get(position).get("item_price")) * 1.05;
                    if (listOfItems.get(position).get("is_food") == 1) {
                        priceInclusiveOfTax = listOfItems.get(position).get("is_food") * 1.1;
                    }
                    Toast.makeText(view.getContext(), "the price is  " + priceInclusiveOfTax, Toast.LENGTH_SHORT).show();
                } else if (listOfItems.get(position).get("is_food") == 1) {
                    priceInclusiveOfTax = listOfItems.get(position).get("is_food") * 1.1;
                }
                Toast.makeText(view.getContext(), "the price is  " + priceInclusiveOfTax, Toast.LENGTH_SHORT).show();
            }

        });
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return listOfItems.size();
    }

    class ListItemHolder extends RecyclerView.ViewHolder {

        TextView itemName;
        TextView price;
        ImageView imageView;

        public ListItemHolder(View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.list_item_name);
            price = itemView.findViewById(R.id.list_item_price);
            imageView = itemView.findViewById(R.id.list_item_image);
        }
    }
}
