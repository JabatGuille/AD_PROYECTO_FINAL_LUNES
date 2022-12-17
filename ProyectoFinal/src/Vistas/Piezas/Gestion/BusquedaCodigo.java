package Vistas.Piezas.Gestion;

import Clases.PiezaEntity;
import Clases.ProveedorEntity;
import Conexiones.Conexiones;

import javax.swing.*;
import java.util.ArrayList;

public class BusquedaCodigo {
    private JButton botonBusqueda;
    private JTextField textoBusqueda;
    private JComboBox comboCodigos;
    private JTextArea textoArea;
    public JPanel panel_main;

    ArrayList<PiezaEntity> piezas;

    public void construirSpinner() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        if (piezas.size() > 0) {
            comboCodigos.removeAll();
            for (PiezaEntity pieza : piezas) {
                model.addElement(pieza.getCodigoPieza());
            }
            comboCodigos.setModel(model);
        } else {
            JOptionPane.showMessageDialog(null, "La pieza no existe", "Error pieza", JOptionPane.ERROR_MESSAGE);
        }
    }

    public BusquedaCodigo() {
        botonBusqueda.addActionListener(e -> {
            textoBusqueda.setText(textoBusqueda.getText().replaceAll(" ", ""));
            if (!textoBusqueda.getText().equals("")) {
                piezas = Conexiones.listaPosiblesPiezas(textoBusqueda.getText().toUpperCase(), "codigo_pieza");
                construirSpinner();
            } else {
                JOptionPane.showMessageDialog(null, "Error debe escribir un codigo", "Error pieza", JOptionPane.ERROR_MESSAGE);
            }
        });
        comboCodigos.addActionListener(e -> {
            if (piezas.size() > 0) {
                PiezaEntity pieza = piezas.get(comboCodigos.getSelectedIndex());
                textoArea.setText("CODIGO :" + pieza.getCodigoPieza() + "\n"
                        + "NOMBRE :" + pieza.getNombre() + "\n" +
                        "PRECIO :" + pieza.getPrecio() + "\n" +
                        "DESCRIPCION :" + pieza.getDescripcion() + "\n");
            }
        });

    }
}
