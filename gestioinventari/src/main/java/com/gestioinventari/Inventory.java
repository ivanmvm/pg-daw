package com.gestioinventari;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void afegirItem(Item item) {
        items.add(item);
    }

    public boolean eliminarItem(int id) {
        return items.removeIf(item -> item.getId() == id);
    }

    public List<Item> buscarItemsPerNom(String nom) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getNom().equalsIgnoreCase(nom)) {
                result.add(item);
            }
        }
        return result;
    }

    public List<Item> buscarItemsPerTipus(String tipus) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getTipus().equalsIgnoreCase(tipus)) {
                result.add(item);
            }
        }
        return result;
    }

    public List<Item> llistarItems() {
        return new ArrayList<>(items);
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getValor();
        }
        return total;
    }

    public double calcularPesTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getPes();
        }
        return total;
    }

    public Item itemMesValuos() {
        Item mesValuos = null;
        for (Item item : items) {
            if (mesValuos == null || item.getValor() > mesValuos.getValor()) {
                mesValuos = item;
            }
        }
        return mesValuos;
    }

    public Item itemMesPesat() {
        Item mesPesat = null;
        for (Item item : items) {
            if (mesPesat == null || item.getPes() > mesPesat.getPes()) {
                mesPesat = item;
            }
        }
        return mesPesat;
    }

    public void guardarAJSON(String ruta) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta))) {
            writer.write("[");
            for (int i = 0; i < items.size(); i++) {
                writer.write(items.get(i).toJSON());
                if (i < items.size() - 1) {
                    writer.write(",");
                }
            }
            writer.write("]");
        }
    }

    public void carregarDeJSON(String ruta) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
            String jsonString = json.toString();
            jsonString = jsonString.substring(1, jsonString.length() - 1); // Eliminar els claudàtors []
            String[] itemStrings = jsonString.split("},\\{");

            this.items.clear();
            for (String itemString : itemStrings) {
                if (!itemString.startsWith("{")) {
                    itemString = "{" + itemString;
                }
                if (!itemString.endsWith("}")) {
                    itemString = itemString + "}";
                }
                this.items.add(Item.fromJSON(itemString));
            }
        }
    }
}
