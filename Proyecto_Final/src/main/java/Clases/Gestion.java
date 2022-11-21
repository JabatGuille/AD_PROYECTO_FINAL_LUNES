package Clases;

import jakarta.persistence.*;

@Entity
@Table(name = "Gestion")
public class Gestion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "CDProveedor")
    private Proveedor proveedor;
    @ManyToOne
    @JoinColumn(name = "CDPieza")
    private Pieza pieza;
    @ManyToOne
    @JoinColumn(name = "CDProyecto")
    private Proyecto proyecto;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Proveedor getCDProveedor() {
        return proveedor;
    }

    public void setCDProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Pieza getCDPieza() {
        return pieza;
    }

    public void setCDPieza(Pieza pieza) {
        this.pieza = pieza;
    }

    public Proyecto getCDroyecto() {
        return proyecto;
    }

    public void setCDProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
