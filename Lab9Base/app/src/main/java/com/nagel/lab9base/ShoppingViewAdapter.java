package com.nagel.lab9base;

import android.view.*;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ShoppingViewAdapter extends RecyclerView.Adapter<ShoppingViewAdapter.ShoppingViewHolder>{

    private final ShoppingBasket shoppingBasket;

    public ShoppingViewAdapter(ShoppingBasket shoppingBasket) {
        this.shoppingBasket = shoppingBasket;
    }

    @NonNull
    @Override
    public ShoppingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.basket_item,parent,false);
        return new ShoppingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingViewHolder holder, int position) {
        ShoppingItem shoppingItem = shoppingBasket.getItems().get(position);
        TextView txtItemName = holder.itemView.findViewById(R.id.txtItemName);
        TextView txtItemPrice = holder.itemView.findViewById(R.id.txtItemPrice);
        TextView txtItemAmount = holder.itemView.findViewById(R.id.txtItemAmount);
        txtItemName.setText(shoppingItem.getName());
        txtItemPrice.setText(String.valueOf(shoppingItem.getPrice()));
        txtItemAmount.setText(String.valueOf(shoppingItem.getAmount()));
    }

    @Override
    public int getItemCount() {
        return shoppingBasket.getItems().size();
    }

    public static class ShoppingViewHolder extends RecyclerView.ViewHolder{
        public ShoppingViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
