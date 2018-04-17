
package db.dao;
import db.connection.Conexion;
import db.entity.Artista;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ArtistaDAO {
    
    public ArtistaDAO(){}
    
    public void agregarArtista(Artista a) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector  = new Conexion();
        String query = "insert into Artista values(?,?,?)";
        PreparedStatement pS;
        conector.setBd("proyecto_DDB");
        conector.abrirConexion();
        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);
        
        pS.setInt(1, a.getIdArtista());
        pS.setString(2, a.getDescripcion());
        pS.setInt(3, a.getIdUsuario());
        pS.execute();
        conector.getConect().commit();
        conector.cerrarConexion();
    }
    
    public Artista buscarArtista(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector  = new Conexion();
        String query = "select * from Artista where idArtista = ?";
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
                ? new Artista(rS.getInt(1), rS.getString(2), rS.getInt(3))
                : null;
    }
    
    public Artista getArtista_Usuario(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector  = new Conexion();
        String query = "select * from Artista where idUsuario = ?";
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
                ? new Artista(rS.getInt(1), rS.getString(2), rS.getInt(3))
                : null;
    }
    
    public void eliminarArtista(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector  = new Conexion();
        String query = "delete from Artista where idArtista=?";
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
    
    public void actualizarArtista(Artista c) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector = new Conexion();
        String query = "UPDATE Artista SET descripcion = ? where idArtista=?";
        PreparedStatement pS;
        conector.setBd("proyecto_DDB");
        conector.abrirConexion();
        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);
        pS.setString(1, c.getDescripcion());
        pS.setInt(2, c.getIdArtista());
        pS.execute();
        conector.getConect().commit();
    }
    
    public List<Artista> getArtistas() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Conexion conector = new Conexion();
        String query = "SELECT * FROM artista ORDER BY idArtista";
        PreparedStatement pS;
        ResultSet rS;

        conector.setBd("proyecto_DDB");
        conector.abrirConexion();

        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);

        rS = pS.executeQuery();
        conector.getConect().commit();

        List<Artista> lista = new ArrayList<>();
        while (rS.next()) {
            lista.add(new Artista(rS.getInt(1), rS.getString(2), rS.getInt(3)));
        }
        return lista;
    }
}
