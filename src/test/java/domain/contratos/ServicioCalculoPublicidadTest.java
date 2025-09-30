package test.java.domain.contratos;

import main.java.domain.contratos.Duracion;
import main.java.domain.contratos.Importe;
import main.java.domain.servicios.ServicioCalculoPublicidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicioCalculoPublicidadTest {

    @Test
    void debeCalcularCostoPublicidadConTarifaNormal() {
        Duracion duracion = new Duracion(2); // 2 meses
        double valorPorSegundo = 5.0;

        ServicioCalculoPublicidad servicio = new ServicioCalculoPublicidad();
        Importe importe = servicio.calcularCostoPublicidad(duracion, valorPorSegundo);

        // 2 meses * 30 días * 10 segundos = 600 segundos totales
        // 600 * 5.0 = 3000.0
        assertEquals(3000.0, importe.getValor(), 0.01);
    }

    @Test
    void debeRetornarImporteMayorACero() {
        Duracion duracion = new Duracion(1);
        double valorPorSegundo = 2.0;

        ServicioCalculoPublicidad servicio = new ServicioCalculoPublicidad();
        Importe importe = servicio.calcularCostoPublicidad(duracion, valorPorSegundo);

        assertTrue(importe.getValor() > 0);
    }
}
