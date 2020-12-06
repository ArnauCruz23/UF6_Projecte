
package cat.copernic.m03uf06review.hibernateMain;

import cat.copernic.m03uf06review.hibernateMain.Registre;
import java.util.List;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * En aquesta secció cal accedir a una taula de MySQL amb un camp de cada tipus:
 *
 * int o long, double o float, boolean, char, String i java.sql.Date
 *
 * Recòrrer el result set i mostrar-lo per la consola com a instancies de la
 * classe Registre, que tindrà l'estructura de la teva taula.
 *
 * Cal usar la llibreria Hibernate.
 *
 *
 * @author pep
 */
public class Main {

    private static SessionFactory factory;

    public static void main(String[] args) {
        
        //insertar("Ramon", new java.sql.Date(2014 - 11 - 5), 46.5, "A");
        //insertar("Juan", new java.sql.Date(2017 - 11 - 5), 70.5, "B");
        
        //editar(1, "Pedro", 50.5);
        
        //borrarPersona(9);
        
        mostrar();
        
    }
    
    public static void iniciar() {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static Integer insertar(String Nombre, Date Fecha_de_nacimiento, Double Peso, String LetraFavorita ){
        
        iniciar();
        Session session = factory.openSession();
        Transaction tx = null;
        Integer idP = null;

        try {
            tx = session.beginTransaction();
            Registre persona = new Registre(Nombre, Fecha_de_nacimiento, Peso, LetraFavorita);
            idP = (Integer) session.save(persona);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            factory.close();
        }
        return idP;
    }
    
    public static void borrarPersona(Integer id) {
        iniciar();
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Registre persona = (Registre) session.get(Registre.class, id);
            session.delete(persona);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
    
    public static void editar(Integer id, String nom, Double Peso) {
        iniciar();
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Registre persona = (Registre) session.get(Registre.class, id);
            persona.setNombre(nom);
            persona.setPeso(Peso);
            session.update(persona);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
    
    public static void mostrar() {
        iniciar();
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List<Registre> persona = session.createQuery("FROM Registre").list();
            for (Iterator iterator = persona.iterator(); iterator.hasNext();) {
                Registre registre = (Registre) iterator.next();
                System.out.println("==========================================");
                System.out.println(
                        registre.getId()
                        +" || "+registre.getNombre()
                        +" || "+registre.getFecha_de_nacimiento()
                        +" || "+registre.getPeso()
                        +" || "+registre.getLetraFavorita()
                );
                
                
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }

}

