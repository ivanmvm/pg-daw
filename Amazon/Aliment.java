public class Aliment extends Producte {
    private String dataCaducitat;

    public Aliment(int codi, String nom, double preu, String dataCaducitat) {
        super(codi, nom, preu);
        this.dataCaducitat = dataCaducitat;
    }

    @Override
    public double calcularPreuFinal() {
        return getPreu();
    }
}
