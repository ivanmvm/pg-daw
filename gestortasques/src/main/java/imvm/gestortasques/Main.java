package imvm.gestortasques;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix el nom del fitxer de tasques: ");
        String fileName = scanner.nextLine();

        TaskManager taskManager = new TaskManager(fileName);

        while (true) {
            System.out.println("1. Afegir una nova tasca");
            System.out.println("2. Modificar una tasca existent");
            System.out.println("3. Eliminar una tasca existent");
            System.out.println("4. Visualitzar la llista de tasques");
            System.out.println("5. Sortir");
            System.out.print("Selecciona una opció: ");
            int option = Integer.parseInt(scanner.nextLine());

            if (option == 5) {
                break;
            }

            switch (option) {
                case 1:
                    System.out.print("Introdueix el títol: ");
                    String title = scanner.nextLine();
                    System.out.print("Introdueix la descripció: ");
                    String description = scanner.nextLine();
                    System.out.print("Introdueix la data de venciment (dd-MM-yyyy): ");
                    Date dueDate = null;
                    try {
                        dueDate = dateFormat.parse(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("Data de venciment no vàlida");
                        break;
                    }
                    System.out.print("Introdueix l'estat (pendent, en curs, completada): ");
                    String status = scanner.nextLine();
                    Task task = new Task(title, description, dueDate, status);
                    taskManager.addTask(task);
                    break;
                case 2:
                    taskManager.viewTasks();
                    System.out.print("Introdueix l'índex de la tasca a modificar: ");
                    int modifyIndex = Integer.parseInt(scanner.nextLine());
                    System.out.print("Introdueix el nou títol: ");
                    title = scanner.nextLine();
                    System.out.print("Introdueix la nova descripció: ");
                    description = scanner.nextLine();
                    System.out.print("Introdueix la nova data de venciment (dd-MM-yyyy): ");
                    try {
                        dueDate = dateFormat.parse(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("Data de venciment no vàlida");
                        break;
                    }
                    System.out.print("Introdueix el nou estat (pendent, en curs, completada): ");
                    status = scanner.nextLine();
                    task = new Task(title, description, dueDate, status);
                    taskManager.modifyTask(modifyIndex, task);
                    break;
                case 3:
                    taskManager.viewTasks();
                    System.out.print("Introdueix l'índex de la tasca a eliminar: ");
                    int deleteIndex = Integer.parseInt(scanner.nextLine());
                    taskManager.deleteTask(deleteIndex);
                    break;
                case 4:
                    taskManager.viewTasks();
                    break;
                default:
                    System.out.println("Opció no vàlida");
            }
        }

        scanner.close();
    }
}
