package main.java.domain.contratos;

import main.java.domain.excepciones.ContratoVencidoException;
import java.time.LocalDate;

public class Contrato {

    private final String numeroContrato;
    private final Patrocinador patrocinador;
    private final Duracion duracion;
    private final Importe importeTotal;
    private final LocalDate fechaInicio;
    private final boolean activo;

    // Constructor principal
    public Contrato(String numeroContrato, Patrocinador patrocinador,
                    Duracion duracion, Importe importeTotal) {

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

    // Constructor secundario (para actualizaciones sin perder fecha de inicio)
    private Contrato(String numeroContrato, Patrocinador patrocinador,
                     Duracion duracion, Importe importeTotal,
                     LocalDate fechaInicio, boolean activo) {

        this.numeroContrato = numeroContrato;
        this.patrocinador = patrocinador;
        this.duracion = duracion;
        this.importeTotal = importeTotal;
        this.fechaInicio = fechaInicio;
        this.activo = activo;
    }

    // Factory method
    public static Contrato crear(String numeroContrato, Patrocinador patrocinador,
                                 Duracion duracion, Importe importeTotal) {

        return new Contrato(numeroContrato, patrocinador, duracion, importeTotal);
    }

    // Método de dominio para actualización inmutable
    public Contrato actualizar(Patrocinador nuevoPatrocinador,
                               Duracion nuevaDuracion,
                               Importe nuevoImporte) {

        if (nuevoPatrocinador == null) {
            throw new IllegalArgumentException("El patrocinador es obligatorio");
        }
        if (nuevaDuracion == null) {
            throw new IllegalArgumentException("La duración es obligatoria");
        }
        if (nuevoImporte == null) {
            throw new IllegalArgumentException("El importe es obligatorio");
        }

        // Devolvemos un NUEVO contrato (INMUTABLE)
        return new Contrato(
                this.numeroContrato,
                nuevoPatrocinador,
                nuevaDuracion,
                nuevoImporte,
                this.fechaInicio,   // no perder fecha original
                this.activo         // conservar estado
        );
    }

    public boolean estaVencido() {
        return fechaInicio.plusMonths(duracion.getMeses()).isBefore(LocalDate.now());
    }

    public void asignarPublicidad(String programa, int segundos) {
        if (estaVencido()) {
            throw new ContratoVencidoException("No se puede asignar publicidad a un contrato vencido");
        }
        System.out.println("Publicidad asignada al programa " + programa + " por " + segundos + " segundos.");
    }

    // Getters
    public String getNumeroContrato() {
        return numeroContrato;
    }

    public Patrocinador getPatrocinador() {
        return patrocinador;
    }

    public Duracion getDuracion() {
        return duracion;
    }

    public Importe getImporteTotal() {
        return importeTotal;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public boolean isActivo() {
        return activo;
    }
}
