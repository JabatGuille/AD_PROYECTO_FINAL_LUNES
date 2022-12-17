package Vistas.Proyectos.Gestion;

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

    ArrayList<ProyectoEntity> proyectos;

    public void construirSpinner() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        if (proyectos.size() > 0) {
            comboCodigos.removeAll();
            for (ProyectoEntity proyecto : proyectos) {
                model.addElement(proyecto.getNombre());
            }
            comboCodigos.setModel(model);
        } else {
            JOptionPane.showMessageDialog(null, "El proyecto no existe", "Error proyecto", JOptionPane.ERROR_MESSAGE);
        }
    }

    public BusquedaNombre() {
        botonBusqueda.addActionListener(e -> {
            if (!textoBusqueda.getText().equals("")) {
                proyectos = Conexiones.listaPosiblesProyectos(textoBusqueda.getText(), "nombre");
                construirSpinner();
            } else {
                JOptionPane.showMessageDialog(null, "Error debe escribir un nombre", "Error proyecto", JOptionPane.ERROR_MESSAGE);
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
