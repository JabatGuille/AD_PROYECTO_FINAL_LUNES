package Vistas.Proyectos.Gestion;

import Clases.ProyectoEntity;
import Conexiones.Conexiones;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BusquedaCiudad {
    private JButton botonBusqueda;
    private JTextField textoBusqueda;
    private JComboBox comboCodigos;
    private JTextArea textoArea;
    public JPanel panel_main;

    ArrayList<ProyectoEntity> proyectos;

    public void construirSpinner() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        if (proyectos.size() > 0) {
            comboCodigos.removeAll();
            for (ProyectoEntity proyecto : proyectos) {
                model.addElement(proyecto.getCiudad());
            }
            comboCodigos.setModel(model);
        } else {
            JOptionPane.showMessageDialog(null, "El proyecto no existe", "Error proyecto", JOptionPane.ERROR_MESSAGE);
        }
    }

    public BusquedaCiudad() {
        botonBusqueda.addActionListener(e -> {

            if (!textoBusqueda.getText().equals("")) {
                proyectos = Conexiones.listaPosiblesProyectos(textoBusqueda.getText(), "ciudad");
                construirSpinner();
            } else {
                JOptionPane.showMessageDialog(null, "Error debe escribir una ciudad", "Error proyecto", JOptionPane.ERROR_MESSAGE);
            }
        });
        comboCodigos.addActionListener(e -> {
            if (proyectos.size() > 0) {
                ProyectoEntity proyecto = proyectos.get(comboCodigos.getSelectedIndex());
                textoArea.setText("CODIGO :" + proyecto.getCodigoProyecto() + "\n"
                        + "NOMBRE :" + proyecto.getNombre() + "\n" +
                        "CIUDAD :" + proyecto.getCiudad() + "\n");
            }
        });

    }
}
