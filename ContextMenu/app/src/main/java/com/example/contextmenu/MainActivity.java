package com.example.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editSearch = (EditText)findViewById(R.id.editSearch);
        //Dang ki su dung menu context
        registerForContextMenu(editSearch);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //Anh xa menu tren giao dien vao ung dung
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Chức năng").setHeaderIcon(android.R.drawable.ic_menu_info_details);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Action bar - popup menu
        //        menu.add(0,1,1,"Add");
//        menu.add(0,2,2,"Edit");
//        menu.add(0,3,3,"Delete");
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_context, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_item_add:
                Toast.makeText(this, "Bạn vừa chọn chức năng "+item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_item_edit:
                Toast.makeText(this, "Bạn vừa chọn chức năng "+item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_item_delete:
                Toast.makeText(this, "Bạn vừa chọn chức năng "+item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    public void btnShowPopupClick(View v){
        PopupMenu popupMenu = new PopupMenu(this,v);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_context, popupMenu.getMenu());
        popupMenu.show();
    }
}