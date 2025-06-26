
package RegistroUsuarios;


public class RegistroUsuario {
    private String rut,nombre,apellido,direccion,comuna,mail;
    private int telefono,id;
    
    public RegistroUsuario() {
    }

    
    

    public RegistroUsuario(String rut, String nombre, String apellido, String direccion, String comuna, int telefono, String mail, int id) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.comuna = comuna;
        this.telefono = telefono;
        this.mail=mail;
        this.id=id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    public void InfoUsuario(){
        System.out.println("");
        System.out.println("Rut: "+getRut());
        System.out.println("Nombre: "+getNombre());
        System.out.println("Apellido : "+getApellido());
        System.out.println("Domicilio: "+getDireccion());
        System.out.println("Comuna: "+getComuna());
        System.out.println("Telefono: "+getTelefono());
        System.out.println("Email: "+getMail());
        System.out.println("ID Estudiante"+getId());
        System.out.println("");
    }
}

