
package ejjdbcjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author https://github.com/arkadoel
 */
public class GestorDB {
    private static Connection _conn = null;
    public static String RutaDB="data/pygenda.db";
    public static String LoginName="";
    public static String Password="";
    
    public static Connection getConnection(){
        
        if(_conn!=null){
            finalizarConexion();
        }
        
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            _conn= (Connection) DriverManager.getConnection("jdbc:sqlite:" + RutaDB, LoginName, Password);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return _conn;
    }
    
    public static void finalizarConexion(){
        if(_conn !=null){
            try {
                try{
                    _conn.commit();
                }catch(Exception ex){}
                
                _conn.close();
            } catch (SQLException ex) {
               ex.printStackTrace();
            }
        }
    }
    
    public static ResultSet Consulta(String _sql){
        Connection con = GestorDB.getConnection();
        ResultSet rs= null;
        try{
            Statement stmt = (Statement) con.createStatement();
            rs=stmt.executeQuery(_sql);
            /*while(rs.next()) {
                //System.out.println(rs.getString(?login?)+?\t?+rs.getString(?password?));
            }*/
        }catch(Exception ex){
            
        }
        return rs;
    }
    
    public static int Ejecutar(String _sql){
        int respuesta=-1;
        
        try{
            Connection con = GestorDB.getConnection();
            Statement stmt = (Statement) con.createStatement();
            respuesta = stmt.executeUpdate(_sql);
            
            //si esta en auto-commit la siguiente linea dara error
            con.commit();
        }catch(Exception ex){
            
        }
        finally{
            finalizarConexion();
        }
        
        return respuesta;
    }
}
