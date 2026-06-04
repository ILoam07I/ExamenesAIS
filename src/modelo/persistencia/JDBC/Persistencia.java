
package modelo.persistencia.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Persistencia {
    
    private static String url = "jdbc:mysql://localhost:3306/facturacion?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC";
    private static Connection connection = null;
    
    private static String login = "root";
    private static String password = "";

    public static Connection createConnection() {

        if (connection == null) {
            try {                
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, login, password);
                
            } catch (ClassNotFoundException e) {
                System.out.println(e);      
                
            } catch (SQLException e) {
                System.out.println(e);             
            }
        }
        
        return connection;
    }
    
    public static void closeConnection() {
        
        try {
            if (connection != null) {
                connection.close();
                connection = null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
}
