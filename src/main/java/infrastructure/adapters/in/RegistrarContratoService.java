package main.java.infrastructure.adapters.in;

import main.java.application.dto.ContratoCrearDTO;
import main.java.application.usecases.RegistrarContratoUseCase;
import main.java.application.usecases.ContratoRepository;
import main.java.application.mappers.ContratoMapper;
import main.java.domain.contratos.Contrato;

public class RegistrarContratoService implements RegistrarContratoUseCase {

    private final ContratoRepository contratoRepository;

    public RegistrarContratoService(ContratoRepository repo) {
        this.contratoRepository = repo;
    }

    @Override
    public void registrar(ContratoCrearDTO dto) {

        // Convertimos el DTO de creación al dominio
        Contrato contrato = ContratoMapper.fromCrearDTO(dto);

        // Guardamos el contrato usando el repositorio
        contratoRepository.guardar(contrato);
    }
}
