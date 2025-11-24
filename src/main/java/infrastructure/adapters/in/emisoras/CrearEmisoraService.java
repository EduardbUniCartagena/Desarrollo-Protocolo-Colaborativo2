package main.java.infrastructure.adapters.in.emisoras;

import main.java.application.dto.emisoras.EmisoraCrearDTO;
import main.java.application.dto.emisoras.EmisoraRespuestaDTO;
import main.java.application.usecases.emisoras.CrearEmisoraUseCase;

public class CrearEmisoraService {

    private final CrearEmisoraUseCase useCase;

    public CrearEmisoraService(CrearEmisoraUseCase useCase) {
        this.useCase = useCase;
    }

    public EmisoraRespuestaDTO crear(EmisoraCrearDTO dto) {
        return useCase.ejecutar(dto);
    }
}
