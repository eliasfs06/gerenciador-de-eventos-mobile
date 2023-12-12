package com.eliasfs06.gerenciadoreventos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.eliasfs06.gerenciadoreventos.db.DBHelper;
import com.eliasfs06.gerenciadoreventos.model.Cliente;

public class AlterarClienteActivity extends AppCompatActivity {

    private EditText codigoText;
    private EditText nomeText;
    private EditText emailText;
    private String sexoText;
    private RadioGroup selecaoSexo;
    Boolean rockInRio, theTown, lollaPalooza, carnatal;

    private CheckBox boxRockInRio, boxTheTown, boxLolla, boxCarnatal;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altera_evento);

        dbHelper = new DBHelper(this);

        rockInRio = theTown = lollaPalooza = carnatal = false;
        codigoText = findViewById(R.id.codigoText);
        nomeText = findViewById(R.id.nomeText);
        emailText = findViewById(R.id.emailText);
        sexoText = "Não Selecionado";

        boxRockInRio = findViewById(R.id.cbRockInRio);
        boxTheTown = findViewById(R.id.cbTheTown);
        boxLolla = findViewById(R.id.cbLolla);
        boxCarnatal = findViewById(R.id.cbCarnatal);

        selecaoSexo = findViewById(R.id.radioGroupSexo);

        Button btnSalvar = findViewById(R.id.salvarBtn);
        Button btnLimpar = findViewById(R.id.limparBtn);
        Button voltarBtn = findViewById(R.id.voltarBtnCadastro);

        selecaoSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton opcao = findViewById(checkedId);
                sexoText = opcao.getText().toString();
            }
        });

        boxRockInRio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                rockInRio = isChecked;
            }
        });

        boxTheTown.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                theTown = isChecked;
            }
        });

        boxLolla.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                lollaPalooza = isChecked;
            }
        });

        boxCarnatal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                carnatal = isChecked;
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                RadioButton opcao = findViewById(selecaoSexo.getCheckedRadioButtonId());
//                Toast.makeText(CadastroClienteActivity.this, opcao.getText(), Toast.LENGTH_SHORT).show();
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

    private void salvarEvento(String codigo, String nome, String email) {
        dbHelper.alterdata(new Cliente(codigo, nome, email));
        showToast("Evento salvo com sucesso!");
        limparInput();
    }

    private void limparInput(){
        codigoText.setText("");
        nomeText.setText("");
        emailText.setText("");
    }

    public void showToast(String mensagem){
        Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_SHORT).show();
    }

    public void validarEvento(){
        String codigo = codigoText.getText().toString();
        String nome = nomeText.getText().toString();
        String email = emailText.getText().toString();

        if(!codigo.isEmpty() && !nome.isEmpty() && !email.isEmpty()){
            salvarEvento(codigo, nome, email);
        } else {
            showToast("Preencha todos os campos.");
        }
    }

    private void irParaMenuActivity() {
        Intent intent = new Intent(AlterarClienteActivity.this, MenuActivity.class);
        startActivity(intent);
        finish();
    }

}