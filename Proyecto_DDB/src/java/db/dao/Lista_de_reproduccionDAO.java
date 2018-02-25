package db.dao;
//lista_reproduccion
import db.connection.Conexion;
import java.sql.SQLException;
import db.entity.Lista;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Lista_de_reproduccionDAO {
    
    public Lista_de_reproduccionDAO(){}
    
    public void agregarListaDeReprodccion(Lista c) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector  = new Conexion();
        String query = "insert into lista_de_reproduccion values(?,?,?)";
        PreparedStatement pS;
        conector.setBd("proyecto_DDB");
        conector.abrirConexion();
        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);
        pS.setInt(1, c.getIdLista());
        pS.setString(2, c.getNombre());
        pS.setInt(3, c.getIdUsuario());
       
        pS.execute();
        conector.getConect().commit();
        conector.cerrarConexion();
    }
    
    public Lista buscarLista(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector  = new Conexion();
        String query = "select * from lista_de_reproducion where idLista = ?";
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
                ? new Lista(rS.getInt(1), rS.getString(2), rS.getInt(3))
                : null;
    }
    
    public void eliminarLista(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector  = new Conexion();
        String query = "delete from lista_de_reproducion where idLista=?";
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
    
    public void actualizarLista(Lista c) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector = new Conexion();
        String query = "UPDATE lista_de_reproducion SET Nombre = ?";
        PreparedStatement pS;
        conector.setBd("proyecto_DDB");
        conector.abrirConexion();
        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);
        pS.setString(1, c.getNombre());
        pS.execute();
        conector.getConect().commit();
    }
}
