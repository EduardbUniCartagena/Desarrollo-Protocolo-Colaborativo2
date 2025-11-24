package main.java.infrastructure.adapters.in.emisoras;

import main.java.application.usecases.emisoras.EliminarEmisoraUseCase;

public class EliminarEmisoraService {

    private final EliminarEmisoraUseCase eliminarEmisoraUseCase;

    public EliminarEmisoraService(EliminarEmisoraUseCase eliminarEmisoraUseCase) {
        this.eliminarEmisoraUseCase = eliminarEmisoraUseCase;
    }

    /**
     * Elimina una emisora por su NIF.
     *
     * @param nif Identificador de la emisora que se quiere eliminar
     */
    public void eliminar(String nif) {
        eliminarEmisoraUseCase.ejecutar(nif);
    }
}
