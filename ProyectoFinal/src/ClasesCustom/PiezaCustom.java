package ClasesCustom;

import java.util.ArrayList;

public class PiezaCustom {
    public String codiog_pieza;
    public String nombre;
    public double precio;
    public String descripcion;
    public ArrayList<String> codigo_proyecto = new ArrayList<>();

    public PiezaCustom(String codiog_pieza, String nombre, double precio, String descripcion) {
        this.codiog_pieza = codiog_pieza;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public ArrayList<String> getCodigo_proyecto() {
        return codigo_proyecto;
    }

    public void setCodigo_proyecto(String codigo_proyecto) {
        this.codigo_proyecto.add(codigo_proyecto);
    }
}
