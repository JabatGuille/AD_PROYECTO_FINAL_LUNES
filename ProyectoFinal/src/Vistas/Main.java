/*
 * Created by JFormDesigner on Mon Nov 28 21:39:45 CET 2022
 */

package Vistas;

import java.awt.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class Main extends JFrame {
    public Main() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        BBDDmenu = new JMenu();
        PROVEEDORESmenu = new JMenu();
        GESTIONPROVEEDORmenu = new JMenu();
        ALTASPROVEEDORmenu = new JMenuItem();
        BAJASPROVEEDORmenu = new JMenuItem();
        MODIFICACIONESPROVEEDORmenu = new JMenuItem();
        LISTADOPROVEEDORmenu = new JMenuItem();
        CONSULTAPROVEEDORESmenu = new JMenu();
        CODIGOPROVEEDORES = new JMenuItem();
        NOMBREPROVEEDORmenu = new JMenuItem();
        PIEZASmenu = new JMenu();
        GESTIONPIEZAmenu = new JMenu();
        menu2 = new JMenu();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //======== BBDDmenu ========
            {
                BBDDmenu.setText("Base de Datos");
            }
            menuBar1.add(BBDDmenu);

            //======== PROVEEDORESmenu ========
            {
                PROVEEDORESmenu.setText("Proveedores");

                //======== GESTIONPROVEEDORmenu ========
                {
                    GESTIONPROVEEDORmenu.setText("Gesti\u00f3n de Proveedores");

                    //---- ALTASPROVEEDORmenu ----
                    ALTASPROVEEDORmenu.setText("Altas");
                    GESTIONPROVEEDORmenu.add(ALTASPROVEEDORmenu);

                    //---- BAJASPROVEEDORmenu ----
                    BAJASPROVEEDORmenu.setText("Baja");
                    GESTIONPROVEEDORmenu.add(BAJASPROVEEDORmenu);

                    //---- MODIFICACIONESPROVEEDORmenu ----
                    MODIFICACIONESPROVEEDORmenu.setText("Modificaciones");
                    GESTIONPROVEEDORmenu.add(MODIFICACIONESPROVEEDORmenu);

                    //---- LISTADOPROVEEDORmenu ----
                    LISTADOPROVEEDORmenu.setText("Listado");
                    GESTIONPROVEEDORmenu.add(LISTADOPROVEEDORmenu);
                }
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
                }
                PROVEEDORESmenu.add(CONSULTAPROVEEDORESmenu);
            }
            menuBar1.add(PROVEEDORESmenu);

            //======== PIEZASmenu ========
            {
                PIEZASmenu.setText("Piezas");

                //======== GESTIONPIEZAmenu ========
                {
                    GESTIONPIEZAmenu.setText("Gesti\u00f3n de piezas");
                }
                PIEZASmenu.add(GESTIONPIEZAmenu);

                //======== menu2 ========
                {
                    menu2.setText("text");
                }
                PIEZASmenu.add(menu2);
            }
            menuBar1.add(PIEZASmenu);
        }
        setJMenuBar(menuBar1);

        contentPane.setPreferredSize(new Dimension(665, 430));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JMenu BBDDmenu;
    private JMenu PROVEEDORESmenu;
    private JMenu GESTIONPROVEEDORmenu;
    private JMenuItem ALTASPROVEEDORmenu;
    private JMenuItem BAJASPROVEEDORmenu;
    private JMenuItem MODIFICACIONESPROVEEDORmenu;
    private JMenuItem LISTADOPROVEEDORmenu;
    private JMenu CONSULTAPROVEEDORESmenu;
    private JMenuItem CODIGOPROVEEDORES;
    private JMenuItem NOMBREPROVEEDORmenu;
    private JMenu PIEZASmenu;
    private JMenu GESTIONPIEZAmenu;
    private JMenu menu2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
