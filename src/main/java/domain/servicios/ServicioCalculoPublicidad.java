package main.java.domain.servicios;

import main.java.domain.contratos.Duracion;
import main.java.domain.contratos.Importe;

public class ServicioCalculoPublicidad {

    /**
     * Calcula el costo total de la publicidad de un contrato
     * según su duración en meses y un valor fijo por segundo.
     *
     * @param duracion Duración del contrato en meses
     * @param valorPorSegundo Valor en dinero por segundo de publicidad
     * @return Importe total a pagar
     */
    public Importe calcularCostoPublicidad(Duracion duracion, double valorPorSegundo) {
        // Supongamos que cada mes tiene 30 días y el contrato implica 10 segundos diarios de publicidad
        int segundosTotales = duracion.getMeses() * 30 * 10;
        double total = segundosTotales * valorPorSegundo;

        return new Importe(total);
    }
}
