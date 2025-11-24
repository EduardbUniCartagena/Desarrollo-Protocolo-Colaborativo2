package main.java.application.usecases.emisoras;

import main.java.application.dto.emisoras.EmisoraActualizarDTO;
import main.java.application.mappers.EmisoraMapper;
import main.java.domain.emisoras.Emisora;

public class ActualizarEmisoraUseCase {

    private final EmisoraRepository repository;

    public ActualizarEmisoraUseCase(EmisoraRepository repository) {
        this.repository = repository;
    }

    public Emisora ejecutar(EmisoraActualizarDTO dto) {

        // Validación básica
        if (dto.getNif() == null || dto.getNif().isBlank()) {
            throw new IllegalArgumentException("El NIF no puede estar vacío");
        }

        // Buscar emisora existente
        Emisora existente = repository.buscarPorNif(dto.getNif());

        if (existente == null) {
            throw new IllegalArgumentException(
                    "No existe una emisora registrada con el NIF: " + dto.getNif()
            );
        }

        // Actualizar datos usando tu mapper
        EmisoraMapper.actualizarDesdeDTO(existente, dto);

        // Guardar actualización
        repository.guardar(existente);

        // Retornar la entidad del dominio (NO DTO)
        return existente;
    }
}
