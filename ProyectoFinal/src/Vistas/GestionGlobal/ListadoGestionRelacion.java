package Vistas.GestionGlobal;

import Clases.GestionEntity;
import Clases.PiezaEntity;
import Conexiones.Conexiones;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ListadoGestionRelacion {
    public JPanel panel_main;
    private JTable TablaRelacion;
    ArrayList<GestionEntity> gestiones;

    public void setTabla() {

        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        model.addColumn("Codigo Gestion");
        model.addColumn("Codigo Proveedor");
        model.addColumn("Codigo Pieza");
        model.addColumn("Codigo Proyecto");
        model.addColumn("Cantidad");
        gestiones = Conexiones.listaGestion();
        for (GestionEntity gestion : gestiones) {
            model.addRow(new Object[]{gestion.getIdGestion(), gestion.getCdProveedor(), gestion.getCdPieza(), gestion.getCdProyecto(), gestion.getCantidad()});
        }
        TablaRelacion.setModel(model);
    }

    public ListadoGestionRelacion() {
        setTabla();
    }

}
