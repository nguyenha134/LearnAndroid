package com.example.monan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MonAnViewGroup extends LinearLayout {
    public TextView textTenMonAn;
    public TextView textMoTa;
    public ImageView imgAnh;

    public MonAnViewGroup(Context context){
        super(context);

        //Anh xa giao dien xml voi code
        LayoutInflater li = (LayoutInflater)getContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
         li.inflate(R.layout.monan_iem, this, false);
        textTenMonAn = findViewById(R.id.txtTenMA);
        textMoTa = findViewById(R.id.textMoTa);
        imgAnh = findViewById(R.id.imgVMonAn);
    }
}
