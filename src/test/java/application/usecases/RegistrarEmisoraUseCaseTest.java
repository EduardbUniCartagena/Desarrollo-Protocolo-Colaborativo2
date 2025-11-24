package test.java.application.usecases;

import main.java.application.dto.emisoras.EmisoraCrearDTO;
import main.java.application.usecases.emisoras.CrearEmisoraUseCase;
import main.java.application.usecases.emisoras.EmisoraRepository;
import main.java.infrastructure.adapters.in.emisoras.CrearEmisoraService;
import main.java.infrastructure.adapters.out.emisoras.EmisoraRepositoryInMemory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistrarEmisoraUseCaseTest {

    @Test
    void debeRegistrarEmisoraExitosamente() {

        // Repositorio de prueba en memoria
        EmisoraRepository repo = new EmisoraRepositoryInMemory();

        // Caso de uso
        CrearEmisoraUseCase useCase = new CrearEmisoraUseCase(repo);

        // Servicio adaptador (igual que en tu ejemplo de contratos)
        CrearEmisoraService service = new CrearEmisoraService(useCase);

        // DTO para creación
        EmisoraCrearDTO dto = new EmisoraCrearDTO(
                "E100",
                "Emisora Caribe Stereo"
        );

        // Ejecutar el servicio (flujo completo)
        service.crear(dto);

        // Verificar que la emisora se guardó correctamente
        assertNotNull(repo.buscarPorNif("E100"));
        assertEquals("Emisora Caribe Stereo", repo.buscarPorNif("E100").getNombre());
    }
}
