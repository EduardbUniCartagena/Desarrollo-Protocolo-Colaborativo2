package main.java.application.usecases.emisoras;

import java.util.List;
import java.util.stream.Collectors;

import main.java.application.dto.emisoras.EmisoraRespuestaDTO;
import main.java.application.mappers.EmisoraMapper;
import main.java.domain.emisoras.Emisora;

public class ListarEmisorasUseCase {

    private final EmisoraRepository repository;

    public ListarEmisorasUseCase(EmisoraRepository repository) {
        this.repository = repository;
    }

    public List<EmisoraRespuestaDTO> ejecutar() {

        // Obtener todas las emisoras del repositorio
        List<Emisora> emisoras = repository.listarTodas();

        // Mapear cada una al DTO
        return emisoras.stream()
                .map(EmisoraMapper::toDTO)
                .collect(Collectors.toList());
    }
}
