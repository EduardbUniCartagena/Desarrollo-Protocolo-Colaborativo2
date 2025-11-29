package main.java.infrastructure.adapters.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Configuración de la base de datos local
    private static final String URL = "jdbc:mysql://localhost:3306/7502420038_34_radio";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    // Método estático para obtener la conexión
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar con la base de datos: " + e.getMessage(), e);
        }
    }
}