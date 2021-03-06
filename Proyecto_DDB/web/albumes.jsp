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
            List<DatosPago> datosPago = null;
            DatosPagoDAO dtDAO = new DatosPagoDAO();
            datosPago = dtDAO.getDatosPagos();
        %>
       <div class="container-fluid">
		<div class="row ">
			<div class="col-md-2 colo2"></div>
			<div class="col-md-2 colo margen-tabLeft" >				
					<nav class="nav flex-column ">
					  <a class="nav-link text-color-gris active" href="canciones.jsp"><b>Inicio</b></a>
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
			<div class="col-md-10 color-cafe2-fondo">
				<ul class="nav justify-content-center margen">
				  
				  <li class="nav-item">
				    <a class="nav-link text-color-gris" href="canciones.jsp">CANCIONES.</a>
				  </li>
                                  <li class="nav-item">
				    <a class="nav-link text-color-gris active"  href="albumes.jsp">LAS PLAYLIST DE TODOS.</a>
				  </li>
				</ul>
                            <div class="row ">
                                <%  ListaReproduccionDAO lDAO = new  ListaReproduccionDAO();
                                    List <ListaReproduccion> ListasReproduccion = lDAO.getListasReproduccion();
                                    
                                    CancionListaDAO ClDAO = new CancionListaDAO();
                                    CancionDAO Ca = new CancionDAO();
                                    for(int i = 0; i<ListasReproduccion.size(); i++){
                                     List < CancionLista > l = ClDAO.buscarLista(ListasReproduccion.get(i).getIdLista());
                                        if(i<6){
                                             out.println("<div class=\"col-md-2\">"
                                                + "<a href=\"#collapseExample"+i+"\" data-toggle=\"collapse\">"
                                                + "<img src=\"src/Untitled-1.png\" class=\"img-fluid\" alt=\"Responsive image sombra \">"
                                                + "</a>"
                                                + "<p class=\"color-blanco text-center texto-discos\">"+ListasReproduccion.get(i).getNombre()+""
                                                + "</p>"
                                                + "</div>"
                                        +"<div class=\"collapse\" id=\"collapseExample"+i+"\"> \n"
                                        +"<div class=\"card card-body\"> \n"); 
                                             for(int o=0; o<l.size(); o++){
                                       List <Cancion> cn = Ca.buscarCancion(l.get(o).getIdCancion());  
                                       out.println("<ul id=\"playlist\" class=\"list-group list-group-flush tranaparente\"> ");
                                       
                                       for(int t=0; t<cn.size();t++){
                                          out.println("<li class=\"list-group-item tranaparente \">\n");
                                            out.println("<a href=\"Canciones/"+cn.get(t).getIdCancion()+".mp3\"><span>" + cn.get(t).getNombre() + "</span></a>\n");
                                             out.println("</li>"); 
                                               }
                                        
                                       } 
                                             out.println("  </div> \n"
                                                +"  </div> \n"                                        
                                        ); 
                                            
                                        }     
                                    }
                                   
                                    
                                %>
                                </div>
			</div>
		</div>
		<FOOTER>
			<nav class="navbar fixed-bottom navbar-light footer">
				<div class="center">
			  <audio src="" controls id="audioPlayer">
        			Sorry, your browser doesn't support html5!
    			</audio>    
    			</div>			
			</nav>	
		</FOOTER>
	</div>
	<script src="https://code.jquery.com/jquery-2.2.0.js"></script>
    <script src="./js/audioPlayer.js"></script>
    <script>
        audioPlayer();
    </script>
    </body>
</html>