package com.example.activity_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    public static int TRAVETU_ACTIVITY2 = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i = getIntent();
        String dulieu = i.getStringExtra("dulieu");

        EditText editText = findViewById(R.id.editText);
        editText.setText(dulieu);

        Button button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                String s = editText.getText().toString();
                i.putExtra("dulieu", s);

                setResult(TRAVETU_ACTIVITY2, i);
                finish();


            }
        });
    }
}