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
                                        <select class="form-control" id="sell" name="relacion" onchange="generarTabla()">
                                            <option value="1">Administrador</option>
                                            <option value="2">Artista</option>
                                            <option value="3">Cancion</option>
                                            <option value="4">Cancion_Artista</option>
                                            <option value="5">Datos Pago </option>
                                            <option value="6">Lista de Reproducción</option>
                                            <option value="7">Usuarios </option>
                                            <option value="8">Cancion_Lista </option>
                                        </select>
                                    </div>
                                    <div id="ctabla" class="card">
                                        <table class='table table-bordered'  id = 'table'> <tr> <th>Atributo 1</th> <th>Atributo 2</th> <th>Atributo 3</th> </tr>
                                            <tr> <td>idAdministrador</td> <td>Codigo</td> <td>idUsuario</td> </tr>  </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <script>
                            function generarTabla() {
                                var x = document.getElementById("sell").value;
                                switch (x) {

                                    case "1":
                                        table = "<table class='table table-bordered'  id = 'table'> <tr> <th>Atributo 1</th> <th>Atributo 2</th> <th>Atributo 3</th> </tr>";
                                        table = table + "<tr> <td>idAdministrador</td> <td>Codigo</td> <td>idUsuario</td> </tr>  </table>";
                                        document.getElementById("ctabla").innerHTML = table;
                                        cont = "<select class=\"form-control\" id='attr' name=\"attr\">\n" +
                                                "                                                    <option value=\"idAdministrador\">idAdministrador</option>\n" +
                                                "                                                    <option value=\"Codigo\">Codigo</option>\n" +
                                                "                                                    <option value=\"idUsuario\">idUsuario</option>\n" +
                                                "                                                </select>";
                                        document.getElementById("attrs").innerHTML = cont;
                                        break;
                                    case "2":
                                        table = "<table class='table table-bordered'  id = 'table'> <tr> <th>Atributo 1</th> <th>Atributo 2</th> <th>Atributo 3</th> </tr>";
                                        table = table + "<tr> <td>idArtista</td> <td>Descripción</td> <td>idUsuario</td> </tr>  </table>";
                                        document.getElementById("ctabla").innerHTML = table;
                                        cont = "<select class=\"form-control\" id='attr' name=\"attr\">\n" +
                                                "                                                    <option value=\"idArtista\">idArtista</option>\n" +
                                                "                                                    <option value=\"Descripcion\">Descripción</option>\n" +
                                                "                                                    <option value=\"idUsuario\">idUsuario</option>\n" +
                                                "                                                </select>";
                                        document.getElementById("attrs").innerHTML = cont;
                                        break;
                                    case "3":
                                        table = "<table class='table table-bordered'  id = 'table'> <tr> <th>Atributo 1</th> <th>Atributo 2</th> <th>Atributo 3</th> <th>Atributo 4</th> <th>Atributo 5</th> <th>Atributo 6</th></tr>";
                                        table = table + "<tr> <td>idCancion</td> <td>Nombre</td> <td>Album</td> <td>Genero</td> <td>No_reproducciones</td> <td>Año</td></tr>  </table>";
                                        document.getElementById("ctabla").innerHTML = table;
                                        cont = "<select class=\"form-control\" id='attr' name=\"attr\">\n" +
                                                "                                                    <option value=\"idCancion\">idCancion</option>\n" +
                                                "                                                    <option value=\"Nombre\">Nombre</option>\n" +
                                                "                                                    <option value=\"Album\">Album</option>\n" +
                                                "                                                    <option value=\"Genero\">Genero</option>\n" +
                                                "                                                    <option value=\"No_reproducciones\">No_Reproducciones</option>\n" +
                                                "                                                    <option value=\"anio\">Año</option>\n" +
                                                "                                                </select>";
                                        document.getElementById("attrs").innerHTML = cont;
                                        break;
                                    case "4":
                                        table = "<table class='table table-bordered'  id = 'table'> <tr> <th>Atributo 1</th> <th>Atributo 2</th> </tr>";
                                        table = table + "<tr> <td>idArtista</td> <td>IdCancion</td> </tr>  </table>";
                                        document.getElementById("ctabla").innerHTML = table;
                                        cont = "<select class=\"form-control\" id='attr' name=\"attr\">\n" +
                                                "                                                    <option value=\"idArtista\">idArtista</option>\n" +
                                                "                                                    <option value=\"idCancion\">idCanción</option>\n" +
                                                "                                                </select>";
                                        document.getElementById("attrs").innerHTML = cont;
                                        break;
                                    case "5":
                                        table = "<table class='table table-bordered'  id = 'table'> <tr> <th>Atributo 1</th> <th>Atributo 2</th> <th>Atributo 3</th> <th>Atributo 4</th> <th>Atributo 5</th> <th>Atributo 6</th><th>Atributo 7</th></tr>";
                                        table = table + "<tr> <td>idDatos</td> <td>Nombre</td> <td>Ap_Paterno</td> <td>Ap_Materno</td> <td>no_tarjeta</td> <td>FechaVenc</td> <td>idUsuario</td></tr>  </table>";
                                        document.getElementById("ctabla").innerHTML = table;
                                        cont = "<select class=\"form-control\" id='attr' name=\"attr\">\n" +
                                                "                                                    <option value=\"idDatos\">idDatos</option>\n" +
                                                "                                                    <option value=\"nombre\">Nombre</option>\n" +
                                                "                                                    <option value=\"Apellido_p\">Ap_Paterno</option>\n" +
                                                "                                                    <option value=\"Apellido_m\">Ap_Materno</option>\n" +
                                                "                                                    <option value=\"noTarjeta\">no_Tarjeta</option>\n" +
                                                "                                                    <option value=\"FechaVenc\">FechaVenc</option>\n" +
                                                "                                                    <option value=\"idUsuario\">idUsuario</option>\n" +
                                                "                                                </select>";
                                        document.getElementById("attrs").innerHTML = cont;
                                        break;
                                    case "6":
                                        table = "<table class='table table-bordered'  id = 'table'> <tr> <th>Atributo 1</th> <th>Atributo 2</th> <th>Atributo 3</th> </tr>";
                                        table = table + "<tr> <td>idLista</td> <td>Nombre</td> <td>idUsuario</td> </tr>  </table>";
                                        document.getElementById("ctabla").innerHTML = table;
                                        cont = "<select class=\"form-control\" id='attr' name=\"attr\">\n" +
                                                "                                                    <option value=\"idLista\">idLista</option>\n" +
                                                "                                                    <option value=\"Nombre\">Nombre</option>\n" +
                                                "                                                    <option value=\"idUsuario\">idUsuario</option>\n" +
                                                "                                                </select>";
                                        document.getElementById("attrs").innerHTML = cont;
                                        break;
                                    case "7":
                                        table = "<table class='table table-bordered'  id = 'table'> <tr> <th>Atributo 1</th> <th>Atributo 2</th> <th>Atributo 3</th> <th>Atributo 4</th> <th>Atributo 5</th> <th>Atributo 6</th><th>Atributo 7</th><th>Atributo 8</th></tr>";
                                        table = table + "<tr> <td>idUsuario</td> <td>Nombre</td> <td>Ap_Paterno</td> <td>Ap_Materno</td> <td>Usuario</td> <td>Contraseña</td> <td>Tipo</td><td>E-mail</td></tr>  </table>";
                                        document.getElementById("ctabla").innerHTML = table;
                                        cont = "<select class=\"form-control\" id='attr' name=\"attr\">\n" +
                                                "                                                    <option value=\"idUsuario\">idUsuario</option>\n" +
                                                "                                                    <option value=\"Nombre\">Nombre</option>\n" +
                                                "                                                    <option value=\"Apellido_p\">Ap_Paterno</option>\n" +
                                                "                                                    <option value=\"Apellido_m\">Ap_Materno</option>\n" +
                                                "                                                    <option value=\"Usuario\">Usuario</option>\n" +
                                                "                                                    <option value=\"Contrasenia\">Contraseña</option>\n" +
                                                "                                                    <option value=\"Tipo\">Tipo</option>\n" +
                                                "                                                    <option value=\"E-mail\">E-mail</option>\n" +
                                                "                                                </select>";
                                        document.getElementById("attrs").innerHTML = cont;
                                        break;
                                    case "8":
                                        table = "<table class='table table-bordered'  id = 'table'> <tr> <th>Atributo 1</th> <th>Atributo 2</th></tr>";
                                        table = table + "<tr> <td>idLista</td> <td>idCancion</td> </tr>  </table>";
                                        document.getElementById("ctabla").innerHTML = table;
                                        cont = "<select class=\"form-control\" id='attr' name=\"attr\">\n" +
                                                "                                                    <option value=\"1\">idLista</option>\n" +
                                                "                                                    <option value=\"2\">idCanción</option>\n" +
                                                "                                                </select>";
                                        document.getElementById("attrs").innerHTML = cont;
                                        break;
                                }
                            }
                        </script>
                        <!--<div class="col-md-8 ">
                            <div id="ctabla" class="card">
                                <table class='table table-bordered'  id = 'table'> <tr> <th>Atributo 1</th> <th>Atributo 2</th> <th>Atributo 3</th> </tr>
                                    <tr> <td>idAdministrador</td> <td>Codigo</td> <td>idUsuario</td> </tr>  </table>
                            </div>
                        </div>-->
                        <div class="col-md-4 ">
                            <div class="card">
                                <div class="card-header">
                                    Generar Predicados Simples.
                                </div>                            
                                <div class="card-body">
                                    <h5 class="card-title">Predicados simples</h5>
                                    <div class="border border-dark secondary rounded" id="predicados" style="width: 400px; height: 125px; overflow: auto;">
                                    </div>
                                    <!--<textarea class="form-control margen-10" rows="3"></textarea>-->
                                    <br><button onclick="generarFM()" type="button" class="btn btn-success">Generar FM</button>
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
                                            <div class="form-group" id="attrs">
                                                <select class="form-control" id="attr" name="attr">
                                                    <option value="idAdministrador">idAdministrador</option>
                                                    <option value="Codigo">Codigo</option>
                                                    <option value="idUsuario">idUsuario</option>
                                                </select>
                                            </div>                                             
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-2">
                                            <p class="card-text">Operador</p>                                            
                                        </div>
                                        <div class="col-md-10">
                                            <div class="form-group">
                                                <select class="form-control" id="operador">
                                                    <option value="<" ><</option>
                                                    <option value=">" >></option>
                                                    <option value="<>" >< ></option>
                                                    <option value="<=" ><=</option>
                                                    <option value=">=" >>=</option>
                                                    <option value="=" >=</option>
                                                </select>
                                            </div>                                             
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-2">
                                            <p class="card-text">Valor.</p>                                            
                                        </div>
                                        <div class="col-md-10">
                                            <input id ="valor" type="text" class="form-control" placeholder="">                                            
                                        </div>
                                    </div>
                                    <div class="row">
                                        <button class="btn btn-dark" onclick="agregar()">Agregar</button>
                                    </div>
                                </div>                   
                            </div>
                        </div>
                        <script>
                            pad = 1, par = 1, pc = 1, pca = 1, pcl = 1, pdp = 1, plr = 1, pu = 1;                               
                            predicadosS = [];  
                            color;
                            function agregar(){
                                //alert('Agregar');
                                var relacion = document.getElementById("sell").value;
                                var atributo = document.getElementById("attr").value;
                                var operador = document.getElementById("operador").value;
                                var valor = document.getElementById("valor").value;
                                //alert(relacion+" "+atributo+" "+operador+" "+valor);
                                var predicadoS = {relacion: relacion, atributo: atributo, operador: operador, valor:valor};
                                predicadosS.push(predicadoS);
                                var i = actualizar(relacion);
                                //alert(color);
                                var v = "<div style='color:"+color+";'>p"+i+": "+atributo+" "+operador+" "+valor+"</div>";
                                $("#predicados").append(v);
                                //document.getElementById("ps") = v +  
                                
                            }
                            function actualizar(relacion){
                                var v ; 
                                switch(relacion){
                                    case "1":
                                        v = pad;
                                        pad++;
                                        color = "#0101DF";
                                        break;
                                    case "2":
                                        v = par;
                                        par++;
                                        color = "#FF0000";
                                        break;
                                    case "3":
                                        v = pc;
                                        pc++;
                                        color = "#DF7401";
                                        break;
                                    case "4":
                                        v = pca;
                                        pca++;
                                        color = "#04B404";
                                        break;
                                    case "5":
                                        v = pcl;
                                        pcl++;
                                        color = "#00FFFF";
                                        break;
                                    case "6":
                                        v = pdp;
                                        pdp++;
                                        color = "#FF00FF";
                                        break;
                                    case "7":
                                        v = plr;
                                        plr++;
                                        color = "#6E6E6E";
                                        break;
                                    case "8":
                                        v = pu;
                                        pu++;
                                        color = "#000000";
                                        break;
                                      
                                }
                                return v;
                            };
                        </script>
                        <div class="col-md-6 ">
                            <div class="card">
                                <div class="card-header">
                                    Fragmentos miniterminos
                                </div>                            
                                <div class="card-body">
                                    <!--<textarea class="form-control margen" rows="3" id="ps"></textarea>-->
                                    <div class="border border-secondary rounded" id="fragmentos" style="width: 400px; height: 125px; overflow: auto;">
                                    </div>
                                    <br><div class="row">
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