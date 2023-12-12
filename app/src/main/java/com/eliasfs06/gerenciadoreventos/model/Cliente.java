package com.eliasfs06.gerenciadoreventos.model;

import java.util.List;

public class Cliente {

    String codigo;
    String nome;
    String email;
    String sexo;
    Boolean rockInRio, theTown, lollapalooza, carnatal;
    public Cliente() {
    }
    public Cliente(String codigo, String nome, String email, String sexo, Boolean rockInRio, Boolean theTown, Boolean lollapalooza, Boolean carnatal) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.sexo = sexo;
        this.rockInRio = rockInRio;
        this.theTown = theTown;
        lollapalooza = lollapalooza;
        this.carnatal = carnatal;
    }

    public Cliente(String codigo, String nome, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
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

    public Boolean getRockInRio() {
        return rockInRio;
    }

    public void setRockInRio(Boolean rockInRio) {
        this.rockInRio = rockInRio;
    }

    public Boolean getTheTown() {
        return theTown;
    }

    public void setTheTown(Boolean theTown) {
        this.theTown = theTown;
    }

    public Boolean getLollapalooza() {
        return lollapalooza;
    }

    public void setLollapalooza(Boolean lollapalooza) {
        lollapalooza = lollapalooza;
    }

    public Boolean getCarnatal() {
        return carnatal;
    }

    public void setCarnatal(Boolean carnatal) {
        this.carnatal = carnatal;
    }
}
