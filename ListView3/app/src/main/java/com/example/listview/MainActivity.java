package com.example.listview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
//    private String[] listData;
    private ArrayList<String> listData;
    private ArrayAdapter<String> adapter;
    private Context context;
    private Button button, btnUpdate;
    private EditText editText;
    private int vitri=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        listView = (ListView) findViewById(R.id.lv);
        button = (Button) findViewById(R.id.btn);
        editText = (EditText) findViewById(R.id.edt);
        btnUpdate = (Button) findViewById(R.id.btnCapNhat);

         //Cach 1: Tao danh sach tu mang
        //listData=context.getResources().getStringArray(R.array.listVideo); //Lay du lieu tu string.xml
        //Cach 2: Gan du lieu truc tiep
//        listData = new String[]{
//                "Bài 1: Giới thiệu Android",
//                 "Bài 2: Cài đặt môi trường lập trình",
//                  "Bài 3: Tạo project HelloWord"
//        };
        //Cách 3:
        listData = new ArrayList<>();
        listData.add("Bài 1: Giới thiệu Android");
        listData.add("Bài 2: Cài đặt môi trường lập trình");
        listData.add("Bài 3: Tạo project HelloWord");

        adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, listData);

        listView.setAdapter((adapter));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = editText.getText().toString().trim();
                if(TextUtils.isEmpty(item)){
                    Toast.makeText(context, "Bạn chưa nhập dữ liệu", Toast.LENGTH_SHORT).show();
                    return;
                }
                listData.add(item);
                adapter.notifyDataSetChanged();
                //giup cap nhat du lieu trong lisview
            }
        });
        //Click vao tưng phan tu trong list se hien thu len ten chon
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(context, listData.get(i), Toast.LENGTH_SHORT).show();
                editText.setText(listData.get(i));
                vitri=i;
            }
        });
        //Cap nhat
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listData.set(vitri, editText.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        //Xoa
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                dialog.setTitle("Xác nhận");
                dialog.setMessage("Bạn có muốn xoá không?");
                dialog.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i1) {
                        listData.remove(i);
                        adapter.notifyDataSetChanged();
                    }
                });
                dialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
                return false;
            }
        });

    }
}