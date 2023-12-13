package com.eliasfs06.gerenciadoreventos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.eliasfs06.gerenciadoreventos.db.DBHelper;

public class DeletarEventoActivity extends AppCompatActivity {

    private EditText codigo;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleta_evento);

        dbHelper = new DBHelper(this);
        codigo = findViewById(R.id.nomeText);

        Button btnDeletar = findViewById(R.id.deletarBtn);
        Button btnLimpar = findViewById(R.id.limparBtn);
        Button voltarBtn = findViewById(R.id.voltarBtnCadastro);

        btnDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deletarEvento();
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparInput();
            }
        });

        voltarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irParaMenuActivity();
            }
        });
    }

    private void deletarEvento(){
        if(dbHelper.verificarClienteExistente(codigo.getText().toString())){
            dbHelper.deletedata(codigo.getText().toString());
            Toast.makeText(DeletarEventoActivity.this, "Participante deletado com sucesso.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(DeletarEventoActivity.this, "Não foi encontrado nenhum participante com esse código.", Toast.LENGTH_SHORT).show();
        }

    }

    private void limparInput(){
        codigo.setText("");
    }

    private void irParaMenuActivity() {
        Intent intent = new Intent(DeletarEventoActivity.this, MenuActivity.class);
        startActivity(intent);
        finish();
    }

    public void showToast(String mensagem){
        Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_SHORT).show();
    }

}