package com.example.sarrawi.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sarrawi.myapplication.database.DatabaseHelper;
import com.example.sarrawi.myapplication.model.Adapter_zekr;
import com.example.sarrawi.myapplication.model.Product;

import java.util.List;

public class Text extends AppCompatActivity {
    private List<Adapter_zekr> mProductLists;
    private DatabaseHelper mDBHelper;
    int titleID;
    String x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        Intent i=getIntent();
        TextView tv= findViewById(R.id.textView);
        mDBHelper =new DatabaseHelper(this);
        mProductLists=mDBHelper.getAllPrayerzekr();
        if (i.getExtras()!=null) {
            titleID = i.getExtras().getInt("titleID");
            Toast.makeText(this, String.valueOf(titleID), Toast.LENGTH_SHORT).show();
            tv.setText(mProductLists.get(titleID).getDescription());
        }
        else
        {
            titleID=1;
        }





    }
}
