package com.example.gamefication.Objetos;

import android.widget.ImageView;

public class Usuario {
    String nome;
    int sexo; // se for implementado
    ImageView foto;

    public ImageView getFoto() {
        return foto;
    }

    public void setFoto(ImageView foto) {
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }
}
