public class EmpleatPerComisio extends Empleat {
    private double vendesRealitzades;
    private double comisioPerVenta;

    public EmpleatPerComisio(String nom, double salari, double vendesRealitzades, double comisioPerVenta) {
        super(nom, salari);
        this.vendesRealitzades = vendesRealitzades;
        this.comisioPerVenta = comisioPerVenta;
    }

    public double calcularSalari() {
        return super.getSalari() + (vendesRealitzades * comisioPerVenta);
    }
}
