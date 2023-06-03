package com.example.classarrange2;

public class Semestre {
    private String nome;

    public Semestre() {
        // Construtor vazio necessário para o Firebase Realtime Database
    }

    public Semestre(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
