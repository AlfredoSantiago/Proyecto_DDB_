package db.dao;
//cancion
import db.connection.Conexion;
import java.sql.SQLException;
import db.entity.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class UsuarioDAO {
    
    public UsuarioDAO(){}
    
    public void agregarUsuario(Usuario c) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector  = new Conexion();
        String query = "insert into usuario values(?,?,?,?,?,?,?)";
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
                ? new Usuario(rS.getInt(1), rS.getString(2), rS.getString(3), rS.getString(4), rS.getString(5),rS.getString(6), rS.getInt(7))
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
        String query = "UPDATE usuario SET Nombre = ?, Apellido_p = ?, Apellido_m = ?, Usuario = ?, Contrasenia=?, Tipo=?   WHERE idUsuario = ?";
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
        pS.setString(5, c.getContrasenia());
        pS.setInt(7, c.getTipo());
        pS.execute();
        conector.getConect().commit();
    }
}
