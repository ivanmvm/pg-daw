public class Main {
    public static void main(String[] args) {
        Botiga botiga = new Botiga();

        // Afegir diferents tipus de productes
        botiga.afegirProducte(new Aliment(1, "Iogurt", 1.5, "2024-05-10"));
        botiga.afegirProducte(new Electrodomestic(2, "Rentadora", 300, 12));
        botiga.afegirProducte(new Llibre(3, "El libro troll", 20, "Ruben García", 1000));

        // Calcular preu total i mostrar detalls dels productes
        System.out.println("Preu total de la botiga: " + botiga.calcularPreuTotal());
        System.out.println("Detalls dels productes:");
        botiga.mostrarDetallsProductes();
    }
}
