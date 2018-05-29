package db.dao;
//cancion
import db.connection.Conexion;
import db.entity.Artista;
import java.sql.SQLException;
import db.entity.Cancion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class CancionDAO {
    
    public CancionDAO(){}
    
    public void agregarCancion(Cancion c) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
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
        pS.setInt(5, c.getNo_reproducciones());
        pS.setInt(6, c.getAnio());
        pS.execute();
        conector.getConect().commit();
        conector.cerrarConexion();
    }
    
    public List<Cancion> buscarCancion(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
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
         List<Cancion> lista = new ArrayList<>();
        while (rS.next()) {
            lista.add(new Cancion(rS.getInt(1), rS.getString(2), rS.getString(3), rS.getString(4), rS.getInt(5), rS.getInt(6)));
        }
        return lista;
    }
     public Cancion buscarCancion1(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
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
                ? new Cancion(rS.getInt(1), rS.getString(2), rS.getString(3), rS.getString(4), rS.getInt(5), rS.getInt(6))
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
    
    public void actualizarCancion(Cancion c) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector = new Conexion();
        String query = "UPDATE Cancion SET nombre = ?, album = ?, genero = ?, anio=?   WHERE idcancion = ?";
        PreparedStatement pS;
        conector.setBd("proyecto_DDB");
        conector.abrirConexion();
        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);
        pS.setString(1, c.getNombre());
        pS.setString(2, c.getAlbum());
        pS.setString(3, c.getGenero());
        pS.setInt(4, c.getAnio());
        pS.setInt(5, c.getIdCancion());
        pS.execute();
        conector.getConect().commit();
    }

    public void incrementarReproducciones(int id, int n) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector = new Conexion();
        String query = "UPDATE Cancion SET no_reproducciones = ?   WHERE idcancion = ?";
        PreparedStatement pS;
        conector.setBd("proyecto_DDB");
        conector.abrirConexion();
        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);
        pS.setInt(1, n);
        pS.setInt(2, id);
        pS.execute();
        conector.getConect().commit();
    }
    
    public int recuperarNoReproducciones(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector = new Conexion();
        String query = "SELECT no_reproducciones FROM cancion  WHERE idcancion = ?";
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
                ? rS.getInt(1)
                : -1;
    }
    
    public List<Cancion> getCanciones() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Conexion conector = new Conexion();
        String query = "SELECT * FROM cancion ORDER BY idCancion";
        PreparedStatement pS;
        ResultSet rS;

        conector.setBd("proyecto_DDB");
        conector.abrirConexion();

        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);

        rS = pS.executeQuery();
        conector.getConect().commit();

        List<Cancion> lista = new ArrayList<>();
        while (rS.next()) {
            lista.add(new Cancion(rS.getInt(1), rS.getString(2), rS.getString(3), rS.getString(4), rS.getInt(5), rS.getInt(6)));
        }
        return lista;
    }
    
    public int count(String atributo, String operador, String valor) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Conexion conector = new Conexion();
        String query = "select count(*) from Cancion where "+atributo+" "+operador+" "+valor+"";
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
        String query = "select count(*) from Cancion where "+atributo_1+" "+operador_1+" "+valor_1+" and "+atributo_2+" "+operador_2+" "+valor_2;
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
    
    public List<Cancion> getTuplas(String atributo_1, String operador_1, String valor_1, String atributo_2, String operador_2, String valor_2) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Conexion conector = new Conexion();
        String query = "SELECT * FROM cancion where "+atributo_1+" "+operador_1+" "+valor_1+" and "+atributo_2+" "+operador_2+" "+valor_2;
        PreparedStatement pS;
        ResultSet rS;

        conector.setBd("proyecto_DDB");
        conector.abrirConexion();

        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);

        rS = pS.executeQuery();
        conector.getConect().commit();

        List<Cancion> lista = new ArrayList<>();
        while (rS.next()) {
            lista.add(new Cancion(rS.getInt(1), rS.getString(2), rS.getString(3), rS.getString(4), rS.getInt(5), rS.getInt(6)));
        }
        return lista;
    }
    
    public void agregarCancionSitio(Cancion c, String sitio, String nombreBase, String contrasenia) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector  = new Conexion();
        String query = "insert into Cancion values(?,?,?,?,?,?)";
        PreparedStatement pS;
        conector.setBd(nombreBase);
        conector.setUrl(sitio);
        conector.setPassword(contrasenia);
        conector.abrirConexion();
        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);
        pS.setInt(1, c.getIdCancion());
        pS.setString(2, c.getNombre());
        pS.setString(3, c.getAlbum());
        pS.setString(4, c.getGenero());
        pS.setInt(5, c.getNo_reproducciones());
        pS.setInt(6, c.getAnio());
        pS.execute();
        conector.getConect().commit();
        conector.cerrarConexion();
    }
}
