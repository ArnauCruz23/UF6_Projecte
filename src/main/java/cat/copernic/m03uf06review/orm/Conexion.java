package cat.copernic.m03uf06review.orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Conexion {
    
    public Connection conectar(){
        String MySQLURL = "jdbc:mysql://localhost/javafx";
        String databseUserName = "root";
        String databasePassword = "";
        Connection con = null;
                
        try{
            con = DriverManager.getConnection(MySQLURL, databseUserName, databasePassword);
        }catch (Exception e) {
            e.printStackTrace();
    }
      return con;
    }
    }

