// Clase Automóvil
class Automovil {
    private String marca;
    private double velocidad;

    public Automovil(String marca) {
        this.marca = marca;
        this.velocidad = 0.0;
    }

    public void accelerate() {
        velocidad += 10.0;
    }

    public void brake() {
        velocidad -= 5.0;
    }

    public double getCurrentSpeed() {
        return velocidad;
    }
}