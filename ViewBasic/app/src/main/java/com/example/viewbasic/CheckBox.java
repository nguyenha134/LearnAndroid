package com.example.viewbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

public class CheckBox extends AppCompatActivity {

    CheckBox pa1, pa2,pa3,pa4;
    Button kiemtra, goiy;

    public CheckBox() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
//        pa1 = findViewById(R.id.cb1);
//        pa2 = findViewById(R.id.cb2);
//        pa3 = findViewById(R.id.cb3);
//        pa4 = findViewById(R.id.cb4);
//
//        pa1.OnCheckedChangeListener(mListener);
//        pa2.OnCheckedChangeListener(mListener);
//        pa3.OnCheckedChangeListener(mListener);
//        pa4.OnCheckedChangeListener(mListener);
//
//
//
//        kiemtra = findViewById(R.id.btnInspector);
//        goiy = findViewById(R.id.btnSuggest);
//
//        kiemtra.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(pa3.isChecked() && (!pa1.isChecked()) && (!pa2.isChecked()) && (!pa4.isChecked()) ){
//                    kiemtra.setText("Bạn đã làm đúng");
//
//                }
//                else{
//                    kiemtra.setText("Bạn đã làm sai");
//                }
//            }

//        });

    }

//    CompoundButton.OnCheckedChangeListener mListener = new CompoundButton.OnCheckedChangeListener() {
//        @Override
//        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//            if(compoundButton.getId()==R.id.pa4){
//                if(b){
//                    pa1.setChecked(false);
//                    pa2.setChecked(false);
//                    pa2.setChecked(false);
//
//                    pa1.setEnabled(false);
//                    pa2.setEnabled(false);
//                    pa3.setEnabled(false);
//
//                }
//                else{
//                    pa1.setEnabled(true);
//                    pa2.setEnabled(true);
//                    pa3.setEnabled(true);
//                }
//            }
//
//        }
//    }


}