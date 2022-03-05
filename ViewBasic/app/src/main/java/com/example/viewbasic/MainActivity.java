package com.example.viewbasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    ImageView imageView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        imageView = findViewById(R.id.imageView);
        button =findViewById(R.id.button);

        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

        Drawable img;
        img = AppCompatResources.getDrawable(this, R.drawable.r);
        imageView.setImageDrawable(img);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(MainActivity.this, MainActivity2.class);
                startActivity(i);
            }
        });
    }
}