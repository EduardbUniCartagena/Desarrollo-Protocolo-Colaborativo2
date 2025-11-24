package main.java.application.usecases.emisoras;

import main.java.application.dto.emisoras.EmisoraCrearDTO;
import main.java.application.dto.emisoras.EmisoraRespuestaDTO;
import main.java.application.mappers.EmisoraMapper;
import main.java.domain.emisoras.Emisora;

public class CrearEmisoraUseCase {

    private final EmisoraRepository repository;

    public CrearEmisoraUseCase(EmisoraRepository repository) {
        this.repository = repository;
    }

    public EmisoraRespuestaDTO ejecutar(EmisoraCrearDTO dto) {

        // Validación básica
        if (dto.getNif() == null || dto.getNif().isBlank()) {
            throw new IllegalArgumentException("El NIF de la emisora no puede ser vacío");
        }

        // Validación de duplicados
        if (repository.buscarPorNif(dto.getNif()) != null) {
            throw new IllegalArgumentException(
                    "Ya existe una emisora registrada con el NIF: " + dto.getNif()
            );
        }

        // Crear entidad de dominio desde el DTO
        Emisora nueva = EmisoraMapper.fromCrearDTO(dto);

        // Guardar
        repository.guardar(nueva);

        // Respuesta DTO
        return EmisoraMapper.toDTO(nueva);
    }
}
