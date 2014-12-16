/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccesss;
import java.sql.*;
import java.util.ArrayList;
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
                + causa.getDescripcion()+ "', true);";
        
        ejecutarUpdate();
        
    }
        
    public void estadoCausa (String codigo, boolean estado) throws SQLException {
        
        sentenciaSql = "UPDATE Causa SET estado = " + estado + " WHERE codigo = '" + codigo + "';";
        
        ejecutarUpdate();
        
    }
    
    public Causa consultarCausa (String codigo) throws SQLException {
        
        Causa causa = new Causa("","","");
        
        sentenciaSql = "SELECT * FROM Causa WHERE codigo = '" + codigo + "';";
        
        ejecutarConsulta();
        
        while (registros.next()) {
            
            causa.setCodigo(registros.getString(1));
            causa.setNombre(registros.getString(2));
            causa.setDescripcion(registros.getString(3));
        }

        return causa;
                
    }
    
            public void editarCausa(Causa causa)throws SQLException{
        
        sentenciaSql = "UPDATE Causa SET nombre = '"+causa.getNombre()+"', descripcion = '"+causa.getDescripcion()+"' WHERE codigo = '"+causa.getCodigo()+"';";
        ejecutarUpdate();
    }
            
    public ArrayList<String[]> consultarCausasRegistradas () throws SQLException {
        
        sentenciaSql = "SELECT codigo, nombre FROM Causa;";
        ejecutarConsulta();
        
        ArrayList<String[]> causas = new ArrayList<>();
        
        while (registros.next()) {
            
            String codigo = registros.getString(1);
            String nombre = registros.getString(2);
            
            String[] datos = {codigo, nombre};
            
            causas.add(datos);
            
        }
        
        return causas;
    }
}
