package com.example.vd10;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mButtonSubmit;
    private TextView mTextResult;
    private EditText mTextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        addAction();
    }

    private void addAction() {
        mTextInput.setOnClickListener(this);

    }

    private void initView() {
        mButtonSubmit = findViewById(R.id.button_submit);
        mTextInput = findViewById(R.id.edit_input);
        mTextResult = findViewById(R.id.text_result);
    }

    @Override
    public void onClick(View view) {
        String input = mTextInput.getText().toString();
        mTextResult.setText(getResources().getString(R.string.message)+' '+input+'!'+getResources().getString(R.string.nice_day_msg));
    }
}