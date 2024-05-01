// Classe principal (Main)
public class Main {
    public static void main(String[] args) {
        Cercle cercle = new Cercle("Cercle", 5.0);
        Rectangle rectangle = new Rectangle("Rectangle", 4.0, 6.0);

        System.out.println("Àrea del " + cercle.getNom() + ": " + cercle.calcularArea());
        System.out.println("Perímetre del " + cercle.getNom() + ": " + cercle.calcularPerimetre());

        System.out.println("Àrea del " + rectangle.getNom() + ": " + rectangle.calcularArea());
        System.out.println("Perímetre del " + rectangle.getNom() + ": " + rectangle.calcularPerimetre());
    }
}