
package Pruebas;

import db.dao.CancionDAO;
import db.dao.UsuarioDAO;
import db.entity.CancionEntity;
import db.entity.Usuario;
import java.sql.SQLException;

public class Pruebas {
    public static void main(String []args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        CancionEntity c = new CancionEntity(1,"prueba2", "prueba2", "prueba2", "prueb2a", 2018);
        Usuario u =  new Usuario(1,"Jonathan", "Aviles", "Gomez","Admin","contra",1);
        
        
        CancionDAO cDAO = new CancionDAO();
        UsuarioDAO uDAO = new UsuarioDAO();
        
        uDAO.agregarUsuario(u);
      
    }
}
