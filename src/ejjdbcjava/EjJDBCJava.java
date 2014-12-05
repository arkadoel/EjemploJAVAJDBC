package ejjdbcjava;

import java.util.ArrayList;

/**
 * 
 * @author fer
 */
public class EjJDBCJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Leer tabla personas");
        try{
            verPersonas();
            
            //prueba insercion
            Persona p = new Persona();
            p.setNombre("Pacor");
            p.setApellidos("Gonca");
            p.setEmail("pacogonca@gmail.com");
            
            Persona pBuscado = tbPersonas.getPersonaByName("Pacor");
            
            if(pBuscado != null){
                tbPersonas.Delete(pBuscado);
                System.out.println("Eliminada persona");
            }
            
            System.out.println("Agregada persona");
            tbPersonas.Add(p);
            verPersonas();
            
            pBuscado = tbPersonas.getPersonaByName("Pacor");
            pBuscado.setApellidos("Goncarrio");
            tbPersonas.Update(pBuscado);
            verPersonas();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static void verPersonas(){
        ArrayList<Persona> lista = tbPersonas.toArrayList();
        System.out.println("nº personas: " + lista.size());

        for(Persona p : tbPersonas.toArrayList()){
            System.out.println("\t" + p.getNombre() + " " + p.getApellidos());
        }
    }
    
}
