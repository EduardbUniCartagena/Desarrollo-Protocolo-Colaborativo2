package main.java.domain.eventos;

import java.time.LocalDateTime;

public class ContratoDePublicidadCreado {
    private final String numeroContrato;
    private final String patrocinadorId;
    private final LocalDateTime fechaCreacion;

    public ContratoDePublicidadCreado(String numeroContrato, String patrocinadorId) {
        this.numeroContrato = numeroContrato;
        this.patrocinadorId = patrocinadorId;
        this.fechaCreacion = LocalDateTime.now();
    }

    public String getNumeroContrato() {
        return numeroContrato;
    }

    public String getPatrocinadorId() {
        return patrocinadorId;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
}