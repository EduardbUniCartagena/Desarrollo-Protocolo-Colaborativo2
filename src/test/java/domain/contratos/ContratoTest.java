package test.java.domain.contratos;

import main.java.domain.contratos.Contrato;
import main.java.domain.contratos.Duracion;
import main.java.domain.contratos.Importe;
import main.java.domain.contratos.Patrocinador;
import org.junit.jupiter.api.Test;
import main.java.domain.excepciones.ContratoVencidoException;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.lang.reflect.Field;

class ContratoTest {

    @Test
    void noDebePermitirAsignarPublicidadSiContratoVencido() throws Exception {
        Patrocinador patrocinador = new Patrocinador("P01", "CocaCola");
        Duracion duracion = new Duracion(1); // 1 mes
        Importe importe = new Importe(1000.0);
        Contrato contrato = new Contrato("C001", patrocinador, duracion, importe);

        // Forzar el contrato a estar vencido manipulando la fecha con reflexión (solo para test)
        Field fieldFecha = Contrato.class.getDeclaredField("fechaInicio");
        fieldFecha.setAccessible(true);
        fieldFecha.set(contrato, LocalDate.now().minusMonths(2));

        assertTrue(contrato.estaVencido());

        assertThrows(ContratoVencidoException.class, () -> {
            contrato.asignarPublicidad("Programa Mañanero", 30);
        });
    }

    @Test
    void debePermitirAsignarPublicidadSiContratoActivo() {
        Patrocinador patrocinador = new Patrocinador("P02", "Pepsi");
        Duracion duracion = new Duracion(6); // 6 meses
        Importe importe = new Importe(2000.0);
        Contrato contrato = new Contrato("C002", patrocinador, duracion, importe);

        assertFalse(contrato.estaVencido());

        assertDoesNotThrow(() -> contrato.asignarPublicidad("Programa Nocturno", 60));
    }
}
