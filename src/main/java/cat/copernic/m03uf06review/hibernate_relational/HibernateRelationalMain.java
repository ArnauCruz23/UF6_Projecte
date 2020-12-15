package cat.copernic.m03uf06review.hibernate_relational;

 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import cat.copernic.m03uf06review.hibernate_relational.Barcos;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/**
 * En aquesta secció cal accedir a dues taules de MySQL que formin una relació
 * 
 * One to Many, com per exemple: Departament -> Empleat
 * 
 * Cada departament té molts empleats, i un empleat només treballa en un
 * departament.
 * 
 * Recòrrer la relaciçó i mostrar-la per la consola 
 * 
 * Cal usar la llibreria Hibernate.
 * 
 * @author pep
 */
public class HibernateRelationalMain {
    
    private static SessionFactory factory; 
    
    public static void main(String[] args) {
        
      
      HashSet set1 = new HashSet();
      set1.add(new Barcos_descripcion(null, "Torpedos"));
      set1.add(new Barcos_descripcion(null, "Cargas de profundidad"));
      set1.add(new Barcos_descripcion(null, "Misiles guiados"));
      /*      
      addBarco(null, "Bismark", 4000.5, 4000, set1);
      */
      
      HashSet set2 = new HashSet();
      set2.add(new Barcos_descripcion(null, "Penetrantes"));
      set2.add(new Barcos_descripcion(null, "Antiaereos"));
      
      HashSet set3 = new HashSet();
      set3.add(new Barcos_descripcion(null, "Minas"));
      addBarco(new Barcos(null, "Francesc", 5000.60, 3000), set3);
      listar();
      /*
      addBarco(null, "Hood", 5000.60, 3000, set2);

      listar();
      */
      
      /*set1.add(new Barcos_descripcion(null, "Minas"));
      update(new Barcos(7, "Bismark SS", 5000.0, 5000), set1);
      listar();*/
      
      
      
      
      /*
      borrar(8);
      listar();
      */
   }
    
   public static void iniciar() {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
   
   public static Integer addBarco(Barcos barco, Set mun){
       
      iniciar();
      Session session = factory.openSession();
      Transaction tx = null;
      Integer BarcoID = null;
      
      try {
         tx = session.beginTransaction();
         Barcos b = barco;
         b.setBarcosD(mun);
         BarcoID = (Integer) session.save(b); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         factory.close(); 
      }
      return BarcoID;
   }

   public static void listar(){
      iniciar();
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         List barquitos = session.createQuery("FROM Barcos").list(); 
         for (Iterator iterator1 = barquitos.iterator(); iterator1.hasNext();){
            System.out.println("===========================================================");
            Barcos barco = (Barcos) iterator1.next();
            System.out.print("Nombre: " + barco.getNombre()); 
            System.out.print("  Peso: " + barco.getPeso()); 
            System.out.println("  Numero de Armas: " + barco.getnArmas());
            System.out.println("===========================================================");
            Set barcosD = barco.getBarcosD();
            for (Iterator iterator2 = barcosD.iterator(); iterator2.hasNext();){
               Barcos_descripcion BarcosD = (Barcos_descripcion) iterator2.next(); 
               System.out.println("Municion: " + BarcosD.getCarga()); 
               System.out.println("--------------------------------------");
            }
            
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         factory.close(); 
      }
   }
   
   
   public static void update(Barcos barco, Set mun){
      iniciar();
      Session session = factory.openSession();
      Transaction tx = null;
      try {
         tx = session.beginTransaction();
         barco.setBarcosD(mun);
         session.update(barco);
         
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         factory.close(); 
      }
   }
   
   
    
   public static void borrar(Integer id){
      iniciar();
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Barcos barco = (Barcos)session.get(Barcos.class, id); 
         session.delete(barco); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         factory.close();  
      }
   }
   
    
}
