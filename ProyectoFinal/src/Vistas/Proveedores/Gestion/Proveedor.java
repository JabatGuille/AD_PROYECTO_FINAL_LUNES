package Vistas.Proveedores.Gestion;

import Clases.ProveedorEntity;
import Conexiones.Conexiones;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

public class Proveedor {
    public JPanel panel_main;
    private JTabbedPane Listado;
    private JTable TablaProveedor;
    private JTextField CodigoProveedorTexto;
    private JTextField NombreProveedorTexto;
    private JTextField ApellidoProveedorTexto;
    private JButton LimparButton;
    private JButton InsertarButton;
    private JButton EliminarButton;
    private JButton ModificarButton;
    private JTextField DireccionProveedorTexto;
    private JButton bajasButton;
    ArrayList<ProveedorEntity> proveedores;

    public void setTabla() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Codigo Proveedor");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Direccion");
        proveedores = Conexiones.listaProveedor();
        for (ProveedorEntity proveedor : proveedores) {
            model.addRow(new Object[]{proveedor.getCodigoProveedor(), proveedor.getNombre(), proveedor.getApellido(), proveedor.getDireccion()});
        }
        TablaProveedor.setModel(model);
    }

    public Proveedor() {

        Listado.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                setTabla();
            }
        });
        LimparButton.addActionListener(e -> {
            CodigoProveedorTexto.setText("");
            NombreProveedorTexto.setText("");
            ApellidoProveedorTexto.setText("");
            DireccionProveedorTexto.setText("");
        });
        InsertarButton.addActionListener(e -> {
            setTabla();
            if (CodigoProveedorTexto.getText().length() <= 6 && NombreProveedorTexto.getText().length() <= 20 && ApellidoProveedorTexto.getText().length() <= 20 && DireccionProveedorTexto.getText().length() <= 20) {
                if (!CodigoProveedorTexto.getText().equals("") && !NombreProveedorTexto.getText().equals("") && !ApellidoProveedorTexto.getText().equals("") && !DireccionProveedorTexto.getText().equals("")) {
                    ProveedorEntity proveedor = new ProveedorEntity();
                    proveedor.setCodigoProveedor(CodigoProveedorTexto.getText().toUpperCase());
                    proveedor.setNombre(NombreProveedorTexto.getText());
                    proveedor.setApellido(ApellidoProveedorTexto.getText());
                    proveedor.setDireccion(DireccionProveedorTexto.getText());
                    Conexiones.insertarProveedor(proveedor);
                } else {
                    if (CodigoProveedorTexto.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "El codigo esta vacio", "Error Proveedor", JOptionPane.ERROR_MESSAGE);
                    }
                    if (NombreProveedorTexto.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "El nombre esta vacio", "Error Proveedor", JOptionPane.ERROR_MESSAGE);
                    }
                    if (ApellidoProveedorTexto.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "El apellido esta vacio", "Error Proveedor", JOptionPane.ERROR_MESSAGE);
                    }
                    if (DireccionProveedorTexto.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "La direccion esta vacia", "Error Proveedor", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                if (CodigoProveedorTexto.getText().length() > 6) {
                    JOptionPane.showMessageDialog(null, "El codigo es demasiado largo", "Error Proveedor", JOptionPane.ERROR_MESSAGE);
                }
                if (NombreProveedorTexto.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "El nombre es demasiado largo", "Error Proveedor", JOptionPane.ERROR_MESSAGE);
                }
                if (ApellidoProveedorTexto.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "El apellido es demasiado largo", "Error Proveedor", JOptionPane.ERROR_MESSAGE);
                }
                if (DireccionProveedorTexto.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "La direccion es demasiado larga", "Error Proveedor", JOptionPane.ERROR_MESSAGE);
                }
            }
            setTabla();
        });
        ModificarButton.addActionListener(e -> {
            if (CodigoProveedorTexto.getText().length() <= 6 && NombreProveedorTexto.getText().length() <= 20 && ApellidoProveedorTexto.getText().length() <= 20 && DireccionProveedorTexto.getText().length() <= 20) {
                if (!CodigoProveedorTexto.getText().equals("") && !NombreProveedorTexto.getText().equals("") && !ApellidoProveedorTexto.getText().equals("") && !DireccionProveedorTexto.getText().equals("")) {
                    ProveedorEntity proveedor = new ProveedorEntity();
                    proveedor.setCodigoProveedor(CodigoProveedorTexto.getText().toUpperCase());
                    proveedor.setNombre(NombreProveedorTexto.getText());
                    proveedor.setApellido(ApellidoProveedorTexto.getText());
                    proveedor.setDireccion(DireccionProveedorTexto.getText());
                    Conexiones.modificarProveedor(proveedor);
                } else {
                    if (CodigoProveedorTexto.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "El codigo esta vacio", "Error Proveedor", JOptionPane.ERROR_MESSAGE);
                    }
                    if (NombreProveedorTexto.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "El nombre esta vacio", "Error Proveedor", JOptionPane.ERROR_MESSAGE);
                    }
                    if (ApellidoProveedorTexto.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "El apellido esta vacio", "Error Proveedor", JOptionPane.ERROR_MESSAGE);
                    }
                    if (DireccionProveedorTexto.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "La direccion esta vacia", "Error Proveedor", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                if (CodigoProveedorTexto.getText().length() > 6) {
                    JOptionPane.showMessageDialog(null, "El codigo es demasiado largo", "Error Proveedor", JOptionPane.ERROR_MESSAGE);
                }
                if (NombreProveedorTexto.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "El nombre es demasiado largo", "Error Proveedor", JOptionPane.ERROR_MESSAGE);
                }
                if (ApellidoProveedorTexto.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "El apellido es demasiado largo", "Error Proveedor", JOptionPane.ERROR_MESSAGE);
                }
                if (DireccionProveedorTexto.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "La direccion es demasiado larga", "Error Proveedor", JOptionPane.ERROR_MESSAGE);
                }
            }
            setTabla();
        });
        EliminarButton.addActionListener(e -> {
            if (CodigoProveedorTexto.getText().length() <= 6) {
                if (!CodigoProveedorTexto.getText().equals("")) {
                    ProveedorEntity proveedor = new ProveedorEntity();
                    proveedor.setCodigoProveedor(CodigoProveedorTexto.getText().toUpperCase());
                    proveedor.setNombre(NombreProveedorTexto.getText());
                    proveedor.setApellido(ApellidoProveedorTexto.getText());
                    proveedor.setDireccion(DireccionProveedorTexto.getText());
                    Conexiones.eliminarProveedor(proveedor.getCodigoProveedor().toUpperCase());
                } else {
                    if (CodigoProveedorTexto.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "El codigo esta vacio", "Error Proveedor", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                if (CodigoProveedorTexto.getText().length() > 6) {
                    JOptionPane.showMessageDialog(null, "El codigo es demasiado largo", "Error Proveedor", JOptionPane.ERROR_MESSAGE);
                }
            }
            setTabla();
        });
        bajasButton.addActionListener(e -> {
            try {
                Conexiones.eliminarProveedor(proveedores.get(TablaProveedor.getSelectedRow()).getCodigoProveedor());
                setTabla();
            } catch (IndexOutOfBoundsException exception) {
                JOptionPane.showMessageDialog(null, "Debes seleccionar un proveedor para poder eliminarlo", "Error Proveedor", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
