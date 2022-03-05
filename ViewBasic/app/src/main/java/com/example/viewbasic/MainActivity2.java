package com.example.viewbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    EditText editText;
    Button button;
    ListView listView;
    ArrayAdapter<String> lstContactAdapter;
    ArrayList<String> arr;
    Button btnPre;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText = findViewById(R.id.editText2);
        button = findViewById(R.id.button2);
        btnPre = findViewById(R.id.btnPrev);
        btnNext = findViewById(R.id.btnNext);
        btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(MainActivity2.this, MainActivity.class);
                startActivity(i);
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(MainActivity2.this, CheckBox.class);
                startActivity(i);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = editText.getText().toString();
                arr.add(a);
                lstContactAdapter.notifyDataSetChanged();
            }
        });

        arr = new ArrayList<>();
        arr.add("Nguyen Thu Ha");
        arr.add("Nguyen Vy");

        lstContactAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, arr);
        listView = findViewById(R.id.lstContact);
        listView.setAdapter(lstContactAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity2.this, arr.get(i).toString(), Toast.LENGTH_LONG).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity2.this, arr.get(i).toString(), Toast.LENGTH_LONG).show();
                return false;
            }
        });



    }
}