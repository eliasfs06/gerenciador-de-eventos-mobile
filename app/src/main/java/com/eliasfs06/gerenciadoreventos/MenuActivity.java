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
        Button btnAlterarEventos = findViewById(R.id.alterarProdButton);
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

        btnAlterarEventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irParaAlterarEvento();
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
        Intent intent = new Intent(MenuActivity.this, CadastroClienteActivity.class);
        startActivity(intent);
        finish();
    }

    private void irParaListarActivity() {
        Intent intent = new Intent(MenuActivity.this, Userlist.class);
        startActivity(intent);
//        finish();
    }

    private void irParaAlterarEvento() {
        Intent intent = new Intent(MenuActivity.this, AlterarClienteActivity.class);
        startActivity(intent);
//        finish();
    }

    private void irParaDeletarActivity() {
        Intent intent = new Intent(MenuActivity.this, DeletarClienteActivity.class);
        startActivity(intent);
        finish();
    }
}