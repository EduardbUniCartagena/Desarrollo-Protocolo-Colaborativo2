package test.java.application.usecases;


import main.java.application.dto.ContratoDTO;
import main.java.application.usecases.ContratoRepository;
import main.java.application.usecases.RegistrarContratoUseCase;
import main.java.infrastructure.adapters.in.RegistrarContratoService;
import main.java.infrastructure.adapters.out.ContratoRepositoryInMemory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistrarContratoUseCaseTest {

    @Test
    void debeRegistrarContratoExitosamente() {
        ContratoRepository repo = new ContratoRepositoryInMemory();
        RegistrarContratoUseCase useCase = new RegistrarContratoService(repo);

        ContratoDTO dto = new ContratoDTO();
        dto.numeroContrato = "C100";
        dto.patrocinadorId = "P01";
        dto.meses = 3;
        dto.importeTotal = 1500.0;

        useCase.registrar(dto);

        assertNotNull(repo.buscarPorNumero("C100"));
    }
}
