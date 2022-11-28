package Clases;

import javax.persistence.*;

@Entity
@Table(name = "pieza", schema = "gestionproyectos", catalog = "")
public class PiezaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codigo_pieza", nullable = false, length = 6)
    private String codigoPieza;
    @Basic
    @Column(name = "nombre", nullable = true, length = 20)
    private String nombre;
    @Basic
    @Column(name = "precio", nullable = true, precision = 0)
    private Double precio;
    @Basic
    @Column(name = "descripcion", nullable = true, length = 20)
    private String descripcion;

    public String getCodigoPieza() {
        return codigoPieza;
    }

    public void setCodigoPieza(String codigoPieza) {
        this.codigoPieza = codigoPieza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
