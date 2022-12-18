package Vistas.GestionGlobal;

import Clases.GestionEntity;
import Clases.PiezaEntity;
import Clases.ProyectoEntity;
import ClasesCustom.PiezaCustom;
import ClasesCustom.Singleton;
import Conexiones.Conexiones;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.HashMap;

public class SuministrosPiezaTabla {
    public JPanel panel_main;
    private JTable tablaCustom;

    public void setTablaCustom() {
        Singleton singleton = Singleton.getInstance();
        ArrayList<GestionEntity> gestiones = new ArrayList<>();
        gestiones = Conexiones.listaGestionCantidad(singleton.codigo_pieza, "CDPieza");
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        model.addColumn("Codigo Proyecto");
        model.addColumn("Nombre");
        model.addColumn("Ciudad");
        HashMap<String, PiezaCustom> custom = new HashMap<>();
        for (GestionEntity gestion : gestiones) {
            ProyectoEntity proyecto = Conexiones.recuperarProyecto(gestion.getCdProyecto());
            if (!custom.containsKey(proyecto.getCodigoProyecto())) {
                custom.put(proyecto.getCodigoProyecto(), new PiezaCustom(proyecto.getCodigoProyecto(), proyecto.getNombre(), 2, proyecto.getCiudad()));
            }
            custom.get(proyecto.getCodigoProyecto()).setCodigo_proyecto(gestion.getCdProveedor());
        }
        int max = 0;
        for (PiezaCustom pcustom : custom.values()) {
            if (pcustom.codigo_proyecto.size() > max) {
                max = pcustom.codigo_proyecto.size() - 1;
            }
        }
        for (PiezaCustom pcustom : custom.values()) {
            for (int i = 0; i <= max; i++) {
                model.addColumn("Proveedor" + i);
            }

            Object[] row = new Object[3 + pcustom.codigo_proyecto.size()];
            row[0] = pcustom.codiog_pieza;
            row[1] = pcustom.nombre;
            row[2] = pcustom.descripcion;
            for (int i = 3; i <= row.length - 1; i++) {
                row[i] = pcustom.codigo_proyecto.get(i - 3);
            }
            model.addRow(row);
        }
        tablaCustom.setModel(model);
    }

    public SuministrosPiezaTabla() {
        setTablaCustom();
    }
}
