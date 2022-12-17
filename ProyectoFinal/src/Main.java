import Vistas.Ayuda;
import Vistas.PantallaPrincipal;
import Vistas.Proveedores.Gestion.Proveedor;
import Vistas.Proyectos.Gestion.BusquedaCiudad;
import Vistas.Proyectos.Gestion.BusquedaCodigo;
import Vistas.Proyectos.Gestion.BusquedaNombre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Session sesion = getCurrentSessionFromConfig();

        menuPrincipal();
    }

    public static void menuPrincipal() {
        JMenuBar jmenuBar = new JMenuBar();
        //Proveedor

        JMenu MenuProveedor = new JMenu("Proveedores");
        JMenuItem jItemProveedorGestion = new JMenuItem("Gestión de Proveedores");
        JMenu MenuProveedorConsuta = new JMenu("Consulta de Proveedores");
        JMenuItem jItemProveedorGestionCodigo = new JMenuItem("Código");
        JMenuItem jItemProveedorGestionNombre = new JMenuItem("Nombre");
        JMenuItem jItemProveedorGestionDireccion = new JMenuItem("Dirección");

        MenuProveedor.add(jItemProveedorGestion);
        MenuProveedor.add(MenuProveedorConsuta);
        MenuProveedorConsuta.add(jItemProveedorGestionCodigo);
        MenuProveedorConsuta.add(jItemProveedorGestionNombre);
        MenuProveedorConsuta.add(jItemProveedorGestionDireccion);
        jmenuBar.add(MenuProveedor);

        jItemProveedorGestion.addActionListener(e -> {
            JFrame frame = new JFrame("Gestion Proveedor");
            frame.setContentPane(new Proveedor().panel_main);
            frame.pack();
            frame.setSize(600, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
        jItemProveedorGestionCodigo.addActionListener(e -> {
            JFrame frame = new JFrame("Busqueda Proveedor Codigo");
            frame.setContentPane(new Vistas.Proveedores.Gestion.BusquedaCodigo().panel_main);
            frame.pack();
            frame.setSize(600, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
        jItemProveedorGestionNombre.addActionListener(e -> {
            JFrame frame = new JFrame("Busqueda Proveedor Nombre");
            frame.setContentPane(new Vistas.Proveedores.Gestion.BusquedaNombre().panel_main);
            frame.pack();
            frame.setSize(600, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
        jItemProveedorGestionDireccion.addActionListener(e -> {
            JFrame frame = new JFrame("Busqueda Proveedor Direccion");
            frame.setContentPane(new Vistas.Proveedores.Gestion.BusquedaDireccion().panel_main);
            frame.pack();
            frame.setSize(600, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });

        //Pieza

        JMenu MenuPieza = new JMenu("Piezas");
        JMenuItem ItemPiezaGestion = new JMenuItem("Gestión de Piezas");
        JMenu MenuPiezaConsuta = new JMenu("Consulta de Piezas");
        JMenuItem ItemPiezaGestionCodigo = new JMenuItem("Código");
        JMenuItem ItemPiezaGestionNombre = new JMenuItem("Nombre");

        MenuPieza.add(ItemPiezaGestion);
        MenuPieza.add(MenuPiezaConsuta);
        MenuPiezaConsuta.add(ItemPiezaGestionCodigo);
        MenuPiezaConsuta.add(ItemPiezaGestionNombre);
        jmenuBar.add(MenuPieza);

        ItemPiezaGestion.addActionListener(e -> {
            JFrame frame = new JFrame("Gestion Piezas");
            frame.setContentPane(new Vistas.Piezas.Gestion.Pieza().panel_main);
            frame.pack();
            frame.setSize(600, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
        ItemPiezaGestionCodigo.addActionListener(e -> {
            JFrame frame = new JFrame("Piezas Buscar Codigo");
            frame.setContentPane(new Vistas.Piezas.Gestion.BusquedaCodigo().panel_main);
            frame.pack();
            frame.setSize(600, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
        ItemPiezaGestionNombre.addActionListener(e -> {
            JFrame frame = new JFrame("Piezas Buscar Nombre");
            frame.setContentPane(new Vistas.Piezas.Gestion.BusquedaNombre().panel_main);
            frame.pack();
            frame.setSize(600, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });

        //Proyecto

        JMenu jMenuProyecto = new JMenu("Proyectos");
        JMenuItem jItemProyectoGestion = new JMenuItem("Gestión de Proyectos");
        JMenu jMenuProyectoConsuta = new JMenu("Consulta de Proyectos");
        JMenuItem jItemProyectoGestionCodigo = new JMenuItem("Código");
        JMenuItem jItemProyectoGestionNombre = new JMenuItem("Nombre");
        JMenuItem jItemProyectoGestionCiudad = new JMenuItem("Ciudad");

        jMenuProyecto.add(jItemProyectoGestion);
        jMenuProyecto.add(jMenuProyectoConsuta);
        jMenuProyectoConsuta.add(jItemProyectoGestionCodigo);
        jMenuProyectoConsuta.add(jItemProyectoGestionNombre);
        jMenuProyectoConsuta.add(jItemProyectoGestionCiudad);
        jmenuBar.add(jMenuProyecto);

        jItemProyectoGestion.addActionListener(e -> {
            JFrame frame = new JFrame("Gestion Proyecto");
            frame.setContentPane(new Vistas.Proyectos.Gestion.Proyecto().panel_main);
            frame.pack();
            frame.setSize(600, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
        jItemProyectoGestionCodigo.addActionListener(e -> {
            JFrame frame = new JFrame("Proyectos Buscar Codigo");
            frame.setContentPane(new BusquedaCodigo().panel_main);
            frame.pack();
            frame.setSize(600, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
        jItemProyectoGestionNombre.addActionListener(e -> {
            JFrame frame = new JFrame("Proyectos Buscar Nombre");
            frame.setContentPane(new BusquedaNombre().panel_main);
            frame.pack();
            frame.setSize(600, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
        jItemProyectoGestionCiudad.addActionListener(e -> {
            JFrame frame = new JFrame("Proyectos Buscar Ciudad");
            frame.setContentPane(new BusquedaCiudad().panel_main);
            frame.pack();
            frame.setSize(600, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });

        //Gestion Global

        JMenu jMenuGestionGlobal = new JMenu("Gestion Global");
        jmenuBar.add(jMenuGestionGlobal);

        //Ayuda

        JMenuItem jItemAyuda = new JMenuItem("Ayuda");
        jmenuBar.add(jItemAyuda);

        jItemAyuda.addActionListener(e -> {
            JFrame frame = new JFrame("Ayuda");
            frame.setContentPane(new Ayuda().panel_main);
            frame.pack();
            frame.setSize(600, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });

        JFrame frame = new JFrame("MENU");
        frame.setJMenuBar(jmenuBar);
        frame.setContentPane(new PantallaPrincipal().panel_main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static Session getCurrentSessionFromConfig() {
        // SessionFactory in Hibernate 5 example
        Configuration config = new Configuration();
        config.configure();
        // local SessionFactory bean created
        SessionFactory sessionFactory = config.buildSessionFactory();
        return sessionFactory.getCurrentSession();
    }
}