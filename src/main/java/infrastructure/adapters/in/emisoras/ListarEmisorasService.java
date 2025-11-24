package main.java.infrastructure.adapters.in.emisoras;

import main.java.application.dto.emisoras.EmisoraRespuestaDTO;
import main.java.application.usecases.emisoras.ListarEmisorasUseCase;

import java.util.List;

public class ListarEmisorasService {

    private final ListarEmisorasUseCase listarEmisorasUseCase;

    public ListarEmisorasService(ListarEmisorasUseCase listarEmisorasUseCase) {
        this.listarEmisorasUseCase = listarEmisorasUseCase;
    }

    /**
     * Lista todas las emisoras registradas en el sistema.
     *
     * @return Lista de DTOs con los datos de cada emisora
     */
    public List<EmisoraRespuestaDTO> listar() {
        return listarEmisorasUseCase.ejecutar();
    }
}
