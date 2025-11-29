package main.java.application.usecases.reportes;

import java.util.List;

public class GenerarReportesUseCase {

    private final ReporteRepository repositorio;

    public GenerarReportesUseCase(ReporteRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<String[]> reporteContratosDetallados() {
        return repositorio.obtenerContratosConPatrocinador();
    }

    public List<String[]> reporteInversion() {
        return repositorio.obtenerTotalInversionPorPatrocinador();
    }

    public List<String[]> reporteProgramacion() {
        return repositorio.obtenerProgramacionPorEmisora();
    }
}