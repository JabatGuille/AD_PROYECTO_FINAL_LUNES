package Conexiones;

import Clases.PiezaEntity;
import Clases.ProveedorEntity;
import Clases.ProyectoEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.swing.*;

public class Conexiones {

    public static void insertarPieza(PiezaEntity pieza) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(pieza);
        tx.commit();
        session.close();

    }

    public static void modificarPieza(PiezaEntity pieza) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        PiezaEntity piezaModificada;
        piezaModificada = recuperarPieza(pieza.getCodigoPieza());
        if (piezaModificada != null) {
            piezaModificada.setNombre(pieza.getNombre());
            piezaModificada.setPrecio(pieza.getPrecio());
            piezaModificada.setDescripcion(pieza.getDescripcion());
            session.update(piezaModificada);
            tx.commit();
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

        piezaBorrar = recuperarPieza(cod_pieza);


        if (piezaBorrar != null) {
            session.delete(piezaBorrar);
            tx.commit();
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
        session.save(proveedor);
        tx.commit();
        session.close();

    }

    public static void modificarProveedor(ProveedorEntity proveedor) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        ProveedorEntity proveedorModificada;
        proveedorModificada = recuperarProveedor(proveedor.getCodigoProveedor());
        if (proveedorModificada != null) {
            proveedorModificada.setNombre(proveedor.getNombre());
            proveedorModificada.setApellido(proveedor.getApellido());
            proveedorModificada.setDireccion(proveedor.getDireccion());
            session.update(proveedorModificada);
            tx.commit();
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

        proveedorBorrar = recuperarProveedor(cod_proveedor);


        if (proveedorBorrar != null) {
            session.delete(proveedorBorrar);
            tx.commit();
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
        session.save(proyecto);
        tx.commit();
        session.close();

    }

    public static void modificarProyecto(ProyectoEntity proyecto) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        ProyectoEntity proyectoModificado;
        proyectoModificado = recuperarProyecto(proyecto.getCodigoProyecto());
        if (proyectoModificado != null) {
            proyectoModificado.setNombre(proyecto.getNombre());
            proyectoModificado.setCiudad(proyecto.getCiudad());
            session.update(proyectoModificado);
            tx.commit();
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

        proyectoBorrar = recuperarProyecto(cod_proyecto);


        if (proyectoBorrar != null) {
            session.delete(proyectoBorrar);
            tx.commit();
        } else {
            JOptionPane.showMessageDialog(null, "El proyecto no se pudo borrar porque no existe.", "Error proyecto", JOptionPane.ERROR_MESSAGE);
        }
        session.close();
    }



}
