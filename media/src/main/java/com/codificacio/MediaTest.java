package com.codificacio;

public class MediaTest {
    public static void main(String[] args) {
        MediaClass media = new MediaClass("Hábitos atómicos", "James Clear", 4);
        System.out.println("Valores Iniciales:");
        System.out.println("Nom: " + media.getNom());
        System.out.println("Autor: " + media.getAutor());
        System.out.println("Durada: " + media.getDurada() + " horas");

        media.setNom("La grieta del silencio");
        media.setAutor("Javier Castillo");
        media.setDurada(2);

        System.out.println("Valores actualizados:");
        System.out.println("Nom: " + media.getNom());
        System.out.println("Autor: " + media.getAutor());
        System.out.println("Durada: " + media.getDurada() + " horas");
    }
}