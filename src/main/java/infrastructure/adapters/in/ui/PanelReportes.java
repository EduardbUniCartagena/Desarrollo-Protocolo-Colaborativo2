package main.java.infrastructure.adapters.in.ui;

import main.java.application.usecases.reportes.GenerarReportesUseCase;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PanelReportes extends JPanel {

    private final GenerarReportesUseCase useCase;
    private JTable tablaResultados;
    private DefaultTableModel modelo;

    public PanelReportes(GenerarReportesUseCase useCase) {
        this.useCase = useCase;
        setLayout(new BorderLayout());

        // Panel de Botones
        JPanel panelBotones = new JPanel();
        JButton btnContratos = new JButton("Ver Contratos (JOIN)");
        JButton btnInversion = new JButton("Total Inversión (GROUP BY)");
        JButton btnProgramacion = new JButton("Programación (3 Tablas)");

        panelBotones.add(btnContratos);
        panelBotones.add(btnInversion);
        panelBotones.add(btnProgramacion);

        add(panelBotones, BorderLayout.NORTH);

        // Tabla
        modelo = new DefaultTableModel();
        tablaResultados = new JTable(modelo);
        add(new JScrollPane(tablaResultados), BorderLayout.CENTER);

        // Acciones
        btnContratos.addActionListener(e -> cargarContratos());
        btnInversion.addActionListener(e -> cargarInversion());
        btnProgramacion.addActionListener(e -> cargarProgramacion());
    }

    private void cargarContratos() {
        String[] titulos = {"N° Contrato", "Patrocinador", "Fecha Inicio", "Importe"};
        modelo.setDataVector(convertirDatos(useCase.reporteContratosDetallados()), titulos);
    }

    private void cargarInversion() {
        String[] titulos = {"Patrocinador", "Total Invertido ($)"};
        modelo.setDataVector(convertirDatos(useCase.reporteInversion()), titulos);
    }

    private void cargarProgramacion() {
        String[] titulos = {"Emisora", "Programa", "Día", "Hora"};
        modelo.setDataVector(convertirDatos(useCase.reporteProgramacion()), titulos);
    }

    // Utilidad para convertir lista a matriz para Swing
    private Object[][] convertirDatos(List<String[]> lista) {
        Object[][] datos = new Object[lista.size()][];
        for (int i = 0; i < lista.size(); i++) {
            datos[i] = lista.get(i);
        }
        return datos;
    }
}