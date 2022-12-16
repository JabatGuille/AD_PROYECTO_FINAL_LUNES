/*
 * Created by JFormDesigner on Mon Dec 12 18:54:37 CET 2022
 */

package Vistas.Proyectos.Gestion;

import javax.swing.event.*;

import Clases.ProveedorEntity;
import Clases.ProyectoEntity;
import Conexiones.Conexiones;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * @author unknown
 */
public class Proyectos extends JFrame {
    public Proyectos() {
        initComponents();
        this.setVisible(true);
    }

    private void Limpar(ActionEvent e) {
        // TODO add your code here
        CodigoProyectoTexto.setText("");
        NombreProyectoTexto.setText("");
        CiudadProyectoTexto.setText("");
    }

    private void Insertar(ActionEvent e) {
        if (!CodigoProyectoTexto.getText().equals("") && !NombreProyectoTexto.getText().equals("") && !CiudadProyectoTexto.getText().equals("")) {
            ProyectoEntity proyecto = new ProyectoEntity();
            proyecto.setCodigoProyecto(CodigoProyectoTexto.getText().toUpperCase());
            proyecto.setNombre(NombreProyectoTexto.getText());
            proyecto.setCiudad(CiudadProyectoTexto.getText());
            Conexiones.insertarProyecto(proyecto);
        }

    }

    private void Modificar(ActionEvent e) {
        if (!CodigoProyectoTexto.getText().equals("") && !NombreProyectoTexto.getText().equals("") && !CiudadProyectoTexto.getText().equals("")) {
            ProyectoEntity proyecto = new ProyectoEntity();
            proyecto.setCodigoProyecto(CodigoProyectoTexto.getText().toUpperCase());
            proyecto.setNombre(NombreProyectoTexto.getText());
            proyecto.setCiudad(CiudadProyectoTexto.getText());
            Conexiones.modificarProyecto(proyecto);
        }
    }

    private void Eliminar(ActionEvent e) {
        // TODO add your code here
        if (!CodigoProyectoTexto.getText().equals("") && !NombreProyectoTexto.getText().equals("") && !CiudadProyectoTexto.getText().equals("")) {
            ProyectoEntity proyecto = new ProyectoEntity();
            proyecto.setCodigoProyecto(CodigoProyectoTexto.getText().toUpperCase());
            proyecto.setNombre(NombreProyectoTexto.getText());
            proyecto.setCiudad(CiudadProyectoTexto.getText());
            Conexiones.eliminarProyecto(proyecto.getCodigoProyecto());
        }
    }

    private void tabbedPane1StateChanged(ChangeEvent e) {
        // TODO add your code here
        setTabla();
    }

    public void setTabla() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Codigo Proyecto");
        model.addColumn("Nombre");
        model.addColumn("Ciudad");
        ArrayList<ProyectoEntity> proyectos = Conexiones.listaProyecto();
        for (ProyectoEntity proyecto : proyectos) {
            model.addRow(new Object[]{proyecto.getCodigoProyecto(), proyecto.getNombre(), proyecto.getCiudad()});
        }
        TablaProyectos.setModel(model);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        tabbedPane1 = new JTabbedPane();
        PanelGestion = new JPanel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        CodigoProyectoTexto = new JTextField();
        NombreProyectoTexto = new JTextField();
        CiudadProyectoTexto = new JTextField();
        LimparButton = new JButton();
        EliminarButton = new JButton();
        ModificarButton = new JButton();
        InsertarButton = new JButton();
        PanelListado = new JPanel();
        scrollPane1 = new JScrollPane();
        TablaProyectos = new JTable();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== tabbedPane1 ========
        {
            tabbedPane1.addChangeListener(e -> tabbedPane1StateChanged(e));

            //======== PanelGestion ========
            {
                PanelGestion.setLayout(null);

                //---- label7 ----
                label7.setText("ALTAS BAJAS Y MODIFICACIONES");
                PanelGestion.add(label7);
                label7.setBounds(15, 25, 190, 30);

                //---- label8 ----
                label8.setText("Codigo de Proyecto");
                PanelGestion.add(label8);
                label8.setBounds(new Rectangle(new Point(30, 80), label8.getPreferredSize()));

                //---- label9 ----
                label9.setText("Nombre");
                PanelGestion.add(label9);
                label9.setBounds(new Rectangle(new Point(30, 125), label9.getPreferredSize()));

                //---- label10 ----
                label10.setText("Ciudad");
                PanelGestion.add(label10);
                label10.setBounds(new Rectangle(new Point(30, 170), label10.getPreferredSize()));
                PanelGestion.add(CodigoProyectoTexto);
                CodigoProyectoTexto.setBounds(160, 75, 290, CodigoProyectoTexto.getPreferredSize().height);
                PanelGestion.add(NombreProyectoTexto);
                NombreProyectoTexto.setBounds(95, 120, 355, NombreProyectoTexto.getPreferredSize().height);
                PanelGestion.add(CiudadProyectoTexto);
                CiudadProyectoTexto.setBounds(95, 165, 355, CiudadProyectoTexto.getPreferredSize().height);

                //---- LimparButton ----
                LimparButton.setText("Limpiar");
                LimparButton.addActionListener(e -> Limpar(e));
                PanelGestion.add(LimparButton);
                LimparButton.setBounds(new Rectangle(new Point(15, 310), LimparButton.getPreferredSize()));

                //---- EliminarButton ----
                EliminarButton.setText("Eliminar");
                EliminarButton.addActionListener(e -> Eliminar(e));
                PanelGestion.add(EliminarButton);
                EliminarButton.setBounds(310, 310, 78, 30);

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
                    scrollPane1.setViewportView(TablaProyectos);
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
            tabbedPane1.addTab("Listado de Proyectos", PanelListado);
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
    private JTextField CodigoProyectoTexto;
    private JTextField NombreProyectoTexto;
    private JTextField CiudadProyectoTexto;
    private JButton LimparButton;
    private JButton EliminarButton;
    private JButton ModificarButton;
    private JButton InsertarButton;
    private JPanel PanelListado;
    private JScrollPane scrollPane1;
    private JTable TablaProyectos;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
