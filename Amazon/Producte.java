public abstract class Producte {
    private int codi;
    private String nom;
    private double preu;

    public Producte(int codi, String nom, double preu) {
        this.codi = codi;
        this.nom = nom;
        this.preu = preu;
    }

    public abstract double calcularPreuFinal();

    public int getCodi() {
        return codi;
    }

    public String getNom() {
        return nom;
    }

    public double getPreu() {
        return preu;
    }
}
