/*
 * Created by JFormDesigner on Mon Dec 12 18:54:37 CET 2022
 */

package Vistas.Proveedores.Gestion;

import javax.swing.event.*;

import Clases.PiezaEntity;
import Clases.ProveedorEntity;
import Clases.ProyectoEntity;
import Conexiones.Conexiones;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author unknown
 */
public class Proveedores extends JFrame {
    public Proveedores() {
        initComponents();
    }

    private void Limpar(ActionEvent e) {
        // TODO add your code here
        CodigoProveedorTexto.setText("");
        NombreProveedorTexto.setText("");
        ApellidoProveedorTexto.setText("");
        DireccionProveedorTexto.setText("");
    }

    private void Insertar(ActionEvent e) {
        if (!CodigoProveedorTexto.getText().equals("") && !NombreProveedorTexto.getText().equals("") && !ApellidoProveedorTexto.getText().equals("") && !DireccionProveedorTexto.getText().equals("")) {
            ProveedorEntity proveedor = new ProveedorEntity();
            proveedor.setCodigoProveedor(CodigoProveedorTexto.getText());
            proveedor.setNombre(NombreProveedorTexto.getText());
            proveedor.setApellido(ApellidoProveedorTexto.getText());
            proveedor.setDireccion(DireccionProveedorTexto.getText());
            Conexiones.insertarProveedor(proveedor);
        }

    }

    private void Modificar(ActionEvent e) {
        if (!CodigoProveedorTexto.getText().equals("") && !NombreProveedorTexto.getText().equals("") && !ApellidoProveedorTexto.getText().equals("") && !DireccionProveedorTexto.getText().equals("")) {
            ProveedorEntity proveedor = new ProveedorEntity();
            proveedor.setCodigoProveedor(CodigoProveedorTexto.getText());
            proveedor.setNombre(NombreProveedorTexto.getText());
            proveedor.setApellido(ApellidoProveedorTexto.getText());
            proveedor.setDireccion(DireccionProveedorTexto.getText());
            Conexiones.modificarProveedor(proveedor);
        }
    }

    private void Eliminar(ActionEvent e) {
        // TODO add your code here
        if (!CodigoProveedorTexto.getText().equals("") && !NombreProveedorTexto.getText().equals("") && !ApellidoProveedorTexto.getText().equals("") && !DireccionProveedorTexto.getText().equals("")) {
            ProveedorEntity proveedor = new ProveedorEntity();
            proveedor.setCodigoProveedor(CodigoProveedorTexto.getText());
            proveedor.setNombre(NombreProveedorTexto.getText());
            proveedor.setApellido(ApellidoProveedorTexto.getText());
            proveedor.setDireccion(DireccionProveedorTexto.getText());
            Conexiones.eliminarProveedor(proveedor.getCodigoProveedor());
        }
    }

    private void tabbedPane1StateChanged(ChangeEvent e) {
        // TODO add your code here
        setTabla();
    }

    public void setTabla() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Codigo Proveedor");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Direccion");
        ArrayList<ProveedorEntity> proveedores = Conexiones.listaProveedor();
        for (ProveedorEntity proveedor : proveedores) {
            model.addRow(new Object[]{proveedor.getCodigoProveedor(), proveedor.getNombre(), proveedor.getApellido(), proveedor.getDireccion()});
        }
        TablaProveedor.setModel(model);
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
        CodigoProveedorTexto = new JTextField();
        NombreProveedorTexto = new JTextField();
        ApellidoProveedorTexto = new JTextField();
        DireccionProveedorTexto = new JTextField();
        LimparButton = new JButton();
        EliminarButton = new JButton();
        ModificarButton = new JButton();
        InsertarButton = new JButton();
        PanelListado = new JPanel();
        scrollPane1 = new JScrollPane();
        TablaProveedor = new JTable();

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
                label8.setText("Codigo de Proveedor");
                PanelGestion.add(label8);
                label8.setBounds(new Rectangle(new Point(30, 80), label8.getPreferredSize()));

                //---- label9 ----
                label9.setText("Nombre");
                PanelGestion.add(label9);
                label9.setBounds(new Rectangle(new Point(30, 125), label9.getPreferredSize()));

                //---- label10 ----
                label10.setText("Apellidos");
                PanelGestion.add(label10);
                label10.setBounds(new Rectangle(new Point(30, 170), label10.getPreferredSize()));

                //---- label11 ----
                label11.setText("Direccion");
                PanelGestion.add(label11);
                label11.setBounds(new Rectangle(new Point(30, 210), label11.getPreferredSize()));
                PanelGestion.add(CodigoProveedorTexto);
                CodigoProveedorTexto.setBounds(160, 75, 290, CodigoProveedorTexto.getPreferredSize().height);
                PanelGestion.add(NombreProveedorTexto);
                NombreProveedorTexto.setBounds(95, 120, 355, NombreProveedorTexto.getPreferredSize().height);
                PanelGestion.add(ApellidoProveedorTexto);
                ApellidoProveedorTexto.setBounds(95, 165, 355, ApellidoProveedorTexto.getPreferredSize().height);
                PanelGestion.add(DireccionProveedorTexto);
                DireccionProveedorTexto.setBounds(95, 210, 350, DireccionProveedorTexto.getPreferredSize().height);

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
            tabbedPane1.addTab("Gestion de Proveedores", PanelGestion);

            //======== PanelListado ========
            {
                PanelListado.setLayout(null);

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(TablaProveedor);
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
    private JTextField CodigoProveedorTexto;
    private JTextField NombreProveedorTexto;
    private JTextField ApellidoProveedorTexto;
    private JTextField DireccionProveedorTexto;
    private JButton LimparButton;
    private JButton EliminarButton;
    private JButton ModificarButton;
    private JButton InsertarButton;
    private JPanel PanelListado;
    private JScrollPane scrollPane1;
    private JTable TablaProveedor;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
