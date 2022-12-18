package Vistas.GestionGlobal;

import Clases.GestionEntity;
import Clases.PiezaEntity;
import Clases.ProveedorEntity;
import ClasesCustom.Singleton;
import Conexiones.Conexiones;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class SuministrosPieza {
    public JPanel panel_main;
    private JComboBox comboPieza;
    private JTextField textoNombre;
    private JTextField textoPrecio;
    private JTextField textoNumeroProyectos;
    private JTextArea textoDescripcion;
    private JTextField textoNumeroProveedor;
    private JTextField totalCantidad;
    private JButton listaPiezaSuministrada;
    ArrayList<GestionEntity> gestiones = new ArrayList<>();
    ArrayList<PiezaEntity> piezas = new ArrayList<>();

    public void setCombo() {
        piezas = Conexiones.listaPieza();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        if (piezas.size() > 0) {
            comboPieza.removeAll();
            for (PiezaEntity pieza : piezas) {
                model.addElement(pieza.getCodigoPieza());
            }
            comboPieza.setModel(model);
        } else {
            JOptionPane.showMessageDialog(null, "No existen piezas", "Error Piezas", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setTexto() {
        if (comboPieza.getSelectedIndex() >= 0) {
            gestiones = Conexiones.listaGestionCantidad(piezas.get(comboPieza.getSelectedIndex()).getCodigoPieza(), "CDPieza");
            if (gestiones.size() > 0) {
                int total = 0;
                HashMap<String, String> numeroproyectos = new HashMap<>();
                HashMap<String, String> numeroproveedor = new HashMap<>();
                for (GestionEntity gestion : gestiones) {
                    numeroproyectos.put(gestion.getCdProyecto(), gestion.getCdProyecto());
                    numeroproveedor.put(gestion.getCdPieza(), gestion.getCdProveedor());
                    total = total + gestion.getCantidad();
                }
                totalCantidad.setText(String.valueOf(total));
                textoNumeroProyectos.setText(String.valueOf(numeroproyectos.size()));
                textoNumeroProveedor.setText(String.valueOf(numeroproveedor.size()));
            } else {
                JOptionPane.showMessageDialog(null, "Esta pieza no tiene relaciones", "Error relacion", JOptionPane.ERROR_MESSAGE);
            }
            textoNombre.setText(piezas.get(comboPieza.getSelectedIndex()).getNombre());
            textoPrecio.setText(String.valueOf(piezas.get(comboPieza.getSelectedIndex()).getPrecio()));
            textoDescripcion.setText(piezas.get(comboPieza.getSelectedIndex()).getDescripcion());

        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una pieza", "Error relaciones", JOptionPane.ERROR_MESSAGE);
        }
    }

    public SuministrosPieza() {
        setCombo();
        comboPieza.addActionListener(e -> {
            setTexto();
        });
        listaPiezaSuministrada.addActionListener(e -> {
            if (!textoNombre.getText().equals("") &&
                    !textoPrecio.getText().equals("") &&
                    !textoDescripcion.getText().equals("")) {
                Singleton singleton = Singleton.getInstance();
                singleton.codigo_pieza = piezas.get(comboPieza.getSelectedIndex()).getCodigoPieza();
                JFrame frame = new JFrame("Tabla suministros Piezas");
                frame.setContentPane(new SuministrosPiezaTabla().panel_main);
                frame.pack();
                frame.setSize(600, 600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una pieza", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
