package com.example.classarrange2;

public class Curso {
    private String nome;

    public Curso() {
        // Construtor vazio necessário para o Firebase Realtime Database
    }

    public Curso(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
