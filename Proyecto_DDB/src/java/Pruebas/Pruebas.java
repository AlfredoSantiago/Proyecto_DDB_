
package Pruebas;

import db.dao.ArtistaDAO;
import db.dao.CancionDAO;
import db.dao.UsuarioDAO;
import db.dao.AdministradorDAO;
import db.dao.CancionArtistaDAO;
import db.dao.CancionListaDAO;
import db.dao.DatosPagoDAO;
import db.dao.ListaReproduccionDAO;
import db.entity.Administrador;
import db.entity.Artista;
import db.entity.Cancion;
import db.entity.CancionArtista;
import db.entity.CancionLista;
import db.entity.DatosPago;
import db.entity.ListaReproduccion;
import db.entity.Usuario;
import java.sql.SQLException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Pruebas {
    public static void main(String []args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, ParseException{
        Usuario u = new Usuario(1, "ALfredo", "Santiago", "Hernandez", "Alfredo", "pass", 2,"alfa");
        /*Cancion c = new Cancion(1,"yo si", "no lo se", "reguaetoonn", 1900);
        CancionDAO cDAO = new CancionDAO();
        cDAO.agregarCancion(c);
        Artista a = new Artista(1, "Alfredo", "Santiago", "Hernandez","Es la pura verga este wey");
        ArtistaDAO aDAO = new ArtistaDAO();
        aDAO.agregarArtista(a);
        /*Administrador a = new Administrador(1,"CZER#", 1);
        AdministradorDAO aDAO = new AdministradorDAO();
        aDAO.agregarAdministrador(a);
        
        DatosPago dp= new DatosPago(2, "Alfredo", "Santiago", "Hernandez", "5555222444326676", "2017-03-12", 1);
        DatosPagoDAO dpDAO = new DatosPagoDAO();
        dpDAO.agregarDatosPago(dp);
        CancionArtista ca = new CancionArtista(1,1);
        CancionArtistaDAO caDAO = new CancionArtistaDAO();
        caDAO.agregarCancionArtista(ca);*/
        /*ListaReproduccion lr = new ListaReproduccion(1,"Gustosculposos", 1);
        ListaReproduccionDAO lrDAO = new ListaReproduccionDAO();
        lrDAO.agregarListaDeReprodccion(lr);
        CancionLista cl = new CancionLista(1,1);
        CancionListaDAO clDAO = new CancionListaDAO();
        clDAO.agregarCancionEnLista(cl);*/
        //System.out.println(d.getYear()+1900+" "+d.getDate()+" "+(d.getMonth()+1));
        UsuarioDAO uDAO = new UsuarioDAO();
        uDAO.agregarUsuario(u);
        //uDAO.eliminarUsuario(1);
        System.out.println("<li class=\"list-group-item tranaparente \">\n" +
"                                    <a href=\"src/2.mp3\"><span class=\"text-color-gris\">NOMBRE CANCION.</span></a>\n" +
"                                    <button type=\"button\" class=\"btn btn-outline-danger float-right\">ELIMINAR</button>\n" +
"                                </li>");
        
    }
    

}
