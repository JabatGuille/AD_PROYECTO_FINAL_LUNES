package Conexiones;

import Clases.PiezaEntity;
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
        }else{
            JOptionPane.showMessageDialog(null,"La pieza no existe","Error pieza",JOptionPane.ERROR_MESSAGE);
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
        }else {
            JOptionPane.showMessageDialog(null,"La pieza se pudo borrar porque no existe.","Error pieza",JOptionPane.ERROR_MESSAGE);
        }
        session.close();
    }
}
