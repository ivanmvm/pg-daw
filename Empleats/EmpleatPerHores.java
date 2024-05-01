public class EmpleatPerHores extends Empleat {
    private int horesTreballades;
    private double tarifaPerHora;

    public EmpleatPerHores(String nom, double salari, int horesTreballades, double tarifaPerHora) {
        super(nom, salari);
        this.horesTreballades = horesTreballades;
        this.tarifaPerHora = tarifaPerHora;
    }

    public double calcularSalari() {
        return horesTreballades * tarifaPerHora;
    }
}
