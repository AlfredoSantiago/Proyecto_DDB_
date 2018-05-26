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
     public ListaReproduccion buscarLista1(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
 
        Conexion conector  = new Conexion();
        String query = "select * from lista_de_reproduccion where idLista = ?";
 
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
                ? new ListaReproduccion(rS.getInt(1), rS.getString(2), rS.getInt(3))
 
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
    
    public int count(String atributo, String operador, String valor) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Conexion conector = new Conexion();
        String query = "select count(*) from Lista_de_Reproduccion where "+atributo+" "+operador+" "+valor+"";
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
        String query = "select count(*) from lista_de_reproduccion where "+atributo_1+" "+operador_1+" "+valor_1+" and "+atributo_2+" "+operador_2+" "+valor_2;
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
    
    public List<ListaReproduccion> getTuplas(String atributo_1, String operador_1, String valor_1, String atributo_2, String operador_2, String valor_2) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Conexion conector = new Conexion();
        String query = "SELECT * FROM lista_de_reproduccion where "+atributo_1+" "+operador_1+" "+valor_1+" and "+atributo_2+" "+operador_2+" "+valor_2;
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
    
    public void agregarListaDeReprodccionSitio(ListaReproduccion c, String sitio, String nombreBase) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector  = new Conexion();
        String query = "insert into lista_de_reproduccion values(?,?,?)";
        PreparedStatement pS;
        conector.setBd(nombreBase);
        conector.setUrl(sitio);
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
}
