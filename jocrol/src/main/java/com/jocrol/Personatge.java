package com.jocrol;

public class Personatge {
    private String nom;
    private int nivell;
    private int puntsDeVida;
    private int puntsDeMana;
    private String arma;
    private String armadura;

    // Constructor
    public Personatge(String nom, int nivell, int puntsDeVida, int puntsDeMana, String arma, String armadura) {
        this.nom = nom;
        this.nivell = nivell;
        this.puntsDeVida = puntsDeVida;
        this.puntsDeMana = puntsDeMana;
        this.arma = arma;
        this.armadura = armadura;
    }

    // Getters i Setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public int getNivell() { return nivell; }
    public void setNivell(int nivell) { this.nivell = nivell; }
    public int getPuntsDeVida() { return puntsDeVida; }
    public void setPuntsDeVida(int puntsDeVida) { this.puntsDeVida = puntsDeVida; }
    public int getPuntsDeMana() { return puntsDeMana; }
    public void setPuntsDeMana(int puntsDeMana) { this.puntsDeMana = puntsDeMana; }
    public String getArma() { return arma; }
    public void setArma(String arma) { this.arma = arma; }
    public String getArmadura() { return armadura; }
    public void setArmadura(String armadura) { this.armadura = armadura; }
}
