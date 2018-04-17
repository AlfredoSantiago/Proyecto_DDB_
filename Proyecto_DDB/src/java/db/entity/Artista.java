
package db.entity;

public class Artista {
    private int idArtista;
    private String descripcion;
    private int idUsuario;
    
    public Artista(int idArtista, String descripcion, int idUsuario) {
        this.idArtista = idArtista;
        this.idUsuario = idUsuario;
        this.descripcion = descripcion;
    }

    public int getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.descripcion = Descripcion;
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsaurio(int idUsaurio) {
        this.idUsuario = idUsuario;
    }
    
    public String toString(){
        return "idArtista: "+idArtista+"\nidUSuario: "+idUsuario+"\ndesc: "+descripcion;
    }
}
