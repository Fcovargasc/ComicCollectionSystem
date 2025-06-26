
package REgistroComic;


import REgistroComic.RegistroComic;
import java.util.TreeSet;
//ArrayList

public class Comic  {
     private TreeSet<RegistroComic>lista= new TreeSet<>();
    public void agregarLibro(RegistroComic registrocomic){
        lista.add(registrocomic);
    }
    public RegistroComic buscarLibro(int codigoComic){
        for (RegistroComic registrocomic : lista) {
            if (registrocomic.getCodigoComic()==codigoComic) {
                return registrocomic;
            }
        }
        return null;
    }
    
    public void mostrarLibros(int codigoComic){
        for (RegistroComic registrocomic:lista) {
            if(registrocomic.getCodigoComic()==codigoComic){
                System.out.println("datos del Comic");
                registrocomic.infoComic();
                return;
            }
        }
        System.out.println("comic no encontrado");
    }
    
    public boolean libroExiste(int codigoComic){
        for (RegistroComic registrocomic : lista) {
            if (registrocomic.getCodigoComic()==codigoComic) {
                return true;
            }
        }
        return false;
    }
}
