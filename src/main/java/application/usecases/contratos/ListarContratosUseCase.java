package main.java.application.usecases.contratos;

import main.java.domain.contratos.Contrato;
import java.util.List;

/**
 * Caso de uso para listar todos los contratos almacenados.
 */
public class ListarContratosUseCase {

    private final ContratoRepository contratoRepository;

    public ListarContratosUseCase(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    /**
     * Retorna una lista con todos los contratos existentes.
     *
     * @return Lista de contratos
     */
    public List<Contrato> ejecutar() {
        return contratoRepository.listarTodos();
    }
}
