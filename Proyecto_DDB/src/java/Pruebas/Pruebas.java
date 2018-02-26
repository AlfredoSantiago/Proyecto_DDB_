
package Pruebas;

import db.dao.CancionDAO;
import db.dao.Lista_de_reproduccionDAO;
import db.dao.UsuarioDAO;
import db.dao.cancion_listaDAO;
import db.entity.CancionEntity;
import db.entity.Lista;
import db.entity.ListaEntity;
import db.entity.Usuario;
import java.sql.SQLException;

public class Pruebas {
    public static void main(String []args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        //CancionEntity c = new CancionEntity(1,"prueba2", "prueba2", "prueba2", "prueb2a", 2018);
        //Usuario u =  new Usuario(1,"Jonathan", "Aviles", "Gomez","Admin","contra",1);
        //Lista l = new Lista(1, "Lo mas chingon", 1);
        //Lista_de_reproduccionDAO lDAO = new Lista_de_reproduccionDAO();
        //lDAO.agregarListaDeReprodccion(l);
        //CancionDAO cDAO = new CancionDAO();
        //UsuarioDAO uDAO = new UsuarioDAO();
        ListaEntity l = new ListaEntity(1,1);
        cancion_listaDAO lcDAO = new cancion_listaDAO();
        lcDAO.agregarCancionEnLista(l);
//uDAO.agregarUsuario(u);
      
    }
}
