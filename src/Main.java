import main.java.application.usecases.emisoras.CrearEmisoraUseCase;
import main.java.application.usecases.emisoras.EmisoraRepository;
import main.java.application.usecases.emisoras.ListarEmisorasUseCase;
import main.java.application.usecases.contratos.ContratoRepository;
import main.java.application.usecases.contratos.RegistrarContratoUseCase;
import main.java.infrastructure.adapters.in.contratos.RegistrarContratoService;
import main.java.infrastructure.adapters.out.emisoras.EmisoraRepositoryMySQL;
import main.java.infrastructure.adapters.out.contratos.ContratoRepositoryMySQL;
import main.java.infrastructure.adapters.in.ui.PanelEmisoras;
import main.java.infrastructure.adapters.in.ui.PanelContratos;
import main.java.application.usecases.reportes.ReporteRepository;
import main.java.application.usecases.reportes.GenerarReportesUseCase;
import main.java.infrastructure.adapters.out.reportes.ReporteRepositoryMySQL;
import main.java.infrastructure.adapters.in.ui.PanelReportes;
import main.java.infrastructure.adapters.in.ui.VentanaPrincipal;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        // --- 1. INFRAESTRUCTURA (Repositorios) ---
        EmisoraRepository emisoraRepo = new EmisoraRepositoryMySQL();
        ContratoRepository contratoRepo = new ContratoRepositoryMySQL();
        ReporteRepository reporteRepo = new ReporteRepositoryMySQL();


        // --- 2. APLICACIÓN (Casos de Uso) ---
        // Emisoras
        CrearEmisoraUseCase crearEmisoraUC = new CrearEmisoraUseCase(emisoraRepo);
        ListarEmisorasUseCase listarEmisorasUC = new ListarEmisorasUseCase(emisoraRepo);
        GenerarReportesUseCase reportesUC = new GenerarReportesUseCase(reporteRepo);

        // Contratos (Usamos el Service que actúa como UseCase implementation)
        RegistrarContratoUseCase registrarContratoUC = new RegistrarContratoService(contratoRepo);

        // --- 3. UI (Interfaz Gráfica) ---
        SwingUtilities.invokeLater(() -> {
            // Creamos los paneles inyectando sus dependencias
            PanelEmisoras panelEmisoras = new PanelEmisoras(crearEmisoraUC, listarEmisorasUC);
            PanelContratos panelContratos = new PanelContratos(registrarContratoUC);
            PanelReportes panelReportes = new PanelReportes(reportesUC);

            // Creamos la ventana principal y le pasamos ambos paneles
            // (Necesitarás actualizar el constructor de VentanaPrincipal para recibir el panelContratos)
            VentanaPrincipal ventana = new VentanaPrincipal(panelEmisoras, panelContratos, panelReportes);
            ventana.setVisible(true);
        });
    }
}