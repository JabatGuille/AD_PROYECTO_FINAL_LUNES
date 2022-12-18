package Vistas.GestionGlobal;

import Clases.GestionEntity;
import Clases.PiezaEntity;
import ClasesCustom.PiezaCustom;
import ClasesCustom.Singleton;
import Conexiones.Conexiones;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.util.ArrayList;
import java.util.HashMap;

public class SuministroProveedorTabla {
    public JPanel panel_main;
    private JTable tablaCustom;

    public void setTablaCustom() {
        Singleton singleton = Singleton.getInstance();
        ArrayList<GestionEntity> gestiones = new ArrayList<>();
        gestiones = Conexiones.listaGestionCantidad(singleton.codigo_proveedor, "CDProveedor");
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        model.addColumn("Codigo Pieza");
        model.addColumn("Nombre");
        model.addColumn("Precio");
        model.addColumn("Descripcion");
        HashMap<String, PiezaCustom> custom = new HashMap<>();
        for (GestionEntity gestion : gestiones) {
            PiezaEntity pieza = Conexiones.recuperarPieza(gestion.getCdPieza());
            if (!custom.containsKey(pieza.getCodigoPieza())) {
                custom.put(pieza.getCodigoPieza(), new PiezaCustom(pieza.getCodigoPieza(), pieza.getNombre(), pieza.getPrecio(), pieza.getDescripcion()));
            }
            custom.get(pieza.getCodigoPieza()).setCodigo_proyecto(singleton.codigo_proveedor);
        }
        int max = 0;
        for (PiezaCustom pcustom : custom.values()) {
            if (pcustom.codigo_proyecto.size() > max) {
                max = pcustom.codigo_proyecto.size()-1;
            }
        }
        for (PiezaCustom pcustom : custom.values()) {
            for (int i = 0; i <= max; i++) {
                model.addColumn("Proyecto" + i);
            }

            Object[] row = new Object[4 + pcustom.codigo_proyecto.size()];
            row[0] = pcustom.codiog_pieza;
            row[1] = pcustom.nombre;
            row[2] = pcustom.precio;
            row[3] = pcustom.descripcion;
            for (int i = 4; i <= row.length - 1; i++) {
                row[i] =pcustom.codigo_proyecto.get(i-4);
            }
            model.addRow(row);
        }
        tablaCustom.setModel(model);
    }

    public SuministroProveedorTabla() {
        setTablaCustom();
    }
}
