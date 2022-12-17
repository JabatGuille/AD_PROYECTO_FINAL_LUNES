package Vistas.Piezas.Gestion;

import Clases.PiezaEntity;
import Conexiones.Conexiones;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

public class Pieza {
    public JPanel panel_main;
    private JTabbedPane Listado;
    private JTable TablaPieza;
    private JTextField CodigoPiezaTexto;
    private JTextField NombrePiezaTexto;
    private JTextField ApellidoProveedorTexto;
    private JButton LimparButton;
    private JButton InsertarButton;
    private JButton EliminarButton;
    private JButton ModificarButton;
    private JTextField DescripcionPiezaTexto;
    private JSpinner SpinnerPrecioPieza;
    private JButton bajasButton;
    ArrayList<PiezaEntity> piezas;

    public void setTabla() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Codigo Pieza");
        model.addColumn("Nombre");
        model.addColumn("Precio");
        model.addColumn("Descripcion");
        piezas = Conexiones.listaPieza();
        for (PiezaEntity pieza : piezas) {
            model.addRow(new Object[]{pieza.getCodigoPieza(), pieza.getNombre(), pieza.getPrecio(), pieza.getDescripcion()});
        }
        TablaPieza.setModel(model);
    }

    public Pieza() {
        Listado.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                setTabla();
            }
        });
        LimparButton.addActionListener(e -> {
            CodigoPiezaTexto.setText("");
            NombrePiezaTexto.setText("");
            DescripcionPiezaTexto.setText("");
            SpinnerPrecioPieza.setValue(0);
        });
        InsertarButton.addActionListener(e -> {
            if (CodigoPiezaTexto.getText().length() <= 6 && NombrePiezaTexto.getText().length() <= 20 && DescripcionPiezaTexto.getText().length() <= 20) {
                if (!CodigoPiezaTexto.getText().equals("") && !NombrePiezaTexto.getText().equals("") && !DescripcionPiezaTexto.getText().equals("")) {
                    PiezaEntity pieza = new PiezaEntity();
                    pieza.setCodigoPieza(String.valueOf(CodigoPiezaTexto.getText()).toUpperCase());
                    pieza.setNombre(NombrePiezaTexto.getText());
                    pieza.setDescripcion(DescripcionPiezaTexto.getText());
                    pieza.setPrecio(Double.parseDouble(SpinnerPrecioPieza.getValue().toString()));
                    Conexiones.insertarPieza(pieza);
                } else {
                    if (CodigoPiezaTexto.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "El codigo esta vacio", "Error Pieza", JOptionPane.ERROR_MESSAGE);
                    }
                    if (NombrePiezaTexto.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "El nombre esta vacio", "Error Pieza", JOptionPane.ERROR_MESSAGE);
                    }
                    if (DescripcionPiezaTexto.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "La descripcion esta vacia", "Error Pieza", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                if (CodigoPiezaTexto.getText().length() > 6) {
                    JOptionPane.showMessageDialog(null, "El codigo es demasiado largo", "Error Pieza", JOptionPane.ERROR_MESSAGE);
                }
                if (NombrePiezaTexto.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "El nombre es demasiado largo", "Error Pieza", JOptionPane.ERROR_MESSAGE);
                }
                if (DescripcionPiezaTexto.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "La descripcion es demasiado larga", "Error Pieza", JOptionPane.ERROR_MESSAGE);
                }
            }
            setTabla();
        });
        ModificarButton.addActionListener(e -> {
            if (CodigoPiezaTexto.getText().length() <= 6 && NombrePiezaTexto.getText().length() <= 20 && DescripcionPiezaTexto.getText().length() <= 20) {
                if (!CodigoPiezaTexto.getText().equals("") && !NombrePiezaTexto.getText().equals("") && !DescripcionPiezaTexto.getText().equals("")) {
                    PiezaEntity pieza = new PiezaEntity();
                    pieza.setCodigoPieza(String.valueOf(CodigoPiezaTexto.getText()).toUpperCase());
                    pieza.setNombre(NombrePiezaTexto.getText());
                    pieza.setDescripcion(DescripcionPiezaTexto.getText());
                    pieza.setPrecio(Double.parseDouble(SpinnerPrecioPieza.getValue().toString()));
                    Conexiones.modificarPieza(pieza);
                } else {
                    if (CodigoPiezaTexto.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "El codigo esta vacio", "Error Pieza", JOptionPane.ERROR_MESSAGE);
                    }
                    if (NombrePiezaTexto.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "El nombre esta vacio", "Error Pieza", JOptionPane.ERROR_MESSAGE);
                    }
                    if (DescripcionPiezaTexto.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "La descripcion esta vacia", "Error Pieza", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                if (CodigoPiezaTexto.getText().length() > 6) {
                    JOptionPane.showMessageDialog(null, "El codigo es demasiado largo", "Error Pieza", JOptionPane.ERROR_MESSAGE);
                }
                if (NombrePiezaTexto.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "El nombre es demasiado largo", "Error Pieza", JOptionPane.ERROR_MESSAGE);
                }
                if (DescripcionPiezaTexto.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "La descripcion es demasiado larga", "Error Pieza", JOptionPane.ERROR_MESSAGE);
                }
            }
            setTabla();
        });
        EliminarButton.addActionListener(e -> {
            if (CodigoPiezaTexto.getText().length() <= 6) {
                if (!CodigoPiezaTexto.getText().equals("")) {
                    PiezaEntity pieza = new PiezaEntity();
                    pieza.setCodigoPieza(String.valueOf(CodigoPiezaTexto.getText()).toUpperCase());
                    pieza.setNombre(NombrePiezaTexto.getText());
                    pieza.setDescripcion(DescripcionPiezaTexto.getText());
                    pieza.setPrecio(Double.parseDouble(SpinnerPrecioPieza.getValue().toString()));
                    Conexiones.eliminarPieza(pieza.getCodigoPieza().toUpperCase());
                } else {
                    if (CodigoPiezaTexto.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "El codigo esta vacio", "Error Pieza", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                if (CodigoPiezaTexto.getText().length() > 6) {
                    JOptionPane.showMessageDialog(null, "El codigo es demasiado largo", "Error Pieza", JOptionPane.ERROR_MESSAGE);
                }
            }
            setTabla();
        });
        bajasButton.addActionListener(e -> {
            try {
                Conexiones.eliminarPieza(piezas.get(TablaPieza.getSelectedRow()).getCodigoPieza());
                setTabla();
            } catch (IndexOutOfBoundsException exception) {
                JOptionPane.showMessageDialog(null, "Debes seleccionar una pieza para poder eliminarlo", "Error Pieza", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
