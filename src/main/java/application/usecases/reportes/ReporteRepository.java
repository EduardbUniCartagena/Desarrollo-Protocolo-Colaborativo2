package main.java.application.usecases.reportes;

import java.util.List;

public interface ReporteRepository {
    // Consulta 1: Listar contratos con el nombre real del patrocinador (JOIN)
    List<String[]> obtenerContratosConPatrocinador();

    // Consulta 2: Total de dinero invertido por cada patrocinador (GROUP BY + SUM)
    List<String[]> obtenerTotalInversionPorPatrocinador();

    // Consulta 3: Programas que tiene cada Emisora (JOIN de 3 tablas)
    List<String[]> obtenerProgramacionPorEmisora();
}