package com.example.classarrange2;

public class Turma {
    private String nome;

    public Turma() {
        // Construtor vazio necessário para o Firebase Realtime Database
    }

    public Turma(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
