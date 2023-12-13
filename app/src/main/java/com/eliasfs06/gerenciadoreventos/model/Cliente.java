package com.eliasfs06.gerenciadoreventos.model;

import java.util.List;

public class Cliente {

    String codigo, nome, email, sexo;
    String rockInRio, theTown, lollapalooza, carnatal;
    public Cliente() {
    }
    public Cliente(String codigo, String nome, String email, String sexo, String rockInRio, String theTown, String lollapalooza, String carnatal) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.sexo = sexo;
        this.rockInRio = rockInRio;
        this.theTown = theTown;
        this.lollapalooza = lollapalooza;
        this.carnatal = carnatal;
    }

//    public Cliente(String codigo, String nome, String email, String sexo, String rockInRio) {
//        this.codigo = codigo;
//        this.nome = nome;
//        this.email = email;
//        this.sexo = sexo;
//        this.rockInRio = rockInRio;
//    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRockInRio() {
        return rockInRio;
    }

    public void setRockInRio(String rockInRio) {
        this.rockInRio = rockInRio;
    }

    public String getTheTown() {
        return theTown;
    }

    public void setTheTown(String theTown) {
        this.theTown = theTown;
    }

    public String getLollapalooza() {
        return lollapalooza;
    }

    public void setLollapalooza(String lollapalooza) {
        this.lollapalooza = lollapalooza;
    }

    public String getCarnatal() {
        return carnatal;
    }

    public void setCarnatal(String carnatal) {
        this.carnatal = carnatal;
    }
}
