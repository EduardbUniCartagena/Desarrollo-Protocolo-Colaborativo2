package main.java.domain.contratos;

import main.java.domain.excepciones.ContratoVencidoException;
import java.time.LocalDate;

public class Contrato {
    private final String numeroContrato;
    private final Patrocinador patrocinador;
    private final Duracion duracion;
    private final Importe importeTotal;
    private final LocalDate fechaInicio;
    private boolean activo;

    public Contrato(String numeroContrato, Patrocinador patrocinador, Duracion duracion, Importe importeTotal) {
        if (patrocinador == null) throw new IllegalArgumentException("Patrocinador requerido");
        if (duracion == null) throw new IllegalArgumentException("Duración requerida");
        if (importeTotal == null) throw new IllegalArgumentException("Importe requerido");

        this.numeroContrato = numeroContrato;
        this.patrocinador = patrocinador;
        this.duracion = duracion;
        this.importeTotal = importeTotal;
        this.fechaInicio = LocalDate.now();
        this.activo = true;
    }

    public boolean estaVencido() {
        return fechaInicio.plusMonths(duracion.getMeses()).isBefore(LocalDate.now());
    }

    public void asignarPublicidad(String programa, int segundos) {
        if (estaVencido()) {
            throw new ContratoVencidoException("No se puede asignar publicidad a un contrato vencido");
        }
        // lógica simplificada de asignación
        System.out.println("Publicidad asignada al programa " + programa + " por " + segundos + " segundos.");
    }
    // Factory method
    public static Contrato crear(String numeroContrato, Patrocinador patrocinador, Duracion duracion, Importe importeTotal) {
        if (patrocinador == null) {
            throw new IllegalArgumentException("El patrocinador es obligatorio");
        }
        if (duracion == null) {
            throw new IllegalArgumentException("La duración es obligatoria");
        }
        if (importeTotal == null) {
            throw new IllegalArgumentException("El importe es obligatorio");
        }
        return new Contrato(numeroContrato, patrocinador, duracion, importeTotal);
    }
}