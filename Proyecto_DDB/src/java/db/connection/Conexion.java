package db.connection;
import java.sql.*;

public class Conexion {
    private Connection conect;
    private String user;
    private String password;
    private String url;
    private String bd;
    
    public Conexion(Connection conect, String user, String password, String url, String bd) {
        this.conect = conect;
        this.user = user;
        this.password = password;
        this.url = url;
        this.bd = bd;
    }
    public Conexion() {
        this(null, "root", "root", "jdbc:mysql://localhost/", null);
    }
    public Connection getConect() {
        return conect;
    }

    public void setConect(Connection conect) {
        this.conect = conect;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBd() {
        return bd;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

    private void cargarDriver() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName("org.gjt.mm.mysql.Driver").newInstance();
    }

    public void abrirConexion() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        cargarDriver();

        conect = DriverManager.getConnection(url + bd, user, password);
    }

    public void cerrarConexion() throws SQLException {
        conect.close();
    }

    public void destruir() {
        conect = null;
        user = null;
        password = null;
        url = null;
        bd = null;
        System.gc();
    }

    @Override
    public String toString() {
        return "Conexión: " + conect + "\n"
                + "Usuario: " + user + "\n"
                + "Contraseña: " + password + "\n"
                + "Dirección URL: " + url + "\n"
                + "Base de datos: " + bd + "\n";
    }
}
