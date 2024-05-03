public class Llibre extends Producte {
    private String autor;
    private int numPagines;

    public Llibre(int codi, String nom, double preu, String autor, int numPagines) {
        super(codi, nom, preu);
        this.autor = autor;
        this.numPagines = numPagines;
    }

    @Override
    public double calcularPreuFinal() {
        return getPreu();
    }
}
