package main.java.application.usecases.contratos;

import main.java.domain.excepciones.DomainException;

/**
 * Caso de uso para eliminar un contrato existente.
 */
public class EliminarContratoUseCase {

    private final ContratoRepository contratoRepository;

    public EliminarContratoUseCase(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    /**
     * Ejecuta la eliminación del contrato.
     *
     * @param id Identificador del contrato a eliminar
     * @throws DomainException Si el contrato no existe
     */
    public void ejecutar(String id) {

        // 1. Validar existencia
        if (contratoRepository.buscarPorNumero(id) == null) {
            throw new DomainException("No existe un contrato con ID: " + id);
        }

        // 2. Eliminar
        contratoRepository.eliminar(id);
    }
}
