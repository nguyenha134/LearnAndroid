package com.example.monan;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MonAnAdapter extends ArrayAdapter {
    List<MonAn> lsMonAn;
    int resource;

    Context context;

    public  MonAnAdapter(Context context, int resource, List<MonAn> lsMonAn){
        super(context, resource, lsMonAn);
        this.context = context;
        this.resource = resource;
        this.lsMonAn=lsMonAn;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row = convertView;
        MonAnViewGroup viewGroup;
        //neu la null thi khoi tao doi tuong moi
        if(convertView==null){
            viewGroup = new MonAnViewGroup(getContext());
        }
        MonAn objMonAn = lsMonAn.get(position);
        //neu thong tin mon an khac null
        if(objMonAn!=null){
            TextView textMonAn = ((MonAnViewGroup)row).textTenMonAn;
            TextView textMoTa= ((MonAnViewGroup)row).textMoTa;
            ImageView imgAnh= ((MonAnViewGroup)row).imgAnh;

            //Lay thong tin cho cac widget
            textMonAn.setText(objMonAn.getTenMonAn());
            textMoTa.setText(objMonAn.getMoTa());
//            imgAnh.setImageResource(objMonAn.);



        }

        return super.getView(position, convertView, parent);
    }
}
