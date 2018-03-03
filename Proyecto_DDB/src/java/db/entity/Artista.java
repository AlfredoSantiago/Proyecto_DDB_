
package db.entity;

public class Artista {
    private int idArtista;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String descripcion;

    public Artista(int idArtista, String nombre, String apellidoP, String apellidoM, String descripcion) {
        this.idArtista = idArtista;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.descripcion = descripcion;
    }

    public int getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.descripcion = Descripcion;
    }
    
    public String toString(){
        return "idArtista: "+idArtista+" Nombre: "+nombre+" "+apellidoP+" "+apellidoM+" "+descripcion;
    }
}
