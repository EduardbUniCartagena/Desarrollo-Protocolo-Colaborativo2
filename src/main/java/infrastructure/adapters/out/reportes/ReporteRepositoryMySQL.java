package main.java.infrastructure.adapters.out.reportes;

import main.java.application.usecases.reportes.ReporteRepository;
import main.java.infrastructure.adapters.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReporteRepositoryMySQL implements ReporteRepository {

    @Override
    public List<String[]> obtenerContratosConPatrocinador() {
        // Consulta con JOIN: Une Contratos con Patrocinadores
        String sql = "SELECT c.numero_contrato, p.nombre, c.fecha_inicio, c.importe_total " +
                "FROM contratopublicidad c " +
                "JOIN patrocinador p ON c.id_patrocinador = p.id_patrocinador";

        return ejecutarConsulta(sql, 4); // 4 columnas
    }

    @Override
    public List<String[]> obtenerTotalInversionPorPatrocinador() {
        // Consulta de Agregación: Suma cuánto ha gastado cada patrocinador
        String sql = "SELECT p.nombre, SUM(c.importe_total) as total " +
                "FROM contratopublicidad c " +
                "JOIN patrocinador p ON c.id_patrocinador = p.id_patrocinador " +
                "GROUP BY p.nombre";

        return ejecutarConsulta(sql, 2); // 2 columnas
    }

    @Override
    public List<String[]> obtenerProgramacionPorEmisora() {
        // Consulta Compleja: Une Programa, ProgramaEmision y Emisora
        String sql = "SELECT e.nombre, pr.nombre, pe.dia_semana, pe.hora_inicio " +
                "FROM programaemision pe " +
                "JOIN emisora e ON pe.NIF_emisora = e.NIF " +
                "JOIN programa pr ON pe.id_programa = pr.id_programa " +
                "ORDER BY e.nombre, pe.dia_semana";

        return ejecutarConsulta(sql, 4);
    }

    // Método auxiliar para no repetir código JDBC
    private List<String[]> ejecutarConsulta(String sql, int numColumnas) {
        List<String[]> resultados = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String[] fila = new String[numColumnas];
                for (int i = 0; i < numColumnas; i++) {
                    // SQL indexa desde 1
                    fila[i] = rs.getString(i + 1);
                }
                resultados.add(fila);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error en reporte: " + e.getMessage(), e);
        }
        return resultados;
    }
}