package com.example.view;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(Color.GREEN);

        TextView textView = new TextView(this);
        textView.setText("Nguyen Thi Thu Ha");
        textView.setTextColor(Color.BLACK);
        layout.addView(textView);

        Button bt = new Button(this);
        bt.setText("Next");
        LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        bt.setLayoutParams(pr);
        layout.addView(bt);

        EditText editText = new EditText(this);
        editText.setHint("Enter your name");
        layout.addView(editText);

        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.a);
        layout.addView(imageView);

        setContentView(layout);



    }
}