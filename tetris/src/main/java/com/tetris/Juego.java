package com.tetris;

import java.util.ArrayList;
import java.util.List;

public class Juego {
    private Tablero tablero;
    private List<Pieza> piezas;
    private Pieza piezaActual;

    public Juego() {
        this.tablero = new Tablero();
        this.piezas = new ArrayList<>();
        generarPiezas();
        piezaActual = piezas.get((int)(Math.random() * piezas.size()));  // Generar pieza aleatoria
    }

    private void generarPiezas() {
        piezas.add(new Pieza.I_Piece());
        piezas.add(new Pieza.O_Piece());
        piezas.add(new Pieza.T_Piece());
        piezas.add(new Pieza.S_Piece());
        piezas.add(new Pieza.Z_Piece());
        piezas.add(new Pieza.J_Piece());
        piezas.add(new Pieza.L_Piece());
    }

    public void logicaPrincipal() {
        // Lógica principal del juego
    }

    public void controlFlujo() {
        // Mover la pieza hacia abajo
        piezaActual.y += 1;

        if (!tablero.verificarPosicion(piezaActual)) {
            piezaActual.y -= 1; // Revertir el movimiento si no es válido
            piezaActual.colocarEnTablero(tablero);
            tablero.eliminarLineas();
            piezaActual = piezas.get((int)(Math.random() * piezas.size())); // Generar nueva pieza aleatoria
        }
    }

    public Tablero getTablero() {
        return tablero;
    }
}
