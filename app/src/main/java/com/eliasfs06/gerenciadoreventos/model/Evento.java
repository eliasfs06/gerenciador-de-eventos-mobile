package com.eliasfs06.gerenciadoreventos.model;

import java.util.List;

public class Evento {

    String codigo;
    String nome;
    String descricao;
    String dataInicio;
    String dataFim;
    List<String> inscritos;

    public Evento() {
    }

    public Evento(String codigo, String nome, String descricao, String dataInicio, String dataFim, List<String> inscritos) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.inscritos = inscritos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String formatarParaList() {
        return this.codigo + " - " + this.nome;
    }

    public List<String> getInscritos() {
        return inscritos;
    }

    public void setInscritos(List<String> inscritos) {
        this.inscritos = inscritos;
    }
}
