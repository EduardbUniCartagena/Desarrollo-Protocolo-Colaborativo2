package main.java.application.usecases;

import main.java.application.dto.ContratoActualizarDTO;
import main.java.application.mappers.ContratoMapper;
import main.java.domain.contratos.Contrato;
import main.java.domain.excepciones.DomainException;

/**
 * Caso de uso para actualizar un contrato existente.
 */
public class ActualizarContratoUseCase {

    private final ContratoRepository contratoRepository;

    public ActualizarContratoUseCase(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    /**
     * Ejecuta la actualización del contrato.
     *
     * @param dto Datos necesarios para actualizar el contrato
     * @return El contrato actualizado
     * @throws DomainException Si el contrato no existe
     */
    public Contrato ejecutar(ContratoActualizarDTO dto) {

        // 1. Buscar el contrato
        Contrato contratoExistente = contratoRepository.buscarPorNumero(dto.getId());

        if (contratoExistente == null) {
            throw new DomainException("No existe un contrato con ID: " + dto.getId());
        }

        // 2. Aplicar cambios usando el mapper inmutable
        Contrato contratoActualizado = ContratoMapper.actualizarDesdeDTO(contratoExistente, dto);

        // 3. Actualizar en el repositorio
        contratoRepository.actualizar(contratoActualizado);

        return contratoActualizado;
    }
}
