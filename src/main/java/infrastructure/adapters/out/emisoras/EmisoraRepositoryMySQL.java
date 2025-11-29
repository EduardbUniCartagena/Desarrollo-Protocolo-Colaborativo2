package main.java.infrastructure.adapters.out.emisoras;

import main.java.application.usecases.emisoras.EmisoraRepository;
import main.java.domain.emisoras.Emisora;
import main.java.infrastructure.adapters.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmisoraRepositoryMySQL implements EmisoraRepository {

    @Override
    public void guardar(Emisora emisora) {
        // SQL para insertar. Usamos ON DUPLICATE KEY UPDATE para que sirva de "Guardar o Actualizar"
        String sql = "INSERT INTO emisora (NIF, nombre) VALUES (?, ?) " +
                "ON DUPLICATE KEY UPDATE nombre = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, emisora.getNif());
            stmt.setString(2, emisora.getNombre());
            stmt.setString(3, emisora.getNombre()); // Para el update

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error SQL al guardar emisora: " + e.getMessage(), e);
        }
    }

    @Override
    public Emisora buscarPorNif(String nif) {
        String sql = "SELECT * FROM emisora WHERE NIF = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nif);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Mapeamos de la Tabla -> Objeto Java
                    return new Emisora(
                            rs.getString("NIF"),
                            rs.getString("nombre")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error SQL al buscar emisora: " + e.getMessage(), e);
        }
        return null; // Si no encuentra nada
    }

    @Override
    public List<Emisora> listarTodas() {
        List<Emisora> lista = new ArrayList<>();
        String sql = "SELECT * FROM emisora";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(new Emisora(
                        rs.getString("NIF"),
                        rs.getString("nombre")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error SQL al listar emisoras: " + e.getMessage(), e);
        }
        return lista;
    }

    @Override
    public void eliminar(String nif) {
        String sql = "DELETE FROM emisora WHERE NIF = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nif);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error SQL al eliminar emisora: " + e.getMessage(), e);
        }
    }
}