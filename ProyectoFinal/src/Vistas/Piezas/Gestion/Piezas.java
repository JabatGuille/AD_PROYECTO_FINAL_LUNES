/*
 * Created by JFormDesigner on Mon Dec 12 18:54:37 CET 2022
 */

package Vistas.Piezas.Gestion;

import Clases.PiezaEntity;
import Conexiones.Conexiones;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.awt.event.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import javax.swing.text.html.parser.Entity;
import java.awt.*;

/**
 * @author unknown
 */
public class Piezas extends JFrame {
    public Piezas() {
        initComponents();
    }

    private void Limpar(ActionEvent e) {
        // TODO add your code here
        CodigoPiezaTexto.setText("");
        NombrePiezaTexto.setText("");
        DescripcionPiezaTexto.setText("");
        SpinnerPrecioPieza.setValue(0);

    }

    private void Insertar(ActionEvent e) {
        if (!CodigoPiezaTexto.getText().equals("") && !NombrePiezaTexto.getText().equals("") && !DescripcionPiezaTexto.getText().equals("")) {
            PiezaEntity pieza = new PiezaEntity();
            pieza.setCodigoPieza(String.valueOf(CodigoPiezaTexto.getText()));
            pieza.setNombre(NombrePiezaTexto.getText());
            pieza.setDescripcion(DescripcionPiezaTexto.getText());
            pieza.setPrecio(Double.parseDouble(SpinnerPrecioPieza.getValue().toString()));
            Conexiones.insertarPieza(pieza);
        }

    }

    private void Modificar(ActionEvent e) {
        if (!CodigoPiezaTexto.getText().equals("") && !NombrePiezaTexto.getText().equals("") && !DescripcionPiezaTexto.getText().equals("")) {
            PiezaEntity pieza = new PiezaEntity();
            pieza.setCodigoPieza(String.valueOf(CodigoPiezaTexto.getText()));
            pieza.setNombre(NombrePiezaTexto.getText());
            pieza.setDescripcion(DescripcionPiezaTexto.getText());
            pieza.setPrecio(Double.parseDouble(SpinnerPrecioPieza.getValue().toString()));
            Conexiones.modificarPieza(pieza);
        }
    }

    private void Eliminar(ActionEvent e) {
        // TODO add your code here
        if (!CodigoPiezaTexto.getText().equals("") && !NombrePiezaTexto.getText().equals("") && !DescripcionPiezaTexto.getText().equals("")) {
            PiezaEntity pieza = new PiezaEntity();
            pieza.setCodigoPieza(String.valueOf(CodigoPiezaTexto.getText()));
            pieza.setNombre(NombrePiezaTexto.getText());
            pieza.setDescripcion(DescripcionPiezaTexto.getText());
            pieza.setPrecio(Double.parseDouble(SpinnerPrecioPieza.getValue().toString()));
            Conexiones.eliminarPieza(pieza.getCodigoPieza());
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        tabbedPane1 = new JTabbedPane();
        PanelGestion = new JPanel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        CodigoPiezaTexto = new JTextField();
        NombrePiezaTexto = new JTextField();
        DescripcionPiezaTexto = new JTextField();
        LimparButton = new JButton();
        EliminarButton = new JButton();
        ModificarButton = new JButton();
        InsertarButton = new JButton();
        SpinnerPrecioPieza = new JSpinner();
        PanelListado = new JPanel();
        scrollPane1 = new JScrollPane();
        TablaPieza = new JTable();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== tabbedPane1 ========
        {

            //======== PanelGestion ========
            {
                PanelGestion.setLayout(null);

                //---- label7 ----
                label7.setText("ALTAS BAJAS Y MODIFICACIONES");
                PanelGestion.add(label7);
                label7.setBounds(15, 25, 190, 30);

                //---- label8 ----
                label8.setText("Codigo de Pieza");
                PanelGestion.add(label8);
                label8.setBounds(new Rectangle(new Point(30, 80), label8.getPreferredSize()));

                //---- label9 ----
                label9.setText("Nombre");
                PanelGestion.add(label9);
                label9.setBounds(new Rectangle(new Point(30, 125), label9.getPreferredSize()));

                //---- label10 ----
                label10.setText("Precio");
                PanelGestion.add(label10);
                label10.setBounds(new Rectangle(new Point(30, 170), label10.getPreferredSize()));

                //---- label11 ----
                label11.setText("Descripcion");
                PanelGestion.add(label11);
                label11.setBounds(new Rectangle(new Point(30, 210), label11.getPreferredSize()));
                PanelGestion.add(CodigoPiezaTexto);
                CodigoPiezaTexto.setBounds(160, 75, 290, CodigoPiezaTexto.getPreferredSize().height);
                PanelGestion.add(NombrePiezaTexto);
                NombrePiezaTexto.setBounds(95, 120, 355, NombrePiezaTexto.getPreferredSize().height);
                PanelGestion.add(DescripcionPiezaTexto);
                DescripcionPiezaTexto.setBounds(100, 210, 350, DescripcionPiezaTexto.getPreferredSize().height);

                //---- LimparButton ----
                LimparButton.setText("Limpiar");
                LimparButton.addActionListener(e -> Limpar(e));
                PanelGestion.add(LimparButton);
                LimparButton.setBounds(new Rectangle(new Point(15, 310), LimparButton.getPreferredSize()));

                //---- EliminarButton ----
                EliminarButton.setText("Eliminar");
                EliminarButton.addActionListener(e -> {
                    Eliminar(e);
                    Eliminar(e);
                });
                PanelGestion.add(EliminarButton);
                EliminarButton.setBounds(310, 310, 110, 30);

                //---- ModificarButton ----
                ModificarButton.setText("Modificar");
                ModificarButton.addActionListener(e -> Modificar(e));
                PanelGestion.add(ModificarButton);
                ModificarButton.setBounds(210, 310, 78, 30);

                //---- InsertarButton ----
                InsertarButton.setText("Insertar");
                InsertarButton.addActionListener(e -> Insertar(e));
                PanelGestion.add(InsertarButton);
                InsertarButton.setBounds(110, 310, 78, 30);
                PanelGestion.add(SpinnerPrecioPieza);
                SpinnerPrecioPieza.setBounds(95, 170, 350, SpinnerPrecioPieza.getPreferredSize().height);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for (int i = 0; i < PanelGestion.getComponentCount(); i++) {
                        Rectangle bounds = PanelGestion.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = PanelGestion.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    PanelGestion.setMinimumSize(preferredSize);
                    PanelGestion.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("Gestion de Proyectos", PanelGestion);

            //======== PanelListado ========
            {
                PanelListado.setLayout(null);

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(TablaPieza);
                }
                PanelListado.add(scrollPane1);
                scrollPane1.setBounds(5, 0, 540, 380);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for (int i = 0; i < PanelListado.getComponentCount(); i++) {
                        Rectangle bounds = PanelListado.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = PanelListado.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    PanelListado.setMinimumSize(preferredSize);
                    PanelListado.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("Listado de Proveedores", PanelListado);
        }
        contentPane.add(tabbedPane1);
        tabbedPane1.setBounds(0, 0, 545, 415);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < contentPane.getComponentCount(); i++) {
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
    private JTabbedPane tabbedPane1;
    private JPanel PanelGestion;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JTextField CodigoPiezaTexto;
    private JTextField NombrePiezaTexto;
    private JTextField DescripcionPiezaTexto;
    private JButton LimparButton;
    private JButton EliminarButton;
    private JButton ModificarButton;
    private JButton InsertarButton;
    private JSpinner SpinnerPrecioPieza;
    private JPanel PanelListado;
    private JScrollPane scrollPane1;
    private JTable TablaPieza;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
