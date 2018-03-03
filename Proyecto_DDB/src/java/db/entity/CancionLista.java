//cancion_lista
package db.entity;

public class CancionLista {
    private int idLista;
    private int idCancion;

    public CancionLista(int idLista, int idCancion) {
        this.idLista = idLista;
        this.idCancion = idCancion;
    }
    
    public CancionLista(){
        this(0,0);
    }
    
    public String toString(){
        return "idLista: "+idLista+"\nidCancion: "+idCancion;
    }

    public int getIdLista() {
        return idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }    
}