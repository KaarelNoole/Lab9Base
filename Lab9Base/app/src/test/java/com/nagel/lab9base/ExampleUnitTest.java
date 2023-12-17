package com.nagel.lab9base;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public
    void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    public ShoppingItem egg;
    public ShoppingBasket basket;


    @Before
    public void setup(){
        // TODO - add some code to re-use between test cases, e.g. create an empty basket, some items
        this.basket = new ShoppingBasket();
        this.egg = new ShoppingItem("Egg");
    }

    @Test
    public void shoppingItem_priceFromNameWorks() {
        //TODO - test if item price is correctly set based on ShoppingItem name length
        ShoppingItem item = new ShoppingItem("Milk");
        assertEquals(4,item.getPrice());
    }

    @Test
    public void basket_totalPriceCalculationWorks(){
        // TODO validate behaviour of getTotalPrice() in ShoppingBasket class
        ShoppingBasket basket = new ShoppingBasket();
        basket.addItem(new ShoppingItem("Egg"));
        basket.addItem(new ShoppingItem("Coffee"));
        int price = basket.getTotalPrice();
        assertEquals(9,price);
    }

    @Test
    public void baske_totalPriceCalculationWithDuplicatesWorks(){
        ShoppingBasket basket = new ShoppingBasket();
        basket.addItem(new ShoppingItem("Egg"));
        basket.addItem(new ShoppingItem("Egg"));
        basket.addItem(new ShoppingItem("Coffee"));
        int price = basket.getTotalPrice();
        assertEquals(12,price);
    }

    @Test
    public void basket_addingUniqueItemsIncreasesBasketSize(){
        // TODO validate noOfProductsUnique() function of ShoppingBasket class  after adding items
        basket.addItem(egg);
        basket.addItem(egg);
        basket.addItem(new ShoppingItem("Milk"));
        int uniqueProduct = basket.noOfProductsUnique();
        assertEquals(2,uniqueProduct);
    }

    @Test
    public void basket_addingSameNameItemTwice(){
        // TODO adding item with identical name should not increase unique item count, but should increase items quantity
        basket.addItem(egg);
        basket.addItem(egg);
        int eggAmount = basket.getItems().get(0).getAmount();
        assertEquals(2,eggAmount);
    }

    //TODO: add any other test cases you need to get 100% line coverage for ShoppingBasket
    @Test
    public void baskeytNoOfProductsTotalWorks(){
        assertEquals(0,basket.noOfProductsTotal());
        basket.addItem(new ShoppingItem("Watermelon"));
        basket.addItem(new ShoppingItem("Watermelon"));
        assertEquals(2,basket.noOfProductsTotal());
    }


}