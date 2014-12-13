/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dataAccesss;

/**
 *
 * @author Santa Gutierrez
 */
import java.sql.*;
import logica.Area;
public class DaoArea {
    
    private final Fachada fachadaConectar;
    private Connection conectar;
    private Statement sentencia;
    private String sentenciaSql;
    private ResultSet registros;
    
    public DaoArea(){
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
    
    public void crearArea(Area area)throws SQLException{
        
        sentenciaSql="INSERT INTO Area VALUES ('"+area.getCodigo()+"', '"+area.getNombre()+"', '"+area.getDescripcion()+"');";
        
        ejecutarUpdate();
        
    }
    
    public Area consultarArea(String codigo) throws SQLException{
        
        Area area = new Area();
        
        sentenciaSql = "SELECT * FROM Area WHERE codigo = '"+codigo+"';";
        
        while (registros.next()) {

            area.setCodigo(registros.getString(1));
            area.setNombre(registros.getString(2));
            area.setDescripcion(registros.getString(3));

        }
            
        return area;
        
    }
    
    public void actualizarArea(){
        
    }
    
    public void borrarArea(String codigo)throws SQLException{
        
        sentenciaSql = "UPDATE Area SET estado = false WHERE codigo = '"+codigo+"';";
        ejecutarUpdate();
        
    }
    
}
