package com.nagel.lab9base;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.nagel.lab9base", appContext.getPackageName());
    }


    @Test
    public void loadingBasketState() {
        // If a certain .json is already contained in SharedPreferences, does BasketStorageHelper read it in correctly?
        // TODO: preparing test - Put a json representation of basket in preferences and save it
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        SharedPreferences sharedPrefs = appContext.getSharedPreferences("testFile",Context.MODE_PRIVATE);
        String json = "{ 'items' : [{'name':'Egg', 'price':3, 'amount':2}] }";
        sharedPrefs.edit().putString(BasketStorageHelper.KEY_JSON_BASKET,json).commit();

        // TODO:
        //  1. use BasketStorageHelper.loadBasket() to load the basket object
        ShoppingBasket loadedBasket = BasketStorageHelper.INSTANCE.loadBasket(sharedPrefs);
        assertEquals(2,loadedBasket.noOfProductsTotal());
        assertEquals(1,loadedBasket.noOfProductsUnique());
        assertEquals("Egg",loadedBasket.getItems().get(0).getName());
    }

    @Test
    public void savingBasketState() {
        // TODO validate that calling BasketStorageHelper.saveBasket( ) actually puts the right json into SharedPreferences

        // 1. Create A Basket with items
        // 2. Save it with BasketStorageHelper
        // 3. validate that preferences contains the right data with
        //  prefs.getString(BasketStorageHelper.KEY_JSON_BASKET, null)
        // In this app, we expect BasketStorageHelper to write to sharedPreferences using GSON, so
        // either try to construct a Basket from the stored Preferences data and verify it is correct like so:
        // ShoppingBasket basketFromJson = (new Gson()).fromJson(jsonString, ShoppingBasket.class); or
        // we see the expected string json format with: String expectedResult = (new Gson()).toJson(basket);

    }
}