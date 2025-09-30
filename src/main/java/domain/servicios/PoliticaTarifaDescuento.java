package main.java.domain.servicios;

import main.java.domain.contratos.Duracion;
import main.java.domain.contratos.Importe;

public class PoliticaTarifaDescuento implements PoliticaCalculoTarifa {
    private final double porcentajeDescuento;

    public PoliticaTarifaDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public Importe calcular(Duracion duracion, double valorPorSegundo) {
        int segundosTotales = duracion.getMeses() * 30 * 10;
        double total = segundosTotales * valorPorSegundo;
        double conDescuento = total * (1 - porcentajeDescuento / 100);
        return new Importe(conDescuento);
    }
}