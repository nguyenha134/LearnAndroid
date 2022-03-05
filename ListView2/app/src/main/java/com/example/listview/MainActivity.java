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
    Button btnSubmit;
    ListView lstContact;
    ArrayAdapter<String> lstContactAdapter;
    ArrayList<String> arrContact;
    MyAdpater lstStudentAdapter;
    ArrayList<Student> lstStudent;
    EditText txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName = findViewById(R.id.editText);
        //Tham chieu toi button tren giao dien
        btnSubmit = findViewById(R.id.btnSubmit);
        //Co the bat su kien theo mau sau
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txtName.getText().toString();
                arrContact.add(name);
                //cap nhat nguon du lieu cho ListAdapter
                lstContactAdapter.notifyDataSetChanged();
            }
        });
        //tao du lieu cho ListView Adapter
        arrContact = new ArrayList<>();
        arrContact.add("Nguyen Thi Thu Ha");
        arrContact.add("Nguyen Thai Tuong Vy");
        arrContact.add("Nguyen Thi Huyen");
        //Tao doi tuong ListViewAdapter
        //Tham so 1: Context - Lop cha cua lop Activity luu ngu canh ung dung
        //Tham so 2: Layout cua ListView
        //Tham so 3: du lieu
        lstStudent = new ArrayList<>();
        lstStudent.add(new Student(1, "Nguyen Van A", "015666444", "HN"));
        lstStudent.add(new Student(2, "Nguyen Van B", "015666444", "HY"));
        lstStudent.add(new Student(3, "Nguyen Van C", "015666444", "HN"));

        lstStudentAdapter = new MyAdpater(this, lstStudent);
        lstContactAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item,
                arrContact);
        //Tham chieu toi ListView va thiet lap Adapter
        lstContact = findViewById(R.id.lstContact);
        lstContact.setAdapter(lstContactAdapter);
        lstContact.setAdapter(lstStudentAdapter);
        //bat su kien cho listview
        lstContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,
                        arrContact.get(i).toString(), Toast.LENGTH_LONG).show();
            }
        });
        lstContact.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, arrContact.get(i).toString(),
                        Toast.LENGTH_LONG).show();
                return false;
            }
        });


    }
}