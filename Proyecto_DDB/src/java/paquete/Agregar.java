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
            Cancion aux = uDAO.buscarCancion(id);
            if (aux == null) {
                break;
            } else {
                id++;
            }
        }
        return id;
    }
}
