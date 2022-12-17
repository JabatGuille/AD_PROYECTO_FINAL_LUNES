package Conexiones;

import Clases.PiezaEntity;
import Clases.ProveedorEntity;
import Clases.ProyectoEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;

import javax.swing.*;
import java.util.ArrayList;

public class Conexiones {

    public static void insertarPieza(PiezaEntity pieza) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        PiezaEntity piezaModificada;
        pieza.setCodigoPieza(pieza.getCodigoPieza().toUpperCase());
        piezaModificada = recuperarPieza(pieza.getCodigoPieza());
        if (piezaModificada == null) {
            session.save(pieza);
            tx.commit();
            JOptionPane.showMessageDialog(null, "La pieza se ha insertado");
        } else {
            JOptionPane.showMessageDialog(null, "La pieza ya existe", "Error piezas", JOptionPane.ERROR_MESSAGE);
        }
        session.close();

    }

    public static void modificarPieza(PiezaEntity pieza) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        pieza.setCodigoPieza(pieza.getCodigoPieza().toUpperCase());
        PiezaEntity piezaModificada;
        piezaModificada = recuperarPieza(pieza.getCodigoPieza());
        if (piezaModificada != null) {
            piezaModificada.setNombre(pieza.getNombre());
            piezaModificada.setPrecio(pieza.getPrecio());
            piezaModificada.setDescripcion(pieza.getDescripcion());
            session.update(piezaModificada);
            tx.commit();
            JOptionPane.showMessageDialog(null, "La pieza se ha modifica");

        } else {
            JOptionPane.showMessageDialog(null, "La pieza no existe", "Error pieza", JOptionPane.ERROR_MESSAGE);
        }
        session.close();

    }

    public static PiezaEntity recuperarPieza(String cod_pieza) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        PiezaEntity pieza;

        pieza = (PiezaEntity) session.get(PiezaEntity.class, cod_pieza);
        tx.commit();
        session.close();
        return pieza;
    }

    public static void eliminarPieza(String cod_pieza) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        PiezaEntity piezaBorrar;

        piezaBorrar = recuperarPieza(cod_pieza.toUpperCase());

        if (piezaBorrar != null) {
            try {
                session.delete(piezaBorrar);
                tx.commit();
                JOptionPane.showMessageDialog(null, "La pieza se ha eliminado");
            } catch (ConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, "Ha intentado borrar una pieza que tiene relacion con otros objetos", "Error borrar Pieza", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "La pieza no se pudo borrar porque no existe.", "Error pieza", JOptionPane.ERROR_MESSAGE);
        }
        session.close();
    }

    public static void insertarProveedor(ProveedorEntity proveedor) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        ProveedorEntity proveedorModificada;
        proveedor.setCodigoProveedor(proveedor.getCodigoProveedor().toUpperCase());
        proveedorModificada = recuperarProveedor(proveedor.getCodigoProveedor());
        if (proveedorModificada == null) {
            session.save(proveedor);
            tx.commit();
            JOptionPane.showMessageDialog(null, "El proveedor se ha insertado");
        } else {
            JOptionPane.showMessageDialog(null, "El proveedor ya existe", "Error proveedor", JOptionPane.ERROR_MESSAGE);
        }
        session.close();

    }

    public static void modificarProveedor(ProveedorEntity proveedor) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        proveedor.setCodigoProveedor(proveedor.getCodigoProveedor().toUpperCase());
        ProveedorEntity proveedorModificada;
        proveedorModificada = recuperarProveedor(proveedor.getCodigoProveedor());
        if (proveedorModificada != null) {
            proveedorModificada.setNombre(proveedor.getNombre());
            proveedorModificada.setApellido(proveedor.getApellido());
            proveedorModificada.setDireccion(proveedor.getDireccion());
            session.update(proveedorModificada);
            tx.commit();
            JOptionPane.showMessageDialog(null, "El proveedor se ha modificado");

        } else {
            JOptionPane.showMessageDialog(null, "El proveedor no existe", "Error proveedor", JOptionPane.ERROR_MESSAGE);
        }
        session.close();

    }

    public static ProveedorEntity recuperarProveedor(String cod_proveedor) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        ProveedorEntity proveedor;

        proveedor = (ProveedorEntity) session.get(ProveedorEntity.class, cod_proveedor);
        tx.commit();
        session.close();
        return proveedor;
    }

    public static void eliminarProveedor(String cod_proveedor) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        ProveedorEntity proveedorBorrar;

        proveedorBorrar = recuperarProveedor(cod_proveedor.toUpperCase());


        if (proveedorBorrar != null) {
            try {
                session.delete(proveedorBorrar);
                tx.commit();
                JOptionPane.showMessageDialog(null, "El proveedor se ha eliminado");
            } catch (ConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, "Ha intentado borrar un proveedor que tiene relacion con otros objetos", "Error borrar Proveedor", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El proveedor no se pudo borrar porque no exitste.", "Error proveedor", JOptionPane.ERROR_MESSAGE);
        }
        session.close();
    }

    public static void insertarProyecto(ProyectoEntity proyecto) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        ProyectoEntity proyectoModificado;
        proyecto.setCodigoProyecto(proyecto.getCodigoProyecto().toUpperCase());
        proyectoModificado = recuperarProyecto(proyecto.getCodigoProyecto());
        if (proyectoModificado == null) {
            session.save(proyecto);
            tx.commit();
            JOptionPane.showMessageDialog(null, "El proyecto se ha insertado");
        } else {
            JOptionPane.showMessageDialog(null, "El proyecto ya existe", "Error proyecto", JOptionPane.ERROR_MESSAGE);
        }
        session.close();

    }

    public static void modificarProyecto(ProyectoEntity proyecto) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        proyecto.setCodigoProyecto(proyecto.getCodigoProyecto().toUpperCase());
        ProyectoEntity proyectoModificado;
        proyectoModificado = recuperarProyecto(proyecto.getCodigoProyecto());
        if (proyectoModificado != null) {
            proyectoModificado.setNombre(proyecto.getNombre());
            proyectoModificado.setCiudad(proyecto.getCiudad());
            session.update(proyectoModificado);
            tx.commit();
            JOptionPane.showMessageDialog(null, "El proyecto se ha modificado");
        } else {
            JOptionPane.showMessageDialog(null, "El proyecto no existe", "Error proyecto", JOptionPane.ERROR_MESSAGE);
        }
        session.close();

    }

    public static ProyectoEntity recuperarProyecto(String cod_proyecto) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        ProyectoEntity proyecto;

        proyecto = (ProyectoEntity) session.get(ProyectoEntity.class, cod_proyecto);
        tx.commit();
        session.close();
        return proyecto;
    }

    public static void eliminarProyecto(String cod_proyecto) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        ProyectoEntity proyectoBorrar;

        proyectoBorrar = recuperarProyecto(cod_proyecto.toUpperCase());


        if (proyectoBorrar != null) {
            try {
                session.delete(proyectoBorrar);
                tx.commit();
                JOptionPane.showMessageDialog(null, "El proyecto se ha borrado");
            } catch (ConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, "Ha intentado borrar un proyecto que tiene relacion con otros objetos", "Error borrar Proyecto", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El proyecto no se pudo borrar porque no existe.", "Error proyecto", JOptionPane.ERROR_MESSAGE);
        }
        session.close();
    }

    public static ArrayList<ProveedorEntity> listaProveedor() {
        ArrayList<ProveedorEntity> proveedores = new ArrayList<>();
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        for (Object value : session.createSQLQuery("SELECT * FROM proveedor").list()) {
            Object[] lista = (Object[]) value;
            ProveedorEntity p = new ProveedorEntity();
            p.setCodigoProveedor((String) lista[0]);
            p.setNombre((String) lista[1]);
            p.setApellido((String) lista[2]);
            p.setDireccion((String) lista[3]);
            proveedores.add(p);
        }
        tx.commit();
        session.close();
        return proveedores;
    }

    public static ArrayList<PiezaEntity> listaPieza() {
        ArrayList<PiezaEntity> piezas = new ArrayList<>();
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        for (Object value : session.createSQLQuery("SELECT * FROM pieza").list()) {
            Object[] lista = (Object[]) value;
            PiezaEntity p = new PiezaEntity();
            p.setCodigoPieza((String) lista[0]);
            p.setNombre((String) lista[1]);
            p.setPrecio((Double) lista[2]);
            p.setDescripcion((String) lista[3]);
            piezas.add(p);
        }
        tx.commit();
        session.close();
        return piezas;
    }

    public static ArrayList<ProyectoEntity> listaProyecto() {
        ArrayList<ProyectoEntity> proyectos = new ArrayList<>();
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        for (Object value : session.createSQLQuery("SELECT * FROM proyecto").list()) {
            Object[] lista = (Object[]) value;
            ProyectoEntity p = new ProyectoEntity();
            p.setCodigoProyecto((String) lista[0]);
            p.setNombre((String) lista[1]);
            p.setCiudad((String) lista[2]);
            proyectos.add(p);
        }
        tx.commit();
        session.close();
        return proyectos;
    }

    public static ArrayList<ProveedorEntity> listaPosiblesProveedores(String busqueda, String campo) {
        ArrayList<ProveedorEntity> proveedor = new ArrayList<>();
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        busqueda = "'%" + busqueda.toLowerCase() + "%'";
        for (Object value : session.createSQLQuery("SELECT * FROM proveedor  WHERE LOWER(" + campo + ") LIKE " + busqueda + "").list()) {
            Object[] lista = (Object[]) value;
            ProveedorEntity p = new ProveedorEntity();
            p.setCodigoProveedor((String) lista[0]);
            p.setNombre((String) lista[1]);
            p.setApellido((String) lista[2]);
            p.setDireccion((String) lista[3]);
            proveedor.add(p);
        }
        tx.commit();
        session.close();
        return proveedor;
    }

    public static ArrayList<PiezaEntity> listaPosiblesPiezas(String busqueda, String campo) {
        ArrayList<PiezaEntity> pieza = new ArrayList<>();
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        busqueda = "'%" + busqueda.toLowerCase() + "%'";
        for (Object value : session.createSQLQuery("SELECT * FROM pieza WHERE LOWER(" + campo + ") LIKE " + busqueda + "").list()) {
            Object[] lista = (Object[]) value;
            PiezaEntity p = new PiezaEntity();
            p.setCodigoPieza((String) lista[0]);
            p.setNombre((String) lista[1]);
            p.setPrecio((double) lista[2]);
            p.setDescripcion((String) lista[3]);
            pieza.add(p);
        }
        tx.commit();
        session.close();
        return pieza;
    }

    public static ArrayList<ProyectoEntity> listaPosiblesProyectos(String busqueda, String campo) {
        ArrayList<ProyectoEntity> proyectos = new ArrayList<>();
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        busqueda = "'%" + busqueda.toLowerCase() + "%'";
        for (Object value : session.createSQLQuery("SELECT * FROM proyecto  WHERE LOWER(" + campo + ") LIKE " + busqueda + "").list()) {
            Object[] lista = (Object[]) value;
            ProyectoEntity p = new ProyectoEntity();
            p.setCodigoProyecto((String) lista[0]);
            p.setNombre((String) lista[1]);
            p.setCiudad((String) lista[2]);
            proyectos.add(p);
        }
        tx.commit();
        session.close();
        return proyectos;
    }
}
