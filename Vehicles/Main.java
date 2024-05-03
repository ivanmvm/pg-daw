// Clase principal Main
public class Main {
    public static void main(String[] args) {
        Automovil miAuto = new Automovil("Toyota");
        Bicicleta miBicicleta = new Bicicleta("Montaña");

        miAuto.accelerate();
        miBicicleta.accelerate();

        System.out.println("Velocidad del automóvil: " + miAuto.getCurrentSpeed() + " km/h");
        System.out.println("Velocidad de la bicicleta: " + miBicicleta.getCurrentSpeed() + " km/h");
    }
}