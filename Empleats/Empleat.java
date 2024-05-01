public class Empleat {
    private String nom;
    private double salari;

    public Empleat(String nom, double salari) {
        this.nom = nom;
        this.setSalari(salari);
    }

    public double getSalari() {
        return salari;
        
    }

    public void setSalari(double salari) {
        this.salari = salari;
        
    }

    public void imprimirDetalls() {
        System.out.println("Nom: " + nom);
        System.out.println("Salari: " + getSalari());
    }
}
