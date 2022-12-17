package Vistas.GestionGlobal;

import Clases.GestionEntity;
import Clases.PiezaEntity;
import Clases.ProveedorEntity;
import Clases.ProyectoEntity;
import Conexiones.Conexiones;
import Vistas.Proveedores.Gestion.Proveedor;

import javax.swing.*;
import java.util.ArrayList;

public class GestionRelacion {
    public JPanel panel_main;
    private JButton listadoButton;
    private JButton eliminarButton;
    private JButton modificarButton;
    private JButton insertarButton;
    private JComboBox comboProveedor;
    private JComboBox comboPieza;
    private JComboBox comboProyecto;
    private JTextField NombrePiezaTexto;
    private JTextField PrecioPiezaTexto;
    private JTextField DescripcionPiezaTexto;
    private JTextField NombreProveedorTexto;
    private JTextField ApellidoProveedorTexto;
    private JTextField DireccionProveedorTexto;
    private JTextField NombreProyectoTexto;
    private JTextField CiudadProyectoTexto;
    private JSpinner cantidadSpinner;
    ArrayList<ProveedorEntity> proveedores;
    ArrayList<PiezaEntity> piezas;
    ArrayList<ProyectoEntity> proyectos;

    public void construirSpinners() {
        proveedores = Conexiones.listaProveedor();
        piezas = Conexiones.listaPieza();
        proyectos = Conexiones.listaProyecto();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        if (proveedores.size() > 0) {
            comboProveedor.removeAll();
            for (ProveedorEntity proveedor : proveedores) {
                model.addElement(proveedor.getCodigoProveedor());
            }
            comboProveedor.setModel(model);
        } else {
            JOptionPane.showMessageDialog(null, "No existen proveedores", "Error Gestion", JOptionPane.ERROR_MESSAGE);
        }
        model = new DefaultComboBoxModel();
        if (piezas.size() > 0) {
            comboPieza.removeAll();
            for (PiezaEntity pieza : piezas) {
                model.addElement(pieza.getCodigoPieza());
            }
            comboPieza.setModel(model);
        } else {
            JOptionPane.showMessageDialog(null, "No existen piezas", "Error Gestion", JOptionPane.ERROR_MESSAGE);
        }
        model = new DefaultComboBoxModel();
        if (proyectos.size() > 0) {
            comboProyecto.removeAll();
            for (ProyectoEntity proyecto : proyectos) {
                model.addElement(proyecto.getCodigoProyecto());
            }
            comboProyecto.setModel(model);
        } else {
            JOptionPane.showMessageDialog(null, "No existen proyectos", "Error Gestion", JOptionPane.ERROR_MESSAGE);
        }
    }

    public GestionRelacion() {
        construirSpinners();
        listadoButton.addActionListener(e -> {
            JFrame frame = new JFrame("Gestion Relacion Lista");
            frame.setContentPane(new ListadoGestionRelacion().panel_main);
            frame.pack();
            frame.setSize(600, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
        eliminarButton.addActionListener(e -> {
            if (!NombreProveedorTexto.getText().equals("") &&
                    !ApellidoProveedorTexto.getText().equals("") &&
                    !DireccionProveedorTexto.getText().equals("") &&
                    !NombrePiezaTexto.getText().equals("") &&
                    !PrecioPiezaTexto.getText().equals("") &&
                    !DescripcionPiezaTexto.getText().equals("") &&
                    !NombreProyectoTexto.getText().equals("") &&
                    !CiudadProyectoTexto.getText().equals("")) {
                GestionEntity gestionEntity = new GestionEntity();
                gestionEntity.setCdProveedor(proveedores.get(comboProveedor.getSelectedIndex()).getCodigoProveedor());
                gestionEntity.setCdPieza(piezas.get(comboPieza.getSelectedIndex()).getCodigoPieza());
                gestionEntity.setCdProyecto(proyectos.get(comboProyecto.getSelectedIndex()).getCodigoProyecto());
                gestionEntity.setCantidad((Integer) cantidadSpinner.getValue());
                Conexiones.eliminarGestion(gestionEntity);
            } else {
                JOptionPane.showMessageDialog(null, "Deben estar todos seleccionados", "Error Gestion Relacion", JOptionPane.ERROR_MESSAGE);
            }
        });
        modificarButton.addActionListener(e -> {
            if (!NombreProveedorTexto.getText().equals("") &&
                    !ApellidoProveedorTexto.getText().equals("") &&
                    !DireccionProveedorTexto.getText().equals("") &&
                    !NombrePiezaTexto.getText().equals("") &&
                    !PrecioPiezaTexto.getText().equals("") &&
                    !DescripcionPiezaTexto.getText().equals("") &&
                    !NombreProyectoTexto.getText().equals("") &&
                    !CiudadProyectoTexto.getText().equals("")) {
                if ((Integer) cantidadSpinner.getValue() > 0) {
                    GestionEntity gestionEntity = new GestionEntity();
                    gestionEntity.setCdProveedor(proveedores.get(comboProveedor.getSelectedIndex()).getCodigoProveedor());
                    gestionEntity.setCdPieza(piezas.get(comboPieza.getSelectedIndex()).getCodigoPieza());
                    gestionEntity.setCdProyecto(proyectos.get(comboProyecto.getSelectedIndex()).getCodigoProyecto());
                    gestionEntity.setCantidad((Integer) cantidadSpinner.getValue());
                    Conexiones.modificarGestion(gestionEntity);
                } else {
                    JOptionPane.showMessageDialog(null, "Debe escribir una cantidad mayor a 0", "Error Gestion Relacion", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Deben estar todos seleccionados", "Error Gestion Relacion", JOptionPane.ERROR_MESSAGE);
            }
        });
        insertarButton.addActionListener(e -> {
            if (!NombreProveedorTexto.getText().equals("") &&
                    !ApellidoProveedorTexto.getText().equals("") &&
                    !DireccionProveedorTexto.getText().equals("") &&
                    !NombrePiezaTexto.getText().equals("") &&
                    !PrecioPiezaTexto.getText().equals("") &&
                    !DescripcionPiezaTexto.getText().equals("") &&
                    !NombreProyectoTexto.getText().equals("") &&
                    !CiudadProyectoTexto.getText().equals("")) {
                if ((Integer) cantidadSpinner.getValue() > 0) {
                    GestionEntity gestionEntity = new GestionEntity();
                    gestionEntity.setCdProveedor(proveedores.get(comboProveedor.getSelectedIndex()).getCodigoProveedor());
                    gestionEntity.setCdPieza(piezas.get(comboPieza.getSelectedIndex()).getCodigoPieza());
                    gestionEntity.setCdProyecto(proyectos.get(comboProyecto.getSelectedIndex()).getCodigoProyecto());
                    gestionEntity.setCantidad((Integer) cantidadSpinner.getValue());
                    Conexiones.insertarGestion(gestionEntity);
                } else {
                    JOptionPane.showMessageDialog(null, "Debe escribir una cantidad mayor a 0", "Error Gestion Relacion", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Deben estar todos seleccionados", "Error Gestion Relacion", JOptionPane.ERROR_MESSAGE);
            }
        });
        comboProveedor.addActionListener(e -> {
            if (proveedores.size() > 0) {
                ProveedorEntity proveedor = proveedores.get(comboProveedor.getSelectedIndex());
                NombreProveedorTexto.setText(proveedor.getNombre());
                ApellidoProveedorTexto.setText(proveedor.getApellido());
                DireccionProveedorTexto.setText(proveedor.getDireccion());
            }
        });
        comboPieza.addActionListener(e -> {
            if (piezas.size() > 0) {
                PiezaEntity pieza = piezas.get(comboPieza.getSelectedIndex());
                NombrePiezaTexto.setText(pieza.getNombre());
                PrecioPiezaTexto.setText(String.valueOf(pieza.getPrecio()));
                DescripcionPiezaTexto.setText(pieza.getDescripcion());
            }
        });
        comboProyecto.addActionListener(e -> {
            if (proyectos.size() > 0) {
                ProyectoEntity proyecto = proyectos.get(comboProyecto.getSelectedIndex());
                NombreProyectoTexto.setText(proyecto.getNombre());
                CiudadProyectoTexto.setText(proyecto.getCiudad());
            }
        });
    }
}
