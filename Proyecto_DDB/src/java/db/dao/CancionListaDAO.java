package db.dao;
//cancion_lista
import db.connection.Conexion;
import db.entity.Cancion;
import java.sql.SQLException;
import db.entity.CancionLista;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class CancionListaDAO {
    
    public CancionListaDAO(){}
    
    public void agregarCancionEnLista(CancionLista c) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector  = new Conexion();
        String query = "insert into cancion_lista values(?,?)";
        PreparedStatement pS;
        conector.setBd("proyecto_DDB");
        conector.abrirConexion();
        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);
        pS.setInt(1, c.getIdLista());
        pS.setInt(2, c.getIdCancion());
        pS.execute();
        conector.getConect().commit();
        conector.cerrarConexion();
    }
    
    public CancionLista buscarCancionEnListas(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector  = new Conexion();
        String query = "select * from cancion_lista where idCancion = ?";
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
                ? new CancionLista(rS.getInt(1), rS.getInt(2))
                : null;
    }
    
    public List<CancionLista> buscarLista(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector  = new Conexion();
        String query = "select * from cancion_lista where idLista = ?";
        PreparedStatement pS;
        ResultSet rS;
        conector.setBd("proyecto_DDB");
        conector.abrirConexion();
        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);
        pS.setInt(1, id);
        rS = pS.executeQuery();
        conector.getConect().commit();
       List<CancionLista> lista = new ArrayList<>();
        while (rS.next()) {
            lista.add(new CancionLista(rS.getInt(1), rS.getInt(2)));
        }
        return lista;
    }
    public CancionLista buscarLista1(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector  = new Conexion();
        String query = "select * from cancion_lista where idLista = ?";
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
                ? new CancionLista(rS.getInt(1), rS.getInt(2))
                : null;

    }
    
    
    
    public void eliminarCancionEnLista(CancionLista cl) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector  = new Conexion();
        String query = "delete from cancion_lista where idLista=? and idCancion=?";
        PreparedStatement pS;
        conector.setBd("proyecto_DDB");
        conector.abrirConexion();
        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);
        pS.setInt(1,cl.getIdLista());
        pS.setInt(2,cl.getIdCancion());
        pS.execute();
        conector.getConect().commit();
        conector.cerrarConexion();
    }
    
    public List<CancionLista> getListaCanciones() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Conexion conector = new Conexion();
        String query = "SELECT * FROM cancion_lista ORDER BY idCancion";
        PreparedStatement pS;
        ResultSet rS;

        conector.setBd("proyecto_DDB");
        conector.abrirConexion();

        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);

        rS = pS.executeQuery();
        conector.getConect().commit();

        List<CancionLista> lista = new ArrayList<>();
        while (rS.next()) {
            lista.add(new CancionLista(rS.getInt(1), rS.getInt(2)));
        }
        return lista;
    }
}
