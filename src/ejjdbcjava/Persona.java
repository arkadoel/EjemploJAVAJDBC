package ejjdbcjava;

/**
 *
 * @author https://github.com/arkadoel
 */
public class Persona {
    private String id;
    private String Nombre;
    private String Apellidos;
    private String Fijo;
    private String Movil;
    private String Email;

    public Persona() {
        id="";
        Nombre="";
        Apellidos="";
        Fijo="";
        Movil="";
        Email="";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getFijo() {
        return Fijo;
    }

    public void setFijo(String Fijo) {
        this.Fijo = Fijo;
    }

    public String getMovil() {
        return Movil;
    }

    public void setMovil(String Movil) {
        this.Movil = Movil;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    
}
