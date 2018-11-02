package com.example.rsrimone.mycart;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class MyCartDisplayAdapter extends RecyclerView.Adapter<MyCartDisplayAdapter.MycartDisplayViewHolder>{
    Product product;
    List<Product> productList;

    public MyCartDisplayAdapter(List<Product> productList) {
        this.productList =productList;
    }

    @Override
    public MyCartDisplayAdapter.MycartDisplayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_my_cart_display,parent,false);
        return new MycartDisplayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyCartDisplayAdapter.MycartDisplayViewHolder holder, int position) {
            holder.productId.setText("1");
            holder.brandName.setText(productList.get(position).itemBrandName);
            holder.itemPrice.setText(productList.get(position).price.toString());
            holder.itemType.setText(productList.get(position).itemType);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
    class MycartDisplayViewHolder extends RecyclerView.ViewHolder {
        TextView productId;
        TextView brandName;
        TextView itemType;
        TextView itemPrice;

        public MycartDisplayViewHolder(View view) {
            super(view);
            this.productId = view.findViewById(R.id.item_id);
            this.brandName = view.findViewById(R.id.item_brand_name);
            this.itemType = view.findViewById(R.id.list_item_type);
            this.itemPrice = view.findViewById(R.id.list_item_price);
        }
    }
}
