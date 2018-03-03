package db.entity;

public class ListaReproduccion {
    private int idLista;
    private String nombre;
    private int idUsuario;

    public ListaReproduccion(int idLista, String nombre, int idUsuario) {
        this.idLista = idLista;
        this.nombre = nombre;
        this.idUsuario = idUsuario;
    }
    
    public ListaReproduccion(){
        this(0, null, 0);
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
    
    public String toString(){
        return "idLista: "+idLista+" nombre: "+nombre+" idUsuario: "+idUsuario;
    }
    
}
