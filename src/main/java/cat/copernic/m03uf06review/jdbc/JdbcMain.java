package cat.copernic.m03uf06review.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * En aquesta secció cal accedir a una taula de MySQL amb un camp de cada tipus:
 * 
 * int o long, double o float, boolean, char, String i java.sql.Date
 * 
 * Recòrrer el result set i mostrar-lo per la consola.
 * 
 * 
 * @author pep
 */
public class JdbcMain {
    public static void main(String[] args) {
        String MySQLURL = "jdbc:mysql://localhost/javafx";
        String databseUserName = "root";
        String databasePassword = "";
        Connection con = null;
        try {
            con = DriverManager.getConnection(MySQLURL, databseUserName, databasePassword);
            if (con != null) {
                //System.out.println("Database connection is successful !!!!");
                Statement stmt = con.createStatement();
                String query = "select * from kantaicollec;";
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    System.out.println(
                    rs.getInt("id") 
                    +"||"+ rs.getString("NombreChicaBarco")
                    +"||"+ rs.getString("Municion")
                    +"||"+ rs.getInt("Veocidad"));


            }
        }
    }
    catch (Exception e
        ) {
            e.printStackTrace();
    }
    }
    
}
