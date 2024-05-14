package com.jocrol;

public abstract class ElementJoc {
    private String nom;
    private int valor;

    // Constructor
    public ElementJoc(String nom, int valor) {
        this.nom = nom;
        this.valor = valor;
    }
    
    public class Arma extends ElementJoc {
        public Arma(String nom, int valor) {
            super(nom, valor);
        }
    }
    
    public class Armadura extends ElementJoc {
        public Armadura(String nom, int valor) {
            super(nom, valor);
        }
    }
    

    // Getters i Setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public int getValor() { return valor; }
    public void setValor(int valor) { this.valor = valor; }
}
