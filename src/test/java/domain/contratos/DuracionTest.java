package test.java.domain.contratos;

import main.java.domain.contratos.Duracion;
import org.junit.jupiter.api.Test;
import main.java.domain.excepciones.DomainException;
import static org.junit.jupiter.api.Assertions.*;

class DuracionTest {

    @Test
    void noDebeAceptarDuracionInvalida() {
        assertThrows(DomainException.class, () -> new Duracion(0));
    }

    @Test
    void debeCrearDuracionValida() {
        Duracion d = new Duracion(6);
        assertEquals(6, d.getMeses());
    }
}