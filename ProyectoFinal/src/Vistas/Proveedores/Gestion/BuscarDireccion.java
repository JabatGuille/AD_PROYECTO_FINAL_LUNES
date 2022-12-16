/*
 * Created by JFormDesigner on Thu Dec 15 17:12:15 CET 2022
 */

package Vistas.Proveedores.Gestion;

import Clases.ProveedorEntity;
import Conexiones.Conexiones;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author unknown
 */
public class BuscarDireccion extends JFrame {
    public BuscarDireccion() {
        initComponents();
    }

    ArrayList<ProveedorEntity> proveedores;

    private void botonBusqueda(ActionEvent e) {
        // TODO add your code here

        if (!textoBusqueda.getText().equals("")) {
            proveedores = Conexiones.listaPosiblesProveedores(textoBusqueda.getText(), "direccion");
            construirSpinner();
        }
    }

    public void construirSpinner() {
        comboCodigos.removeAllItems();
        for (ProveedorEntity proveedore : proveedores) {
            comboCodigos.addItem(proveedore.getDireccion());
        }

    }

    private void comboCodigos(ActionEvent e) {
        // TODO add your code here
        ProveedorEntity proveedor = proveedores.get(comboCodigos.getSelectedIndex());
        textoArea.setText("CODIGO :" + proveedor.getCodigoProveedor() + "\n"
                + "NOMBRE :" + proveedor.getNombre()+"\n"+
                "APELLIDOS :"+proveedor.getApellido()+"\n"+
                "DIRECCION :"+proveedor.getDireccion()+"\n");
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
        label1.setText("Escribe la direccion o parte de la direccion");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(30, 40), label1.getPreferredSize()));
        contentPane.add(textoBusqueda);
        textoBusqueda.setBounds(260, 35, 240, textoBusqueda.getPreferredSize().height);

        //---- botonBusqueda ----
        botonBusqueda.setText("Buscar Proveedor");
        botonBusqueda.addActionListener(e -> botonBusqueda(e));
        contentPane.add(botonBusqueda);
        botonBusqueda.setBounds(new Rectangle(new Point(525, 35), botonBusqueda.getPreferredSize()));

        //---- comboCodigos ----
        comboCodigos.addActionListener(e -> comboCodigos(e));
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
