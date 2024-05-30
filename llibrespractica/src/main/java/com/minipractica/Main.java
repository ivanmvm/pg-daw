package com.minipractica;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            DatabaseManager dbManager = new DatabaseManager();

            // Afegir un nou llibre
            Book newBook = new Book(0, "DAW", "Manuel Molina", 29.99);
            dbManager.addBook(newBook);

            // Recuperar tots els llibres
            List<Book> books = dbManager.getAllBooks();
            for (Book book : books) {
                System.out.println(book);
            }

            // Actualitzar un llibre existent
            Book updatedBook = new Book(1, "DIW", "Jose Aranda", 39.99);
            dbManager.updateBook(updatedBook);

            // Eliminar un llibre
            dbManager.deleteBook(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
