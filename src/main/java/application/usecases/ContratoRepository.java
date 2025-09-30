package main.java.application.usecases;

import main.java.domain.contratos.Contrato;

public interface ContratoRepository {
    void guardar(Contrato contrato);
    Contrato buscarPorNumero(String numeroContrato);
}