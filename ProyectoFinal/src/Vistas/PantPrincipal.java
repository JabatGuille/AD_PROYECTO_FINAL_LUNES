/*
 * Created by JFormDesigner on Mon Dec 12 19:55:08 CET 2022
 */

package Vistas;

import Vistas.Piezas.Gestion.Piezas;

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
                PROVEEDORESmenu.add(GESTIONPROVEEDORmenu);

                //======== CONSULTAPROVEEDORESmenu ========
                {
                    CONSULTAPROVEEDORESmenu.setText("Consulta de Proveedores");

                    //---- CODIGOPROVEEDORES ----
                    CODIGOPROVEEDORES.setText("C\u00f3digo");
                    CONSULTAPROVEEDORESmenu.add(CODIGOPROVEEDORES);

                    //---- NOMBREPROVEEDORmenu ----
                    NOMBREPROVEEDORmenu.setText("Nombre");
                    CONSULTAPROVEEDORESmenu.add(NOMBREPROVEEDORmenu);

                    //---- CIUDADCONSULTAPROVEEDOR ----
                    CIUDADCONSULTAPROVEEDOR.setText("Ciudad");
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
            menuBar1.add(AYUDABUTTON);
        }
        contentPane.add(menuBar1);
        menuBar1.setBounds(0, 0, 855, 22);

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
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
