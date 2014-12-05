/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejjdbcjava;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author https://github.com/arkadoel
 */
public class tbPersonas {
    
    private static String INSERT ="insert into Persona " + 
                                "(Nombre, Apellidos, Fijo, Movil, Email) " +
                                "values ('@Nombre', '@Apellidos', '@Fijo', '@Movil', '@Email');";
    
    private static String DELETE = "delete from persona where id = @Id;";
    
    private static String UPDATE ="update Persona set "+
                                    "Nombre = '@Nombre', "+
                                    "Apellidos='@Apellidos', "+
                                    "Fijo='@Fijo', "+
                                    "Movil='@Movil', "+
                                    "Email='@Email' where id = @Id;";
    
    private static String SELECT = "select * from persona;";
    
    public static int Add(Persona _conf)
    {
        String sql = mapeoSQL(INSERT, _conf);
        int resultado = GestorDB.Ejecutar(sql);
        return resultado;
    }

    public static int Delete(Persona _conf)
    {
        String sql = mapeoSQL(DELETE, _conf);
        int resultado = GestorDB.Ejecutar(sql);
        return resultado;
    }

    public static int Update(Persona _conf)
    {
        String sql = mapeoSQL(UPDATE, _conf);
        int resultado = GestorDB.Ejecutar(sql);
        return resultado;
    }

    private static String mapeoSQL(String _sql, Persona _conf)
    {
        String s = _sql;
        s = s.replaceAll("@Id", _conf.getId());
        s = s.replaceAll("@Nombre", _conf.getNombre());
        s = s.replaceAll("@Apellidos", _conf.getApellidos());
        s = s.replaceAll("@Email", _conf.getEmail());
        s = s.replaceAll("@Fijo", _conf.getFijo());
        s = s.replaceAll("@Movil", _conf.getMovil());

        System.out.println(s);
        return s;
    }
    
    
    
    public static ArrayList<Persona> toArrayList(){
        ArrayList<Persona> lista = new ArrayList<>();
        ResultSet rs = GestorDB.Consulta(SELECT);
        Persona g =null;
        
        try
        {
            while(rs.next()){
                    g = new Persona();
                    g.setId( String.valueOf( rs.getInt("id") ));
                    g.setNombre( rs.getString("Nombre"));
                    g.setApellidos( rs.getString("Apellidos"));
                    g.setEmail( rs.getString("Email"));
                    g.setFijo( rs.getString("Fijo"));
                    g.setMovil( rs.getString("Movil"));

                    lista.add(g);
            }
        }catch(Exception ex){
                    ex.printStackTrace();
        }
        finally{
            GestorDB.finalizarConexion();
        }
        return lista;               
    }
	
    public static Persona getPersonaByName(String nombre){
        String sql = SELECT.replace(";", " where Nombre='" + nombre + "'");
        ResultSet rs = GestorDB.Consulta(sql);
        Persona g =null;
        
        try
        {
            if(rs.next()){
                    g = new Persona();
                    g.setId( String.valueOf( rs.getInt("id") ));
                    g.setNombre( rs.getString("Nombre"));
                    g.setApellidos( rs.getString("Apellidos"));
                    g.setEmail( rs.getString("Email"));
                    g.setFijo( rs.getString("Fijo"));
                    g.setMovil( rs.getString("Movil"));
            }
        }catch(Exception ex){
                    ex.printStackTrace();
                    return null;
        }
        finally{
            GestorDB.finalizarConexion();
        }
        return g;            
    }
		
		
}
