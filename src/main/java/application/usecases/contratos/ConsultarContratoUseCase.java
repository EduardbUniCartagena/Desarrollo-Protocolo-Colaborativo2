package main.java.application.usecases.contratos;

import main.java.domain.contratos.Contrato;
import main.java.domain.excepciones.DomainException;

public class ConsultarContratoUseCase {

    private final ContratoRepository contratoRepository;

    public ConsultarContratoUseCase(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    /**
     * Permite consultar un contrato por su identificador.
     *
     * @param id Identificador único del contrato
     * @return El contrato encontrado
     * @throws DomainException Si el contrato no existe
     */
    public Contrato ejecutar(String id) {
        Contrato contrato = contratoRepository.buscarPorNumero(id);

        if (contrato == null) {
            throw new DomainException("El contrato con ID " + id + " no existe.");
        }

        return contrato;
    }
}
