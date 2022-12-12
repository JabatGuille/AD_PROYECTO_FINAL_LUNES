/*
 * Created by JFormDesigner on Mon Dec 12 21:46:34 CET 2022
 */

package Vistas;

import java.awt.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class Ayuda extends JFrame {
    public Ayuda() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Autor");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(15, 20), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("Guillermo Jabato Aguado");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(65, 20), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("Version");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(15, 55), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("0.0.1");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(75, 55), label4.getPreferredSize()));

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
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
