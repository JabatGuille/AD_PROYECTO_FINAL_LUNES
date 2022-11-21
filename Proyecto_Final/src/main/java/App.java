// Java Program to Illustrate App File

import Clases.Gestion;
import Clases.Pieza;
import Clases.Proveedor;
import Clases.Proyecto;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// Main class
public class App {

    // Main driver method
    public static void main(String[] args) {

        // Create Configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Pieza.class);
        configuration.addAnnotatedClass(Proveedor.class);
        configuration.addAnnotatedClass(Proyecto.class);
        configuration.addAnnotatedClass(Gestion.class);

        // Create Session Factory
        SessionFactory sessionFactory
                = configuration.buildSessionFactory();
    }
}
