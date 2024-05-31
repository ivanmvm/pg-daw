package com.tetris;

public class Tablero {
    private int[][] matriz;

    public Tablero() {
        this.matriz = new int[20][10]; // Ejemplo de tamaño de tablero
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public boolean verificarPosicion(Pieza pieza) {
        for (int i = 0; i < pieza.getForma().length; i++) {
            for (int j = 0; j < pieza.getForma()[i].length; j++) {
                if (pieza.getForma()[i][j] != 0) {
                    int nuevoX = pieza.getX() + j;
                    int nuevoY = pieza.getY() + i;
                    if (nuevoX < 0 || nuevoX >= matriz[0].length || nuevoY < 0 || nuevoY >= matriz.length || matriz[nuevoY][nuevoX] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void marcarPosiciones(Pieza pieza) {
        // Marcar posiciones en el tablero
        for (int i = 0; i < pieza.getForma().length; i++) {
            for (int j = 0; j < pieza.getForma()[i].length; j++) {
                if (pieza.getForma()[i][j] != 0) {
                    matriz[pieza.getY() + i][pieza.getX() + j] = pieza.getForma()[i][j];
                }
            }
        }
    }

    public void eliminarLineas() {
        for (int i = 0; i < matriz.length; i++) {
            boolean lineaCompleta = true;
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 0) {
                    lineaCompleta = false;
                    break;
                }
            }
            if (lineaCompleta) {
                for (int k = i; k > 0; k--) {
                    System.arraycopy(matriz[k - 1], 0, matriz[k], 0, matriz[k].length);
                }
                matriz[0] = new int[matriz[0].length];
            }
        }
    }
}

