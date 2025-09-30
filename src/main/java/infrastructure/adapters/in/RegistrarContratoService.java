package main.java.infrastructure.adapters.in;


import main.java.application.usecases.RegistrarContratoUseCase;
import main.java.application.usecases.ContratoRepository;
import main.java.application.dto.ContratoDTO;
import main.java.application.mappers.ContratoMapper;
import main.java.domain.contratos.Contrato;


public class RegistrarContratoService implements RegistrarContratoUseCase {
    private final ContratoRepository contratoRepository; // atributo de clase

    public RegistrarContratoService(ContratoRepository repo) {
        this.contratoRepository = repo; // inicializamos el atributo
    }

    @Override
    public void registrar(ContratoDTO contratoDTO) {
        Contrato contrato = ContratoMapper.toDomain(contratoDTO);
        contratoRepository.guardar(contrato); // usamos el repo inyectado
    }
}
