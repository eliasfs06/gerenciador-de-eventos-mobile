package com.eliasfs06.gerenciadoreventos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.eliasfs06.gerenciadoreventos.db.DBHelper;

public class DeletarClienteActivity extends AppCompatActivity {

    private EditText nomeText, codigoText;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleta_cliente);

        dbHelper = new DBHelper(this);
        codigoText = findViewById(R.id.codigoText);

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
        String codigo = codigoText.getText().toString();

        Boolean chickinsertdata = dbHelper.deletedata(codigo);

        if(chickinsertdata == true) {
            Toast.makeText(DeletarClienteActivity.this, "Cliente Deletado com Sucesso!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(DeletarClienteActivity.this, "Cliente não Encontrado!", Toast.LENGTH_SHORT).show();
        }
//        finish();

    }

    private void limparInput(){
        codigoText.setText("");
    }

    private void irParaMenuActivity() {
        Intent intent = new Intent(DeletarClienteActivity.this, MenuActivity.class);
        startActivity(intent);
        finish();
    }

    public void showToast(String mensagem){
        Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_SHORT).show();
    }

}