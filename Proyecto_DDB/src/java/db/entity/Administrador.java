
package db.entity;

public class Administrador {
    private int idAdministrador;
    private String Codigo;
    private int idUsuario;

    public Administrador(int idAdministrador, String Codigo, int idUsuario) {
        this.idAdministrador = idAdministrador;
        this.Codigo = Codigo;
        this.idUsuario = idUsuario;
    }
    public Administrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }
    public Administrador(int idAdministrador, String Codigo) {
        this.idAdministrador = idAdministrador;
        this.Codigo = Codigo;
    }
    
    
    public Administrador(){
        this(0,null,0);
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public String toString(){
        return "idAdmin: "+idAdministrador+" Codigo: "+Codigo+" idUsuario: "+idUsuario;
    }
}
