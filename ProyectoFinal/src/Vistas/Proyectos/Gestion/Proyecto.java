package Vistas.Proyectos.Gestion;

import Clases.ProyectoEntity;
import Conexiones.Conexiones;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

public class Proyecto {
    public JPanel panel_main;
    private JTabbedPane Listado;
    private JTable TablaProyectos;
    private JTextField CodigoProyectoTexto;
    private JTextField NombreProyectoTexto;
    private JTextField CiudadProyectoTexto;
    private JButton LimparButton;
    private JButton InsertarButton;
    private JButton EliminarButton;
    private JButton ModificarButton;
    private JButton bajasButton;
    ArrayList<ProyectoEntity> proyectos;

    public void setTabla() {

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Codigo Proyecto");
        model.addColumn("Nombre");
        model.addColumn("Ciudad");
        proyectos = Conexiones.listaProyecto();
        for (ProyectoEntity proyecto : proyectos) {
            model.addRow(new Object[]{proyecto.getCodigoProyecto(), proyecto.getNombre(), proyecto.getCiudad()});
        }
        TablaProyectos.setModel(model);
    }

    public Proyecto() {

        Listado.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                setTabla();
            }
        });
        LimparButton.addActionListener(e -> {
            CodigoProyectoTexto.setText("");
            NombreProyectoTexto.setText("");
            CiudadProyectoTexto.setText("");
        });
        InsertarButton.addActionListener(e -> {
            if (CodigoProyectoTexto.getText().length() <= 6 && NombreProyectoTexto.getText().length() <= 20 && CiudadProyectoTexto.getText().length() <= 40) {
                if (!CodigoProyectoTexto.getText().equals("") && !NombreProyectoTexto.getText().equals("") && !CiudadProyectoTexto.getText().equals("")) {
                    ProyectoEntity proyecto = new ProyectoEntity();
                    proyecto.setCodigoProyecto(CodigoProyectoTexto.getText().toUpperCase());
                    proyecto.setNombre(NombreProyectoTexto.getText());
                    proyecto.setCiudad(CiudadProyectoTexto.getText());
                    Conexiones.insertarProyecto(proyecto);
                } else {
                    if (CodigoProyectoTexto.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "El codigo esta vacio", "Error Proyecto", JOptionPane.ERROR_MESSAGE);
                    }
                    if (NombreProyectoTexto.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "El nombre esta vacio", "Error Proyecto", JOptionPane.ERROR_MESSAGE);
                    }
                    if (CiudadProyectoTexto.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "La ciudad esta vacia", "Error Proyecto", JOptionPane.ERROR_MESSAGE);
                    }

                }
            } else {
                if (CodigoProyectoTexto.getText().length() > 6) {
                    JOptionPane.showMessageDialog(null, "El codigo es demasiado largo", "Error Proyecto", JOptionPane.ERROR_MESSAGE);
                }
                if (NombreProyectoTexto.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "El nombre es demasiado largo", "Error Proyecto", JOptionPane.ERROR_MESSAGE);
                }
                if (CiudadProyectoTexto.getText().length() > 40) {
                    JOptionPane.showMessageDialog(null, "La ciudad es demasiado larga", "Error Proyecto", JOptionPane.ERROR_MESSAGE);
                }
            }
            setTabla();
        });
        ModificarButton.addActionListener(e -> {
            if (CodigoProyectoTexto.getText().length() <= 6 && NombreProyectoTexto.getText().length() <= 20 && CiudadProyectoTexto.getText().length() <= 40) {
                if (!CodigoProyectoTexto.getText().equals("") && !NombreProyectoTexto.getText().equals("") && !CiudadProyectoTexto.getText().equals("")) {
                    ProyectoEntity proyecto = new ProyectoEntity();
                    proyecto.setCodigoProyecto(CodigoProyectoTexto.getText().toUpperCase());
                    proyecto.setNombre(NombreProyectoTexto.getText());
                    proyecto.setCiudad(CiudadProyectoTexto.getText());
                    Conexiones.modificarProyecto(proyecto);
                } else {
                    if (CodigoProyectoTexto.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "El codigo esta vacio", "Error Proyecto", JOptionPane.ERROR_MESSAGE);
                    }
                    if (NombreProyectoTexto.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "El nombre esta vacio", "Error Proyecto", JOptionPane.ERROR_MESSAGE);
                    }
                    if (CiudadProyectoTexto.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "La ciudad esta vacia", "Error Proyecto", JOptionPane.ERROR_MESSAGE);
                    }

                }
            } else {
                if (CodigoProyectoTexto.getText().length() > 6) {
                    JOptionPane.showMessageDialog(null, "El codigo es demasiado largo", "Error Proyecto", JOptionPane.ERROR_MESSAGE);
                }
                if (NombreProyectoTexto.getText().length() > 20) {
                    JOptionPane.showMessageDialog(null, "El nombre es demasiado largo", "Error Proyecto", JOptionPane.ERROR_MESSAGE);
                }
                if (CiudadProyectoTexto.getText().length() > 40) {
                    JOptionPane.showMessageDialog(null, "La ciudad es demasiado larga", "Error Proyecto", JOptionPane.ERROR_MESSAGE);
                }
            }
            setTabla();

        });
        EliminarButton.addActionListener(e -> {
            if (CodigoProyectoTexto.getText().length() <= 6) {
                if (!CodigoProyectoTexto.getText().equals("")) {
                    ProyectoEntity proyecto = new ProyectoEntity();
                    proyecto.setCodigoProyecto(CodigoProyectoTexto.getText().toUpperCase());
                    proyecto.setNombre(NombreProyectoTexto.getText());
                    proyecto.setCiudad(CiudadProyectoTexto.getText());
                    Conexiones.eliminarProyecto(proyecto.getCodigoProyecto());
                } else {
                    if (CodigoProyectoTexto.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "El codigo esta vacio", "Error Proyecto", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                if (CodigoProyectoTexto.getText().length() > 6) {
                    JOptionPane.showMessageDialog(null, "El codigo es demasiado largo", "Error Proyecto", JOptionPane.ERROR_MESSAGE);
                }
            }
            setTabla();
        });
        bajasButton.addActionListener(e -> {
            try {
                Conexiones.eliminarProyecto(proyectos.get(TablaProyectos.getSelectedRow()).getCodigoProyecto());
                setTabla();
            } catch (IndexOutOfBoundsException exception) {
                JOptionPane.showMessageDialog(null, "Debes seleccionar un proyecto para poder eliminarlo", "Error Proyecto", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
