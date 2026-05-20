package org.example;

import java.sql.*;
import org.h2.tools.Server;

public class MovieDemo {

    private static final String URL = "jdbc:h2:mem:moviesdb;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try {
            Server webServer = Server.createWebServer("-webPort", "8082", "-tcpAllowOthers").start();
            System.out.println("H2 Console: http://localhost:8082\n");

            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

                createTable(connection);

                insertMovie(connection, "Cocaine Bear", "Elizabeth Banks", 2023, 5.9);
                insertMovie(connection, "Smile", "Parker Finn", 2022, 6.5);
                insertMovie(connection, "Tarot", "Spenser Cohen", 2024, 5.2);
                insertMovie(connection, "The Grudge", "Nicolas Pesce", 2020, 4.2);
                insertMovie(connection, "Sinners", "Ryan Coogler", 2025, 7.3);

                System.out.println("Toate filemele:");
                printAllMovies(connection);

                updateMovieRating(connection, 2, 7.0);
                System.out.println("\nActualizare rating Smile:");
                printAllMovies(connection);

                deleteMovie(connection, 3);
                System.out.println("\nStergere Tarot:");
                printAllMovies(connection);

                System.out.println("\nApasa ENTER pentru iesire");
                System.in.read();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String sql = """
            CREATE TABLE movies (
                id INT AUTO_INCREMENT PRIMARY KEY,
                title VARCHAR(200) NOT NULL,
                director VARCHAR(100) NOT NULL,
                release_year INT NOT NULL,
                rating DOUBLE NOT NULL
            )
            """;

        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    private static void insertMovie(Connection connection, String title, String director,
                                    int releaseYear, double rating) throws SQLException {
        String sql = "INSERT INTO movies (title, director, release_year, rating) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, title);
            ps.setString(2, director);
            ps.setInt(3, releaseYear);
            ps.setDouble(4, rating);
            ps.executeUpdate();
        }
    }

    private static void printAllMovies(Connection connection) throws SQLException {
        String sql = "SELECT id, title, director, release_year, rating FROM movies ORDER BY id";

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " - " +
                                rs.getString("title") + " , " +
                                rs.getString("director") + " , " +
                                rs.getInt("release_year") + " , " +
                                rs.getDouble("rating")
                );
            }
        }
    }

    private static void updateMovieRating(Connection connection, int id, double newRating) throws SQLException {
        String sql = "UPDATE movies SET rating = ? WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDouble(1, newRating);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    private static void deleteMovie(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM movies WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}