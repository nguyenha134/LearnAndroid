package com.example.monan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lvDoAn = findViewById(R.id.lvDS);

        //Lay danh sach mon an
        MonAnBusiness monAnBusiness = new MonAnBusiness();
        List<MonAn> lstMonAn = monAnBusiness.getListMonAn();
        MonAnAdapter monAnAdapter = new MonAnAdapter(this, R.layout.monan_iem, lstMonAn);
        lvDoAn.setAdapter(monAnAdapter);

    }
}