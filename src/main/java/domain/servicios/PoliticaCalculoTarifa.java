package main.java.domain.servicios;


import main.java.domain.contratos.Duracion;
import main.java.domain.contratos.Importe;

public interface PoliticaCalculoTarifa {
    Importe calcular(Duracion duracion, double valorPorSegundo);
}
