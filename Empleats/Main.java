public class Main {
    public static void main(String[] args) {
        EmpleatPerHores empleatHores = new EmpleatPerHores("Anna", 0, 40, 15.0);
        empleatHores.imprimirDetalls();
        System.out.println("Salari: " + empleatHores.calcularSalari());

        EmpleatAsalariat empleatAsalariat = new EmpleatAsalariat("Pere", 2000);
        empleatAsalariat.imprimirDetalls();

        EmpleatPerComisio empleatComisio = new EmpleatPerComisio("Carla", 1000, 5000, 0.05);
        empleatComisio.imprimirDetalls();
        System.out.println("Salari: " + empleatComisio.calcularSalari());
    }
}
