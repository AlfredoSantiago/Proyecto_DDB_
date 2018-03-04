/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import db.dao.UsuarioDAO;
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

/**
 *
 * @author Alfredo
 */
public class Agregar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String opcion = request.getParameter("op");
        int op = Integer.parseInt(opcion);
        switch (op) {
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
