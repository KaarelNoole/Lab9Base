package com.nagel.lab9base;

import android.text.TextUtils;

import androidx.annotation.NonNull;

public class ShoppingItem {

    private int price;
    private int amount;
    private String name;

    public ShoppingItem(String name) {
        this.name = name;
        this.price = this.name.length();
        this.amount = 1;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public final String getReformattedName(){
        return TextUtils.isDigitsOnly((CharSequence) this.name) ? "Product #" + this.name : this.name;
    }

    @NonNull
    @Override
    public String toString() {
        return this.name + " price: " + this.price +" amount " + this.amount;
    }
}
