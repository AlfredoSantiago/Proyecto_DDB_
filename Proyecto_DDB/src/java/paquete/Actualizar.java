/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import db.dao.ArtistaDAO;
import db.dao.CancionArtistaDAO;
import db.dao.CancionDAO;
import db.dao.UsuarioDAO;
import db.entity.Artista;
import db.entity.Cancion;
import db.entity.CancionArtista;
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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Alfredo
 */
@WebServlet("/reupload")
@MultipartConfig
public class Actualizar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String opcion = request.getParameter("op");
        HttpSession session = request.getSession();
        int op = Integer.parseInt(opcion);

        switch (op) {
            //case 1 subir al session un usuario
            case 1:
                int id = Integer.parseInt(request.getParameter("id"));
                try {
                    UsuarioDAO aDAO = new UsuarioDAO();
                    Usuario a = aDAO.buscarUsuario(id);
                    session.setAttribute("user", a);
                } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
                }
                response.sendRedirect("agregar_usuario.jsp");
                return;
            //case 2 subir al session a una cancion
            case 2:
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    CancionDAO aDAO = new CancionDAO();
                    Cancion a = aDAO.buscarCancion1(id);
                    session.setAttribute("cancion", a);
                } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
                }
                response.sendRedirect("agregar_cancion.jsp");
                return;
            //case 3 subir al session un artista
            case 3:
                id = Integer.parseInt(request.getParameter("id"));          
                try {
                    ArtistaDAO aDAO = new ArtistaDAO();
                    Artista a = aDAO.buscarArtista(id);
                    UsuarioDAO uaDAO =  new UsuarioDAO();
                    Usuario ua = uaDAO.buscarUsuario(a.getIdUsuario());
                    session.setAttribute("artista", a);
                    session.setAttribute("ua", ua);
                } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
                }
                response.sendRedirect("agregar_artista.jsp");
                return;
            case 4:
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    CancionDAO aDAO = new CancionDAO();
                    Cancion a = aDAO.buscarCancion1(id);
                    session.setAttribute("cancion", a);
                } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
                }
                response.sendRedirect("artista_dash_agregar.jsp");
                return;
        }
        PrintWriter out = response.getWriter();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String opcion = request.getParameter("op");
        HttpSession session = request.getSession();
        int op = Integer.parseInt(opcion);

        switch (op) {
            //case 1 agregar Cliente    
            case 1:
                Usuario u = (Usuario) session.getAttribute("user");
                u.setNombre(request.getParameter("name"));
                u.setApellido_p(request.getParameter("ap"));
                u.setApellido_m(request.getParameter("am"));
                u.setEmail(request.getParameter("email"));
                u.setUsuario(request.getParameter("user"));
                u.setContrasenia(request.getParameter("pass"));

                try {
                    UsuarioDAO uDAO = new UsuarioDAO();
                    uDAO.actualizarUsuario(u);
                } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
                }
                session.setAttribute("user", null);
                response.sendRedirect("admin.jsp");
                return;
            //case 2 agregar Cancion
            case 2:
                Cancion c = (Cancion) session.getAttribute("cancion");
                c.setNombre(request.getParameter("name"));
                c.setAlbum(request.getParameter("album"));
                c.setGenero(request.getParameter("genero"));
                c.setAnio(Integer.parseInt(request.getParameter("anio")));
                //int idArtista = Integer.parseInt(request.getParameter("artista"));
                try {
                    CancionDAO cDAO = new CancionDAO();
                    cDAO.actualizarCancion(c);
                    //CancionArtista ca = new CancionArtista(idArtista, idCancion);
                    //CancionArtistaDAO caDAO = new CancionArtistaDAO();
                    //caDAO.agregarCancionArtista(ca);

                } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(Agregar.class.getName()).log(Level.SEVERE, null, ex);
                }

                Part arch = request.getPart("archivo");
                if (arch != null && arch.getSize()!=0) {
                    InputStream is = arch.getInputStream();
                    ServletContext context = this.getServletContext();
                    String ruta = context.getRealPath("/");
                    File f = new File(ruta + "\\Canciones/" + c.getIdCancion() + ".mp3");
                    FileOutputStream ous = new FileOutputStream(f);
                    int dato = is.read();
                    while (dato != -1) {
                        ous.write(dato);
                        dato = is.read();
                    }
                    ous.close();
                    is.close();
                }
                session.setAttribute("cancion", null);
                response.sendRedirect("canciones_admin.jsp");
                return;
            case 3:
                Artista ar = (Artista) session.getAttribute("artista");
                //Usuario
                u = (Usuario) session.getAttribute("ua");
                u.setNombre(request.getParameter("name"));
                u.setApellido_p(request.getParameter("ap"));
                u.setApellido_m(request.getParameter("am"));
                u.setEmail(request.getParameter("email"));
                u.setUsuario(request.getParameter("user"));
                u.setContrasenia(request.getParameter("pass"));
                
                ar.setDescripcion(request.getParameter("desc"));
                try {
                    UsuarioDAO uDAO = new UsuarioDAO();
                    uDAO.actualizarUsuario(u);
                    ArtistaDAO aDAO = new ArtistaDAO();
                    aDAO.actualizarArtista(ar);
                } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
                }
                session.setAttribute("artista", null);
                session.setAttribute("ua", null);
                response.sendRedirect("artistas_admin.jsp");
                return;
            case 4:
                c = (Cancion) session.getAttribute("cancion");
                c.setNombre(request.getParameter("name"));
                c.setAlbum(request.getParameter("album"));
                c.setGenero(request.getParameter("genero"));
                c.setAnio(Integer.parseInt(request.getParameter("anio")));
                //int idArtista = Integer.parseInt(request.getParameter("artista"));
                try {
                    CancionDAO cDAO = new CancionDAO();
                    cDAO.actualizarCancion(c);
                    //CancionArtista ca = new CancionArtista(idArtista, idCancion);
                    //CancionArtistaDAO caDAO = new CancionArtistaDAO();
                    //caDAO.agregarCancionArtista(ca);

                } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(Agregar.class.getName()).log(Level.SEVERE, null, ex);
                }

                arch = request.getPart("archivo");
                if (arch != null && arch.getSize()!=0) {
                    InputStream is = arch.getInputStream();
                    ServletContext context = this.getServletContext();
                    String ruta = context.getRealPath("/");
                    File f = new File(ruta + "\\Canciones/" + c.getIdCancion() + ".mp3");
                    FileOutputStream ous = new FileOutputStream(f);
                    int dato = is.read();
                    while (dato != -1) {
                        ous.write(dato);
                        dato = is.read();
                    }
                    ous.close();
                    is.close();
                }
                session.setAttribute("cancion", null);
                response.sendRedirect("artista_dash.jsp");
                return;
                

        }
        PrintWriter out = response.getWriter();
    }
}
