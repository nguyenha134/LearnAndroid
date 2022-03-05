package com.example.bai_kiem_tra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editTextName;
    EditText editTextPhone;
    RadioButton rd1;
    RadioButton rd2;
    Spinner que;
    Button button;
    ListView lsContact;
    ArrayAdapter<String> lstContactAdapter;
    ArrayList<String> arrContact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = findViewById(R.id.editTextName);
        editTextPhone = findViewById(R.id.editTextPhone);
        rd1 = findViewById(R.id.radioButton);
        rd2 = findViewById(R.id.radioButton2);
        que = findViewById(R.id.spinner);
        button = findViewById(R.id.button);

        String QueQuan[] = {
                "Hà Nội",
                "Hưng Yên",
                "Hải Dương"
        };
        lstContactAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, QueQuan);
        que.setAdapter(lstContactAdapter);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Check() && Check2()) {

                    String i = "";
                    i += editTextName.getText().toString() + " - " + getGioiTinh() + " - " + editTextPhone.getText().toString() + " - " + que.getSelectedItem();
                    arrContact.add(i);
                    lstContactAdapter.notifyDataSetChanged();
                }

            }
        });

        arrContact = new ArrayList<>();
//        arrContact.add("Nguyen Hoang - Nam - 0358647155 - Hà Nội");

        lstContactAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, arrContact);
        lsContact = findViewById(R.id.lstContact);
        lsContact.setAdapter(lstContactAdapter);

        //Nhan gui vao 1 phan tu trong listView se toast  thong tin phan tu
        lsContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, lstContactAdapter.getItem(i), Toast.LENGTH_LONG).show();
            }
        });

        lsContact.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, lstContactAdapter.getItem(i), Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }
    String getGioiTinh(){
        if(rd1.isChecked()){
            return "Nam";
        }
        if(rd2.isChecked()){
            return "Nữ";
        }
        return "";
    }
    //Kiem tra chua chon gioi tinh, que quan
    boolean Check2(){
        boolean t = true;
        if(getGioiTinh().trim().length() == 0){
            Toast.makeText(MainActivity.this, "Bạn phải chọn giới tính", Toast.LENGTH_LONG).show();
            t=false;
        }
        if(que.getSelectedItem().toString().trim().length()==0){
            Toast.makeText(MainActivity.this, "Bạn phải chọn quê quán", Toast.LENGTH_LONG).show();
            t=false;
        }
        return  t;
    }
    //Kiem tra bo trong ho ten, sdt
    boolean Check(){
        boolean t = true;
        if(editTextName.getText().toString().trim().length() == 0){
            Toast.makeText(MainActivity.this, "Bạn phải nhập họ tên", Toast.LENGTH_LONG).show();
            t=false;
        }
        if(editTextPhone.getText().toString().trim().length()==0){
            Toast.makeText(MainActivity.this, "Bạn phải nhập số điện thoại", Toast.LENGTH_LONG).show();
            t=false;
        }
        return  t;
    }




}
