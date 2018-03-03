
package db.entity;

public class CancionArtista {
    private int idArtista;
    private int idCancion;
    
    public CancionArtista(int idArtista, int idCancion){
        this.idArtista = idArtista;
        this.idCancion = idCancion;
    }
    
    public CancionArtista(){
        this(0,0);
    }
    
    public int getIdArtista(){
        return idArtista;
    }
    
    public int getIdCancion(){
        return idCancion;
    }
    
    public void setIdCancion(int idCancion){
        this.idCancion = idCancion;
    }
    
    public void setIdArtista(int idArtista){
        this.idArtista = idArtista;
    }
}
