
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
        String query = "insert into Artista values(?,?,?,?,?)";
        PreparedStatement pS;
        conector.setBd("proyecto_DDB");
        conector.abrirConexion();
        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);
        
        pS.setInt(1, a.getIdArtista());
        pS.setString(2, a.getNombre());
        pS.setString(3, a.getApellidoP());
        pS.setString(4, a.getApellidoM());
        pS.setString(5, a.getDescripcion());
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
                ? new Artista(rS.getInt(1), rS.getString(2), rS.getString(3), rS.getString(4), rS.getString(5))
                : null;
    }
    
    public void eliminarLista(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
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
        String query = "UPDATE Artista SET Nombre = ?, Apellido_p = ?, Apellido_m = ?, descripcion = ? where idArtista=?";
        PreparedStatement pS;
        conector.setBd("proyecto_DDB");
        conector.abrirConexion();
        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);
        pS.setString(1, c.getNombre());
        pS.setString(2, c.getApellidoP());
        pS.setString(3, c.getApellidoM());
        pS.setString(4, c.getDescripcion());
        pS.setInt(5, c.getIdArtista());
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
            lista.add(new Artista(rS.getInt(1), rS.getString(2), rS.getString(3), rS.getString(4), rS.getString(5)));
        }
        return lista;
    }
}
