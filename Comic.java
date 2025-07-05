
package REgistroComic;


import REgistroComic.RegistroComic;
import java.util.ArrayList;
import java.io.*;


public class Comic  {
     private ArrayList<RegistroComic>lista= new ArrayList<>();
    public void agregarLibro(RegistroComic registrocomic){
        lista.add(registrocomic);
    }
    
    
    
    
    
    
     public void cargarComicsCSV(String nombreArchivo){
         lista.clear();
         try(BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))){
             String linea;
             while ((linea = br.readLine())!=null){
             String[]datos = linea.split(",");
                 if (datos.length>=3) {
                     String autor = datos[0];
                     String titulo = datos[1];
                     int codigoComic= Integer.parseInt(datos[2]);
                     RegistroComic comic = new RegistroComic (autor,titulo,codigoComic);
                     this.agregarLibro(comic);
                 }
                   }
           }catch (IOException e){
             System.out.println("error al leer el archivo de comics: "+e.getMessage());
         }
     }
     public void mostrarComics() {
         for (RegistroComic comic : lista) {
                 System.out.println("Autor: " + comic.getAutor() +
                                   ", Título: " + comic.getTitulo() +
                                   ", Código: " + comic.getCodigoComic());
    }
}
     public void guardarComicCSV(RegistroComic comic,String nombreArchivo){
         try(BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo,true))){
             bw.write(comic.getAutor()+","+comic.getTitulo()+","+comic.getCodigoComic());
             bw.newLine();
         }catch(IOException e){
             System.out.println("Error al guardar el comic: "+e.getMessage());
         }
     }
     public boolean buscarComicCSV(int codigoBuscado,String nombreArchivo){
         try (BufferedReader br = new BufferedReader (new FileReader(nombreArchivo))){
             String linea;
             boolean encontrado = false;
             while((linea=br.readLine())!=null){
                 String []datos = linea.split(",");
                 if (datos.length>=3) {
                     int codigo = Integer.parseInt(datos[2]);
                     if (codigo==codigoBuscado) {
                         System.out.println("Autor: "+datos[0]);
                         System.out.println("Titulo: "+datos[1]);
                         System.out.println("codigo: "+datos[2]);
                         System.out.println("Disponibilidad:disponible");
                         return true;
                         
                         
                     }
                 }
             }
             
         }catch(IOException e){
             System.out.println("Error al buscar comic "+e.getMessage());
         }
         return false;
     }
     public boolean eliminarComic(int codigo){
         for (int i = 0; i < 10; i++) {
             if (lista.get(i).getCodigoComic()==codigo) {
                 lista.remove(i);
                 return true;
             }
         }
         return false;
     }
     
     public void reescribirComicsCSV(String nombreArchivo){
         try(BufferedWriter bw= new BufferedWriter(new FileWriter(nombreArchivo))){
             for (RegistroComic comic : lista) {
              bw.write(comic.getAutor()+","+comic.getTitulo()+","+comic.getCodigoComic());
              bw.newLine();   
             }
             
         }catch(IOException e){
             System.out.println("Error al guartdar los comics: "+e.getMessage());
         }
     }
}

