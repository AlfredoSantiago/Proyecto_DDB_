
package Pruebas;

import db.dao.CancionDAO;
import db.entity.CancionEntity;
import java.sql.SQLException;

public class Pruebas {
    public static void main(String []args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        CancionEntity c = new CancionEntity(1,"prueba2", "prueba2", "prueba2", "prueb2a", 2018);
        CancionDAO cDAO = new CancionDAO();
        cDAO.actualizarCancion(c);
        //cDAO.agregarCancion(c);
        //CancionEntity c = cDAO.buscarCancion(1);
        //System.out.println(c);
        //cDAO.eliminarCancion(1);
    }
}
