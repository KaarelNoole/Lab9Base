package com.nagel.lab9base;

import static org.junit.Assert.assertEquals;

import android.os.Build;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = {Build.VERSION_CODES.P})
public class RobolectricUnitTest {

    @Test
    public void shoppingItemReformattedNameWorks(){
        ShoppingItem item = new ShoppingItem("12345");
        String newName = item.getReformattedName();
        assertEquals("Product #12345",newName);
    }
}
