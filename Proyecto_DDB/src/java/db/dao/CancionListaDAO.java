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
    
    public int count(String atributo, String operador, String valor) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Conexion conector = new Conexion();
        String query = "select count(*) from cancion_lista where "+atributo+" "+operador+" "+valor+"";
        //String query = "SELECT * FROM Administrador ORDER BY idAdministrador";
        PreparedStatement pS;
        ResultSet rS;

        conector.setBd("proyecto_DDB");
        conector.abrirConexion();

        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);

        rS = pS.executeQuery();
        conector.getConect().commit();
        //conector.cerrarConexion();
        rS.next();
        return rS.getInt(1);
    }
    
    public int count2(String atributo_1, String operador_1, String valor_1, String atributo_2, String operador_2, String valor_2) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Conexion conector = new Conexion();
        String query = "select count(*) from cancion_lista where "+atributo_1+" "+operador_1+" "+valor_1+" and "+atributo_2+" "+operador_2+" "+valor_2;
        //String query = "SELECT * FROM Administrador ORDER BY idAdministrador";
        PreparedStatement pS;
        ResultSet rS;

        conector.setBd("proyecto_DDB");
        conector.abrirConexion();

        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);

        rS = pS.executeQuery();
        conector.getConect().commit();
        //conector.cerrarConexion();
        rS.next();
        return rS.getInt(1);
    }
    
    public List<CancionLista> getTuplas(String atributo_1, String operador_1, String valor_1, String atributo_2, String operador_2, String valor_2) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Conexion conector = new Conexion();
        String query = "SELECT * FROM cancion_lista where "+atributo_1+" "+operador_1+" "+valor_1+" and "+atributo_2+" "+operador_2+" "+valor_2;
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
    
    public void agregarCancionEnListaSitio(CancionLista c, String sitio, String nombreBase) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector  = new Conexion();
        String query = "insert into cancion_lista values(?,?)";
        PreparedStatement pS;
        conector.setBd(nombreBase);
        conector.setUrl(sitio);
        conector.abrirConexion();
        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);
        pS.setInt(1, c.getIdLista());
        pS.setInt(2, c.getIdCancion());
        pS.execute();
        conector.getConect().commit();
        conector.cerrarConexion();
    }
}
