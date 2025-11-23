package main.java.infrastructure.adapters.in;

import main.java.application.usecases.EliminarContratoUseCase;

public class EliminarContratoService {

    private final EliminarContratoUseCase eliminarContratoUseCase;

    public EliminarContratoService(EliminarContratoUseCase eliminarContratoUseCase) {
        this.eliminarContratoUseCase = eliminarContratoUseCase;
    }

    /**
     * Elimina un contrato identificado por su ID.
     *
     * @param id Identificador del contrato a eliminar
     */
    public void eliminar(String id) {
        eliminarContratoUseCase.ejecutar(id);
    }
}
