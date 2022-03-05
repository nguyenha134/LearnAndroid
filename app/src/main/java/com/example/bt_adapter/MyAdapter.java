package com.example.bt_adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private Activity activity;
    //2. Nguon du lieu cho Adapter
    private ArrayList<Student> data;
    //3. bo phan tich layout
    private LayoutInflater inflater;
    //Viet ham tao cho MyAdapter
    public MyAdapter(Activity activity, ArrayList<Student> data) {
        this.activity = activity;
        this.data = data;
        //Tao doi tuong phan tich Layout
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    //Ham tra ve so phan tu cua listView
    @Override
    public int getCount() {
        return data.size();
    }
    //Ham tra ve phan tu o vi tri position
    @Override
    public Object getItem(int i) {
        return data.get(i);
    }
    //ham tra ve id cua phan tu o vi tri position
    @Override
    public long getItemId(int i) {
        Student s = data.get(i);
        return s.getId();
    }

    public void RemoveItem(int position){
        data.remove(position);

    }
    //ham tra ve phan tich va tra ve view cua 1 phan tu trong listview
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v =view;
        if(v==null){
            //phan tich layout da tao cho ă phan tu cua listview
            v= inflater.inflate(R.layout.item_list, null);
            //tham chieu den tung view va trinh bay du lieu len view
            TextView txtFullName = v.findViewById(R.id.txtName);
            txtFullName.setText(data.get(i).getName());
            TextView txtPhoneNumber = v.findViewById(R.id.txtPhoneNumber);
            txtPhoneNumber.setText(data.get(i).getPhoneNumber());
            CheckBox cb = v.findViewById(R.id.checkBox);
            cb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    data.get(i).setStatus(cb.isChecked());
                }
            });
            cb.setChecked(data.get(i).isStatus());
//            cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                    data.get(i).setStatus(b);
//                }
//            });

        }
        return v;
    }



}
