package main.java.infrastructure.adapters.in.emisoras;

import main.java.application.dto.emisoras.EmisoraActualizarDTO;
import main.java.application.dto.emisoras.EmisoraRespuestaDTO;
import main.java.application.mappers.EmisoraMapper;
import main.java.application.usecases.emisoras.ActualizarEmisoraUseCase;
import main.java.domain.emisoras.Emisora;

public class ActualizarEmisoraService {

    private final ActualizarEmisoraUseCase actualizarEmisoraUseCase;

    public ActualizarEmisoraService(ActualizarEmisoraUseCase actualizarEmisoraUseCase) {
        this.actualizarEmisoraUseCase = actualizarEmisoraUseCase;
    }

    public EmisoraRespuestaDTO actualizar(EmisoraActualizarDTO dto) {
        Emisora emisoraActualizada = actualizarEmisoraUseCase.ejecutar(dto);
        return EmisoraMapper.toDTO(emisoraActualizada);
    }
}
