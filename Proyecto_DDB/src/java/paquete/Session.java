/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import db.dao.AdministradorDAO;
import db.dao.ArtistaDAO;
import db.dao.UsuarioDAO;
import db.entity.Administrador;
import db.entity.Artista;
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
public class Session extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String opcion = request.getParameter("op");
        HttpSession session = request.getSession();
        
        int op = Integer.parseInt(opcion);
        switch (op) {
            case 1:
                String email = request.getParameter("email");
                String pass = request.getParameter("pass");
                List<Usuario> usuarios = null;
                try {
                    UsuarioDAO uDAO = new UsuarioDAO();
                    usuarios = uDAO.getUsuarios();
                    for(int i=0; i<usuarios.size(); i++){
                        if(email.equals(usuarios.get(i).getEmail()) && pass.equals(usuarios.get(i).getContrasenia())){
                            if(usuarios.get(i).getTipo()==3){
                                AdministradorDAO aDAO = new AdministradorDAO();
                                Administrador a= aDAO.buscarAdministradorDeUsuario(usuarios.get(i).getIdUsuario());
                                session.setAttribute("usuario", usuarios.get(i));
                                session.setAttribute("admin", a);                                
                                response.sendRedirect("admin.jsp");
                                return;
                            }
                            if(usuarios.get(i).getTipo()==1){                                
                                session.setAttribute("usuario", usuarios.get(i));                         
                                response.sendRedirect("canciones.jsp");
                                return;
                            }
                            if(usuarios.get(i).getTipo()==4){
                                session.setAttribute("usuario", usuarios.get(i));
                                ArtistaDAO aDAO = new ArtistaDAO();
                                Artista a = aDAO.getArtista_Usuario(usuarios.get(i).getIdUsuario());
                                session.setAttribute("artista", a);
                                response.sendRedirect("artista_dash.jsp");
                                return;
                            }
                        }
                    }
                } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
                }
                response.sendRedirect("login.html");
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

}
