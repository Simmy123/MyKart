package com.example.rsrimone.mycart;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

class MyCartDisplayAdapter extends RecyclerView.Adapter<MyCartDisplayAdapter.MycartDisplayViewHolder>{
    Product product;
    public MyCartDisplayAdapter(Product product) {
        this.product = product;
    }

    @Override
    public MyCartDisplayAdapter.MycartDisplayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_my_cart_display,parent,false);
        return new MycartDisplayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyCartDisplayAdapter.MycartDisplayViewHolder holder, int position) {
            holder.productId.setText("1");
            holder.brandName.setText(product.itemBrandName);
            holder.itemPrice.setText(product.price.toString());
            holder.itemType.setText(product.itemType);
    }

    @Override
    public int getItemCount() {
        return 0;
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
