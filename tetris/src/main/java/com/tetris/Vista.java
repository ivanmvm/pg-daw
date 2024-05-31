package com.tetris;

import javax.swing.*;
import java.awt.*;

public class Vista extends JFrame {
    private Juego juego;
    private JPanel panelTablero;

    public Vista(Juego juego) {
        this.juego = juego;
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setTitle("Juego de Tetris");
        setSize(400, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelTablero = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                dibujarTablero(g);
            }
        };
        add(panelTablero);
    }

    public void dibujarTablero(Graphics g) {
        int[][] matriz = juego.getTablero().getMatriz();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] != 0) {
                    g.setColor(Color.BLUE);
                    g.fillRect(j * 30, i * 30, 30, 30);
                }
            }
        }
    }

    public void mostrarInfo() {
        // Código para mostrar información del juego (p. ej., puntuación)
    }

    public void actualizar() {
        repaint();
    }
}
