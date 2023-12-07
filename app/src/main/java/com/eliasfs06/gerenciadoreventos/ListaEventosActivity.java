package com.eliasfs06.gerenciadoreventos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.eliasfs06.gerenciadoreventos.db.DBHelper;
import com.eliasfs06.gerenciadoreventos.model.Evento;

import java.util.List;

public class ListaEventosActivity extends AppCompatActivity {

    ListView eventosListView;

    Button voltarBtn;

    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_eventos);

        dbHelper = DBHelper.getInstance(this);

        voltarBtn = findViewById(R.id.voltarBtn);
        voltarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irParaMenuActivity();
            }
        });

        eventosListView = findViewById(R.id.eventosList);

        List<Evento> eventos = dbHelper.getAllEventos();
        ArrayAdapter<Evento> adapter = new ArrayAdapter<Evento>(this, R.layout.list_item_evento, eventos) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                if (convertView == null) {
                    convertView = getLayoutInflater().inflate(R.layout.list_item_evento, parent, false);
                }

                TextView nomeEvento = convertView.findViewById(R.id.nome_evento);
                TextView descricaoEvento = convertView.findViewById(R.id.descricao_evento);

                Evento evento = getItem(position);

                if (evento != null) {
                    nomeEvento.setText(evento.getCodigo() + " - " + evento.getNome());
                    descricaoEvento.setText(evento.getDescricao());
                }

                return convertView;
            }
        };

        eventosListView.setAdapter(adapter);
    }

    private void irParaMenuActivity() {
        Intent intent = new Intent(ListaEventosActivity.this, MenuActivity.class);
        startActivity(intent);
        finish();
    }
}