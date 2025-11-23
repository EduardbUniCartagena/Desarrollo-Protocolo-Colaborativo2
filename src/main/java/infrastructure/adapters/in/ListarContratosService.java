package main.java.infrastructure.adapters.in;

import main.java.application.usecases.ListarContratosUseCase;
import main.java.domain.contratos.Contrato;

import java.util.List;

public class ListarContratosService {

    private final ListarContratosUseCase listarContratosUseCase;

    public ListarContratosService(ListarContratosUseCase listarContratosUseCase) {
        this.listarContratosUseCase = listarContratosUseCase;
    }

    /**
     * Lista todos los contratos existentes en el sistema.
     *
     * @return Lista de contratos
     */
    public List<Contrato> listar() {
        return listarContratosUseCase.ejecutar();
    }
}
