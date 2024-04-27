package com.pacman;

public class PacMan {
    // Atributs del personatge PacMan
    private int posX;
    private int posY;
    private int puntuacio;
    private int vides;
    private boolean poderEspecial;

    // Constructor
    public PacMan() {
        this.posX = 0;
        this.posY = 0;
        this.puntuacio = 0;
        this.vides = 3;
        this.poderEspecial = false;
    }

    // Mètodes
    public void move(int newPosX, int newPosY) {
        this.posX = newPosX;
        this.posY = newPosY;
    }

    public void pickupBola() {
        this.puntuacio += 10; 
    }

    public void pickupBolaEspecial() {
        this.poderEspecial = true;
    }

    public void pickupFruita() {
        this.puntuacio += 50; 
    }

    public void loseLife() {
        this.vides--;
        if (this.vides <= 0) {
            // Game Over
        }
    }

    public boolean detectColisionFantasma(Fantasma fantasma) {
        if (this.posX == fantasma.getPosX() && this.posY == fantasma.getPosY()) {
            return true;
        }
        return false;
    }

    // Getters i Setters
    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPuntuacio() {
        return puntuacio;
    }

    public void setPuntuacio(int puntuacio) {
        this.puntuacio = puntuacio;
    }

    public int getVides() {
        return vides;
    }

    public void setVides(int vides) {
        this.vides = vides;
    }

    public boolean isPoderEspecial() {
        return poderEspecial;
    }

    public void setPoderEspecial(boolean poderEspecial) {
        this.poderEspecial = poderEspecial;
    }

    // Classe Bola
    public class Bola {
    }

    // Classe BolaEspecial
    public class BolaEspecial {
    }

    // Classe Fruita
    public class Fruita {
    }

     // Classe Laberint
     public class Laberint {

        public boolean isWall(int nextPosX, int nextPosY) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'isWall'");
        }
    }

    // Classe Fantasma
    public class Fantasma {
        private int posX;
        private int posY;

        public Fantasma(int posX, int posY) {
            this.posX = posX;
            this.posY = posY;
        }

        public int getPosX() {
            return posX;
        }

        public int getPosY() {
            return posY;
        }
    }

    // Main
    public static void main(String[] args) {
        PacMan pacMan = new PacMan();
        Fantasma fantasma = pacMan.new Fantasma(1, 1);

        pacMan.move(1, 1);
        if (pacMan.detectColisionFantasma(fantasma)) {
            System.out.println("GAME ENDED!");
        }

        pacMan.pickupBola();
        pacMan.pickupFruita();
        pacMan.pickupBolaEspecial();

        System.out.println("Puntuacio: " + pacMan.getPuntuacio());
        System.out.println("Vides: " + pacMan.getVides());
        System.out.println("Poder Especial: " + pacMan.isPoderEspecial());
    }
}