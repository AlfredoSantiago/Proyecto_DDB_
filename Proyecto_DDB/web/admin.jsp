<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="db.dao.*"%>
<%@page import="db.entity.*"%>

<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <link rel="stylesheet" href="./css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="./js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="./css/styles.css">

    </head>
    <body>
        <%
            Usuario u = (Usuario) session.getAttribute("usuario");
            Administrador a = (Administrador) session.getAttribute("admin");
            //out.println("hola: " + u.getNombre());
        %>
        <div class="container-fluid">
            <div class="row ">
                <div class="col-md-2 colo2"></div>
                <div class="col-md-2 colo margen-tabLeft" >				
                    <nav class="nav flex-column ">
                        <a class="nav-link text-color-gris active" href="admin.jsp"><b>Usuarios</b></a>
                        <a class="nav-link text-color-gris" href="canciones_admin.jsp"><b>Canciones</b></a>	
                        <a class="nav-link text-color-gris" href="artistas_admin.jsp"><b>Artistas</b></a>
                        <a class="nav-link text-color-gris" href="FragmentacionHorizontal.jsp"><b>Fragmentaciónes.</b></a>
                        <li class="nav-link text-color-gris" ><%out.println(u.getNombre());%></li>		 
                    </nav>			    

                </div>				
                <div class="col-md-10 color-azul-fondo">
                    <ul class="nav justify-content-center margen">
                        <li class="nav-item">
                            <a class="nav-link text-color-gris active btn btn-success" href="agregar_usuario.jsp">AGREGAR</a>
                        </li>
                    </ul>
                    <div class="row">
                        <div class="col-md-12">
                            <ul id="playlist" class="list-group list-group-flush tranaparente">
                                <%
                                    UsuarioDAO uDAO = new UsuarioDAO();
                                    List<Usuario> usuarios = uDAO.getUsuarios();
                                    for (int i = 0; i < usuarios.size(); i++) {
                                        String nombre = usuarios.get(i).getNombre() + " " + usuarios.get(i).getApellido_p() + " " + usuarios.get(i).getApellido_m();
                                        out.println("<li class=\"list-group-item tranaparente \">\n"
                                                + "     <a href=\"src/2.mp3\"><span class=\"text-color-gris\">" + nombre + "</span></a>\n"
                                                + "     <button type=\"button\" onclick='eliminarUsuario(" + usuarios.get(i).getIdUsuario() + ")' class=\"btn btn-danger float-right\">ELIMINAR</button>\n"
                                                + "     <a type=\"button\" href='Actualizar?op=1&id=" + usuarios.get(i).getIdUsuario() + "' class=\"btn btn-warning float-right\">EDITAR</a>"
                                                + " </li>\n");
                                    }
                                %>
                                <script>
                                    function eliminarUsuario(id) {
                                        if (confirm('¿Estas seguro de querer eliminar este usuario?')) {
                                            console.log('si');
                                            $.post("Eliminar?op=1&id=" + id, function (data, status) {
                                                window.location = "admin.jsp";
                                            });
                                        }
                                    }
                                </script>
                            </ul>
                        </div>
                    </div>	
                </div>
            </div>

    </body>
</html>
