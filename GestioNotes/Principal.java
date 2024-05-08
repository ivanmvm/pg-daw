package prog.ivan;

public class Principal {
    public static void main(String[] args) {
        GestorNotes gestor = new GestorNotes();

        // Exemple: Registra les notes d'un alumne
        double[] notesAlumne1 = {8.5, 7.0, 9.2};
        gestor.registrarNotes("Iván", notesAlumne1);

        // Exemple: Obtenir les notes d'un alumne
        double[] notesObtingudes = gestor.obtenirNotes("Iván");
        System.out.println("Notes de l'alumne Iván:");
        for (double nota : notesObtingudes) {
            System.out.println(nota);
        }

        // Exemple: Càlcul d'estadístiques
        CalculadoraEstadistiques calculadora = new CalculadoraEstadistiques();
        double mitjana = calculadora.calcularMitjana(notesObtingudes);
        double maxim = calculadora.calcularMaxim(notesObtingudes);
        double minim = calculadora.calcularMinim(notesObtingudes);

        System.out.println("Mitjana: " + mitjana);
        System.out.println("Nota màxima: " + maxim);
        System.out.println("Nota mínima: " + minim);
    }
}