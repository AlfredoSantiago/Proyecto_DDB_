//cancion
package db.entity;

public class Cancion {
    private int idCancion;
    private String nombre;
    private String album;
    private  String genero;
    private int anio;

    public Cancion(int idCancion, String nombre, String album, String genero, int anio) {
        this.idCancion = idCancion;
        this.nombre = nombre;
        this.album = album;
        this.genero = genero;
        this.anio = anio;
    }
    public Cancion(){
        this(0,null,null,null,0);
    }
    public String toString(){
        return "id: "+idCancion+"\nNombre: "+nombre+"\nAlbum: "+album+"\nGenero: "+genero+"\nAño: "+anio;
    }

    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }    
}
