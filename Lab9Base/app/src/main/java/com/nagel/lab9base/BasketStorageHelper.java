package com.nagel.lab9base;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;
import com.google.gson.Gson;

// Helper class that stores/loads baskets into sharedPreferences in JSON format
public final class BasketStorageHelper {

    public static final String KEY_JSON_BASKET = "PREFERENCE_BASKET";
    public static final BasketStorageHelper INSTANCE;
    private BasketStorageHelper() {
    }
    static { INSTANCE = new BasketStorageHelper(); }

    public final void saveBasket(@NonNull ShoppingBasket basket, @NonNull SharedPreferences sharedPreferences){
        String json = (new Gson()).toJson(basket);
        sharedPreferences.edit().putString(KEY_JSON_BASKET,json).apply();
    }

    public final ShoppingBasket loadBasket(@NonNull SharedPreferences sharedPreferences){
        String storedJson = sharedPreferences.getString(KEY_JSON_BASKET,null);
        //If no previous basket saved, then create a new one
        if (storedJson != null){
            return new Gson().fromJson(storedJson,ShoppingBasket.class);
        } else return new ShoppingBasket();
    }
}
