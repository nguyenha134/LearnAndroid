package com.example.bthadapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RemoteViews;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText txtName;
    Button btnThem;
    Button btnXoa;
    ListView lstContact;
    ArrayAdapter<String> lstContactAdapter;
    MyAdapter lstStudentAdapter;
    ArrayList<Student> lstStudent;
    int selectedid=-1;
    String phone;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menuitem, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
                case R.id.mnuSortByPhone:
                    Sort(0);
                    break;
                case R.id.mnuSortById:
                    Sort(1);
                    break;
                case R.id.mnuSortByName:
                    Sort(2);
                    break;
                case R.id.mnuAdd:
                    ThemMoiActivity();
                    break;

            }

            return super.onOptionsItemSelected(item);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnuEdit:

                Intent intent = new Intent(MainActivity.this, Add_user.class);
                Bundle bundle = new Bundle();

                bundle.putInt("Id", lstStudent.get(selectedid).getId());
                bundle.putString("Name", lstStudent.get(selectedid).getName());
                bundle.putString("Phone", lstStudent.get(selectedid).getPhoneNumber());
                intent.putExtras(bundle);
                startActivityForResult(intent, 200);
                break;
            case R.id.mnuDelete:
                lstStudent.remove(selectedid);
                lstStudentAdapter.notifyDataSetChanged();
                lstContact.setAdapter(lstStudentAdapter);
                Toast.makeText(this, "Đã xóa", Toast.LENGTH_LONG).show();
            case R.id.mnuCall:
                Toast.makeText((MainActivity.this), phone, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+ phone));
                try{
                    startActivity(i);
                }
                catch (ActivityNotFoundException ex){

                }
                break;
        }
        return super.onContextItemSelected(item);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //lay du lieu tu NewContact gui ve
        Log.d("Debug", String.valueOf(resultCode));
        if(resultCode!=202) {

            Bundle bundle = data.getExtras();
            int id = bundle.getInt("Id");
            String name = bundle.getString("Name");
            String phone = bundle.getString("Phone");
            if (requestCode == 100 && resultCode == 200) {
                //dat vao listdata
                Log.d("Debug", String.valueOf(id)+name+phone);
                lstStudent.add(new Student(id, name, phone, false));
                lstStudentAdapter.notifyDataSetChanged();
            }
            else if(requestCode==200 && resultCode==201)
            {
                lstStudent.set(selectedid, new Student(id, name, phone, false));
                lstStudentAdapter.notifyDataSetChanged();
                lstContact.setAdapter(lstStudentAdapter);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName = findViewById(R.id.txtName);
        btnThem = findViewById(R.id.btnThem);


        //Tao doi tuong ListViewAdapter
        //Tham so 1: Context - Lop cha cua lop Activity luu ngu canh ung dung
        //Tham so 2: Layout cua ListView
        //Tham so 3: du lieu
        lstStudent = new ArrayList<>();
        lstStudent.add(new Student(1, "Nguyen Thi Thu Ha", "015266444", false));
        lstStudent.add(new Student(2, "Nguyen Van Hoang", "015486444", false));
        lstStudent.add(new Student(3, "Nguyen Thuc Thuy Tien", "093666444", false));

        lstStudentAdapter = new MyAdapter(this, lstStudent);
        //Tham chieu toi ListView va thiet lap Adapter
        lstContact = findViewById(R.id.listViewInf);
        lstContact.setAdapter(lstStudentAdapter);
        lstContact.setOnItemLongClickListener((parent, view, position, id)->{
            selectedid = position;
            return false;
        });
        //bat su kien cho listview
        btnThem.setText("Edit");

        btnXoa = findViewById(R.id.btnXoa);
        btnXoa.setOnClickListener((v) -> {
            new AlertDialog.Builder(this)
                    .setTitle("Xác nhận")
                    .setMessage("Bạn có muốn xóa các phần tử đã chọn không?")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            int n = lstStudent.size();
                            for (int t = n-1; t >= 0; t--) {
                                if(lstStudent.get(t).isStatus() == true){
                                    lstStudentAdapter.RemoveItem(t);
                                }
                            }
                            lstContact.setAdapter(lstStudentAdapter);
                        }
                    })
                    .setNegativeButton("Cancel", null)
                    .show();
        });

        btnThem = findViewById(R.id.btnThem);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Add_user.class);
                startActivity(intent);
            }
        });
        btnThem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                  //lstStudentAdapter2.getFilter().filter(charSequence.toString());
                  //lstStudentAdapter2.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    public void btnShowPopupClick(View v){
        PopupMenu popupMenu = new PopupMenu(this,v);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.contextmenu, popupMenu.getMenu());
        popupMenu.show();
    }
    void Sort(int t)
    {
        ArrayList<Student> datacopy = lstStudent;
        for (int i = 0; i < datacopy.size() - 1; i++)
        {
            for(int j = 0; j < datacopy.size() - i - 1; j++)
            {
                switch (t)
                {
                    case 0:
                        if(Integer.parseInt(datacopy.get(j).getPhoneNumber()) > Integer.parseInt(datacopy.get(j+1).getPhoneNumber()))
                        {
                            Doi(datacopy, j, j + 1);
                        }
                        break;
                    case 1:
                        if(datacopy.get(j).getId() > datacopy.get(j+1).getId())
                        {
                            Doi(datacopy, j, j + 1);
                        }
                        break;
                    case 2:
                        if(datacopy.get(j).getName().toLowerCase().charAt(0) > datacopy.get(j+1).getName().toLowerCase().charAt(0))
                        {
                            Doi(datacopy, j, j + 1);
                        }
                        else if(datacopy.get(j).getName().toLowerCase().charAt(0) == datacopy.get(j+1).getName().toLowerCase().charAt(0)) {
                            int n = datacopy.get(j).getName().length() < datacopy.get(j + 1).getName().length() ? datacopy.get(j).getName().length() : datacopy.get(j + 1).getName().length();
                            for (int index = 1; index < n; index++) {
                                if (datacopy.get(j).getName().toLowerCase().charAt(index) > datacopy.get(j + 1).getName().toLowerCase().charAt(index)) {
                                    Doi(datacopy, j, j + 1);
                                    break;
                                }
                            }
                        }

                        break;
                }

            }
        }
        lstStudent = datacopy;
        lstContact.setAdapter(lstStudentAdapter);
    }

    void remove()
    {
        for(int i = 0; i < lstStudent.size(); i++)
        {
            if(lstStudent.get(i).isStatus())
            {
                lstStudent.remove(i);
                i--;
            }
        }
        lstContact.setAdapter(lstStudentAdapter);
        Toast.makeText(this, "Đã xóa", Toast.LENGTH_LONG).show();
    }
    void Doi(ArrayList<Student> list, int i, int j)
    {
        Student temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    void ThemMoiActivity()
    {
        Intent intent = new Intent(MainActivity.this, Add_user.class);
        startActivityForResult(intent, 100);
    }


}