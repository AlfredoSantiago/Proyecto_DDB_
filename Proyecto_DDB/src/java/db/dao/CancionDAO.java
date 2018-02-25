package db.dao;

import db.connection.Conexion;
import java.sql.SQLException;
import db.entity.CancionEntity;
import java.sql.PreparedStatement;
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
        pS.setString(6, c.getAnio());
        pS.execute();
        conector.getConect().commit();
        conector.cerrarConexion();
    }
}
