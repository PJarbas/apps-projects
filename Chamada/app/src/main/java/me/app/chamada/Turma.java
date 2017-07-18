package me.app.chamada;

import org.parceler.Parcel;

import java.util.ArrayList;

/**
 * Created by jarbas on 18/07/17.
 */
@Parcel
public class Turma {

    private String nome;
    private int numero_alunos;
    private ArrayList<String> alunos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero_alunos() {
        return numero_alunos;
    }

    public void setNumero_alunos(int numero_alunos) {
        this.numero_alunos = numero_alunos;
    }

    public ArrayList<String> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<String> alunos) {
        this.alunos = alunos;
    }
}
