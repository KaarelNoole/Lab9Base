package com.nagel.lab9base;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    private ShoppingBasket myShoppingBasket;
    private ShoppingViewAdapter myShoppingAdapter;
    private SharedPreferences sharedPreferences;
    public static final String APP_PREFS = "SHOPPING_LIST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.test);

        this.sharedPreferences = getSharedPreferences(APP_PREFS,MODE_PRIVATE);
        this.myShoppingBasket = BasketStorageHelper.INSTANCE.loadBasket(sharedPreferences);

        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        ShoppingBasket basket = this.myShoppingBasket;
        if (basket != null){
            myShoppingAdapter = new ShoppingViewAdapter(myShoppingBasket);
        } else Toast.makeText(this, "basket null", Toast.LENGTH_SHORT).show();
        RecyclerView recyclerView = findViewById(R.id.shopping_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(myShoppingAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ShoppingBasket basket = myShoppingBasket;
        SharedPreferences prefs = sharedPreferences;
        if (basket == null || prefs == null) {
            Log.e(TAG, "onDestroy: myShoppingBasket exception");
            Log.e(TAG, "onDestroy: sharedPreferences exception");
        }else{
            BasketStorageHelper.INSTANCE.saveBasket(basket,prefs);
        }
    }

    public void onAddItemClick(View view) {
        EditText etItemToAdd = findViewById(R.id.etItemToAdd);
        String name = etItemToAdd.getText().toString();
        etItemToAdd.setText("");
        ShoppingItem newItem = new ShoppingItem(name);
        ShoppingBasket basket = this.myShoppingBasket;
        if (basket != null){
            basket.addItem(newItem);
        }else Log.e(TAG, "onAddItemClick: myShoppingBasket exception");
        myShoppingAdapter.notifyDataSetChanged();
        updateTotalCostView();
    }

    public void onClearItemClick(View view) {
        ShoppingBasket basket = myShoppingBasket;
        if (basket != null){
            basket.getItems().clear();
        }else Log.e(TAG, "onDestroy: myShoppingBasket exception");
        myShoppingAdapter.notifyDataSetChanged();
        updateTotalCostView();
    }

    private void updateTotalCostView() {
        ShoppingBasket basket = myShoppingBasket;
        if (basket != null){
            int totalCost = basket.getTotalPrice();
            TextView txtTotal = findViewById(R.id.txtTotal);
            txtTotal.setText((CharSequence) ("Total cost: € " + totalCost));
        } else Log.e(TAG, "updateTotalCostView: myShoppingBasket exception");
    }
}