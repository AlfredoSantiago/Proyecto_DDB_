
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
            List<DatosPago> datosPago = null;
            UsuarioDAO uDAO = new UsuarioDAO();
            DatosPagoDAO dtDAO = new DatosPagoDAO();
            datosPago = dtDAO.getDatosPagos();
        %>
	<div class="container-fluid">
		<div class="row ">
			<div class="col-md-2 colo2"></div>
			<div class="col-md-2 colo margen-tabLeft" >				
					<nav class="nav flex-column ">
					  <a class="nav-link text-color-gris active" href="spotify.html"><b>Inicio</b></a>
					  <a class="nav-link text-color-gris" href="playlist.html"><b>Tu musica</b></a>
                                          <%               
                                              
                                                 for(int p=0; p<datosPago.size(); p++){
                                                 if(u.equals(datosPago.get(p).getIdUsuario())){
                                                     
                                                 }else{
                                                    out.println("<a class='nav-link text-color-gris' href='premium.jsp'><b>HAZTE PREIUM</b></a>");
                                                 }
                                                }  
                                             
                                            %>
					  <li class="nav-link text-color-gris" ><%out.println(u.getNombre());%></li>	
					  <a class="nav-link text-color-gris" href="#.html"><b>Cerrar sesion</b></a>		 
					</nav>	
                        </div>				
			<div class="col-md-10 ">
			<div class="container top-1000">
                        <form action="Agregar?op=4" method="post">
                            <div class="form-group tam ">
                                <input type="hidden" value='<% out.println(u.getNombre()); %>' name="nombre" class="form-control "  id="exampleInputEmail1"  placeholder="">   
                            </div>
                            <div class="form-group tam ">
                                <input type="hidden" value='<% out.println(u.getApellido_p()); %>' name="ApP" class="form-control"  id="exampleInputEmail1"  placeholder="">   
                            </div>
                            <div class="form-group tam ">
                                <input type="hidden" value='<%out.println(u.getApellido_m());%>' name="ApM" class="form-control"  id="exampleInputEmail1"  placeholder="">   
                            </div>
                            <div class="form-group tam ">
                                <input type="hidden" value='<%out.println(u.getIdUsuario());%>' name="id" class="form-control"   id="exampleInputEmail1"  placeholder="">   
                            </div>
                            <div class="form-group tam ">
                                <input type="text" name="noTarjeta" class="form-control" placeholder="No terjeta">   
                            </div>
                            <div class="form-group">
                                <input type="text" name="fecha" class="form-control" placeholder="Fecha de venciomiento (1995-01-29)">
                            </div>
		  	<center style="padding-top: 30px">
		  		<button type="submit" class="btn btn-success btn-lg btn-block" ><b>HACERTE PREMIUM.</b></button>
		  	</center>
		  	</form>
			</div>
			</div>
		</div>

</body>
</html>