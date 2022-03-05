package com.example.bthadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_user extends AppCompatActivity {
    EditText editName;
    EditText editPhone;
    EditText editId;
    Button btnOK;
    Button btnHuy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        editId = findViewById(R.id.editID);
        editName = findViewById(R.id.editName);
        editPhone = findViewById(R.id.editPhone);

        btnOK=findViewById(R.id.btnAdd);
        btnHuy = findViewById(R.id.btnCancel);
        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        if(bundle!=null){
            int id = bundle.getInt("Id");
            String name = bundle.getString("Name");
            String phone = bundle.getString("Phone");
            editId.setText(String.valueOf(id));
            editName.setText(name);
            editPhone.setText(phone);
            btnOK.setText("Edit");
        }



        btnOK.setOnClickListener((v)->{
            if(check())
            {
                Them();
            }
        });

        btnHuy.setOnClickListener((v)->{
            Intent intent = new Intent(Add_user.this, MainActivity.class);
            setResult(202, intent);
            finish();
        });

    }

    void Them(){
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("Id", editId.getId());
        bundle.putString("Name", editName.getText().toString());
        bundle.putString("Phone", editName.getText().toString());

        intent.putExtras(bundle);

        setResult(200,intent);
        if(btnOK.getText()=="Edit")
            setResult(201,intent);
        finish();
    }

    boolean check(){
        String t = "";
        if(editName.getText().toString().trim().length()==0)
        {
            t+="Họ tên không theer trống \n";
        }
        if(editId.getText().toString().trim().length()==0){
            t+="Id không thể trống \n";
        }
        if(editPhone.getText().toString().trim().length()==0)
        {
            t+="SDT không thể trống \n";
        }
        if(t!=""){
            Toast.makeText(this, t, Toast.LENGTH_LONG).show();
            return  false;
        }
        return  true;
    }


}