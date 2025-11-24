package main.java.infrastructure.adapters.in.emisoras;

import main.java.application.dto.emisoras.EmisoraRespuestaDTO;
import main.java.application.usecases.emisoras.ConsultarEmisoraUseCase;

public class ConsultarEmisoraService {

    private final ConsultarEmisoraUseCase consultarEmisoraUseCase;

    public ConsultarEmisoraService(ConsultarEmisoraUseCase consultarEmisoraUseCase) {
        this.consultarEmisoraUseCase = consultarEmisoraUseCase;
    }

    /**
     * Consulta una emisora por su NIF.
     *
     * @param nif Identificador de la emisora
     * @return DTO con los datos de la emisora
     */
    public EmisoraRespuestaDTO consultar(String nif) {
        return consultarEmisoraUseCase.ejecutar(nif);
    }
}
