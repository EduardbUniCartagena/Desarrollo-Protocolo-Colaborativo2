package main.java.application.mappers;

import main.java.application.dto.ContratoCrearDTO;
import main.java.application.dto.ContratoActualizarDTO;
import main.java.application.dto.ContratoRespuestaDTO;

import main.java.domain.contratos.Contrato;
import main.java.domain.contratos.Patrocinador;
import main.java.domain.contratos.Duracion;
import main.java.domain.contratos.Importe;

/**
 * Mapper encargado de convertir entre entidades del dominio
 * y los diferentes DTO utilizados en los casos de uso.
 */
public class ContratoMapper {

    /**
     * Convierte un DTO de creación en una entidad Contrato.
     *
     * @param dto Datos necesarios para crear el contrato
     * @return Entidad Contrato lista para guardar
     */
    public static Contrato fromCrearDTO(ContratoCrearDTO dto) {

        Patrocinador patrocinador = new Patrocinador(dto.getPatrocinadorId());
        Duracion duracion = new Duracion(dto.getDuracionEnSegundos());
        Importe importe = new Importe(dto.getImporte());

        return Contrato.crear(
                dto.getId(),
                patrocinador,
                duracion,
                importe
        );
    }

    /**
     * Actualiza una entidad Contrato existente utilizando los datos del DTO.
     * Este método usa la función inmutable actualizar() del dominio.
     *
     * @param contratoExistente Contrato que ya existe en el sistema
     * @param dto Datos nuevos para actualizar
     * @return Nuevo contrato con los cambios aplicados
     */
    public static Contrato actualizarDesdeDTO(Contrato contratoExistente, ContratoActualizarDTO dto) {

        Patrocinador nuevoPatrocinador = new Patrocinador(dto.getPatrocinadorId());
        Duracion nuevaDuracion = new Duracion(dto.getDuracionEnSegundos());
        Importe nuevoImporte = new Importe(dto.getImporte());

        // Usamos actualización inmutable
        return contratoExistente.actualizar(
                nuevoPatrocinador,
                nuevaDuracion,
                nuevoImporte
        );
    }

    /**
     * Convierte una entidad Contrato a un DTO de respuesta.
     *
     * @param contrato Entidad del dominio
     * @return DTO para devolver datos al usuario
     */
    public static ContratoRespuestaDTO toDTO(Contrato contrato) {
        return new ContratoRespuestaDTO(
                contrato.getNumeroContrato(),
                contrato.getPatrocinador().getId(),
                contrato.getDuracion().getMeses() * 30 * 24 * 3600, // Si usas meses → ajustamos
                contrato.getImporteTotal().getValor(),
                contrato.getDuracion().getMeses()
        );
    }

}
