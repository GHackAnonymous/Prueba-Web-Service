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
    
}

    
    
    