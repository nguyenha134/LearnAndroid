package com.example.listview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyAdpater extends BaseAdapter {
    //khai baó các biến thaành phần cho MyAdapter
    //1. ngu canh cua ung dung Context la lop cha cua Activity
    private Activity activity;
    //2. Nguon du lieu cho Adapter
    private ArrayList<Student> data;
    //3. bo phan tich layout
    private LayoutInflater inflater;
    //Viet ham tao cho MyAdapter
    public MyAdpater(Activity activity, ArrayList<Student> data) {
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
    //ham tra ve phan tich va tra ve view cua 1 phan tu trong listview
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v =view;
        if(v==null){
            //phan tich layout da tao cho ă phan tu cua listview
            v= inflater.inflate(R.layout.list_item, null);
            //tham chieu den tung view va trinh bay du lieu len view
            TextView txtFullName = v.findViewById(R.id.txtName);
            txtFullName.setText(data.get(i).getFullName());
            TextView txtPhoneNumber = v.findViewById(R.id.txtNumber);
            txtPhoneNumber.setText(data.get(i).getPhoneNum());
            TextView txtAddress = v.findViewById(R.id.txtAdress);
            txtAddress.setText(data.get(i).getAddress());
        }
        return null;
    }
}
