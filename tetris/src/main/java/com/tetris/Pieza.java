package com.tetris;

public abstract class Pieza {
    protected int[][] forma;
    protected int x, y; // Posición de la pieza en el tablero

    public abstract void definirForma();

    public void rotar() {
        // Rotar la pieza (implementación básica)
        int n = forma.length;
        int[][] nuevaForma = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nuevaForma[j][n - 1 - i] = forma[i][j];
            }
        }
        forma = nuevaForma;
    }

    public void colocarEnTablero(Tablero tablero) {
        // Colocar la pieza en el tablero (simplificación)
        int[][] matriz = tablero.getMatriz();
        for (int i = 0; i < forma.length; i++) {
            for (int j = 0; j < forma[i].length; j++) {
                if (forma[i][j] != 0) {
                    matriz[y + i][x + j] = forma[i][j];
                }
            }
        }
    }

    public int[][] getForma() {
        return forma;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static class I_Piece extends Pieza {
        public I_Piece() {
            definirForma();
        }

        @Override
        public void definirForma() {
            this.forma = new int[][]{
                {1, 1, 1, 1}
            };
            this.x = 3;
            this.y = 0;
        }
    }

    public static class O_Piece extends Pieza {
        public O_Piece() {
            definirForma();
        }

        @Override
        public void definirForma() {
            this.forma = new int[][]{
                {1, 1},
                {1, 1}
            };
            this.x = 4;
            this.y = 0;
        }
    }

    public static class T_Piece extends Pieza {
        public T_Piece() {
            definirForma();
        }

        @Override
        public void definirForma() {
            this.forma = new int[][]{
                {0, 1, 0},
                {1, 1, 1}
            };
            this.x = 3;
            this.y = 0;
        }
    }

    public static class S_Piece extends Pieza {
        public S_Piece() {
            definirForma();
        }

        @Override
        public void definirForma() {
            this.forma = new int[][]{
                {0, 1, 1},
                {1, 1, 0}
            };
            this.x = 3;
            this.y = 0;
        }
    }

    public static class Z_Piece extends Pieza {
        public Z_Piece() {
            definirForma();
        }

        @Override
        public void definirForma() {
            this.forma = new int[][]{
                {1, 1, 0},
                {0, 1, 1}
            };
            this.x = 3;
            this.y = 0;
        }
    }

    public static class J_Piece extends Pieza {
        public J_Piece() {
            definirForma();
        }

        @Override
        public void definirForma() {
            this.forma = new int[][]{
                {1, 0, 0},
                {1, 1, 1}
            };
            this.x = 3;
            this.y = 0;
        }
    }

    public static class L_Piece extends Pieza {
        public L_Piece() {
            definirForma();
        }

        @Override
        public void definirForma() {
            this.forma = new int[][]{
                {0, 0, 1},
                {1, 1, 1}
            };
            this.x = 3;
            this.y = 0;
        }
    }
}
