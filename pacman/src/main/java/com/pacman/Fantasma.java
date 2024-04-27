// Fantasma.java
package com.pacman;

import com.pacman.PacMan.Laberint;

public class Fantasma {
    private int posX;
    private int posY;

    public Fantasma(int startX, int startY) {
        this.posX = startX;
        this.posY = startY;
    }

    public void move(Laberint laberint) {
        int direction = (int) (Math.random() * 4);
        int nextPosX = posX;
        int nextPosY = posY;
        
        switch (direction) {
            case 0: // UP
                nextPosY--;
                break;
            case 1: // DOWN
                nextPosY++;
                break;
            case 2: // LEFT
                nextPosX--;
                break;
            case 3: // RIGHT
                nextPosX++;
                break;
        }
        
        // Verificar si la siguiente posición no es una pared
        if (!laberint.isWall(nextPosX, nextPosY)) {
            posX = nextPosX;
            posY = nextPosY;
        }
    }
    

    // Getters
    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}
