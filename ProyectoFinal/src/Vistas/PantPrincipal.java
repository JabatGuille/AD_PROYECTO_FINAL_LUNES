/*
 * Created by JFormDesigner on Mon Dec 12 19:55:08 CET 2022
 */

package Vistas;

import Vistas.Piezas.Gestion.Piezas;
import Vistas.Proveedores.Gestion.BuscarCodigo;
import Vistas.Proveedores.Gestion.BuscarDireccion;
import Vistas.Proveedores.Gestion.BuscarNombre;
import Vistas.Proveedores.Gestion.Proveedores;
import Vistas.Proyectos.Gestion.Proyectos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class PantPrincipal extends JFrame {
    public PantPrincipal() {
        initComponents();
    }

    private void GESTIONPIEZAmenu(ActionEvent e) {
        Piezas piezas = new Piezas();
        piezas.setVisible(true);
    }

    private void GESTIONPROYECTOmenu(ActionEvent e) {
        // TODO add your code here
        Proyectos proyecto = new Proyectos();
        proyecto.setVisible(true);
    }

    private void GESTIONPROVEEDORmenu(ActionEvent e) {
        // TODO add your code here
        Proveedores proveedores = new Proveedores();
        proveedores.setVisible(true);
    }

    private void AYUDABUTTON(ActionEvent e) {
        // TODO add your code here
        Ayuda ayuda = new Ayuda();
        ayuda.setVisible(true);
    }

    private void CODIGOPROVEEDORES(ActionEvent e) {
        // TODO add your code here
        BuscarCodigo codigo = new BuscarCodigo();
        codigo.setVisible(true);
    }

    private void NOMBREPROVEEDORmenu(ActionEvent e) {
        // TODO add your code here
        BuscarNombre nombre = new BuscarNombre();
        nombre.setVisible(true);
    }

    private void CIUDADCONSULTAPROVEEDOR(ActionEvent e) {
        // TODO add your code here
        BuscarDireccion direccion = new BuscarDireccion();
        direccion.setVisible(true);

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        BBDDmenu = new JMenuItem();
        PROVEEDORESmenu = new JMenu();
        GESTIONPROVEEDORmenu = new JMenuItem();
        CONSULTAPROVEEDORESmenu = new JMenu();
        CODIGOPROVEEDORES = new JMenuItem();
        NOMBREPROVEEDORmenu = new JMenuItem();
        CIUDADCONSULTAPROVEEDOR = new JMenuItem();
        PIEZASmenu = new JMenu();
        GESTIONPIEZAmenu = new JMenuItem();
        CONSULTASPIEZASmenu = new JMenu();
        CODIGOCONSULTASPIEZASmenu = new JMenuItem();
        NOMBRECONSULTAPIEZA = new JMenuItem();
        PROYECTOSmenu = new JMenu();
        GESTIONPROYECTOmenu = new JMenuItem();
        CONSULTAPROYECTOSmenu = new JMenu();
        CODIGOPROYECTO = new JMenuItem();
        NOMBREPROYECTO = new JMenuItem();
        CIUDADPROYECTO = new JMenuItem();
        GESTIONGLOBALmenu = new JMenu();
        AYUDABUTTON = new JMenuItem();
        label1 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //---- BBDDmenu ----
            BBDDmenu.setText("Base de Datos");
            menuBar1.add(BBDDmenu);

            //======== PROVEEDORESmenu ========
            {
                PROVEEDORESmenu.setText("Proveedores");

                //---- GESTIONPROVEEDORmenu ----
                GESTIONPROVEEDORmenu.setText("Gesti\u00f3n de Proveedores");
                GESTIONPROVEEDORmenu.addActionListener(e -> GESTIONPROVEEDORmenu(e));
                PROVEEDORESmenu.add(GESTIONPROVEEDORmenu);

                //======== CONSULTAPROVEEDORESmenu ========
                {
                    CONSULTAPROVEEDORESmenu.setText("Consulta de Proveedores");

                    //---- CODIGOPROVEEDORES ----
                    CODIGOPROVEEDORES.setText("C\u00f3digo");
                    CODIGOPROVEEDORES.addActionListener(e -> CODIGOPROVEEDORES(e));
                    CONSULTAPROVEEDORESmenu.add(CODIGOPROVEEDORES);

                    //---- NOMBREPROVEEDORmenu ----
                    NOMBREPROVEEDORmenu.setText("Nombre");
                    NOMBREPROVEEDORmenu.addActionListener(e -> {
			NOMBREPROVEEDORmenu(e);
			NOMBREPROVEEDORmenu(e);
		});
                    CONSULTAPROVEEDORESmenu.add(NOMBREPROVEEDORmenu);

                    //---- CIUDADCONSULTAPROVEEDOR ----
                    CIUDADCONSULTAPROVEEDOR.setText("Direccion");
                    CIUDADCONSULTAPROVEEDOR.addActionListener(e -> CIUDADCONSULTAPROVEEDOR(e));
                    CONSULTAPROVEEDORESmenu.add(CIUDADCONSULTAPROVEEDOR);
                }
                PROVEEDORESmenu.add(CONSULTAPROVEEDORESmenu);
            }
            menuBar1.add(PROVEEDORESmenu);

            //======== PIEZASmenu ========
            {
                PIEZASmenu.setText("Piezas");

                //---- GESTIONPIEZAmenu ----
                GESTIONPIEZAmenu.setText("Gesti\u00f3n de piezas");
                GESTIONPIEZAmenu.addActionListener(e -> GESTIONPIEZAmenu(e));
                PIEZASmenu.add(GESTIONPIEZAmenu);

                //======== CONSULTASPIEZASmenu ========
                {
                    CONSULTASPIEZASmenu.setText("Consultas");

                    //---- CODIGOCONSULTASPIEZASmenu ----
                    CODIGOCONSULTASPIEZASmenu.setText("C\u00f3digo");
                    CONSULTASPIEZASmenu.add(CODIGOCONSULTASPIEZASmenu);

                    //---- NOMBRECONSULTAPIEZA ----
                    NOMBRECONSULTAPIEZA.setText("Nombre");
                    CONSULTASPIEZASmenu.add(NOMBRECONSULTAPIEZA);
                }
                PIEZASmenu.add(CONSULTASPIEZASmenu);
            }
            menuBar1.add(PIEZASmenu);

            //======== PROYECTOSmenu ========
            {
                PROYECTOSmenu.setText("Proyectos");

                //---- GESTIONPROYECTOmenu ----
                GESTIONPROYECTOmenu.setText("Gesti\u00f3n de Proyectos");
                GESTIONPROYECTOmenu.addActionListener(e -> GESTIONPROYECTOmenu(e));
                PROYECTOSmenu.add(GESTIONPROYECTOmenu);

                //======== CONSULTAPROYECTOSmenu ========
                {
                    CONSULTAPROYECTOSmenu.setText("Consulta de Proyectos");

                    //---- CODIGOPROYECTO ----
                    CODIGOPROYECTO.setText("C\u00f3digo");
                    CONSULTAPROYECTOSmenu.add(CODIGOPROYECTO);

                    //---- NOMBREPROYECTO ----
                    NOMBREPROYECTO.setText("Nombre");
                    CONSULTAPROYECTOSmenu.add(NOMBREPROYECTO);

                    //---- CIUDADPROYECTO ----
                    CIUDADPROYECTO.setText("Ciudad");
                    CONSULTAPROYECTOSmenu.add(CIUDADPROYECTO);
                }
                PROYECTOSmenu.add(CONSULTAPROYECTOSmenu);
            }
            menuBar1.add(PROYECTOSmenu);

            //======== GESTIONGLOBALmenu ========
            {
                GESTIONGLOBALmenu.setText("Gestion Global");
            }
            menuBar1.add(GESTIONGLOBALmenu);

            //---- AYUDABUTTON ----
            AYUDABUTTON.setText("Ayuda");
            AYUDABUTTON.addActionListener(e -> AYUDABUTTON(e));
            menuBar1.add(AYUDABUTTON);
        }
        contentPane.add(menuBar1);
        menuBar1.setBounds(0, 0, 855, 22);

        //---- label1 ----
        label1.setIcon(new ImageIcon("C:\\Users\\Guillermo\\Desktop\\PROYECTO_FINAL_LUNES\\Logo\\Logo.png"));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(-15, -30), label1.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(855, 415));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JMenuItem BBDDmenu;
    private JMenu PROVEEDORESmenu;
    private JMenuItem GESTIONPROVEEDORmenu;
    private JMenu CONSULTAPROVEEDORESmenu;
    private JMenuItem CODIGOPROVEEDORES;
    private JMenuItem NOMBREPROVEEDORmenu;
    private JMenuItem CIUDADCONSULTAPROVEEDOR;
    private JMenu PIEZASmenu;
    private JMenuItem GESTIONPIEZAmenu;
    private JMenu CONSULTASPIEZASmenu;
    private JMenuItem CODIGOCONSULTASPIEZASmenu;
    private JMenuItem NOMBRECONSULTAPIEZA;
    private JMenu PROYECTOSmenu;
    private JMenuItem GESTIONPROYECTOmenu;
    private JMenu CONSULTAPROYECTOSmenu;
    private JMenuItem CODIGOPROYECTO;
    private JMenuItem NOMBREPROYECTO;
    private JMenuItem CIUDADPROYECTO;
    private JMenu GESTIONGLOBALmenu;
    private JMenuItem AYUDABUTTON;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
