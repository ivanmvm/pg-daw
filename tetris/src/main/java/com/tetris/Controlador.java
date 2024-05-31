package com.tetris;

public class Controlador {
    private Juego juego;
    private Vista vista;

    public Controlador(Juego juego, Vista vista) {
        this.juego = juego;
        this.vista = vista;
    }

    public void recibirEntradas() {
        // Código para recibir entradas del usuario (por ejemplo, con KeyListener)
    }

    public void decidirAccion() {
        // Código para decidir la acción basada en la entrada
    }

    public void actualizarEstado() {
        juego.controlFlujo();
        vista.actualizar();
    }
}