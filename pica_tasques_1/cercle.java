public class Cercle {
    private double radi;

    public Cercle(double radi) {
        this.radi = radi;
    }

    public double getRadi() {
        return radi;
    }

    public void setRadi(double radi) {
        this.radi = radi;
    }

    public double calcularArea() {
        return Math.PI * Math.pow(radi, 2);
    }

    public double calcularPerimetre() {
        return 2 * Math.PI * radi;
    }
}