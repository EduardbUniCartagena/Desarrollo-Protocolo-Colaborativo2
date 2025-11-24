package main.java.application.mappers;

import main.java.application.dto.emisoras.EmisoraCrearDTO;
import main.java.application.dto.emisoras.EmisoraActualizarDTO;
import main.java.application.dto.emisoras.EmisoraRespuestaDTO;
import main.java.domain.emisoras.Emisora;

public class EmisoraMapper {

    // Convierte el DTO de creación en una entidad del dominio
    public static Emisora fromCrearDTO(EmisoraCrearDTO dto) {
        return new Emisora(
                dto.getNif(),
                dto.getNombre()
        );
    }

    // Actualiza la entidad del dominio utilizando el DTO de actualización
    public static Emisora actualizarDesdeDTO(Emisora emisoraExistente, EmisoraActualizarDTO dto) {
        emisoraExistente.cambiarNombre(dto.getNuevoNombre());
        return emisoraExistente;
    }

    // Convierte la entidad del dominio en un DTO de respuesta
    public static EmisoraRespuestaDTO toDTO(Emisora emisora) {
        return new EmisoraRespuestaDTO(
                emisora.getNif(),
                emisora.getNombre()
        );
    }
}
