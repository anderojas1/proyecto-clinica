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
        
        sentenciaSql="INSERT INTO Area VALUES ('"+area.getCodigo()+"', '"+area.getNombre()+"', '"+area.getDescripcion()+""
                + "', " + area.getEstado() + ");";
        
        ejecutarUpdate();
        
    }
    
    public Area consultarArea(String codigo) throws SQLException{
        
        sentenciaSql = "SELECT * FROM Area WHERE codigo = '"+codigo+"';";
        
        while (registros.next()) {

            String nombre = registros.getString(2);
            String descripcion = registros.getString(3);
            boolean estado = registros.getBoolean(4);
            
            Area area = new Area(codigo, descripcion, nombre, estado);
            
            return area;

        }
            
        return null;
        
    }
    
    public void editarArea(Area area)throws SQLException{
        
        sentenciaSql = "UPDATE Area SET nombre = '"+area.getNombre()+"', descripción = '"+area.getDescripcion()+"' WHERE codigo = '"+area.getCodigo()+"';";
        ejecutarUpdate();
    }
    
    public void habilitarArea(String codigo, boolean estado)throws SQLException{
        
        sentenciaSql = "UPDATE Area SET estado = " + estado + " WHERE codigo = '"+ codigo + "';";
        ejecutarUpdate();
        
    }
    
}
