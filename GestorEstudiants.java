package com.imvm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Estudiant {
    private String nom;
    private String cognom;
    private int edat;
    private List<String> materies;

    public Estudiant(String nom, String cognom, int edat) {
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
        this.materies = new ArrayList<>();
    }

    public void afegirMateria(String materia) {
        materies.add(materia);
    }

    public void eliminarMateria(String materia) {
        materies.remove(materia);
    }

    public List<String> obtenirMateries() {
        return materies;
    }

    @Override
    public String toString() {
        return nom + " " + cognom + " (" + edat + " anys)";
    }
}

public class GestorEstudiants {
    private static Map<String, Estudiant> estudiants = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcio;

        do {
            System.out.println("\n1. Afegir estudiant");
            System.out.println("2. Afegir matèria a un estudiant");
            System.out.println("3. Eliminar matèria d'un estudiant");
            System.out.println("4. Mostrar tots els estudiants");
            System.out.println("5. Mostrar matèries d'un estudiant");
            System.out.println("6. Sortir");
            System.out.print("Selecciona una opció: ");
            opcio = scanner.nextInt();
            scanner.nextLine(); // Consumir la nova línia
            switch (opcio) {
                case 1:
                    afegirEstudiant(scanner);
                    break;
                case 2:
                    afegirMateriaEstudiant(scanner);
                    break;
                case 3:
                    eliminarMateriaEstudiant(scanner);
                    break;
                case 4:
                    mostrarEstudiants();
                    break;
                case 5:
                    mostrarMateriesEstudiant(scanner);
                    break;
                case 6:
                    System.out.println("Adéu!");
                    break;
                default:
                    System.out.println("Opció no vàlida. Torna a intentar-ho.");
            }
        } while (opcio != 6);
    }

    private static void afegirEstudiant(Scanner scanner) {
        System.out.print("Nom: ");
        String nom = scanner.nextLine();
        System.out.print("Cognom: ");
        String cognom = scanner.nextLine();
        System.out.print("Edat: ");
        int edat = scanner.nextInt();
        scanner.nextLine(); // Consumir la nova línia

        Estudiant estudiant = new Estudiant(nom, cognom, edat);
        estudiants.put(nom, estudiant);
        System.out.println("Estudiant afegit amb èxit!");
    }

    private static void afegirMateriaEstudiant(Scanner scanner) {
        System.out.print("Nom de l'estudiant: ");
        String nomEstudiant = scanner.nextLine();
        Estudiant estudiant = estudiants.get(nomEstudiant);
        if (estudiant == null) {
            System.out.println("Estudiant no trobat.");
            return;
        }

        System.out.print("Matèria a afegir: ");
        String materia = scanner.nextLine();
        estudiant.afegirMateria(materia);
        System.out.println("Matèria afegida amb èxit a l'estudiant " + nomEstudiant);
    }

    private static void eliminarMateriaEstudiant(Scanner scanner) {
        System.out.print("Nom de l'estudiant: ");
        String nomEstudiant = scanner.nextLine();
        Estudiant estudiant = estudiants.get(nomEstudiant);
        if (estudiant == null) {
            System.out.println("Estudiant no trobat.");
            return;
        }

        System.out.print("Matèria a eliminar: ");
        String materia = scanner.nextLine();
        estudiant.eliminarMateria(materia);
        System.out.println("Matèria eliminada amb èxit de l'estudiant " + nomEstudiant);
    }

    private static void mostrarEstudiants() {
        System.out.println("\nEstudiants registrats:");
        for (Estudiant estudiant : estudiants.values()) {
            System.out.println(estudiant);
        }
    }

    private static void mostrarMateriesEstudiant(Scanner scanner) {
        System.out.print("Nom de l'estudiant: ");
        String nomEstudiant = scanner.nextLine();
        Estudiant estudiant = estudiants.get(nomEstudiant);
        if (estudiant == null) {
            System.out.println("Estudiant no trobat.");
            return;
        }

        List<String> materies = estudiant.obtenirMateries();
        if (materies.isEmpty()) {
            System.out.println("L'estudiant " + nomEstudiant + " no està matriculat en cap matèria.");
        } else {
            System.out.println("Matèries de l'estudiant " + nomEstudiant + ":");
            for (String materia : materies) {
                System.out.println("- " + materia);
            }
        }
    }
}