/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import db.dao.ArtistaDAO;
import db.dao.CancionArtistaDAO;
import db.dao.CancionDAO;
import db.dao.CancionListaDAO;
import db.dao.DatosPagoDAO;
import db.dao.ListaReproduccionDAO;
import db.dao.UsuarioDAO;
import db.entity.Artista;
import db.entity.Cancion;
import db.entity.CancionArtista;
import db.entity.CancionLista;
import db.entity.DatosPago;
import db.entity.ListaReproduccion;
import db.entity.Usuario;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Alfredo
 */
@WebServlet("/upload")
@MultipartConfig
public class Agregar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String opcion = request.getParameter("op");
        int op = Integer.parseInt(opcion);

        switch (op) {
            //case 1 agregar Cliente    
            case 1:
                String nombre = request.getParameter("name");
                String ap = request.getParameter("ap");
                String am = request.getParameter("am");
                String email = request.getParameter("email");
                String user = request.getParameter("user");
                String pass = request.getParameter("pass");
                Usuario u;

                try {
                    u = new Usuario(getIdUsuario(), nombre, ap, am, user, pass, 1, email);
                    UsuarioDAO uDAO = new UsuarioDAO();
                    uDAO.agregarUsuario(u);
                } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
                }
                response.sendRedirect("login.html");
                return;
            //case 2 agregar Cancion
            case 2:
                nombre = request.getParameter("name");
                String album = request.getParameter("album");
                String genero = request.getParameter("genero");
                int idArtista = Integer.parseInt(request.getParameter("artista"));
                int anio = Integer.parseInt(request.getParameter("anio"));
                Cancion c;
                int idCancion=0;
                try {
                    idCancion = getIdCancion();
                    c = new Cancion(idCancion, nombre, album, genero, anio);
                    CancionDAO cDAO = new CancionDAO();
                    cDAO.agregarCancion(c);
                    CancionArtista ca = new CancionArtista(idArtista, idCancion);
                    CancionArtistaDAO caDAO = new CancionArtistaDAO();
                    caDAO.agregarCancionArtista(ca);

                } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(Agregar.class.getName()).log(Level.SEVERE, null, ex);
                }
                                
                Part arch = request.getPart("archivo");
                InputStream is = arch.getInputStream();
                ServletContext context = this.getServletContext();
                String ruta = context.getRealPath("/");
                File f = new File(ruta + "\\Canciones/" + idCancion + ".mp3");
                FileOutputStream ous = new FileOutputStream(f);
                int dato = is.read();
                while (dato != -1) {
                    ous.write(dato);
                    dato = is.read();
                }
                ous.close();
                is.close();
                response.sendRedirect("canciones_admin.jsp");
                return;
            case 3:
                nombre = request.getParameter("name");
                ap = request.getParameter("ap");
                am = request.getParameter("am");
                String desc = request.getParameter("desc");
                Artista a;
                try {
                    a = new Artista(getIdArtista(), nombre, ap, am, desc);
                    ArtistaDAO aDAO = new ArtistaDAO();
                    aDAO.agregarArtista(a);
                } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
                }
                response.sendRedirect("artistas_admin.jsp");
                return;
            case 4:                
                String nombre1 = request.getParameter("nombre");
                String ap2 = request.getParameter("ApP");
                String am2 = request.getParameter("ApM");
                String ids =request.getParameter("id");
                ids=ids.replaceAll("\\s*$","");
                int id = Integer.parseInt(ids);
                String noT = request.getParameter("noTarjeta");
                String fecha = request.getParameter("fecha");
                System.out.println(nombre1+ap2+am2+ids+noT+fecha);
                DatosPago d;
                try {
                    d = new DatosPago(getIdDatosPago(),nombre1,ap2 ,am2 ,noT,fecha,id );
                    DatosPagoDAO dDAO = new DatosPagoDAO();
                    dDAO.agregarDatosPago(d);

                } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(Agregar.class.getName()).log(Level.SEVERE, null, ex);
                }
                response.sendRedirect("spotify.jsp");
                return;
            case 5:
                String nombre3 = request.getParameter("nombre");
                String ids3 = request.getParameter("id");
                ids3 = ids3.replaceAll("\\s*$","");
                int id3 = Integer.parseInt(ids3);
                ListaReproduccion l;
                try {
                    l = new ListaReproduccion(getIdListaReproduccion(),nombre3, id3 );
                    ListaReproduccionDAO lDAO = new ListaReproduccionDAO();
                    lDAO.agregarListaDeReprodccion(l);

                } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(Agregar.class.getName()).log(Level.SEVERE, null, ex);
                }
                response.sendRedirect("playlist.jsp");
                return;
             case 6:
                String idLista = request.getParameter("lista");
                idLista = idLista.replaceAll("\\s*$","");;
                int idLista1 = Integer.parseInt(idLista);
                String ids4 = request.getParameter("id");
                ids4 = ids4.replaceAll("\\s*$","");
                int id4 = Integer.parseInt(ids4);
                CancionLista Cl;
                try {
                    Cl = new CancionLista(idLista1,id4);
                    CancionListaDAO ClDAO = new CancionListaDAO();
                    ClDAO.agregarCancionEnLista(Cl);

                } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(Agregar.class.getName()).log(Level.SEVERE, null, ex);
                }
                response.sendRedirect("playlist.jsp");
                return;
            
                
        }
        PrintWriter out = response.getWriter();
    }

    public int getIdUsuario() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UsuarioDAO uDAO = new UsuarioDAO();
        List usuarios = uDAO.getUsuarios();
        int id = usuarios.size() + 1;
        while (true) {
            Usuario aux = uDAO.buscarUsuario(id);
            if (aux == null) {
                break;
            } else {
                id++;
            }
        }
        return id;
    }

    public int getIdArtista() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        ArtistaDAO uDAO = new ArtistaDAO();
        List usuarios = uDAO.getArtistas();
        int id = usuarios.size() + 1;
        while (true) {
            Artista aux = uDAO.buscarArtista(id);
            if (aux == null) {
                break;
            } else {
                id++;
            }
        }
        return id;
    }

    public int getIdCancion() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        CancionDAO uDAO = new CancionDAO();
        List canciones = uDAO.getCanciones();
        int id = canciones.size() + 1;
        while (true) {
            Cancion aux = uDAO.buscarCancion1(id);
            if (aux == null) {
                break;
            } else {
                id++;
            }
        }
        return id;
    }
    public int getIdDatosPago() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        DatosPagoDAO uDAO = new DatosPagoDAO();
        List datosapago = uDAO.getDatosPagos();
        int id = datosapago.size() + 1;
        while (true) {
            DatosPago aux = uDAO.buscardatosPago(id);
            if (aux == null) {
                break;
            } else {
                id++;
            }
        }
        return id;
    }
    public int getIdListaReproduccion() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        ListaReproduccionDAO lDAO = new ListaReproduccionDAO();
        List ListaReproducciones = lDAO.getListasReproduccion();
        int id = ListaReproducciones.size() + 1;
        while (true) {
            ListaReproduccion aux = (ListaReproduccion) lDAO.buscarLista(id);
            if (aux == null) {
                break;
            } else {
                id++;
            }
        }
        return id;
    }
}
