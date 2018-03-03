package db.entity;
//usuario
public class Usuario {
    private int idUsuario;
    private String nombre;
    private String apellido_p;
    private String apellido_m;
    private String usuario;
    private String contrasenia;
    private int tipo;

    public Usuario(int idUsuario, String nombre, String apellido_p, String apellido_m, String usuario, String contrasenia, int tipo) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido_p = apellido_p;
        this.apellido_m = apellido_m;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.tipo = tipo;
    }
    
    public Usuario(){
        this(0,null,null,null,null,null,0);
    }
    
    public String toString(){
        return "id: "+idUsuario+"\nNombre: "+nombre+"\nApellido Paterno: "+apellido_p+"\nApellido Materno: "+apellido_m+"\nUsuario: "+usuario+"\nContraseña: "+contrasenia+"\nTipo: "+tipo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_p() {
        return apellido_p;
    }

    public void setApellido_p(String apellido_p) {
        this.apellido_p = apellido_p;
    }

    public String getApellido_m() {
        return apellido_m;
    }

    public void setApellido_m(String apellido_m) {
        this.apellido_m = apellido_m;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    
}

