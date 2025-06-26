
package RegistroUsuarios;

import java.util.HashSet;
//HASHMAP

public class Usuario {
    private HashSet <RegistroUsuario>lista= new HashSet<>();
    public void agregarUsuario(RegistroUsuario registrousuario){
        lista.add(registrousuario);
    }
    public RegistroUsuario buscarCliente(int id){
        for (RegistroUsuario registrousuario : lista) {
            if (registrousuario.getId()==id) {
                return registrousuario;
            }
        }
        return null;
    }
    
    public void mostrarCLientes(int id){
        for (RegistroUsuario registrousuario:lista) {
            if(registrousuario.getId()==id){
                System.out.println("datos del Usuario");
                registrousuario.InfoUsuario();
                return;
            }
        }
        System.out.println("usuario no encontrado");
    }
    
    public boolean usuarioExiste(int id){
        for (RegistroUsuario registrousuario : lista) {
            if (registrousuario.getId()==id) {
                return true;
            }
        }
        return false;
    }
    
}

