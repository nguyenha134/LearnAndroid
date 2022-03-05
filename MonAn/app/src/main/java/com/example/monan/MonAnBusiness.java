package com.example.monan;

import java.util.ArrayList;
import java.util.List;

public class MonAnBusiness {
    //ham lay danh sach cac mon an Viet Nam
    public List<MonAn> getListMonAn(){
        List<MonAn> lstMonAn = new ArrayList<MonAn>();
        MonAn objBanhChung = new MonAn("Bánh chưng", "Món ăn ngày tết Việt Nam");
        lstMonAn.add(objBanhChung);
        MonAn objGio = new MonAn("Giò lụa", "Món ăn ngày tết Việt Nam");
        lstMonAn.add(objGio);
        MonAn objNem = new MonAn("Nem cuốn","Đặc sản Hải Phòng");
        lstMonAn.add(objNem);
        MonAn objBunCha = new MonAn("Bún chả", "Món ăn ngon Hà Nội");
        lstMonAn.add(objBunCha);
        MonAn objCanhCua = new MonAn("Canh cua", "Món ăn dân dã Việt Nam");
        lstMonAn.add(objCanhCua);
        MonAn objNemTai = new MonAn("Nem tai", "Món ăn Việt");
        lstMonAn.add(objNemTai);
        return lstMonAn;
    }
}
