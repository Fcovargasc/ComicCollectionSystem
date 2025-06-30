/*
provar y limpiar codigo para darle mas seguridad
 */
package ComicCollectorSystem;

import Exceptions.EstudianteNoEncontradoException;
import REgistroComic.Comic;
import REgistroComic.RegistroComic;
import RegistroUsuarios.RegistroUsuario;
import RegistroUsuarios.Usuario;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ComicCollectorSystem {

    
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        
        int opcion = 0,opcion2=0, id=0,telefono,codigoComic = 0;
        String rut,nombre,apellido,direccion,comuna,autor,titulo,mail;
        boolean continuar=true;
        
        Usuario usuarios =new Usuario();
        Usuario reUsuario = new Usuario();
        Comic reComic = new Comic();
        Comic comics = new Comic();
        reUsuario.cargarUsuariosTXT("usuarios.txt");
       do {
            
                System.out.println("Bienvenidos A la Biblioteca");
               
                System.out.println("");
                System.out.println("Presione");
                System.out.println("1 Para registrar Usuario nuevo");
                System.out.println("2 Para ver Datos del usuario");
                System.out.println("3 para Registrar un libro");
                System.out.println("4 para ver disponibilidad de un Libro");
                System.out.println("5 para salir");
               
                String input = scanner.nextLine();
                
             try {   
                opcion=Integer.parseInt(input);
                
                switch (opcion) {
                    
                    
                    case 1:
                        System.out.println("Registro de Usuario");
                        do{
                        System.out.println("Ingrese su rut con punto y guion");
                        rut = scanner.nextLine();
                        }while(rut.length()>12||rut.length()<11);
                        System.out.println("Ingrese su nombre");
                        nombre = scanner.nextLine();
                        System.out.println("Ingrese su Apellido");
                        apellido = scanner.nextLine();
                        System.out.println("Ingrese su Direccion");
                        direccion = scanner.nextLine();
                        System.out.println("Ingrese su Comuna");
                        comuna = scanner.nextLine();
                        try {
                            System.out.println("Ingrese su telefono");
                            telefono = scanner.nextInt();
                            scanner.nextLine(); 
                        } catch (InputMismatchException e) {
                            System.out.println("Error: digite números");
                            scanner.nextLine();
                            break;
                        }
                        System.out.println("Ingrese su Email");
                        mail=scanner.nextLine();
                        do{
                        System.out.println("Ingrese su id de Usuario de 5 digitos");
                        id = scanner.nextInt();
                        }while(id<10000 || id >99999);
                        scanner.nextLine(); 

                        RegistroUsuario registrousuario = new RegistroUsuario(rut, nombre, apellido, direccion, comuna, telefono,mail, id);
                        reUsuario.agregarUsuario(registrousuario);
                        usuarios.agregarUsuario(registrousuario);
                        usuarios.guardarUsuariosTXT("usuarios.txt");
                        System.out.println("Usuario Creado con Exito");
                        break;

                    case 2:
                        System.out.println("Datos Del Usuario");
                       
                        
                       
                         try {
                                 System.out.println("Ingrese su Id de Usuario");
                                 id = scanner.nextInt();
                                 scanner.nextLine(); 
                                 
                            if (!reUsuario.usuarioExiste(id)) { 
                                throw new EstudianteNoEncontradoException("El Usuario con el código " + id + " no fue encontrado.");
                        }
                            reUsuario.mostrarClientes(id);
                            //reUsuario.mostrarClientes(id);
                        } catch (EstudianteNoEncontradoException e) {
                            System.out.println(e.getMessage());
                            break;
                        }catch(InputMismatchException e){
                            System.out.println("Poner Numeros ");
                            scanner.nextLine();
                            break;
                        }
                         break;
                    case 3:
                        System.out.println("Registro de Comics");
                      
                        System.out.println("Ingrese autor");
                        autor = scanner.nextLine();
                        System.out.println("Ingrese Titulo");
                        titulo = scanner.nextLine();
                        try {
                            System.out.println("Ingrese Codigo numerico del Comic");
                            codigoComic = scanner.nextInt();
                            scanner.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("Error: pon números");
                            scanner.nextLine();
                            break;
                        }
                        RegistroComic comic = new RegistroComic(autor, titulo, codigoComic);
                        
                        reComic.agregarLibro(comic);
                        comics.guardarComicCSV(comic, "comics.csv");
                        break;

                    case 4:
                        System.out.println("Disponibilidad de libros");
                        System.out.println("Libros Arrendados");
                        comics.cargarComicsCSV("comics.csv");
                        comics.mostrarComics();
                        
                        System.out.println("");
                        System.out.println("________________________________________________________");
                      
                        try{
                            System.out.println("Ingresa codigo del Comic");
                            codigoComic = scanner.nextInt();
                            scanner.nextLine(); 
                            
                            boolean encontrado = comics.buscarComicCSV(codigoComic, "comics.csv");
                            if (!encontrado) {
                                System.out.println("Comic no disponible");
                                break;
                        }else {
                            comics.buscarComicCSV(codigoComic, "comics.csv");
                            }
                           
                            
                            
                            do{
                                try{
                            System.out.println("Libro disponible desea arrendar este Comic? ");
                            System.out.println("Presione 1 para arrendar");
                            System.out.println("Presione 2 para salir");
                             opcion2 =scanner.nextInt();
                             scanner.nextLine();
                             }catch(InputMismatchException e){
                                System.out.println("Porfavor colocar numeros");
                                scanner.nextLine();
                                break;
                            }
                            
                             if (opcion2==1) {
                                
                                 if (comics.eliminarComic(codigoComic)) {
                                     comics.reescribirComicsCSV("comics.csv");
                                 }
                                 System.out.println("Libro arrendado Exitosamente");
                                 System.out.println("");
                                 break;
                                
                            }
                            
                            }while(opcion2!=2); 
                            
                        }catch(InputMismatchException e){
                            System.out.println("Porfavor digitar solo Numeros");
                            scanner.nextLine();
                            break;
                        }
                        
                        break;

                    case 5:
                        System.out.println("Saliendo...");
                       continuar=false ;
                        break;

                   
                }
            } catch (NumberFormatException e) {
                System.out.println("Caracter no válido, por favor intente de nuevo.");
                
                
            }
        } while (continuar);

        
    }
}