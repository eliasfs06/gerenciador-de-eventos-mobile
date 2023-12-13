package com.eliasfs06.gerenciadoreventos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.eliasfs06.gerenciadoreventos.db.DBHelper;

import java.util.ArrayList;

public class Userlist extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> codigo, nome, email, sexo, rockInRio, theTown, lollapalooza, carnatal;
    DBHelper dpHelper;
    MyAdapter adapter;
    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);
        dpHelper = new DBHelper(this);
        codigo = new ArrayList<>();
        nome = new ArrayList<>();
        email = new ArrayList<>();
        sexo = new ArrayList<>();
        rockInRio = new ArrayList<>();
        theTown = new ArrayList<>();
        lollapalooza = new ArrayList<>();
        carnatal = new ArrayList<>();

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voltar(v);
            }
        });

        recyclerView = findViewById(R.id.recyclerview);
        adapter = new MyAdapter(this, codigo, nome, email, sexo, rockInRio, theTown, lollapalooza, carnatal);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }

    private void displaydata() {
        Cursor cursor = dpHelper.getdata();
        if(cursor.getCount() == 0) {
            Toast.makeText(Userlist.this, "", Toast.LENGTH_SHORT).show();
            return;
        } else {
            while (cursor.moveToNext()) {
                codigo.add(cursor.getString(0));
                nome.add(cursor.getString(1));
                email.add(cursor.getString(2));
                sexo.add(cursor.getString(3));
                rockInRio.add(cursor.getString(4));
                theTown.add(cursor.getString(5));
                lollapalooza.add(cursor.getString(6));
                carnatal.add(cursor.getString(7));
            }
        }
    }

    public void voltar(View view) {
        finish();
    }

}