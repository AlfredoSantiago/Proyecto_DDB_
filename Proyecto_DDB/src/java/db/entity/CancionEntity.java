
package db.entity;

public class CancionEntity {
    private int idCancion;
    private String nombre;
    private String album;
    private  String genero;
    private  String artista;
    private String anio;

    public CancionEntity(int idCancion, String nombre, String album, String genero, String artista, String anio) {
        this.idCancion = idCancion;
        this.nombre = nombre;
        this.album = album;
        this.genero = genero;
        this.artista = artista;
        this.anio = anio;
    }
    public CancionEntity(){
        this(0,null,null,null,null,null);
    }
    public String toString(){
        return "id: "+idCancion+"\nNombre: "+nombre+"\nAlbum: "+album+"\nGenero: "+genero+"\nArtista: "+artista+"\nAño: "+anio;
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

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }    
}
