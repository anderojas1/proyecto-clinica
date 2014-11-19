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
import javax.swing.JOptionPane;
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
    
    public void ejecutarSentenciaUpdate () throws SQLException, NullPointerException {
                          
        conectar = fachadaConectar.conectar();

        sentencia = conectar.createStatement();
        sentencia.executeUpdate(sentenciaSql);

        conectar.close();            
        
    }
    
    public void crearArea(Area area)throws SQLException{
        
        sentenciaSql="INSERT INTO Area VALUES ('"+area.getCodigo()+"', '"+area.getNombre()+"', '"+area.getDescripcion()+"');";
        
        ejecutarSentenciaUpdate();   
    }
    
    public Area consultarArea(String codigo) throws SQLException{
        Area area = new Area();
        
        sentenciaSql = "SELECT * FROM Area WHERE codigo = '"+codigo+"';";
         try{
            conectar= fachadaConectar.conectar();
            
            sentencia = conectar.createStatement();

            registros = sentencia.executeQuery(sentenciaSql);
            
            while(registros.next()){
                
               area.setCodigo(registros.getString(1));
               area.setNombre(registros.getString(2));
               area.setDescripcion(registros.getString(3));

            }
            conectar.close();
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return area;
    }
    
    public void actualizarArea(){
        
    }
    
    public void borrarArea(String codigo)throws SQLException{
        
        sentenciaSql = "DELETE * FROM Area WHERE codigo = '"+codigo+"';";
        ejecutarSentenciaUpdate();
    }
    
}
