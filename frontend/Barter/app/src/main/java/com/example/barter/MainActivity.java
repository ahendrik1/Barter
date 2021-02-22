package com.example.barter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.barter.model.Product;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;

    ListView sellProductList;
    Product[] sellProducts;
    String[] months;

    ProductAdapter pAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);

        setSupportActionBar(toolbar);

        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.logout).setVisible(false);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.buy);

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET,
                "http://192.168.1.104:8080/products",
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.e("Rest response", response.toString());
                        Gson gson = new Gson();
                        Product[] productArray = gson.fromJson(response.toString(), Product[].class);
                        System.out.println(productArray);
                        ArrayList<Product> pList = new ArrayList<Product>();
                        Collections.addAll(pList, productArray);
                        populateProductsList(pList);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("error response", error.toString());
                    }
                });

        requestQueue.add(jsonObjectRequest);
    }

    private void populateProductsList(ArrayList<Product> productsList){

        // Create the adapter to convert the array to views
        pAdapter = new ProductAdapter(this, productsList);
        // Attach the adapter to a ListView
        sellProductList = (ListView) findViewById(R.id.sell_list);
        pAdapter = new ProductAdapter(this, productsList);
        sellProductList.setAdapter(pAdapter);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch(item.getItemId()) {
            case R.id.buy:
                break;

            case R.id.sell:
                intent = new Intent(MainActivity.this, SellActivity.class);
                startActivity(intent);
                break;

            case R.id.login:
                intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}