package com.example.gridviewlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lsWeek = findViewById(R.id.lvWeeks);

        List<String> lstWeeks = getListDataWeeks();
        //Khai bao 1 doi tuong de hien thi len listview
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, lstWeeks);
        //hien thi len listview
        lsWeek.setAdapter(adapter);

        //lay su kien khi ng dung nhan vao tung item
        lsWeek.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String strDayName = lstWeeks.get(i);
                Toast.makeText(MainActivity.this, "Bạn vừa chọn " +strDayName, Toast.LENGTH_SHORT).show();
            }
        });

        //khai bao 1 tap thong tin
        String[] arrThongTin = new String[]{"FaceBook", "Twitter", "LinkIn", "Google", "Zalo", "Viber"};

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item, arrThongTin);

        //Lay gridView de hien thi du lieu
        GridView gvChar = findViewById(R.id.grvWeek);
        //Thiet lap du lieu cho gridview
        gvChar.setAdapter(arrayAdapter);
    }

    private List<String> getListDataWeeks(){
        List<String> lstWeeks = new ArrayList<String>();
        lstWeeks.add("Monday");
        lstWeeks.add("Tuesday");
        lstWeeks.add("Wednesday");
        lstWeeks.add("Thursday");
        lstWeeks.add("Friday");
        lstWeeks.add("Saturday");
        lstWeeks.add("Sunday");
        return lstWeeks;

    }
}