
package REgistroComic;


public class RegistroComic implements Comparable<RegistroComic> {
    private String autor,titulo;
    private int codigoComic;
    private boolean estado;
    
    public RegistroComic(String autor, String titulo, int codigoComic) {
        this.autor = autor;
        this.titulo = titulo;
        this.codigoComic = codigoComic;
        this.estado = true;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCodigoComic() {
        return codigoComic;
    }

    public void setCodigoComic(int codigoLibro) {
        this.codigoComic = codigoComic;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    public void infoComic(){
        System.out.println("");
        System.out.println("Autor "+getAutor());
        System.out.println("Titulo "+getTitulo());
        System.out.println("Codigo Comic "+getCodigoComic());
        if (estado==true) {
           System.out.println("Comic Disponible"); 
        }else if(estado==false){
            System.out.println("Comic no disponible");
        }
        System.out.println("");
        
    }

    @Override
    public int compareTo(RegistroComic otroRegistroComic){
        return Integer.compare(this.codigoComic,otroRegistroComic.codigoComic);
    }
    
}

