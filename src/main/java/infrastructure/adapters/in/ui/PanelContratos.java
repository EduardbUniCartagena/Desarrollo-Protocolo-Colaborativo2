package main.java.infrastructure.adapters.in.ui;

import main.java.application.dto.contratos.ContratoCrearDTO;
import main.java.application.usecases.contratos.RegistrarContratoUseCase;

import javax.swing.*;
import java.awt.*;

public class PanelContratos extends JPanel {

    private final RegistrarContratoUseCase registrarContratoUseCase;

    private JTextField txtNumero;
    private JTextField txtDuracion; // en meses (para simplificar)
    private JTextField txtImporte;

    public PanelContratos(RegistrarContratoUseCase useCase) {
        this.registrarContratoUseCase = useCase;
        setLayout(new BorderLayout());
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        JPanel form = new JPanel(new GridLayout(4, 2, 10, 10));
        form.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        txtNumero = new JTextField();
        txtDuracion = new JTextField();
        txtImporte = new JTextField();
        JButton btnGuardar = new JButton("Registrar Contrato");

        form.add(new JLabel("Número Contrato (Ej: C-100):"));
        form.add(txtNumero);
        form.add(new JLabel("Duración (Meses):"));
        form.add(txtDuracion);
        form.add(new JLabel("Importe Total ($):"));
        form.add(txtImporte);
        form.add(new JLabel("")); // Espacio vacío
        form.add(btnGuardar);

        add(form, BorderLayout.NORTH);

        btnGuardar.addActionListener(e -> guardar());
    }

    private void guardar() {
        try {
            String id = txtNumero.getText();
            int meses = Integer.parseInt(txtDuracion.getText());
            double importe = Double.parseDouble(txtImporte.getText());

            // Nota: En el DTO original tenías "duracionEnSegundos", pero en el dominio usas Meses.
            // Ajustamos aquí para que el mapper funcione lógicamente.
            // Asumimos que "1" en el ID del patrocinador es el que creamos en SQL.

            ContratoCrearDTO dto = new ContratoCrearDTO(
                    id,
                    "1", // Patrocinador fijo por ahora
                    "PROG-1",
                    meses, // Pasamos meses aquí, el mapper deberá interpretarlo
                    importe
            );

            registrarContratoUseCase.registrar(dto);

            JOptionPane.showMessageDialog(this, "Contrato guardado en MySQL!");
            txtNumero.setText("");
            txtDuracion.setText("");
            txtImporte.setText("");

        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Duración e Importe deben ser números", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}