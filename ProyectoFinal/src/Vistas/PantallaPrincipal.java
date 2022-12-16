package Vistas;

import javax.swing.*;
import java.awt.*;


public class PantallaPrincipal {


    JPanel panel_main;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Frame");
        JMenuBar jmenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("prueba");
        JMenuItem jMenuItem = new JMenuItem("prueba2");

        jMenuItem.addActionListener(e -> JOptionPane.showMessageDialog(null,"rabos"));
        jMenu.add(jMenuItem);
        jmenuBar.add(jMenu);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setJMenuBar(jmenuBar);
        frame.setVisible(true);
    }
}
