package test.java.application.usecases;

import main.java.application.dto.contratos.ContratoCrearDTO;
import main.java.application.usecases.contratos.ContratoRepository;
import main.java.application.usecases.contratos.RegistrarContratoUseCase;
import main.java.infrastructure.adapters.in.contratos.RegistrarContratoService;
import main.java.infrastructure.adapters.out.ContratoRepositoryInMemory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistrarContratoUseCaseTest {

    @Test
    void debeRegistrarContratoExitosamente() {

        // Repositorio de prueba en memoria
        ContratoRepository repo = new ContratoRepositoryInMemory();

        // Caso de uso
        RegistrarContratoUseCase useCase = new RegistrarContratoService(repo);

        // DTO para creación
        ContratoCrearDTO dto = new ContratoCrearDTO(
                "C100",
                "P01",
                "PRG01",
                90,
                1500.0
        );
        // Ejecutar caso de uso
        useCase.registrar(dto);

        // Verificar que se guardó correctamente en el repositorio
        assertNotNull(repo.buscarPorNumero("C100"));
    }
}
