package main.java.infrastructure.adapters.in;

import main.java.application.dto.ContratoActualizarDTO;
import main.java.application.usecases.ActualizarContratoUseCase;
import main.java.domain.contratos.Contrato;

public class ActualizarContratoService {

    private final ActualizarContratoUseCase actualizarContratoUseCase;

    public ActualizarContratoService(ActualizarContratoUseCase actualizarContratoUseCase) {
        this.actualizarContratoUseCase = actualizarContratoUseCase;
    }

    /**
     * Actualiza un contrato existente en el sistema.
     *
     * @param dto Datos para actualizar el contrato
     * @return El contrato actualizado
     */
    public Contrato actualizar(ContratoActualizarDTO dto) {
        return actualizarContratoUseCase.ejecutar(dto);
    }
}
