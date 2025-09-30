package main.java.domain.servicios;

import main.java.domain.contratos.Duracion;
import main.java.domain.contratos.Importe;

public class PoliticaTarifaNormal implements PoliticaCalculoTarifa {
    @Override
    public Importe calcular(Duracion duracion, double valorPorSegundo) {
        int segundosTotales = duracion.getMeses() * 30 * 10;
        double total = segundosTotales * valorPorSegundo;
        return new Importe(total);
    }
}