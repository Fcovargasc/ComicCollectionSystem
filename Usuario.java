
package RegistroUsuarios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
//HASHMAP

public class Usuario {

    // Usamos el id como clave y el RegistroUsuario como valor
    private HashMap<Integer, RegistroUsuario> lista = new HashMap<>();

    public void agregarUsuario(RegistroUsuario registrousuario) {
        lista.put(registrousuario.getId(), registrousuario);
    }

    public RegistroUsuario buscarCliente(int id) {
        return lista.get(id); // Devuelve el usuario o null si no existe
    }

    public void mostrarClientes(int id) {
        RegistroUsuario registrousuario = lista.get(id);
        if (registrousuario != null) {
            System.out.println("Datos del Usuario:");
            registrousuario.InfoUsuario();
        } else {
            System.out.println("Usuario no encontrado");
        }
    }

    public boolean usuarioExiste(int id) {
        return lista.containsKey(id);
    }
    
    public void guardarUsuariosTXT(String nombreArchivo){
        try(FileWriter fw = new FileWriter(nombreArchivo,false)){
            for (RegistroUsuario usuario : lista.values()) {
                fw.write(usuario.getRut()+","+usuario.getNombre()+","+usuario.getApellido()+","+usuario.getDireccion()+","+usuario.getComuna()+","
                        +usuario.getTelefono()+","+ usuario.getMail()+","+usuario.getId()+"\n");
                
            }
        }catch(IOException e){
            System.out.println("Error al guardar los usuarios: "+ e.getMessage());
        }
    }
    
    public void cargarUsuariosTXT(String nombreArchivo){
        try(BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))){
            String linea;
            while((linea = br.readLine())!=null){
            String[] datos = linea.split(",");
            String rut = datos[0];
            String nombre = datos[1];
            String apellido = datos[2];
            String direccion = datos[3];
            String comuna = datos[4];
            int telefono = Integer.parseInt(datos[5]);
            String mail = datos[6];
            int id = Integer.parseInt(datos[7]);
            RegistroUsuario regUsuario = new RegistroUsuario(rut,nombre,apellido,direccion,comuna,telefono,mail,id);
            this.agregarUsuario(regUsuario);
            
            }
        }catch(IOException e){
            System.out.println("Error al cargar los usuarios"+e.getMessage());
        }
    }
}

