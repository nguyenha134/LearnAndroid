package com.example.listnuoc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<Nuoc> arrayList;
    NuocAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lvNuoc);
        arrayList = new ArrayList<>();

        arrayList.add(new Nuoc("Việt Nam", "Hà Nội", R.drawable.vn));
        arrayList.add(new Nuoc("Pháp", "Pari", R.drawable.phap));
        arrayList.add(new Nuoc("Mỹ", "Tokyo", R.drawable.nhatban));
        arrayList.add(new Nuoc("Anh", "Maxcova", R.drawable.nga));
        adapter = new NuocAdapter(this, R.layout.dong_nuoc, arrayList);
        lv.setAdapter(adapter);
    }
}