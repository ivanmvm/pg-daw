package com.tetris;

public class Main {
    public static void main(String[] args) {
        Juego juego = new Juego();
        Vista vista = new Vista(juego);
        Controlador controlador = new Controlador(juego, vista);

        vista.setVisible(true);

        // Bucle principal del juego
        while (true) {
            controlador.actualizarEstado();
            try {
                Thread.sleep(100); // Controlar la velocidad del juego
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
