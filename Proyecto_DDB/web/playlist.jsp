<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="db.dao.*"%>
<%@page import="db.entity.*"%>
<!DOCTYPE html>
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
			<div class="col-md-10 color-verde-fondo">
				<ul class="nav justify-content-center margen">
				  <li class="nav-item">
				    <a class="nav-link text-color-gris active " href="playlist.jsp">PLAYLISTS</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link text-color-gris " href="albumes.jsp">ALBUMES</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link text-color-gris " href="Artistas.jsp">ARTISTAS</a>
				  </li>
				  <li class="nav-item">
				     <a class="btn btn-success" data-toggle="collapse" href="#collapseExamples" role="button" aria-expanded="false" aria-controls="collapseExample">
                                        NUEVA PLAYLIST.
                                      </a>                                      
				  </li>
                                  <div class="collapse" id="collapseExamples">
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
				<H1><b><center class="color-blanco margen">Generos</center></b> </H1>
                             
			<div class="row ">
                            <% 
                                ListaReproduccionDAO lDAO1 = new ListaReproduccionDAO();
                                List < ListaReproduccion> ListaReproducciones1 = lDAO1.buscarLista(u.getIdUsuario());
                                
                                ListaReproduccionDAO lDAO = new ListaReproduccionDAO();
                                List < ListaReproduccion> ListaReproducciones = lDAO.getListasReproduccion();
                                CancionListaDAO ClDAO = new CancionListaDAO();
                                
                                CancionDAO Ca = new CancionDAO();
                                List <Cancion> cancion = Ca.getCanciones();
                                
                                for(int i = 0; i<ListaReproducciones1.size(); i++){
                                    List < CancionLista > l = ClDAO.buscarLista(i);
                                    
                                    if(i<6){                                       
                                        out.println("<div class=\"col-md-2\"><a href=\"#collapseExample"+i+"\" data-toggle=\"collapse\"><img src=\"src/Untitled-1.png\" class=\"img-fluid\" alt=\"Responsive image sombra \"></a><p class=\"color-blanco text-center texto-discos\">"+ListaReproducciones1.get(i).getNombre()+"</p></div>"
                                        +"<div class=\"collapse\" id=\"collapseExample"+i+"\"> \n"
                                        +"<div class=\"card card-body\"> \n"); 
                                       for(int o=0; o<l.size(); o++){
                                       List <Cancion> cn = Ca.buscarCancion(l.get(o).getIdCancion());  
                                       for(int t=0; t<cn.size();t++){
                                                out.println("<option value='" +     cn.get(t).getNombre() + "'>" + cn.get(t).getNombre() + "</option>");
                                               }
                                        
                                       } 
                                        out.println("  </div> \n"
                                                +"  </div> \n"                                        
                                        );                                        
                                    }else if(i>=6){
                                        if(i<12){
                                          out.println("<div class=\"col-md-2\"><img src=\"src/Untitled-1.png\" class=\"img-fluid\" alt=\"Responsive image sombra \"><p class=\"color-blanco text-center texto-discos\">"+ListaReproducciones.get(i).getNombre()+"</p></div>");  
                                        }                                        
                                    
                                }
                                }
                            %>
				
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
