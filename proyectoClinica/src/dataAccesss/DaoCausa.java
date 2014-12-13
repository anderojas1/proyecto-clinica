/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccesss;
import java.sql.*;
import logica.Causa;

    
    
/**
 *
 * @author Mariano
 */
public class DaoCausa {
    private Fachada fachadaConectar;
    private Connection conectar;
    private Statement sentencia;
    private String sentenciaSql;
    private ResultSet registros;
    
     public DaoCausa(){
        fachadaConectar = new Fachada();
    }
    
    public void ejecutarUpdate () throws SQLException, NullPointerException {
                          
        conectar = fachadaConectar.conectar();

        sentencia = conectar.createStatement();
        sentencia.executeUpdate(sentenciaSql);

        conectar.close();            
        
    }
    
    
    public void ejecutarConsulta () throws SQLException {
        
        conectar = fachadaConectar.conectar();
        sentencia = conectar.createStatement();
        
        registros = sentencia.executeQuery(sentenciaSql);
        
        conectar.close();
        
    }
    
    public void registrarCausa (Causa causa) throws SQLException {
        
        sentenciaSql = "INSERT INTO Causa VALUES ('" + causa.getCodigo() + "','" + causa.getNombre() + "','"
                + causa.getDescripcion()+ "'," + "true" + ");";
        
        ejecutarUpdate();
        
    }
        
    public void eliminarCausa (String codigo) throws SQLException {
        
        sentenciaSql = "UPDATE Causa SET estado = " + false + " WHERE codigo = '" + codigo + "';";
        
        ejecutarUpdate();
        
    }
    
    public Causa consultarCausa (String codigo) throws SQLException {
        
        Causa causa = new Causa("","","");
        
        sentenciaSql = "SELECT * FROM Causa WHERE codigo = '" + codigo + "';";
        
        while (registros.next()) {
            
            causa.setCodigo(registros.getString(1));
            causa.setNombre(registros.getString(2));
            causa.setDescripcion(registros.getString(3));
        }
        
        return causa;
                
    }
}
