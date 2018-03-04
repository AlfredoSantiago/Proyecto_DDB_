/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import db.dao.AdministradorDAO;
import db.dao.ArtistaDAO;
import db.dao.CancionDAO;
import db.dao.UsuarioDAO;
import db.entity.Administrador;
import db.entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alfredo
 */
public class Eliminar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String opcion = request.getParameter("op");
        int op = Integer.parseInt(opcion);
        switch (op) {
            //case 1 Eliminar Usuario
            case 1:
                int id = Integer.parseInt(request.getParameter("id"));
                try {
                    UsuarioDAO uDAO = new UsuarioDAO();
                    uDAO.eliminarUsuario(id);
                    //response.sendRedirect("admin.jsp");
                    
                } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
                }
                return;
                //case 2 Eliminar Cancion
            case 2:
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    CancionDAO cDAO = new CancionDAO();
                    cDAO.eliminarCancion(id);
                    //response.sendRedirect("admin.jsp");
                    
                } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
                }
                return;
                //case 3 Eliminar Artista
            case 3: 
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    ArtistaDAO aDAO = new ArtistaDAO();
                    aDAO.eliminarArtista(id);
                    //response.sendRedirect("admin.jsp");
                    
                } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
                }
                return;
        }
        
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
}
