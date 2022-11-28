package Clases;

import javax.persistence.*;

@Entity
@Table(name = "gestion", schema = "gestionproyectos", catalog = "")
public class GestionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_gestion", nullable = false)
    private int idGestion;
    @Basic
    @Column(name = "CDProveedor", nullable = true, length = 6)
    private String cdProveedor;
    @Basic
    @Column(name = "CDPieza", nullable = true, length = 6)
    private String cdPieza;
    @Basic
    @Column(name = "CDProyecto", nullable = true, length = 6)
    private String cdProyecto;
    @Basic
    @Column(name = "cantidad", nullable = true)
    private Integer cantidad;

    public int getIdGestion() {
        return idGestion;
    }

    public void setIdGestion(int idGestion) {
        this.idGestion = idGestion;
    }

    public String getCdProveedor() {
        return cdProveedor;
    }

    public void setCdProveedor(String cdProveedor) {
        this.cdProveedor = cdProveedor;
    }

    public String getCdPieza() {
        return cdPieza;
    }

    public void setCdPieza(String cdPieza) {
        this.cdPieza = cdPieza;
    }

    public String getCdProyecto() {
        return cdProyecto;
    }

    public void setCdProyecto(String cdProyecto) {
        this.cdProyecto = cdProyecto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
