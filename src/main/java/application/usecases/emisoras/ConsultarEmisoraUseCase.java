package main.java.application.usecases.emisoras;

import main.java.application.dto.emisoras.EmisoraRespuestaDTO;
import main.java.application.mappers.EmisoraMapper;
import main.java.domain.emisoras.Emisora;

public class ConsultarEmisoraUseCase {

    private final EmisoraRepository repository;

    public ConsultarEmisoraUseCase(EmisoraRepository repository) {
        this.repository = repository;
    }

    public EmisoraRespuestaDTO ejecutar(String nif) {

        // Validación
        if (nif == null || nif.isBlank()) {
            throw new IllegalArgumentException("El NIF no puede estar vacío");
        }

        // Buscar emisora
        Emisora emisora = repository.buscarPorNif(nif);

        if (emisora == null) {
            throw new IllegalArgumentException(
                    "No existe una emisora registrada con el NIF: " + nif
            );
        }

        // Convertir y retornar
        return EmisoraMapper.toDTO(emisora);
    }
}
