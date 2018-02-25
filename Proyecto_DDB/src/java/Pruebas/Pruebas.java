
package Pruebas;

import db.dao.CancionDAO;
import db.entity.CancionEntity;
import java.sql.SQLException;

public class Pruebas {
    public static void main(String []args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        CancionEntity c = new CancionEntity(1,"prueba", "prueba", "prueba", "prueba", "prueba");
        CancionDAO cDAO = new CancionDAO();
        cDAO.agregarCancion(c);
    }
}
