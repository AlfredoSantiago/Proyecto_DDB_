package db.dao;
//lista_reproduccion
import db.connection.Conexion;
import java.sql.SQLException;
import db.entity.ListaReproduccion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class ListaReproduccionDAO {
    
    public ListaReproduccionDAO(){}
    
    public void agregarListaDeReprodccion(ListaReproduccion c) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
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
    
    public List<ListaReproduccion> buscarLista(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector  = new Conexion();
        String query = "select * from lista_de_reproduccion where idUsuario = ?";
        PreparedStatement pS;
        ResultSet rS;
        conector.setBd("proyecto_DDB");
        conector.abrirConexion();
        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);
        pS.setInt(1, id);
        rS = pS.executeQuery();
        conector.getConect().commit();
        List<ListaReproduccion> lista = new ArrayList<>();
        while (rS.next()) {
            lista.add(new ListaReproduccion(rS.getInt(1), rS.getString(2), rS.getInt(3)));
        }
        return lista;
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
    
    public void actualizarLista(ListaReproduccion c) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector = new Conexion();
        String query = "UPDATE lista_de_reproducion SET Nombre = ? where idLista = ?";
        PreparedStatement pS;
        conector.setBd("proyecto_DDB");
        conector.abrirConexion();
        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);
        pS.setString(1, c.getNombre());
        pS.setInt(2, c.getIdLista());
        pS.execute();
        conector.getConect().commit();
    }
    
    public List<ListaReproduccion> getListasReproduccion() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Conexion conector = new Conexion();
        String query = "SELECT * FROM Lista_de_Reproduccion ORDER BY idLista";
        PreparedStatement pS;
        ResultSet rS;

        conector.setBd("proyecto_DDB");
        conector.abrirConexion();

        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);

        rS = pS.executeQuery();
        conector.getConect().commit();

        List<ListaReproduccion> lista = new ArrayList<>();
        while (rS.next()) {
            lista.add(new ListaReproduccion(rS.getInt(1), rS.getString(2), rS.getInt(3)));
        }
        return lista;
    }
}
