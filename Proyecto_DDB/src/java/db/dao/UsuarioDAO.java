package db.dao;
import db.connection.Conexion;
import java.sql.SQLException;
import db.entity.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class UsuarioDAO {
    
    public UsuarioDAO(){}
    
    public void agregarUsuario(Usuario c) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector  = new Conexion();
        String query = "insert into usuario values(?,?,?,?,?,?,?,?)";
        PreparedStatement pS;
        conector.setBd("proyecto_DDB");
        conector.abrirConexion();
        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);
        pS.setInt(1, c.getIdUsuario());
        pS.setString(2, c.getNombre());
        pS.setString(3, c.getApellido_p());
        pS.setString(4, c.getApellido_m());
        pS.setString(5, c.getUsuario());
        pS.setString(6, c.getContrasenia());
        pS.setInt(7, c.getTipo());
        pS.setString(8, c.getEmail());
        pS.execute();
        conector.getConect().commit();
        conector.cerrarConexion();
    }
    
    public Usuario buscarUsuario(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector  = new Conexion();
        String query = "select * from usuario where idUsuario = ?";
        PreparedStatement pS;
        ResultSet rS;
        conector.setBd("proyecto_DDB");
        conector.abrirConexion();
        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);
        pS.setInt(1, id);
        rS = pS.executeQuery();
        conector.getConect().commit();
        return rS.next()
                ? new Usuario(rS.getInt(1), rS.getString(2), rS.getString(3), rS.getString(4), rS.getString(5),rS.getString(6), rS.getInt(7), rS.getString(8))
                : null;
    }
    
    public void eliminarUsuario(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector  = new Conexion();
        String query = "delete from usuario where idUsuario=?";
        PreparedStatement pS;
        conector.setBd("proyecto_DDB");
        conector.abrirConexion();
        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);
        pS.setInt(1,id);
        pS.execute();
        conector.getConect().commit();
        conector.cerrarConexion();
    }
    
    public void actualizarUsuario(Usuario c) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector = new Conexion();
        String query = "UPDATE usuario SET Nombre = ?, Apellido_p = ?, Apellido_m = ?, Usuario = ?, Contrasenia=?, Tipo=?, email=?   WHERE idUsuario = ?";
        PreparedStatement pS;
        conector.setBd("proyecto_DDB");
        conector.abrirConexion();
        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);
        pS.setInt(8, c.getIdUsuario());
        pS.setString(1, c.getNombre());
        pS.setString(2, c.getApellido_p());
        pS.setString(3, c.getApellido_m());
        pS.setString(4, c.getUsuario());
        pS.setString(5, c.getContrasenia());
        pS.setInt(6, c.getTipo());
        pS.setString(7, c.getEmail());
        pS.execute();
        conector.getConect().commit();
    }
    
    public List<Usuario> getUsuarios() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Conexion conector = new Conexion();
        String query = "SELECT * FROM Usuario ORDER BY nombre";
        PreparedStatement pS;
        ResultSet rS;

        conector.setBd("proyecto_DDB");
        conector.abrirConexion();

        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);

        rS = pS.executeQuery();
        conector.getConect().commit();

        List<Usuario> lista = new ArrayList<>();
        while (rS.next()) {
            lista.add(new Usuario(rS.getInt(1), rS.getString(2), rS.getString(3), rS.getString(4), rS.getString(5),rS.getString(6), rS.getInt(7), rS.getString(8)));
        }
        return lista;
    }
    
    public int count(String atributo, String operador, String valor) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Conexion conector = new Conexion();
        String query = "select count(*) from Usuario where "+atributo+" "+operador+" "+valor+"";
        //String query = "SELECT * FROM Administrador ORDER BY idAdministrador";
        PreparedStatement pS;
        ResultSet rS;

        conector.setBd("proyecto_DDB");
        conector.abrirConexion();

        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);

        rS = pS.executeQuery();
        conector.getConect().commit();
        //conector.cerrarConexion();
        rS.next();
        return rS.getInt(1);
    }
    
    public int count2(String atributo_1, String operador_1, String valor_1, String atributo_2, String operador_2, String valor_2) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Conexion conector = new Conexion();
        String query = "select count(*) from usuario where "+atributo_1+" "+operador_1+" "+valor_1+" and "+atributo_2+" "+operador_2+" "+valor_2;
        //String query = "SELECT * FROM Administrador ORDER BY idAdministrador";
        PreparedStatement pS;
        ResultSet rS;

        conector.setBd("proyecto_DDB");
        conector.abrirConexion();

        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);

        rS = pS.executeQuery();
        conector.getConect().commit();
        //conector.cerrarConexion();
        rS.next();
        return rS.getInt(1);
    }
    
    public List<Usuario> getTuplas(String atributo_1, String operador_1, String valor_1, String atributo_2, String operador_2, String valor_2) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Conexion conector = new Conexion();
        String query = "SELECT * FROM Usuario where "+atributo_1+" "+operador_1+" "+valor_1+" and "+atributo_2+" "+operador_2+" "+valor_2;
        PreparedStatement pS;
        ResultSet rS;

        conector.setBd("proyecto_DDB");
        conector.abrirConexion();

        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);

        rS = pS.executeQuery();
        conector.getConect().commit();

        List<Usuario> lista = new ArrayList<>();
        while (rS.next()) {
            lista.add(new Usuario(rS.getInt(1), rS.getString(2), rS.getString(3), rS.getString(4), rS.getString(5),rS.getString(6), rS.getInt(7), rS.getString(8)));
        }
        return lista;
    }
    
    public void agregarUsuarioSitio(Usuario c, String sitio, String nombreBase, String contrasenia) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector  = new Conexion();
        String query = "insert into usuario values(?,?,?,?,?,?,?,?)";
        PreparedStatement pS;
        conector.setBd(nombreBase);
        conector.setUrl(sitio);
        conector.setPassword(contrasenia);
        conector.abrirConexion();
        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);
        pS.setInt(1, c.getIdUsuario());
        pS.setString(2, c.getNombre());
        pS.setString(3, c.getApellido_p());
        pS.setString(4, c.getApellido_m());
        pS.setString(5, c.getUsuario());
        pS.setString(6, c.getContrasenia());
        pS.setInt(7, c.getTipo());
        pS.setString(8, c.getEmail());
        pS.execute();
        conector.getConect().commit();
        conector.cerrarConexion();
    }
}