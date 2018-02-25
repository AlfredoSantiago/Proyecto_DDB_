//lista_reproduccion
package db.entity;

public class Lista {
    private int idLista;
    private String nombre;
    private int idUsuario;

    public Lista(int idLista, String nombre, int idUsuario) {
        this.idLista = idLista;
        this.nombre = nombre;
        this.idUsuario = idUsuario;
    }
    
    public Lista(){
        this(0,null,0);
    }
    
    public String toString(){
        return "idLista: "+idLista;
    }

    public int getIdLista() {
        return idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
