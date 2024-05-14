package com.jocrol;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Ruta al fitxer XML
            String rutaXML = Main.class.getClassLoader().getResource("personatges.xml").getPath();
            
            // Carregar personatges des de l'XML
            List<Personatge> personatges = CarregadorXML.carregarPersonatges(rutaXML);
            
            // Imprimir els personatges carregats
            for (Personatge personatge : personatges) {
                System.out.println("Nom: " + personatge.getNom());
                System.out.println("Nivell: " + personatge.getNivell());
                System.out.println("Punts de Vida: " + personatge.getPuntsDeVida());
                System.out.println("Punts de Mana: " + personatge.getPuntsDeMana());
                System.out.println("Arma: " + personatge.getArma());
                System.out.println("Armadura: " + personatge.getArmadura());
                System.out.println("--------------------");
            }
        } catch (Exception e) {
            System.err.println("Error al carregar personatges: " + e.getMessage());
        }
    }
}
