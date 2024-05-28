package com.gestioinventari;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static void mostrarMenu() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("/menu.txt")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error al carregar el menú: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        boolean sortir = false;

        while (!sortir) {
            mostrarMenu();
            System.out.print("Selecciona una opció: ");
            String opcio = scanner.nextLine();

            switch (opcio) {
                case "1":
                    System.out.print("ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nom: ");
                    String nom = scanner.nextLine();
                    System.out.print("Tipus: ");
                    String tipus = scanner.nextLine();
                    System.out.print("Valor: ");
                    double valor = Double.parseDouble(scanner.nextLine());
                    System.out.print("Pes: ");
                    double pes = Double.parseDouble(scanner.nextLine());
                    inventory.afegirItem(new Item(id, nom, tipus, valor, pes));
                    System.out.println("Ítem afegit.");
                    break;
                case "2":
                    System.out.print("ID: ");
                    id = Integer.parseInt(scanner.nextLine());
                    if (inventory.eliminarItem(id)) {
                        System.out.println("Ítem eliminat.");
                    } else {
                        System.out.println("Ítem no trobat.");
                    }
                    break;
                case "3":
                    System.out.print("Nom: ");
                    nom = scanner.nextLine();
                    List<Item> itemsNom = inventory.buscarItemsPerNom(nom);
                    System.out.println("Ítems trobats:");
                    for (Item item : itemsNom) {
                        System.out.println(item);
                    }
                    break;
                case "4":
                    System.out.print("Tipus: ");
                    tipus = scanner.nextLine();
                    List<Item> itemsTipus = inventory.buscarItemsPerTipus(tipus);
                    System.out.println("Ítems trobats:");
                    for (Item item : itemsTipus) {
                        System.out.println(item);
                    }
                    break;
                case "5":
                    List<Item> items = inventory.llistarItems();
                    System.out.println("Ítems a l'inventari:");
                    for (Item item : items) {
                        System.out.println(item);
                    }
                    break;
                case "6":
                    double valorTotal = inventory.calcularValorTotal();
                    System.out.println("Valor total de l'inventari: " + valorTotal);
                    break;
                case "7":
                    double pesTotal = inventory.calcularPesTotal();
                    System.out.println("Pes total de l'inventari: " + pesTotal);
                    break;
                case "8":
                    Item itemValuos = inventory.itemMesValuos();
                    System.out.println("Ítem més valuós: " + itemValuos);
                    break;
                case "9":
                    Item itemPesat = inventory.itemMesPesat();
                    System.out.println("Ítem més pesat: " + itemPesat);
                    break;
                case "10":
                    System.out.print("Ruta del fitxer: ");
                    String rutaGuardar = scanner.nextLine();
                    try {
                        inventory.guardarAJSON(rutaGuardar);
                        System.out.println("Inventari desat.");
                    } catch (IOException e) {
                        System.err.println("Error al desar l'inventari: " + e.getMessage());
                    }
                    break;
                case "11":
                    System.out.print("Ruta del fitxer: ");
                    String rutaCarregar = scanner.nextLine();
                    try {
                        inventory.carregarDeJSON(rutaCarregar);
                        System.out.println("Inventari carregat.");
                    } catch (IOException e) {
                        System.err.println("Error al carregar l'inventari: " + e.getMessage());
                    }
                    break;
                case "0":
                    sortir = true;
                    System.out.println("Sortint...");
                    break;
                default:
                    System.out.println("Opció no vàlida.");
                    break;
            }
        }

        scanner.close();
    }
}