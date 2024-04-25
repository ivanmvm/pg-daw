package com.codificacio;

public class MediaClass {
    private String nom;
    private String autor;
    private int durada;

    public MediaClass() {}

    public MediaClass(String nom, String autor, int durada) {
        this.nom = nom;
        this.autor = autor;
        this.durada = durada;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getDurada() {
        return durada;
    }

    public void setDurada(int durada) {
        this.durada = durada;
    }
}