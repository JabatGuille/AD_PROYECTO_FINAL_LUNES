package Clases;

import jakarta.persistence.*;

@Entity
@Table(name = "Proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo", nullable = false, length = 6)
    private String codigo;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "apellido", nullable = false, length = 30)
    private String apellido;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "direccion", nullable = false, length = 40)
    private String direccion;

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
