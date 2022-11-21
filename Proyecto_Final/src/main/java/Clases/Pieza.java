package Clases;

import jakarta.persistence.*;

@Entity
@Table(name = "Pieza")
public class Pieza {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo", nullable = false, length = 6)
    private String codigo;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "precio", nullable = false)
    private Double precio;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "descripcion", nullable = false, length = 40)
    private String descripcion;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
