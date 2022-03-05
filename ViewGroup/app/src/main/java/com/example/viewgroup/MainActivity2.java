package com.example.viewgroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    RadioButton nam,nu;
    CheckBox javascipt, java, ruby, flutter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nam = (RadioButton) findViewById(R.id.rdoNam);
        nu = (RadioButton) findViewById(R.id.rdoNu);

        javascipt = (CheckBox) findViewById(R.id.cb1);
        javascipt.setOnClickListener(this);
        java = (CheckBox) findViewById(R.id.cb2);
        java.setOnClickListener(this);
        flutter = (CheckBox) findViewById(R.id.cb3);
        flutter.setOnClickListener(this);
        ruby = (CheckBox) findViewById(R.id.cb4);
        ruby.setOnClickListener(this);

        if (nam.isChecked())
            Toast.makeText(getApplication(), "Bạn đã chọn gioi tinh " + nam.getText(), Toast.LENGTH_LONG).show();
        else if (nu.isChecked())
            Toast.makeText(getApplication(), "Bạn đã chọn gioi tinh " + nu.getText(), Toast.LENGTH_LONG).show();
    }

        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.cb1:
                    if (javascipt.isChecked())
                        Toast.makeText(getApplicationContext(), "Android", Toast.LENGTH_LONG).show();
                    break;
                case R.id.cb2:
                    if (java.isChecked())
                        Toast.makeText(getApplicationContext(), "Java", Toast.LENGTH_LONG).show();
                    break;
                case R.id.cb3:
                    if (flutter.isChecked())
                        Toast.makeText(getApplicationContext(), "PHP", Toast.LENGTH_LONG).show();
                    break;
                case R.id.cb4:
                    if (ruby.isChecked())
                        Toast.makeText(getApplicationContext(), "Python", Toast.LENGTH_LONG).show();
                    break;
            }
        }




}