package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {
    
    private Statement statment = null;
    private Connection conexion = null; 
    
    private String usuario = "root";
    private String clave = "Siteco"; //Pon el usuario y el password de tu base de datos
    
    public Statement Conectar(){
        
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, "INSTACE", ex);
            } catch (IllegalAccessException ex) {Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, "Ilegal Access", ex);
            }
            if(!clave.equalsIgnoreCase("")){
                conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/webserviceprueba1", usuario,clave); 
                statment = conexion.createStatement();

                return statment;
            }else{
                //esta excepcion es simplemente cecordatorio para no 
                //olbidar poner la clave de la base de datos
                NoClaveException s;
                throw s = new NoClaveException();
            }
        } catch (NoClaveException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE,"No hay clave en el metodo de conetar "
                    + "escribe la clave donde se inicializa", ex);
            
            return null;
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE,"No se pudo cargar el driver de la base de datos", ex);
            
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE,"No se pudo obtener la conexión a la base de datos", ex);
            
            return null;
        } 
    }
    
    public ResultSet consultarTabla(Statement conexion, String strSql) throws SQLException{
    
        ResultSet resultado = null;
        
        synchronized(conexion){
            resultado = conexion.executeQuery(strSql);
        }
        return resultado;
    }
}