/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

/**
 *
 * @author futpilari
 */
public class Querys {
    
    public String ConsultarTablaDatos(){
        String sql = "";
        
        sql = sql + " SELECT ";
        sql = sql + " `tabla_datos`.`id_datos`, `tabla_datos`.`nombre`,";
        sql = sql + " `tabla_datos`.`apellido`,`tabla_datos`.`password`,";
        sql = sql + " `tabla_datos`.`email` FROM `webserviceprueba1`.`tabla_datos`;";
        
        return sql;
    }
    
    public String InsertarUsuarioTablaDatos(String nombre, String apellido, String password, String email){
        String sql = "";
        
        sql = sql + " INSERT INTO `webserviceprueba1`.`tabla_datos` ";
        sql = sql + " (`nombre`,`apellido`,`password`,`email`)";
        sql = sql + " VALUES('"+nombre+"','"+apellido+"','"+password+"','"+email+"');";
        
        return sql;
    }
    
    public String ConsultarUsuario(String nombre, String password){
        String sql = "";
        
        sql = sql + " SELECT ";
        sql = sql + " `tabla_datos`.`nombre`, `tabla_datos`.`password`";
        sql = sql + " FROM `webserviceprueba1`.`tabla_datos`";
        sql = sql + " WHERE nombre = '"+nombre+"' AND";
        sql = sql + " password = '"+password+"';";
        
        return sql;
    }
    
}

    
    
    