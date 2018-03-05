<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="db.dao.*"%>
<%@page import="db.entity.*"%>
<!DOCTYPE html>
<html>
    <head>
	<title></title>
	<link rel="stylesheet" href="./css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
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
					  <a class="nav-link text-color-gris " href="spotify.jsp"><b>Inicio</b></a>
					  <a class="nav-link text-color-gris active" href="playlist.jsp"><b>Tu musica</b></a>	
					  <li class="nav-link text-color-gris" >Jonathan</li>	
					  <a class="nav-link text-color-gris" href="#.html"><b>Cerrar sesion</b></a>				 
					</nav>			    
			
			</div>				
			<div class="col-md-10 color-cafe2-fondo">
				<ul class="nav justify-content-center margen">
				  <li class="nav-item">
				    <a class="nav-link text-color-gris  " href="playlist.jsp">PLAYLISTS</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link text-color-gris active" href="albumes.jsp">ALBUMES</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link text-color-gris " href="Artistas.jsp">ARTISTAS</a>
				  </li>
				  <li class="nav-item">
				     <a class="btn btn-success" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
                                        NUEVA PLAYLIST.
                                      </a>                                      
				  </li>
                                  <div class="collapse" id="collapseExample">
                                    <div class="card card-body">
                                      <form action="upload?op=5" method="post">	     		
                                        <div class="form-group tam ">
                                            <input type="hidden" class="form-control" name="id" placeholder="Nombre" value='<%out.println(u.getIdUsuario());%>'>    
                                            <input type="text" class="form-control" name="nombre" placeholder="Nombre">    
                                        </div>
                                        <center style="padding-top: 30px">
                                            <button type="submit" class="btn btn-success btn-lg btn-block" ><b>AGREGAR.</b></button>
                                        </center>
                                       </form>
                                  </div>
                                  </div>
				</ul>
			<div class="row ">
				<div class="col-md-2"><img src="src/Untitled-1.png" class="img-fluid" alt="Responsive image sombra "><p class="color-blanco text-center texto-discos">Pop</p></div>
				<div class="col-md-2"><img src="src/Untitled-1.png" class="img-fluid" alt="Responsive image"><p class="color-blanco text-center texto-discos">Latina</p></div>
				<div class="col-md-2"><img src="src/Untitled-1.png" class="img-fluid" alt="Responsive image"><p class="color-blanco text-center texto-discos">Mexico</p></div>
				<div class="col-md-2"><img src="src/Untitled-1.png" class="img-fluid" alt="Responsive image"><p class="color-blanco text-center texto-discos">Tv</p></div>
				<div class="col-md-2"><img src="src/Untitled-1.png" class="img-fluid" alt="Responsive image"><p class="color-blanco text-center texto-discos">Romantica</p></div>
				<div class="col-md-2"><img src="src/Untitled-1.png" class="img-fluid" alt="Responsive image"><p class="color-blanco text-center texto-discos">Indie</p></div>
			</div>
			<div class="row ">
				<div class="col-md-2"><img src="src/Untitled-1.png" class="img-fluid" alt="Responsive image"><p class="color-blanco text-center texto-discos">Clasicas</p></div>
				<div class="col-md-2"><img src="src/Untitled-1.png" class="img-fluid" alt="Responsive image"><p class="color-blanco text-center texto-discos">Jazz</p></div>
				<div class="col-md-2"><img src="src/Untitled-1.png" class="img-fluid" alt="Responsive image"><p class="color-blanco text-center texto-discos">Concentracion</p></div>
				<div class="col-md-2"><img src="src/Untitled-1.png" class="img-fluid" alt="Responsive image"><p class="color-blanco text-center texto-discos">Gaming</p></div>
				<div class="col-md-2"><img src="src/Untitled-1.png" class="img-fluid" alt="Responsive image"><p class="color-blanco text-center texto-discos">Punk</p></div>
				<div class="col-md-2"><img src="src/Untitled-1.png" class="img-fluid" alt="Responsive image"><p class="color-blanco text-center texto-discos">Dance</p></div>
			</div>
			</div>
		</div>
		<FOOTER>
			<nav class="navbar fixed-bottom navbar-light footer">
			  <a class="navbar-brand" href="#">Reproductor</a>
			</nav>	
		</FOOTER>
	</div>
</body>
</html>