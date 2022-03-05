package com.example.bt_adapter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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
    EditText txtName;
    Button btnThem;
    Button btnXoa;
    ListView lstContact;
    ArrayAdapter<String> lstContactAdapter;
    MyAdapter lstStudentAdapter;
    ArrayList<Student> lstStudent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName = findViewById(R.id.txtName);
        btnThem = findViewById(R.id.btnThem);

        //Tao doi tuong ListViewAdapter
        //Tham so 1: Context - Lop cha cua lop Activity luu ngu canh ung dung
        //Tham so 2: Layout cua ListView
        //Tham so 3: du lieu
        lstStudent = new ArrayList<>();
        lstStudent.add(new Student(1, "Nguyen Thi Thu Ha", "015266444", false));
        lstStudent.add(new Student(2, "Nguyen Van Hoang", "015486444", false));
        lstStudent.add(new Student(3, "Nguyen Thuc Thuy Tien", "093666444", false));

        lstStudentAdapter = new MyAdapter(this, lstStudent);
        //Tham chieu toi ListView va thiet lap Adapter
        lstContact = findViewById(R.id.listViewInf);
        lstContact.setAdapter(lstStudentAdapter);
        //bat su kien cho listview

        btnXoa = findViewById(R.id.btnXoa);
        btnXoa.setOnClickListener((v) -> {
            new AlertDialog.Builder(this)
                    .setTitle("Xác nhận")
                    .setMessage("Bạn có muốn xóa các phần tử đã chọn không?")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            int n = lstStudent.size();
                            for (int t = n-1; t >= 0; t--) {
                                if(lstStudent.get(t).isStatus() == true){
                                    lstStudentAdapter.RemoveItem(t);
                                }
                            }
                            lstContact.setAdapter(lstStudentAdapter);
                        }
                    })
                    .setNegativeButton("Cancel", null)
                    .show();
        });
    }

}