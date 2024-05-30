package com.minipractica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.database.models.Book;

public class DatabaseManager
{
    private Connection connection;

    public void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://172.17.0.2:5432/Book", "postgres", "mysecretpassword");
            System.out.println("Connexio establerta.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Book getStudent(int id) {
        String query = "SELECT * FROM students WHERE id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Book(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void addStudent(Book Book) {
        String query = "INSERT INTO students (id, first_name, last_name) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);

            stmt.setInt(1, Book.getId());
            stmt.setString(2, Book.getName());
            stmt.setString(3, Book.getLastName());
            stmt.executeUpdate();
            System.out.println("Estudiant afegit.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(Book Book) {
        String query = "UPDATE students SET first_name = ?, last_name = ? WHERE id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);

            stmt.setString(1, Book.getName());
            stmt.setString(2, Book.getLastName());
            stmt.setInt(3, Book.getId());
            stmt.executeUpdate();
            System.out.println("Estudiant modificat.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        String query = "DELETE FROM students WHERE id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Estudiant eliminat.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connexio tancada");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}