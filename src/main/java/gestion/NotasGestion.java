/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.Estudiante;
import modelo.Notas;

/**
 *
 * @author jdavi
 */
public class NotasGestion {
 
    
    //INSERTAR    

   private static final String SQL_INSERT_NOTA="insert into notas (idEstudiante, idMateria, idPeriodo, nota) values(?,?,?,?)";
   
      
 

    public NotasGestion() {
    }
public static boolean insertar(Notas notas) {

        try {

            PreparedStatement sentencia = Conexion.getConexion().prepareCall(SQL_INSERT_NOTA);
            sentencia.setString(1, notas.getIdEstudiante());
            sentencia.setString(2, notas.getIdMateria());
            sentencia.setString(3, notas.getIdPeriodo());
            sentencia.setDouble(4, notas.getNota());
            return sentencia.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(NotasGestion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
   
     
   
   //LISTADO NOTAS
   
     
   
   private static final String SQL_SELECT_NOTAS="Select * from notas";
    
    
    public static ArrayList<Notas> getNotas(){
        
        ArrayList<Notas> lista= new ArrayList<>();
        
        try {
            
            PreparedStatement consulta= Conexion.getConexion().prepareStatement(SQL_SELECT_NOTAS);
            ResultSet rs= consulta.executeQuery();
            while (rs!=null && rs.next()){
                lista.add(new Notas(
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4), 
                        rs.getDouble(5)));
                      
            }

        } catch (SQLException ex) {
            Logger.getLogger(EstudianteGestion.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return lista;     
    }
   
    
    //BORRAR NOTAS
    
   
   
     private static final String SQL_DELETE_NOTAS= "delete from notas where idEstudiante=?";
    
    public static boolean eliminar (Notas notas){
        
        try {
            PreparedStatement consulta= Conexion.getConexion().prepareStatement(SQL_DELETE_NOTAS);
            consulta.setString(1, notas.getIdEstudiante());
            return consulta.executeUpdate()>0;
            //false
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
        
    }
   
    
    //CONSULTAR NOTAS
    
       private static final String SQL_SELECT_ESTUDIANTE= "select * from notas where idEstudiante=?";
    
    
    public static Notas getNotas(String idEstudiante){
        
        Notas notas=null;
        
        try {
            
            
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_ESTUDIANTE);
            consulta.setString(1, idEstudiante);
            ResultSet datos= consulta.executeQuery();
         
            if (datos.next()){
                notas= new Notas(
                datos.getString(2), datos.getString(3),datos.getString(4),datos.getDouble(5));
                  
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return notas;
        
    
      
}
    
     private static final String SQL_UPDATE_NOTAS= "update notas set idMateria=?,idPeriodo=?,"
            + "nota=? where idEstudiante=?";
    
    public static boolean actualiza (Notas notas){
        
        
        try {
            PreparedStatement sentencia= Conexion.getConexion().prepareCall(SQL_UPDATE_NOTAS);
            sentencia.setString(1, notas.getIdMateria());
            sentencia.setString(2, notas.getIdPeriodo());
            sentencia.setDouble(3, notas.getNota());
     
            return sentencia.executeUpdate()>0;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    
    
  }  
}