/*
 * Created by JFormDesigner on Thu Dec 15 17:12:15 CET 2022
 */

package Vistas.Piezas.Gestion;

import Clases.PiezaEntity;
import Conexiones.Conexiones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * @author unknown
 */
public class BuscarNombre extends JFrame {
    public BuscarNombre() {
        initComponents();
    }
    ArrayList<PiezaEntity> piezas;

    private void botonBusqueda(ActionEvent e) {
        // TODO add your code here

        if (!textoBusqueda.getText().equals("")) {
            piezas = Conexiones.listaPosiblesPiezas(textoBusqueda.getText(), "nombre");
            construirSpinner();
        }
    }

    public void construirSpinner() {
        comboCodigos.removeAllItems();
        for (PiezaEntity pieza : piezas) {
            comboCodigos.addItem(pieza.getNombre());
        }

    }

    private void comboCodigos(ActionEvent e) {
        // TODO add your code here
        PiezaEntity pieza = piezas.get(comboCodigos.getSelectedIndex());
        textoArea.setText("CODIGO :" + pieza.getCodigoPieza() + "\n"
                + "NOMBRE :" + pieza.getNombre() + "\n" +
                "PRECIO :" + pieza.getPrecio() + "\n" +
                "DESCRIPCION :" + pieza.getDescripcion() + "\n");
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textoBusqueda = new JTextField();
        botonBusqueda = new JButton();
        comboCodigos = new JComboBox();
        scrollPane1 = new JScrollPane();
        textoArea = new JTextArea();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Escribe el nombre o parte del nombre");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(25, 35), label1.getPreferredSize()));
        contentPane.add(textoBusqueda);
        textoBusqueda.setBounds(260, 35, 240, textoBusqueda.getPreferredSize().height);

        //---- botonBusqueda ----
        botonBusqueda.setText("Buscar Pieza");
        contentPane.add(botonBusqueda);
        botonBusqueda.setBounds(new Rectangle(new Point(525, 35), botonBusqueda.getPreferredSize()));
        contentPane.add(comboCodigos);
        comboCodigos.setBounds(60, 105, 525, comboCodigos.getPreferredSize().height);

        //======== scrollPane1 ========
        {

            //---- textoArea ----
            textoArea.setEditable(false);
            scrollPane1.setViewportView(textoArea);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(70, 165, 495, 270);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textoBusqueda;
    private JButton botonBusqueda;
    private JComboBox comboCodigos;
    private JScrollPane scrollPane1;
    private JTextArea textoArea;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
