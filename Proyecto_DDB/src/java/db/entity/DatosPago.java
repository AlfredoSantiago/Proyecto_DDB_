package db.entity;

import java.util.Date;

public class DatosPago {
    private int idDatosPago;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String noTarjeta;
    private String fechaVenc;
    private int idUsuario;
    
    public DatosPago(int idDatosPago, String nombre, String apellidoP, String apellidoM, String noTarjeta, String fechavenc, int idUsuario) {
        this.idDatosPago = idDatosPago;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.noTarjeta = noTarjeta;
        this.fechaVenc = fechavenc;
        this.idUsuario = idUsuario;
    }

    public int getIdDatosPago() {
        return idDatosPago;
    }

    public void setIdDatosPago(int idDatosPago) {
        this.idDatosPago = idDatosPago;
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

    public String getNoTarjeta() {
        return noTarjeta;
    }

    public void setNoTarjeta(String noTarjeta) {
        this.noTarjeta = noTarjeta;
    }

    public String getFechaVenc() {
        return this.fechaVenc;
    }

    public void setFechaVenc(String fechavenc) {
        this.fechaVenc = fechavenc;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public String toString(){
        return "idDados: "+idDatosPago+" nombre: "+nombre+" "+apellidoP+" "+apellidoM+" noTarjeta: "+noTarjeta+" Fechavenc: "+fechaVenc+" idUsuario: "+idUsuario;
    }
}
