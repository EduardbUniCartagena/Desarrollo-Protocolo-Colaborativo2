package main.java.application.usecases;

import main.java.domain.contratos.Contrato;
import java.util.List;

public interface ContratoRepository {

    // CREATE
    void guardar(Contrato contrato);

    // READ (uno)
    Contrato buscarPorNumero(String numeroContrato);

    // READ (todos)
    List<Contrato> listarTodos();

    // UPDATE
    void actualizar(Contrato contrato);

    // DELETE
    void eliminar(String numeroContrato);
}
