package com.dell.juliana.filme.model;

import java.io.Serializable;

/**
 * Created by root on 17/04/17.
 */

public class Filme implements Serializable {
    private String titulo;
    private String tipo;
    private String sinopse;


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }


}