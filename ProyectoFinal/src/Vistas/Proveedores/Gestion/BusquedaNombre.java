package Vistas.Proveedores.Gestion;

import Clases.ProveedorEntity;
import Clases.ProyectoEntity;
import Conexiones.Conexiones;

import javax.swing.*;
import java.util.ArrayList;

public class BusquedaNombre {
    private JButton botonBusqueda;
    private JTextField textoBusqueda;
    private JComboBox comboCodigos;
    private JTextArea textoArea;
    public JPanel panel_main;

    ArrayList<ProveedorEntity> proveedores;

    public void construirSpinner() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        if (proveedores.size() > 0) {
            comboCodigos.removeAll();
            for (ProveedorEntity proveedore : proveedores) {
                model.addElement(proveedore.getNombre());
            }
            comboCodigos.setModel(model);
        } else {
            JOptionPane.showMessageDialog(null, "El proveedor no existe", "Error proveedor", JOptionPane.ERROR_MESSAGE);
        }
    }

    public BusquedaNombre() {
        botonBusqueda.addActionListener(e -> {
            if (!textoBusqueda.getText().equals("")) {
                proveedores = Conexiones.listaPosiblesProveedores(textoBusqueda.getText(), "nombre");
                construirSpinner();
            } else {
                JOptionPane.showMessageDialog(null, "Error debe escribir un nombre", "Error proveedor", JOptionPane.ERROR_MESSAGE);
            }
        });
        comboCodigos.addActionListener(e -> {
            if (proveedores.size() > 0) {
                ProveedorEntity proveedor = proveedores.get(comboCodigos.getSelectedIndex());
                textoArea.setText("CODIGO :" + proveedor.getCodigoProveedor() + "\n"
                        + "NOMBRE :" + proveedor.getNombre() + "\n" +
                        "APELLIDOS :" + proveedor.getApellido() + "\n" +
                        "DIRECCION :" + proveedor.getDireccion() + "\n");
            }
        });

    }
}
