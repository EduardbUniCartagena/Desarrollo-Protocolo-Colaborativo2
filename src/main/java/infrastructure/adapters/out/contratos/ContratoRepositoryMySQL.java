package main.java.infrastructure.adapters.out.contratos;

import main.java.application.usecases.contratos.ContratoRepository;
import main.java.domain.contratos.*;
import main.java.infrastructure.adapters.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.Date; // Ojo: Importar java.sql.Date, no util.Date
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContratoRepositoryMySQL implements ContratoRepository {

    @Override
    public void guardar(Contrato contrato) {
        // Calculamos la fecha fin para SQL (Fecha inicio + Meses de duración)
        LocalDate fechaInicio = contrato.getFechaInicio();
        int meses = contrato.getDuracion().getMeses();
        LocalDate fechaFin = fechaInicio.plusMonths(meses);

        // NOTA: Asumimos que el patrocinador con ID 1 existe (el que creamos en el script)
        // En un sistema real, buscaríamos el ID real del patrocinador.
        int idPatrocinadorFijo = 1;

        String sql = "INSERT INTO contratopublicidad " +
                "(numero_contrato, id_patrocinador, fecha_inicio, fecha_fin, importe_total, descripcion) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, contrato.getNumeroContrato());
            stmt.setInt(2, idPatrocinadorFijo);
            stmt.setDate(3, Date.valueOf(fechaInicio)); // Conversión Java -> SQL
            stmt.setDate(4, Date.valueOf(fechaFin));
            stmt.setDouble(5, contrato.getImporteTotal().getValor());
            stmt.setString(6, "Contrato generado desde App Hexagonal");

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error SQL al guardar contrato: " + e.getMessage(), e);
        }
    }

    @Override
    public Contrato buscarPorNumero(String numeroContrato) {
        String sql = "SELECT * FROM contratopublicidad WHERE numero_contrato = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, numeroContrato);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Reconstruir el objeto complejo desde la tabla plana
                    // Recuperar datos
                    String num = rs.getString("numero_contrato");
                    double importeVal = rs.getDouble("importe_total");

                    // Reconstruir fechas para calcular duración aproximada
                    LocalDate fInicio = rs.getDate("fecha_inicio").toLocalDate();
                    LocalDate fFin = rs.getDate("fecha_fin").toLocalDate();
                    // Calculamos meses de forma simple
                    int meses = (int) java.time.temporal.ChronoUnit.MONTHS.between(fInicio, fFin);
                    if (meses == 0) meses = 1; // Mínimo 1 mes por seguridad

                    // Reconstruir Value Objects
                    Patrocinador pat = new Patrocinador("1"); // Hardcodeado por simplicidad del ejemplo
                    Duracion dur = new Duracion(meses);
                    Importe importe = new Importe(importeVal);

                    // Usamos el Factory Method del dominio
                    return Contrato.crear(num, pat, dur, importe);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar contrato: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<Contrato> listarTodos() {
        // Implementación simplificada para cumplir el contrato
        return new ArrayList<>();
    }

    @Override
    public void actualizar(Contrato contrato) {
        // Pendiente de implementación
    }

    @Override
    public void eliminar(String numeroContrato) {
        // Pendiente de implementación
    }
}