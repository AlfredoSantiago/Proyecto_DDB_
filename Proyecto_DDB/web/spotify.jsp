
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="db.dao.*"%>
<%@page import="db.entity.*"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
            List<DatosPago> datosPago = null;
            DatosPagoDAO dtDAO = new DatosPagoDAO();
            datosPago = dtDAO.getDatosPagos();
        %>
	<div class="container-fluid">
		<div class="row ">
			<div class="col-md-2 colo2"></div>
			<div class="col-md-2 colo margen-tabLeft" >				
					<nav class="nav flex-column ">
					  <a class="nav-link text-color-gris active" href="spotify.jsp"><b>Inicio</b></a>
					  <a class="nav-link text-color-gris" href="playlist.jsp"><b>Tu musica</b></a>	
                                          <%       if(datosPago.size()==0){
                                                    out.println("<a class='nav-link text-color-gris' href='premium.jsp'><b>HAZTE PREIUM</b></a>");
                                                    }   
                                                int  v = 0;
                                                 for(int p=0; p<datosPago.size(); p++){
                                                 if(datosPago.get(p).getIdUsuario()==u.getIdUsuario()){                                                     
                                                     v=1;                                                    
                                                 }                                                
                                                } 
                                                if(v==0){
                                                    out.println("<a class='nav-link text-color-gris' href='premium.jsp'><b>HAZTE PREIUM</b></a>");
                                                }                                            
                                            %>	
					  <li class="nav-link text-color-gris" ><%out.println(u.getNombre());%></li>	
					  <a class="nav-link text-color-gris" href="login.html"><b>Cerrar sesion</b></a>		 
					</nav>			    
			
			</div>				
			<div class="col-md-10 color-azul-fondo">
				<ul class="nav justify-content-center margen">
				  <li class="nav-item">
				    <a class="nav-link text-color-gris active" href="#">SELECCIONADOS</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link text-color-gris" href="canciones.jsp">CANCIONES.</a>
				  </li>
				</ul>
				<H1><b><center class="color-blanco margen">A darle hasta que amanezca: total, manana es domingo</center></b> </H1>	
			<div class="row ">
				<div class="col-md-2"><img src="src/Untitled-1.png" class="img-fluid" alt="Responsive image sombra "><p class="color-blanco text-center texto-discos">MIRREY</p></div>
				<div class="col-md-2"><img src="src/Untitled-1.png" class="img-fluid" alt="Responsive image"><p class="color-blanco text-center texto-discos">Cumbia sonidera</p></div>
				<div class="col-md-2"><img src="src/Untitled-1.png" class="img-fluid" alt="Responsive image"><p class="color-blanco text-center texto-discos">La Cantina</p></div>
				<div class="col-md-2"><img src="src/Untitled-1.png" class="img-fluid" alt="Responsive image"><p class="color-blanco text-center texto-discos">Rock Party</p></div>
				<div class="col-md-2"><img src="src/Untitled-1.png" class="img-fluid" alt="Responsive image"><p class="color-blanco text-center texto-discos">Fiesta 90tera</p></div>
				<div class="col-md-2"><img src="src/Untitled-1.png" class="img-fluid" alt="Responsive image"><p class="color-blanco text-center texto-discos">Jose Alfredo</p></div>
			</div>
			<div class="row ">
				<div class="col-md-2"><img src="src/Untitled-1.png" class="img-fluid" alt="Responsive image"><p class="color-blanco text-center texto-discos">Pop ip</p></div>
				<div class="col-md-2"><img src="src/Untitled-1.png" class="img-fluid" alt="Responsive image"><p class="color-blanco text-center texto-discos">Muse</p></div>
				<div class="col-md-2"><img src="src/Untitled-1.png" class="img-fluid" alt="Responsive image"><p class="color-blanco text-center texto-discos">Rock en espanol</p></div>
				<div class="col-md-2"><img src="src/Untitled-1.png" class="img-fluid" alt="Responsive image"><p class="color-blanco text-center texto-discos">Cancionero</p></div>
				<div class="col-md-2"><img src="src/Untitled-1.png" class="img-fluid" alt="Responsive image"><p class="color-blanco text-center texto-discos">Clasicos para Fogata</p></div>
				<div class="col-md-2"><img src="src/Untitled-1.png" class="img-fluid" alt="Responsive image"><p class="color-blanco text-center texto-discos">Solo para amantes</p></div>
			</div>
			</div>
		</div>

</body>
</html>