// Classe Rectangle
class Rectangle extends Figura2D {
    private double base;
    private double altura;

    public Rectangle(String nom, double base, double altura) {
        super(nom);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public double calcularPerimetre() {
        return 2 * (base + altura);
    }
}
