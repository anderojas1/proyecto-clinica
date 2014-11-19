package dataAccesss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Fachada {
    
    private final String url;
    private final String user;
    private final String password;
    
    private Connection conexion;
    
    
    public Fachada () {
        
        url = "jdbc:postgresql://pgsql:5432/jorgeaer";
        user = "jorgeaer";
        password = "jorgeaer";
        
    }
    
    
    public Connection conectar () throws SQLException, NullPointerException {
                            
        try {
            
            Class.forName("org.postgresql.Driver");        
            conexion = DriverManager.getConnection(url, user, password);
            
        } catch (ClassNotFoundException ex) {
            
            throw new NullPointerException("imposible cargar el driver de conexión a la base de datos");
            
        }

        return conexion;
        
    }
    
    
    public void desconectar (Connection conex) throws SQLException {
        
        conex.close();
         
    }    
    
}