/* paso 1 en mascarar el projecto y transformarlo en una tienda de comic renombrando
todo lo necesario para que cumpla con lo que piden 
guardar arraylist para almacenar los objetos de la clase comic osea hacer que coincida cambiar nombre a las clases
hashmap para gestionar objetos de la clase usuario tengo qeu hacer lo mismo 
tengo que usar BufferedReader para leer datos de archivos CSV y tambien escribirlos
tambioen FIleWriter para guardar informacion de usuarios incluido los detalles de prestamos de comic 

 */
package ComicCollectorSystem;

import Exceptions.EstudianteNoEncontradoException;
import Exceptions.LibroNoEncontradoException;
import REgistroComic.Comic;
import REgistroComic.RegistroComic;
import RegistroUsuarios.RegistroUsuario;
import RegistroUsuarios.Usuario;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;


public class ComicCollectorSystem {

    
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        
        int opcion = 0,opcion2=0, id=0,telefono,codigoComic = 0;
        String rut,nombre,apellido,direccion,comuna,autor,titulo,mail;
        boolean estado,continuar=true;
        
        HashMap<Integer,String> guardar = new HashMap<>();
        Usuario reUsuario = new Usuario();
        Comic reComic = new Comic();
        
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
                        System.out.println("Ingrese su rut con punto y guion");
                        rut = scanner.nextLine();
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
                        System.out.println("Ingrese su id de estudiante");
                        id = scanner.nextInt();
                        scanner.nextLine(); 

                        RegistroUsuario registrousuario = new RegistroUsuario(rut, nombre, apellido, direccion, comuna, telefono,mail, id);
                        reUsuario.agregarUsuario(registrousuario);
                        break;

                    case 2:
                        System.out.println("Datos Del Usuario");
                        if (id == 0) {
                            System.out.println("Debe crear un usuario primero");
                            break;
                        }
                        
                       
                         try {
                                 System.out.println("Ingrese su Id de Estudiante");
                                 id = scanner.nextInt();
                                 scanner.nextLine(); 
                                 reUsuario.mostrarCLientes(id);
                            if (!reUsuario.usuarioExiste(id)) { 
                                throw new EstudianteNoEncontradoException("El Usuario con el código " + id + " no fue encontrado.");
                        }
                            reUsuario.mostrarCLientes(id);
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
                        if (id == 0) {
                          System.out.println("Debe crear un usuario primero");
                           break;
                        }
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
                        break;

                    case 4:
                        System.out.println("Disponibilidad de libros");
                        System.out.println("Libros Arrendados");
                        
                        for(Map.Entry<Integer,String> entry : guardar.entrySet()){
                            System.out.println("Codigo: "+entry.getKey()+" Titulo: "+entry.getValue());
                        }
                        System.out.println("");
                        System.out.println("________________________________________________________");
                       if (id == 0) {
                           System.out.println("Debe crear un usuario primero");
                            break;
                        }
                        try {
                            System.out.println("Ingresa codigo de libro");
                            codigoComic = scanner.nextInt();
                            scanner.nextLine(); 
                            if (!reComic.libroExiste(codigoComic)) {
                                throw new LibroNoEncontradoException("El libro con el código " + codigoComic + " no fue encontrado.");
                        }
                            RegistroComic comic2 = reComic.buscarLibro(codigoComic);
                            
                            reComic.mostrarLibros(codigoComic);
                            if (comic2.isEstado()==false) {
                                System.out.println("Comic no disponible para arriendo");
                                break;
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
                                 comic2.setEstado(false);
                                 titulo = comic2.getTitulo();
                                 guardar.put(codigoComic, titulo);
                                 System.out.println("Libro arrendado Exitosamente");
                                 System.out.println("");
                                 break;
                                
                            }
                            
                            }while(opcion2!=2); 
                        } catch (LibroNoEncontradoException e) {
                            System.out.println(e.getMessage());
                            break;
                        }catch(InputMismatchException e){
                            System.out.println("Porfavor Digitar Solo Numeros  ");
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