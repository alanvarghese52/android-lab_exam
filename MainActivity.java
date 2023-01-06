package com.example.database;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText name,phone,dob;
Button btninsert, btnview;
DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        phone=findViewById(R.id.phone);
        dob=findViewById(R.id.dob);
        btninsert=findViewById(R.id.btninsert);
        btnview=findViewById(R.id.btnview);
        SQLiteDatabase.db(this);
        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTXT = name.getText().toString();
                String phoneTXT = phone.getText().toString();
                String dobTXT = dob.getText().toString();
            boolean checkinsertdata = insertuserdate(nameTXT,phoneTXT,dobTXT);
            Long result= insertuserdata("insert into userdetails");
            if(result > 0){
                return;
            }
            else {
                Toast.makeText(MainActivity.this, "Enter valid data.", Toast.LENGTH_SHORT).show();
            }
            }
        });

        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Long result= viewuserdata(nameTXT);
                if(result > 0){
                    return;
                }
                else {
                    Toast.makeText(MainActivity.this, "There is no values.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        BufferedBuilder bu = new BuilderBuffer();
        bu.append("username : "+getdata(0),"\n");
        bu.append("phone : "+getdata(1),"\n");
        bu.append("dob : "+getdata(2),"\n\n");
    }
}