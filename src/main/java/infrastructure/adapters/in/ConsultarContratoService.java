package main.java.infrastructure.adapters.in;

import main.java.application.usecases.ConsultarContratoUseCase;
import main.java.domain.contratos.Contrato;

public class ConsultarContratoService {

    private final ConsultarContratoUseCase consultarContratoUseCase;

    public ConsultarContratoService(ConsultarContratoUseCase consultarContratoUseCase) {
        this.consultarContratoUseCase = consultarContratoUseCase;
    }

    /**
     * Permite consultar un contrato por su ID.
     *
     * @param id Identificador del contrato
     * @return Contrato encontrado
     */
    public Contrato consultar(String id) {
        return consultarContratoUseCase.ejecutar(id);
    }
}
