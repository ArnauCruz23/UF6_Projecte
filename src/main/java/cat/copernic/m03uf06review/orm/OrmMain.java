package cat.copernic.m03uf06review.orm;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import cat.copernic.m03uf06review.orm.Conexion;
import java.sql.SQLException;

/**
 * En aquesta secció cal accedir a una taula de MySQL amb un camp de cada tipus:
 * 
 * int o long, double o float, boolean, char, String i java.sql.Date
 * 
 * Recòrrer el result set i mostrar-lo per la consola com a instancies de la 
 * classe Registre, que tindrà l'estructura de la teva taula.
 * 
 * 
 * @author pep
 */
public class OrmMain {
    
    public static void main(String[] args) throws SQLException {
        List<Registre> t = new ArrayList<>();
        
        Conexion c = new Conexion();
        Connection con = c.conectar();
        
        if (con != null) {
            //System.out.println("Database connection is successful !!!!");
            Statement stmt = con.createStatement();
            String query = "select * from kantaicollec;";
            ResultSet rs = stmt.executeQuery(query);
              
            while (rs.next()) {
                t.add(new Registre(
                        rs.getInt("id"), 
                        rs.getString("NombreChicaBarco"), 
                        rs.getString("Municion"), 
                        rs.getInt("Veocidad")));  
                }
            }
            
        System.out.println(t);
    }
   
    }
    
    

