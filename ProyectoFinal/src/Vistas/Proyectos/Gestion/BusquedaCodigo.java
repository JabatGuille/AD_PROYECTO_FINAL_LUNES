package Vistas.Proyectos.Gestion;

import Clases.ProyectoEntity;
import Conexiones.Conexiones;

import javax.swing.*;
import java.util.ArrayList;

public class BusquedaCodigo {
    private JButton botonBusqueda;
    private JTextField textoBusqueda;
    private JComboBox comboCodigos;
    private JTextArea textoArea;
    public JPanel panel_main;

    ArrayList<ProyectoEntity> proyectos;

    public void construirSpinner() {
        if (proyectos.size() > 0) {
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            for (ProyectoEntity proyecto : proyectos) {
                model.addElement(proyecto.getCodigoProyecto());
            }
            comboCodigos.setModel(model);
        } else {
            JOptionPane.showMessageDialog(null, "El proyecto no existe", "Error proyecto", JOptionPane.ERROR_MESSAGE);
        }
    }

    public BusquedaCodigo() {
        botonBusqueda.addActionListener(e -> {
            if (!textoBusqueda.getText().equals("")) {
                proyectos = Conexiones.listaPosiblesProyectos(textoBusqueda.getText(), "codigo_proyecto");
                construirSpinner();
            } else {
                JOptionPane.showMessageDialog(null, "Error debe escribir un codigo", "Error proyecto", JOptionPane.ERROR_MESSAGE);
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
