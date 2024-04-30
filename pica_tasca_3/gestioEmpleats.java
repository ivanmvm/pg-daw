public class Empleat {
    private String nom;
    private String cognom;
    private double sou;

    public Empleat(String nom, String cognom, double sou) {
        this.nom = nom;
        this.cognom = cognom;
        this.sou = sou;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    public double getSou() {
        return sou;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public void setSou(double sou) {
        this.sou = sou;
    }

    @Override
    public String toString() {
        return "Empleat{" +
                "nom='" + nom + '\'' +
                ", cognom='" + cognom + '\'' +
                ", sou=" + sou +
                '}';
    }

    public static void main(String[] args) {
        Empleat empleat1 = new Empleat("Joel", "Jara", 3300.0);
        Empleat empleat2 = new Empleat("Ayman", "Bourhim", 5000.0);

        System.out.println("Detalls de l'empleat 1:");
        System.out.println(empleat1);

        System.out.println("\nDetalls de l'empleat 2:");
        System.out.println(empleat2);
    }
}

class EmpleatTempsComplet extends Empleat {
    public EmpleatTempsComplet(String nom, String cognom, double sou) {
        super(nom, cognom, sou);
    }

    @Override
    public String toString() {
        return "Empleat a temps complet: " + super.toString();
    }
}

class EmpleatTempsParcial extends Empleat {
    private int horesSetmanals;

    public EmpleatTempsParcial(String nom, String cognom, double sou, int horesSetmanals) {
        super(nom, cognom, sou);
        this.horesSetmanals = horesSetmanals;
    }

    @Override
    public String toString() {
        return "Empleat a temps parcial: " + super.toString() +
                ", hores setmanals=" + horesSetmanals;
    }
}