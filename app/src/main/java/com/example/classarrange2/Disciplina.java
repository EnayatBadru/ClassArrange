package com.example.classarrange2;

public class Disciplina {
    private String nome;

    public Disciplina() {
        // Construtor vazio necessário para o Firebase Realtime Database
    }

    public Disciplina(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
