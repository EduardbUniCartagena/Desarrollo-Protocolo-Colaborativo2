package main.java.infrastructure.adapters.in.ui;

import main.java.application.dto.emisoras.EmisoraCrearDTO;
import main.java.application.dto.emisoras.EmisoraRespuestaDTO;
import main.java.application.usecases.emisoras.CrearEmisoraUseCase;
import main.java.application.usecases.emisoras.ListarEmisorasUseCase;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PanelEmisoras extends JPanel {

    // Casos de uso requeridos para la lógica de negocio
    private final CrearEmisoraUseCase crearEmisoraUseCase;
    private final ListarEmisorasUseCase listarEmisorasUseCase;

    // Componentes de la interfaz
    private JTextField txtNif;
    private JTextField txtNombre;
    private DefaultTableModel modeloTabla;

    public PanelEmisoras(CrearEmisoraUseCase crearUseCase, ListarEmisorasUseCase listarUseCase) {
        this.crearEmisoraUseCase = crearUseCase;
        this.listarEmisorasUseCase = listarUseCase;

        setLayout(new BorderLayout());
        inicializarComponentes();
        cargarDatosTabla(); // Carga inicial de datos al abrir la vista
    }

    private void inicializarComponentes() {
        // Sección superior: Formulario de registro
        JPanel panelFormulario = new JPanel(new FlowLayout(FlowLayout.LEFT));

        txtNif = new JTextField(10);
        txtNombre = new JTextField(20);
        JButton btnGuardar = new JButton("Guardar");

        panelFormulario.add(new JLabel("NIF:"));
        panelFormulario.add(txtNif);
        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(txtNombre);
        panelFormulario.add(btnGuardar);

        add(panelFormulario, BorderLayout.NORTH);

        // Sección central: Tabla de listado
        String[] columnas = {"NIF", "Nombre Emisora"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        JTable tablaEmisoras = new JTable(modeloTabla);

        add(new JScrollPane(tablaEmisoras), BorderLayout.CENTER);

        // Eventos
        btnGuardar.addActionListener(e -> guardarEmisora());
    }

    private void guardarEmisora() {
        try {
            // Validación básica de campos vacíos
            if (txtNif.getText().isBlank() || txtNombre.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Mapeo de datos de la vista al DTO
            EmisoraCrearDTO dto = new EmisoraCrearDTO(txtNif.getText().trim(), txtNombre.getText().trim());

            // Ejecución de la lógica de negocio
            crearEmisoraUseCase.ejecutar(dto);

            // Feedback al usuario y limpieza
            JOptionPane.showMessageDialog(this, "Emisora registrada correctamente");
            txtNif.setText("");
            txtNombre.setText("");

            // Actualizamos la tabla para reflejar el nuevo registro
            cargarDatosTabla();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarDatosTabla() {
        modeloTabla.setRowCount(0); // Limpiar filas anteriores

        // Obtener datos actualizados desde la capa de aplicación
        List<EmisoraRespuestaDTO> lista = listarEmisorasUseCase.ejecutar();

        for (EmisoraRespuestaDTO e : lista) {
            modeloTabla.addRow(new Object[]{e.getNif(), e.getNombre()});
        }
    }
}