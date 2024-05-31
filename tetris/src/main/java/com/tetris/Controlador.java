package com.tetris;

public class Controlador {
    private Juego juego;
    private Vista vista;

    public Controlador(Juego juego, Vista vista) {
        this.juego = juego;
        this.vista = vista;
    }

    public void actualizarEstado() {
        juego.controlFlujo();
        vista.actualizar();
    }
}