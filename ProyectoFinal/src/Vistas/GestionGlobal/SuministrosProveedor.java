package Vistas.GestionGlobal;

import Clases.GestionEntity;
import Clases.ProveedorEntity;
import Conexiones.Conexiones;

import javax.swing.*;
import java.util.ArrayList;

public class SuministrosProveedor {
    public JPanel panel_main;
    private JComboBox comboProveedor;
    private JTextField totalPiezas;
    private JTextField totalProyectos;
    private JTextField textoNombre;
    private JTextField textoApellido;
    private JTextField textoDireccion;
    private JButton botonVerPiezas;
    ArrayList<GestionEntity> gestiones = new ArrayList<>();
    ArrayList<ProveedorEntity> proveedores = new ArrayList<>();

    public void setCombo() {
        proveedores = Conexiones.listaProveedor();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        if (proveedores.size() > 0) {
            comboProveedor.removeAll();
            for (ProveedorEntity proveedor : proveedores) {
                model.addElement(proveedor.getCodigoProveedor());
            }
            comboProveedor.setModel(model);
        } else {
            JOptionPane.showMessageDialog(null, "No existen proveedores", "Error Proveedores", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setTexto() {
        if (comboProveedor.getSelectedIndex() >= 0) {
            gestiones = Conexiones.listaGestionCantidad(proveedores.get(comboProveedor.getSelectedIndex()).getCodigoProveedor(), "CDProveedor");
            if (gestiones.size() > 0) {
                int total = 0;
                for (GestionEntity gestion : gestiones) {
                    total = total + gestion.getCantidad();
                }
               totalPiezas.setText(String.valueOf(total));
                totalProyectos.setText(String.valueOf(gestiones.size()));
            } else {
                JOptionPane.showMessageDialog(null, "Este proveedor no tiene relaciones", "Error relacion", JOptionPane.ERROR_MESSAGE);
            }
            textoNombre.setText(proveedores.get(comboProveedor.getSelectedIndex()).getNombre());
            textoApellido.setText(proveedores.get(comboProveedor.getSelectedIndex()).getApellido());
            textoDireccion.setText(proveedores.get(comboProveedor.getSelectedIndex()).getDireccion());

        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un proveedor", "Error relaciones", JOptionPane.ERROR_MESSAGE);
        }
    }

    public SuministrosProveedor() {
        setCombo();
        botonVerPiezas.addActionListener(e -> {

        });
        comboProveedor.addActionListener(e -> {
            setTexto();
        });
    }
}
