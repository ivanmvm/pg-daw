// Classe Cercle
class Cercle extends Figura2D {
    private double radi;

    public Cercle(String nom, double radi) {
        super(nom);
        this.radi = radi;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radi * radi;
    }

    @Override
    public double calcularPerimetre() {
        return 2 * Math.PI * radi;
    }
}
