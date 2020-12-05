
package library_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class ApClient {
    
    
    private static Connection connector;
    
    static Connection getInstance() throws SQLException,ClassNotFoundException
    {
        if(connector == null)
        {
            Class.forName("com.mysql.jdbc.Driver");
            connector = DriverManager.getConnection("jdbc:mysql://localhost/library_management_system?"+"user=root"); 
        }
        return    connector;
       
    }
    static void close() 
    {
        try {
            connector.close();
        } catch (SQLException ex) {
            Logger.getLogger(ApClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
       
}
