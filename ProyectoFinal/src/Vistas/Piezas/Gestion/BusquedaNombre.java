package Vistas.Piezas.Gestion;

import Clases.PiezaEntity;
import Clases.ProveedorEntity;
import Conexiones.Conexiones;

import javax.swing.*;
import java.util.ArrayList;

public class BusquedaNombre {
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
                model.addElement(pieza.getNombre());
            }
            comboCodigos.setModel(model);
        } else {
            JOptionPane.showMessageDialog(null, "La pieza no existe", "Error pieza", JOptionPane.ERROR_MESSAGE);
        }
    }

    public BusquedaNombre() {
        botonBusqueda.addActionListener(e -> {
            if (!textoBusqueda.getText().equals("")) {
                piezas = Conexiones.listaPosiblesPiezas(textoBusqueda.getText(), "nombre");
                construirSpinner();
            } else {
                JOptionPane.showMessageDialog(null, "Error debe escribir un nombre", "Error pieza", JOptionPane.ERROR_MESSAGE);
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
