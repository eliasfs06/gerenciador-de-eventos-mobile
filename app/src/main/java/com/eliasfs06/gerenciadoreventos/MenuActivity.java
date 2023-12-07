package com.eliasfs06.gerenciadoreventos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnCadastraEvento = findViewById(R.id.cadastrarProdButton);
        Button btnListarEventos = findViewById(R.id.listarProdButton);
        Button btnDeletarEventos = findViewById(R.id.deletarProdButton);
        btnCadastraEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irParaCadastrarActivity();
            }
        });

        btnListarEventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irParaListarActivity();
            }
        });

        btnDeletarEventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irParaDeletarActivity();
            }
        });
    }

    private void irParaCadastrarActivity() {
        Intent intent = new Intent(MenuActivity.this, CadastroEventoActivity.class);
        startActivity(intent);
        finish();
    }

    private void irParaListarActivity() {
        Intent intent = new Intent(MenuActivity.this, ListaEventosActivity.class);
        startActivity(intent);
        finish();
    }

    private void irParaDeletarActivity() {
        Intent intent = new Intent(MenuActivity.this, DeletaEventoActivity.class);
        startActivity(intent);
        finish();
    }
}