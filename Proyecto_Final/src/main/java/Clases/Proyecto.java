package Clases;

import jakarta.persistence.*;

@Entity
@Table(name = "Proyecto")
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo", nullable = false, length = 6)
    private String codigo;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "nombre", nullable = false, length = 40)
    private String nombre;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ciudad", nullable = false, length = 40)
    private String ciudad;

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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

}
