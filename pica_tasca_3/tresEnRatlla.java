import java.util.Scanner;

class TresEnRatlla {
    private char[][] tauler;
    private char jugadorActual;

    public TresEnRatlla() {
        tauler = new char[3][3];
        jugadorActual = '1';
        inicialitzaTauler();
    }

    private void inicialitzaTauler() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tauler[i][j] = '-';
            }
        }
    }

    public void mostraTauler() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tauler[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean moure(int fila, int columna) {
        if (fila < 0 || fila >= 3 || columna < 0 || columna >= 3 || tauler[fila][columna] != '-') {
            return false;
        }
        tauler[fila][columna] = jugadorActual;
        jugadorActual = (jugadorActual == '1') ? '2' : 'X';
        return true;
    }

    public boolean comprovaGuanyador() {
        // Comprova files i columnes
        for (int i = 0; i < 3; i++) {
            if (tauler[i][0] != '-' && tauler[i][0] == tauler[i][1] && tauler[i][1] == tauler[i][2]) {
                return true;
            }
            if (tauler[0][i] != '-' && tauler[0][i] == tauler[1][i] && tauler[1][i] == tauler[2][i]) {
                return true;
            }
        }
        // Comprova diagonals
        if (tauler[0][0] != '-' && tauler[0][0] == tauler[1][1] && tauler[1][1] == tauler[2][2]) {
            return true;
        }
        if (tauler[0][2] != '-' && tauler[0][2] == tauler[1][1] && tauler[1][1] == tauler[2][0]) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TresEnRatlla joc = new TresEnRatlla();

        while (true) {
            joc.mostraTauler();
            System.out.println("Jugador " + joc.jugadorActual + ", introdueix fila (0-2):");
            int fila = scanner.nextInt();
            System.out.println("Introdueix columna (0-2):");
            int columna = scanner.nextInt();

            if (!joc.moure(fila, columna)) {
                System.out.println("Moviment invàlid. Torna a intentar.");
            } else {
                if (joc.comprovaGuanyador()) {
                    System.out.println("Jugador " + joc.jugadorActual + " guanya!");
                    break;
                }
            }
        }
        scanner.close();
    }
}
