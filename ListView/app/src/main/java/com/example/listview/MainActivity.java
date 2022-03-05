package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Tham chieu toi view tren giao dien
    //Tham chieu toi view nao thi tao doi tuong thanh phan thuoc lop do
    Button btnSubmit;
    //Khai bao doi tuong ListView de tham chieu toi listview tren giao dien
    ListView lstContact;
    //Khai bao Adapter de binding du lieu cho listview
    //Co nhieu loai Adapter, dac diem chung la ke thua tu BaseAdapter
    //Vi du dung ArrayAdapter de hien thi cac phan tu dang chuoi bang TextView
    ArrayAdapter<String> lstContactAdapter;
    //Khai bao ArrayList<String> la nguon du lieu cho listViewAdapter
    ArrayList<String> arrContact;
    EditText txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName = findViewById(R.id.txtName);
        //Tham chieu toi button tren giao dien
        btnSubmit = findViewById(R.id.btnSubmit);
        //Co the bat su kien cho mau sau
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txtName.getText().toString();
                arrContact.add(name);
                //cap nhat nguon du lieu cho ListAdapter
                lstContactAdapter.notifyDataSetChanged();
            }
        });
        //Tao du lieucho ListViewAdapter
        arrContact = new ArrayList<>();
        arrContact.add("Nguyen Thi Thu Ha");
        arrContact.add("Nguyen Thi Hoa");
        arrContact.add("Nguyen Thi Huyen");
        //Tao doi tuong ListViewAdapter
        //Tham so 1: Context - Lop cha cua lop Activity luu ngu canh ung dung
        //Tham so 2: Layout cua ListView
        //Tham so 3: du lieu
        lstContactAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item,
                arrContact);
        //Tham chieu toi listView va thiet lap Adapter
        lstContact=findViewById(R.id.lstContact);
        lstContact.setAdapter(lstContactAdapter);
        //bat su kien cho listView
        lstContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int posittion;
                Toast.makeText(MainActivity.this,
                        arrContact.get(i).toString(),
                        Toast.LENGTH_LONG).show();
            }
        });
        lstContact.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,
                        arrContact.get(i).toString(),
                        Toast.LENGTH_LONG).show();
                return false;
            }
        });


    }
}