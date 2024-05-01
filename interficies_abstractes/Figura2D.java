// Classe abstracta Figura2D
abstract class Figura2D implements FiguraGeometrica {
    private String nom;

    public Figura2D(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}
