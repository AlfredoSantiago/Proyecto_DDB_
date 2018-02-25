package db.dao;

import db.connection.Conexion;
import java.sql.SQLException;
import db.entity.CancionEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class CancionDAO {
    
    public CancionDAO(){}
    
    public void agregarCancion(CancionEntity c) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector  = new Conexion();
        String query = "insert into Cancion values(?,?,?,?,?,?)";
        PreparedStatement pS;
        conector.setBd("proyecto_DDB");
        conector.abrirConexion();
        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);
        pS.setInt(1, c.getIdCancion());
        pS.setString(2, c.getNombre());
        pS.setString(3, c.getAlbum());
        pS.setString(4, c.getGenero());
        pS.setString(5, c.getArtista());
        pS.setInt(6, c.getAnio());
        pS.execute();
        conector.getConect().commit();
        conector.cerrarConexion();
    }
    
    public CancionEntity buscarCancion(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector  = new Conexion();
        String query = "select * from Cancion where idCancion = ?";
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
                ? new CancionEntity(rS.getInt(1), rS.getString(2), rS.getString(3), rS.getString(4), rS.getString(5), rS.getInt(6))
                : null;
    }
    
    public void eliminarCancion(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector  = new Conexion();
        String query = "delete from Cancion where idCancion=?";
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
    
    public void actualizarCancion(CancionEntity c) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector = new Conexion();
        String query = "UPDATE Cancion SET nombre = ?, album = ?, genero = ?, artista = ?, anio=?   WHERE idcancion = ?";
        PreparedStatement pS;
        conector.setBd("proyecto_DDB");
        conector.abrirConexion();
        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);
        pS.setString(1, c.getNombre());
        pS.setString(2, c.getAlbum());
        pS.setString(3, c.getGenero());
        pS.setString(4, c.getArtista());
        pS.setInt(5, c.getAnio());
        pS.setInt(6, c.getIdCancion());
        pS.execute();
        conector.getConect().commit();
    }
}
