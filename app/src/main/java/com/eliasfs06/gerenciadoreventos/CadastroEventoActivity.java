package com.eliasfs06.gerenciadoreventos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.eliasfs06.gerenciadoreventos.db.DBHelper;
import com.eliasfs06.gerenciadoreventos.model.Evento;

import java.util.ArrayList;
import java.util.Date;

public class CadastroEventoActivity extends AppCompatActivity {

    private EditText codigoText;
    private EditText nomeText;
    private EditText descricaoText;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_evento);

        dbHelper = DBHelper.getInstance(this);

        codigoText = findViewById(R.id.codigoText);
        nomeText = findViewById(R.id.nomeText);
        descricaoText = findViewById(R.id.descricaoText);

        Button btnSalvar = findViewById(R.id.salvarBtn);
        Button btnLimpar = findViewById(R.id.limparBtn);
        Button voltarBtn = findViewById(R.id.voltarBtnCadastro);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarEvento();
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

    private void salvarEvento(String codigo, String nome, String descricao) {
        dbHelper.addEvento(new Evento(codigo, nome, descricao, "", "", new ArrayList<>()));
        showToast("Evento salvo com sucesso!");
        limparInput();
    }

    private void limparInput(){
        codigoText.setText("");
        nomeText.setText("");
        descricaoText.setText("");
    }

    public void showToast(String mensagem){
        Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_SHORT).show();
    }

    public void validarEvento(){
        String codigo = codigoText.getText().toString();
        String nome = nomeText.getText().toString();
        String descricao = descricaoText.getText().toString();

        if(!codigo.isEmpty() && !nome.isEmpty() && !descricao.isEmpty()){
            salvarEvento(codigo, nome, descricao);
        } else {
            showToast("Preencha todos os campos.");
        }
    }

    private void irParaMenuActivity() {
        Intent intent = new Intent(CadastroEventoActivity.this, MenuActivity.class);
        startActivity(intent);
        finish();
    }

}