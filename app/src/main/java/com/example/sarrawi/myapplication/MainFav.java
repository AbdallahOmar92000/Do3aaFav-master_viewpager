package com.example.sarrawi.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.example.sarrawi.myapplication.adapter.Adapter;
import com.example.sarrawi.myapplication.adapter.ListProductAdapter;
import com.example.sarrawi.myapplication.database.DatabaseHelper;
import com.example.sarrawi.myapplication.model.Product;

import java.util.List;

public class MainFav extends AppCompatActivity {
    private ListView lvProduct;
    private Adapter adapter;
    private List<Product> mProductList;
    private DatabaseHelper mDBHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main_fav);


        lvProduct = (ListView)findViewById(R.id.listview_product);
        mDBHelper = new DatabaseHelper(this);
        //Get product list in db when db exists
        mProductList = mDBHelper.DataFaVourit();
//        mProductList = mDBHelper.getListProduct();
        //Init adapter
        adapter = new Adapter(this, mProductList);
        //Set adapter for listview
        lvProduct.setAdapter(adapter);
    }

}
