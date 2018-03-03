package db.dao;

import db.connection.Conexion;
import db.entity.CancionArtista;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CancionArtistaDAO {
    public CancionArtistaDAO(){}
    
    public void agregarCancionArtista(CancionArtista c) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector  = new Conexion();
        String query = "insert into cancion_artista values(?,?)";
        PreparedStatement pS;
        conector.setBd("proyecto_DDB");
        conector.abrirConexion();
        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);
        pS.setInt(1, c.getIdCancion());
        pS.setInt(2, c.getIdArtista());
        pS.execute();
        conector.getConect().commit();
        conector.cerrarConexion();
    }
    
    public CancionArtista buscarCancion(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector  = new Conexion();
        String query = "select * from cancion_artista where idCancion";
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
                ? new CancionArtista(rS.getInt(1), rS.getInt(2))
                : null;
    }
    
    public CancionArtista buscarArtista(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector  = new Conexion();
        String query = "select * from cancion_artista where idArtista";
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
                ? new CancionArtista(rS.getInt(1), rS.getInt(2))
                : null;
    }
    
    public void eliminarCancionArtista(CancionArtista ca) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector  = new Conexion();
        String query = "delete from cancion_lista where idArtista=? and idCancion=?";
        PreparedStatement pS;
        conector.setBd("proyecto_DDB");
        conector.abrirConexion();
        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);
        pS.setInt(1,ca.getIdArtista());
        pS.setInt(2,ca.getIdCancion());
        pS.execute();
        conector.getConect().commit();
        conector.cerrarConexion();
    }
    
    public List<CancionArtista> getListaCanciones() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Conexion conector = new Conexion();
        String query = "SELECT * FROM Lista_cancion ORDER BY idCancion";
        PreparedStatement pS;
        ResultSet rS;

        conector.setBd("proyecto_DDB");
        conector.abrirConexion();

        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);

        rS = pS.executeQuery();
        conector.getConect().commit();

        List<CancionArtista> lista = new ArrayList<>();
        while (rS.next()) {
            lista.add(new CancionArtista(rS.getInt(1), rS.getInt(2)));
        }
        return lista;
    }
}
