package main.java.infrastructure.adapters.in.ui;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal(PanelEmisoras panelEmisoras, PanelContratos panelContratos, PanelReportes panelReportes) {
        // Configuración básica de la ventana
        setTitle("Sistema de Gestión Radial - Arquitectura Hexagonal");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en pantalla

        // Sistema de pestañas para organizar los módulos
        JTabbedPane pestañas = new JTabbedPane();

        pestañas.addTab("Emisoras", panelEmisoras);
        pestañas.addTab("Contratos", panelContratos);
        pestañas.addTab("panelReportes", panelReportes);


        add(pestañas);
    }
}