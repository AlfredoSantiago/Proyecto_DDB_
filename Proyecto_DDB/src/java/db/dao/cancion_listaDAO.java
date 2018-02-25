package db.dao;
//cancion_lista
import db.connection.Conexion;
import java.sql.SQLException;
import db.entity.ListaEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class cancion_listaDAO {
    
    public cancion_listaDAO(){}
    
    public void agregarCancionEnLista(ListaEntity c) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector  = new Conexion();
        String query = "insert into cancion_lista values(?,?)";
        PreparedStatement pS;
        conector.setBd("proyecto_DDB");
        conector.abrirConexion();
        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);
        pS.setInt(1, c.getIdCancion());
        pS.setInt(2, c.getIdLista());
        pS.execute();
        conector.getConect().commit();
        conector.cerrarConexion();
    }
    
    public ListaEntity buscarCancionEnLista(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
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
                ? new ListaEntity(rS.getInt(1), rS.getInt(2))
                : null;
    }
    
    public void eliminarCancionEnLista(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector  = new Conexion();
        String query = "delete from cancion_lista where idLista=?";
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
    
}
