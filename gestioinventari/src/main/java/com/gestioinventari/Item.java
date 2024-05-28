package com.gestioinventari;

public class Item {
    private int id;
    private String nom;
    private String tipus;
    private double valor;
    private double pes;

    public Item(int id, String nom, String tipus, double valor, double pes) {
        this.id = id;
        this.nom = nom;
        this.tipus = tipus;
        this.valor = valor;
        this.pes = pes;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getTipus() {
        return tipus;
    }

    public double getValor() {
        return valor;
    }

    public double getPes() {
        return pes;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", tipus='" + tipus + '\'' +
                ", valor=" + valor +
                ", pes=" + pes +
                '}';
    }

    public String toJSON() {
        return "{\"id\":" + id + ",\"nom\":\"" + nom + "\",\"tipus\":\"" + tipus + "\",\"valor\":" + valor + ",\"pes\":" + pes + "}";
    }

    public static Item fromJSON(String json) {
        json = json.replaceAll("[{}\"]", "");
        String[] parts = json.split(",");
        int id = Integer.parseInt(parts[0].split(":")[1]);
        String nom = parts[1].split(":")[1];
        String tipus = parts[2].split(":")[1];
        double valor = Double.parseDouble(parts[3].split(":")[1]);
        double pes = Double.parseDouble(parts[4].split(":")[1]);

        return new Item(id, nom, tipus, valor, pes);
    }
}
