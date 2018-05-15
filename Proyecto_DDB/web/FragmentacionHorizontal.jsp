
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
                        <a class="nav-link text-color-gris" href="FragmentacionHorizontal.jsp"><b>Fragmentaciónes.</b></a>
                        <li class="nav-link text-color-gris" ><%out.println(u.getNombre());%></li>		 
                    </nav>
                </div>	                    
                    <div class="col-md-10 color-cafe-fondo">
			<ul class="nav justify-content-center margen">
                            <li class="nav-item">
                              <a class="nav-link active" href="#">Fragmentación Horizontal</a>
                            </li>
                            <li class="nav-item">
                              <a class="nav-link disabled" href="#">Fragmentación Vertical</a>
                            </li>
                        </ul>                        
                        <div class="row">
                            <div class="col-md-8 ">
                                <div class="card">
                                    <div class="card-header">
                                      Define las condiciones de fragmentación.
                                    </div>                            
                                    <div class="card-body">
                                         <div class="form-group">
                                            <label for="sel1">Select list:</label>
                                            <select class="form-control" id="sel1">
                                              <option>Administrador.</option>
                                              <option>Artista.</option>
                                              <option>Cancion</option>
                                              <option>Cancion Artista</option>
                                              <option>Datos Pago </option>
                                              <option>Lista de Reproducción.</option>
                                              <option>Usuarios </option>
                                            </select>
                                          </div> 
                                    </div>                   
                                </div>
                            </div>
                            <div class="col-md-4 ">
                                <div class="card">
                                    <div class="card-header">
                                     Generar Predicados Simples.
                                    </div>                            
                                    <div class="card-body">
                                        <h5 class="card-title">Predicados simples.</h5>
                                        <textarea class="form-control margen-10" rows="3"></textarea>
                                        <button type="button" class="btn btn-success">Generar FM</button>
                                    </div>                   
                                </div>
                            </div>
                        </div>
                        <div class="row margen-10">
                            <div class="col-md-6 ">
                                <div class="card">
                                    <div class="card-header">
                                      Define los parametros para los predicados simples.
                                    </div>                            
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col-md-2">
                                                <p class="card-text">Atributo.</p>                                            
                                            </div>
                                            <div class="col-md-10">
                                                <div class="form-group">
                                                    <select class="form-control" id="sel1">
                                                      <option>Administrador.</option>
                                                      <option>Artista.</option>
                                                      <option>Cancion</option>
                                                      <option>Cancion Artista</option>
                                                      <option>Datos Pago </option>
                                                      <option>Lista de Reproducción.</option>
                                                      <option>Usuarios </option>
                                                    </select>
                                                </div>                                             
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-2">
                                                <p class="card-text">Operador.</p>                                            
                                            </div>
                                            <div class="col-md-10">
                                                <div class="form-group">
                                                    <select class="form-control" id="sel1">
                                                      <option><</option>
                                                      <option>></option>
                                                      <option>< ></option>
                                                      <option><= </option>
                                                      <option>>=</option>
                                                      <option>=</option>
                                                    </select>
                                                </div>                                             
                                            </div>
                                        </div>
                                        
                                        <div class="row">
                                            <div class="col-md-2">
                                                <p class="card-text">Valor.</p>                                            
                                            </div>
                                            <div class="col-md-10">
                                             <input type="text" class="form-control" placeholder="">                                            
                                            </div>
                                        </div>
                                    </div>                   
                                </div>
                            </div>
                            <div class="col-md-6 ">
                                <div class="card">
                                    <div class="card-header">
                                      Fragmentos miniterminos.
                                    </div>                            
                                    <div class="card-body">                                        
                                        <textarea class="form-control margen" rows="3"></textarea>
                                        <div class="row">
                                            <div class="col-md-2">
                                                <p>Sitio</p>
                                            </div>
                                            <div class="col-md-8">
                                                    <div class="form-group">
                                                        <select class="form-control" id="sel1">
                                                          <option>Hola</option>
                                                        </select>
                                                    </div>                                             
                                                </div>
                                            <div class="col-md-2">
                                            <button type="button" class="btn btn-success">Enviar</button>
                                            </div>
                                        </div>
                                    </div>                   
                                </div>
                            </div>
                        </div>
                    </div>
                    
            </div>	
                    
        </div>

    </body>
</html>