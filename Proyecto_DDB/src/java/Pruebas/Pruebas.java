
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
        CancionArtista ca = new CancionArtista(3,1);
        CancionArtistaDAO caDAO = new CancionArtistaDAO();
        caDAO.agregarCancionArtista(ca);
        //Usuario u = new Usuario(4, "ALfredo", "Santiago", "Hernandez", "Alfredo", "pass", 4,"alfa@hotmail.com");
        //UsuarioDAO uDAO = new UsuarioDAO();
        //uDAO.agregarUsuario(u);
        //Artista a = new Artista(1 ,"Es la pura verga este wey", 4);
        //ArtistaDAO aDAO = new ArtistaDAO();
        //aDAO.agregarArtista(a);
        //ListaReproduccion l = new ListaReproduccion(1 , "hola",2);
        //Cancion c = new Cancion(1,"yo si", "no lo se", "reguaetoonn", 0,1900);
        //CancionDAO cDAO = new CancionDAO();
        //cDAO.agregarCancion(c);
        
        /*Administrador a = new Administrador(1,"CZER#", 1);
        AdministradorDAO aDAO = new AdministradorDAO();
        aDAO.agregarAdministrador(a);
        
        DatosPago dp= new DatosPago(2, "Alfredo", "Santiago", "Hernandez", "5555222444326676", "2017-03-12", 1);
        DatosPagoDAO dpDAO = new DatosPagoDAO();
        dpDAO.agregarDatosPago(dp);
        
        ListaReproduccion lr = new ListaReproduccion(1,"Gustosculposos", 1);
        ListaReproduccionDAO lrDAO = new ListaReproduccionDAO();
        lrDAO.agregarListaDeReprodccion(lr);
        CancionLista cl = new CancionLista(1,1);
        CancionListaDAO clDAO = new CancionListaDAO();
        clDAO.agregarCancionEnLista(cl);
        //System.out.println(d.getYear()+1900+" "+d.getDate()+" "+(d.getMonth()+1));
        UsuarioDAO uDAO = new UsuarioDAO();
        //Usuario u = new Usuario(1, "Jose", "Frnais", "Hernandez", "Alfredo", "pass", 3,"alfa");
        uDAO.actualizarUsuario(u);
        //uDAO.agregarUsuario(u);
        //uDAO.eliminarUsuario(1);
        System.out.println("");
        //UsuarioDAO uDAO = new UsuarioDAO();
        //uDAO.agregarUsuario(u);
        ListaReproduccionDAO lDAO = new ListaReproduccionDAO();
        lDAO.agregarListaDeReprodccion(l);
        //uDAO.eliminarUsuario(1);*/
        
    }
    

}
