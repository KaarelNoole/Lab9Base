package com.nagel.lab9base;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;

public class ShoppingBasket {
    //List of items in the basket
    private final ArrayList<ShoppingItem> items = new ArrayList<>();

    public ArrayList<ShoppingItem> getItems() {
        return items;
    }

    //Returns the no. of items in the basket
    public final int noOfProductsTotal() {
        int x_amount;
        int sum = 0;
        for (ShoppingItem item : items) {
            x_amount = item.getAmount();
            sum += x_amount;
        }
        return sum;
    }

    //Returns the no. of unique (distinct) product types in the basket
    public final int noOfProductsUnique() {
        return items.size();
    }

    //Returns the total price sum of the basket, taking into account quantities and prices of individual items
    public final int getTotalPrice() {
        int x_price;
        int sum = 0;
        for (ShoppingItem item : items) {
            x_price = item.getPrice();
            sum += x_price;
        }
        return sum;
    }

    //Adds the given item to this shopping basket. If an item with the name already exists, the quantity of that item is updated
    public final void addItem(@NonNull ShoppingItem item){
        ShoppingItem existingItem = this.tryToFindExistingItem(item);
        if (existingItem != null){
            existingItem.setAmount(existingItem.getAmount() + 1);
        }else{
            this.items.add(item);
        }
    }

    //Returns existing item in the basket if it already exists based on name otherwise return null
    private ShoppingItem tryToFindExistingItem(ShoppingItem item){
        Iterator<ShoppingItem> iterator = this.items.iterator();
        ShoppingItem existingItem;
        do {
            if (!iterator.hasNext()){
                return null;
            }
            existingItem = iterator.next();
        }while (!existingItem.getName().equals(item.getName()));
        return existingItem;
    }
}
