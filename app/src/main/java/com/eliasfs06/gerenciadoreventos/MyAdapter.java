package com.eliasfs06.gerenciadoreventos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList codigo_id, nome_id, email_id, sexo_id, rockInRio_id, theTown_id, lollapalooza_id, carnatal_id;
//  ArrayList sexo_id, ArrayList rockInRio_id, ArrayList theTown_id, ArrayList lollapalooza_id, ArrayList carnatal_id

    public MyAdapter(Context context, ArrayList codigo_id, ArrayList nome_id, ArrayList email_id, ArrayList sexo_id, ArrayList rockInRio_id, ArrayList theTown_id, ArrayList lollapalooza_id, ArrayList carnatal_id) {
        this.context = context;
        this.codigo_id = codigo_id;
        this.nome_id = nome_id;
        this.email_id = email_id;
        this.sexo_id = sexo_id;
        this.rockInRio_id = rockInRio_id;
        this.theTown_id = theTown_id;
        this.lollapalooza_id = lollapalooza_id;
        this.carnatal_id = carnatal_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.codigo_id.setText(String.valueOf(codigo_id.get(position)));
        holder.nome_id.setText(String.valueOf(nome_id.get(position)));
        holder.email_id.setText(String.valueOf(email_id.get(position)));
        holder.sexo_id.setText(String.valueOf(sexo_id.get(position)));
        holder.rockInRio_id.setText(String.valueOf(rockInRio_id.get(position)));
        holder.theTown_id.setText(String.valueOf(theTown_id.get(position)));
        holder.lollapalooza_id.setText(String.valueOf(lollapalooza_id.get(position)));
        holder.carnatal_id.setText(String.valueOf(carnatal_id.get(position)));
    }

    @Override
    public int getItemCount() {
        return codigo_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView codigo_id, nome_id, email_id, sexo_id;
        TextView rockInRio_id, theTown_id, lollapalooza_id, carnatal_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            codigo_id = itemView.findViewById(R.id.textcodigo);
            nome_id = itemView.findViewById(R.id.textnome);
            email_id = itemView.findViewById(R.id.textemail);
            sexo_id = itemView.findViewById(R.id.textsexo);
            rockInRio_id = itemView.findViewById(R.id.textRockInRio);
            theTown_id = itemView.findViewById(R.id.textTheTown);
            lollapalooza_id = itemView.findViewById(R.id.textLolla);
            carnatal_id = itemView.findViewById(R.id.textCarnatal);
        }
    }
}