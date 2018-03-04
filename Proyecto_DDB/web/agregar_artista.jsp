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
                <div class="col-md-10 top-1000">
                    <div class="container">
                        <form action="Agregar?op=3" method="post">	     		
                            <div class="form-group tam ">
                                <input type="text" name="name" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Nombre del artista">    
                            </div>
                            <div class="form-group">
                                <input type="text" name="ap" class="form-control" id="exampleInputPassword1" placeholder="Apellido Paterno">
                            </div>
                            <div class="form-group">
                                <input type="text" name="am" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Apellido Materno">   
                            </div>
                            <div class="form-group">
                                <input type="text" name="desc" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Descrpcion">   
                            </div>
                            <center style="padding-top: 30px">
                                <button type="submit" class="btn btn-success btn-lg btn-block" ><b>REGISTRAR.</b></button>
                            </center>
                        </form>
                    </div>
                </div>
            </div>

    </body>
</html>
