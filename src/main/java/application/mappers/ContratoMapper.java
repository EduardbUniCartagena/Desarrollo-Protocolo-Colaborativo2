package main.java.application.mappers;

import main.java.application.dto.ContratoDTO;
import main.java.domain.contratos.Contrato;
import main.java.domain.contratos.Duracion;
import main.java.domain.contratos.Importe;
import main.java.domain.contratos.Patrocinador;

public class ContratoMapper {
    public static Contrato toDomain(ContratoDTO dto) {
        Patrocinador patrocinador = new Patrocinador(dto.patrocinadorId, "Nombre genérico");
        return Contrato.crear(dto.numeroContrato, patrocinador, new Duracion(dto.meses), new Importe(dto.importeTotal));
    }

    public static ContratoDTO toDTO(Contrato contrato) {
        ContratoDTO dto = new ContratoDTO();
        dto.numeroContrato = contrato.getNumeroContrato();
        dto.patrocinadorId = String.valueOf(contrato.getPatrocinador().getId());
        dto.meses = contrato.getDuracion().getMeses();
        dto.importeTotal = contrato.getImporteTotal().getValor();
        return dto;
    }
}
