package com.minipractica;

public class Main {
    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();
        dbManager.connect();

        // Crear un nou llibre
        Book book = new Book(1, "Astroboy", "Osamu Tezuka");
        dbManager.addLlibre(book);

        // Recuperar llibre
        Book retrievedStudent = dbManager.getBook(1);
        System.out.println(retrievedStudent);

        // Actualitzar estudiant
        Book.setLastName("Tezuka");
        
        dbManager.updateStudent(student);

        // Eliminar estudiant
        dbManager.deleteBook(1);

        dbManager.disconnect();
    }
}