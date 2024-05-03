// Clase Bicicleta
class Bicicleta {
    private String tipo;
    private double velocidad;

    public Bicicleta(String tipo) {
        this.tipo = tipo;
        this.velocidad = 0.0;
    }

    public void accelerate() {
        // Lógica para acelerar la bicicleta
        velocidad += 2.0;
    }

    public void brake() {
        // Lógica para frenar la bicicleta
        velocidad -= 1.0;
    }

    public double getCurrentSpeed() {
        return velocidad;
    }
}
