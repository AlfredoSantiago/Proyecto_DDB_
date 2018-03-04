
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
                        <a class="nav-link text-color-gris " href="admin.jsp"><b>Usuarios</b></a>
                        <a class="nav-link text-color-gris" href="canciones_admin.jsp"><b>Canciones</b></a>	
                        <a class="nav-link text-color-gris active" href="artistas_admin.jsp"><b>Artistas</b></a>
                        <li class="nav-link text-color-gris" ><%out.println(u.getNombre());%></li>		 
                    </nav>					    

                </div>				
                <div class="col-md-10 color-azul-fondo">
                    <ul class="nav justify-content-center margen">
                        <li class="nav-item">
                            <a class="nav-link text-color-gris active btn btn-success" href="agregar_artista.jsp">AGREGAR</a>
                        </li>
                    </ul>
                    <div class="row">
                        <div class="col-md-12">
                            <ul id="playlist" class="list-group list-group-flush tranaparente">
                                <%
                                    ArtistaDAO aDAO=new ArtistaDAO();
                                    List<Artista> artistas = aDAO.getArtistas();
                                    
                                    for (int i = 0; i < artistas.size(); i++) {
                                        String nombre = artistas.get(i).getNombre()+" "+artistas.get(i).getApellidoP()+" "+artistas.get(i).getApellidoM();
                                        out.println("<li class=\"list-group-item tranaparente \">\n"
                                                + "     <a href=\"src/2.mp3\"><span class=\"text-color-gris\">" + nombre + "</span></a>\n"
                                                + "     <button type=\"button\" onclick='eliminarArtista("+artistas.get(i).getIdArtista()+")' class=\"btn btn-outline-danger float-right\">ELIMINAR</button>\n"
                                                + " </li>");
                                    }
                                %>
                                <script>
                                    function eliminarArtista(id) {
                                        if (confirm('¿Estas seguro de querer eliminar el Artista?')) {
                                            //console.log('si');
                                            $.post("Eliminar?op=3&id=" + id, function (data, status) {
                                                window.location = "artistas_admin.jsp";
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