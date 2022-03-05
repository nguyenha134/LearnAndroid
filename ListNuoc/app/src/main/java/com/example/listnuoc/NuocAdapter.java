package com.example.listnuoc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class NuocAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<Nuoc> nuocList;

    public NuocAdapter(Context context, int layout, List<Nuoc> nuocList) {
        this.context = context;
        this.layout = layout;
        this.nuocList = nuocList;
    }

    @Override
    public int getCount() {
        return nuocList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        TextView tvTenNuoc, tvThuDo;
        ImageView imgCo;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        if(view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            viewHolder = new ViewHolder();
            //anh xa
            viewHolder.tvTenNuoc = (TextView) view.findViewById(R.id.tvTenNuoc);
            viewHolder.tvThuDo = (TextView) view.findViewById(R.id.tvThuDo);
            viewHolder.imgCo = (ImageView) view.findViewById(R.id.imgCo);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        //gan gia tri
        viewHolder.tvTenNuoc.setText(nuocList.get(i).tenNuoc);
        viewHolder.tvThuDo.setText(nuocList.get(i).thuDo);
        viewHolder.imgCo.setImageResource(nuocList.get(i).hinhAnh);
        return view;
    }
}
