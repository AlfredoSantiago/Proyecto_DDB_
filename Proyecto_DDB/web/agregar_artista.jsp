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
            Artista ar = (Artista) session.getAttribute("artista");
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
                <div class="col-md-10 top-1000">
                    <div class="container">
                        <%
                            if (ar != null) {
                                out.println("<form action=\"Actualizar?op=3\" method=\"post\">	     		\n"
                                        + "                            <div class=\"form-group tam \">\n"
                                        + "                                <input type=\"text\" name=\"name\" value='"+ar.getNombre()+"'  class=\"form-control\" id=\"exampleInputEmail1\" aria-describedby=\"emailHelp\" placeholder=\"Nombre del artista\">    \n"
                                        + "                            </div>\n"
                                        + "                            <div class=\"form-group\">\n"
                                        + "                                <input type=\"text\" name=\"ap\" value='"+ar.getApellidoP()+"' class=\"form-control\" id=\"exampleInputPassword1\" placeholder=\"Apellido Paterno\">\n"
                                        + "                            </div>\n"
                                        + "                            <div class=\"form-group\">\n"
                                        + "                                <input type=\"text\" name=\"am\" value='"+ar.getApellidoM()+"' class=\"form-control\" id=\"exampleInputEmail1\" aria-describedby=\"emailHelp\" placeholder=\"Apellido Materno\">   \n"
                                        + "                            </div>\n"
                                        + "                            <div class=\"form-group\">\n"
                                        + "                                <input type=\"text\" name=\"desc\" value='"+ar.getDescripcion()+"' class=\"form-control\" id=\"exampleInputEmail1\" aria-describedby=\"emailHelp\" placeholder=\"Descrpcion\">   \n"
                                        + "                            </div>\n"
                                        + "                            <center style=\"padding-top: 30px\">\n"
                                        + "                                <button type=\"submit\" class=\"btn btn-success btn-lg btn-block\" ><b>Actualizar</b></button>\n"
                                        + "                            </center>\n"
                                        + "                        </form>");
                            } else {
                                out.println("<form action=\"Agregar?op=3\" method=\"post\">	     		\n"
                                        + "                            <div class=\"form-group tam \">\n"
                                        + "                                <input type=\"text\" name=\"name\" class=\"form-control\" id=\"exampleInputEmail1\" aria-describedby=\"emailHelp\" placeholder=\"Nombre del artista\">    \n"
                                        + "                            </div>\n"
                                        + "                            <div class=\"form-group\">\n"
                                        + "                                <input type=\"text\" name=\"ap\" class=\"form-control\" id=\"exampleInputPassword1\" placeholder=\"Apellido Paterno\">\n"
                                        + "                            </div>\n"
                                        + "                            <div class=\"form-group\">\n"
                                        + "                                <input type=\"text\" name=\"am\" class=\"form-control\" id=\"exampleInputEmail1\" aria-describedby=\"emailHelp\" placeholder=\"Apellido Materno\">   \n"
                                        + "                            </div>\n"
                                        + "                            <div class=\"form-group\">\n"
                                        + "                                <input type=\"text\" name=\"desc\" class=\"form-control\" id=\"exampleInputEmail1\" aria-describedby=\"emailHelp\" placeholder=\"Descrpcion\">   \n"
                                        + "                            </div>\n"
                                        + "                            <center style=\"padding-top: 30px\">\n"
                                        + "                                <button type=\"submit\" class=\"btn btn-success btn-lg btn-block\" ><b>REGISTRAR.</b></button>\n"
                                        + "                            </center>\n"
                                        + "                        </form>");
                            }
                        %>
                        
                    </div>
                </div>
            </div>
    </body>
</html>
