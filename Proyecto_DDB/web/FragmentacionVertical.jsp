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
                            <a class="nav-link disabled" href="FragmentacionHorizontal.jsp">Fragmentación Horizontal</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="FragmentacionVertical.jsp">Fragmentación Vertical</a>
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
                                        cont = "<div class='form-check'>"+
                                                "    <input type='checkbox' id='attr' class='attr' value='idAdministrador'>idAdministrador <br>"+
                                                "    <input type='checkbox' id='attr'  class='attr' value='Codigo'>Codigo <br>"+
                                                "    <input type='checkbox' id='attr'  class='attr' value='idUsuario'>idUsuario <br>"+
                                                "</div> ";                                       
                                        
                                        document.getElementById("attrs").innerHTML = cont;
                                        
                                        break;
                                    case "2":
                                        table = "<table class='table table-bordered'  id = 'table'> <tr> <th>Atributo 1</th> <th>Atributo 2</th> <th>Atributo 3</th> </tr>";
                                        table = table + "<tr> <td>idArtista</td> <td>Descripción</td> <td>idUsuario</td> </tr>  </table>";
                                        document.getElementById("ctabla").innerHTML = table;
                                        cont = "<div class='form-check'>"+
                                                "    <input type='checkbox'  class='attr' value='idArtista'>idArtista <br>"+
                                                "    <input type='checkbox'   class='attr' value='Descripción'>Descripción <br>"+
                                                "    <input type='checkbox'   class='attr' value='idUsuario'>idUsuario <br>"+
                                                "</div> ";  
                                        document.getElementById("attrs").innerHTML = cont;
                                        break;
                                    case "3":
                                        table = "<table class='table table-bordered'  id = 'table'> <tr> <th>Atributo 1</th> <th>Atributo 2</th> <th>Atributo 3</th> <th>Atributo 4</th> <th>Atributo 5</th> <th>Atributo 6</th></tr>";
                                        table = table + "<tr> <td>idCancion</td> <td>Nombre</td> <td>Album</td> <td>Genero</td> <td>No_reproducciones</td> <td>Año</td></tr>  </table>";
                                        document.getElementById("ctabla").innerHTML = table;
                                        cont = "<div class='form-check'>"+
                                                "    <input type='checkbox' id='attr' class='attr' value='idCancion'>idCancion <br>"+
                                                "    <input type='checkbox' id='attr'  class='attr' value='Nombre'>Nombre <br>"+
                                                "    <input type='checkbox' id='attr'  class='attr' value='Album'>Album <br>"+
                                                "    <input type='checkbox' id='attr'  class='attr' value='Genero'>Genero <br>"+
                                                "    <input type='checkbox' id='attr'  class='attr' value='No_reproducciones'>No_reproducciones <br>"+
                                                "    <input type='checkbox' id='attr'  class='attr' value='Año'>Año <br>"+
                                                "</div> "; 
                                        document.getElementById("attrs").innerHTML = cont;
                                        break;
                                    case "4":
                                        table = "<table class='table table-bordered'  id = 'table'> <tr> <th>Atributo 1</th> <th>Atributo 2</th> </tr>";
                                        table = table + "<tr> <td>idArtista</td> <td>IdCancion</td> </tr>  </table>";
                                        document.getElementById("ctabla").innerHTML = table;
                                        cont ="<div class='form-check'>"+
                                                "    <input type='checkbox' id='attr' class='attr' value='idArtista'>idArtista <br>"+
                                                "    <input type='checkbox' id='attr'  class='attr' value='IdCancion'>IdCancion <br>"+
                                                "</div> ";  
                                        document.getElementById("attrs").innerHTML = cont;
                                        break;
                                    case "5":
                                        table = "<table class='table table-bordered'  id = 'table'> <tr> <th>Atributo 1</th> <th>Atributo 2</th> <th>Atributo 3</th> <th>Atributo 4</th> <th>Atributo 5</th> <th>Atributo 6</th><th>Atributo 7</th></tr>";
                                        table = table + "<tr> <td>idDatos</td> <td>Nombre</td> <td>Ap_Paterno</td> <td>Ap_Materno</td> <td>no_tarjeta</td> <td>FechaVenc</td> <td>idUsuario</td></tr>  </table>";
                                        document.getElementById("ctabla").innerHTML = table;
                                        cont = "<div class='form-check'>"+
                                                "    <input type='checkbox' id='attr' class='attr' value='idDatos'>idDatos <br>"+
                                                "    <input type='checkbox' id='attr'  class='attr' value='Nombre'>Nombre <br>"+
                                                "    <input type='checkbox' id='attr'  class='attr' value='Ap_Paterno'>Ap_Paterno <br>"+
                                                "    <input type='checkbox' id='attr'  class='attr' value='Ap_Materno'>Ap_Materno <br>"+
                                                "    <input type='checkbox' id='attr'  class='attr' value='no_tarjeta'>no_tarjeta <br>"+
                                                "    <input type='checkbox' id='attr'  class='attr' value='FechaVenc'>FechaVenc <br>"+
                                                "    <input type='checkbox' id='attr'  class='attr' value='idUsuario'>idUsuario <br>"+
                                                "</div> ";   
                                        document.getElementById("attrs").innerHTML = cont;
                                        break;
                                    case "6":
                                        table = "<table class='table table-bordered'  id = 'table'> <tr> <th>Atributo 1</th> <th>Atributo 2</th> <th>Atributo 3</th> </tr>";
                                        table = table + "<tr> <td>idLista</td> <td>Nombre</td> <td>idUsuario</td> </tr>  </table>";
                                        document.getElementById("ctabla").innerHTML = table;
                                        cont = "<div class='form-check'>"+
                                                "    <input type='checkbox' id='attr' class='attr' value='idAdministrador'>idAdministrador <br>"+
                                                "    <input type='checkbox' id='attr'  class='attr' value='Codigo'>Codigo <br>"+
                                                "    <input type='checkbox' id='attr'  class='attr' value='idUsuario'>idUsuario <br>"+
                                                "</div> ";  
                                        document.getElementById("attrs").innerHTML = cont;
                                        break;
                                    case "7":
                                        table = "<table class='table table-bordered'  id = 'table'> <tr> <th>Atributo 1</th> <th>Atributo 2</th> <th>Atributo 3</th> <th>Atributo 4</th> <th>Atributo 5</th> <th>Atributo 6</th><th>Atributo 7</th><th>Atributo 8</th></tr>";
                                        table = table + "<tr> <td>idUsuario</td> <td>Nombre</td> <td>Ap_Paterno</td> <td>Ap_Materno</td> <td>Usuario</td> <td>Contraseña</td> <td>Tipo</td><td>E-mail</td></tr>  </table>";
                                        document.getElementById("ctabla").innerHTML = table;
                                        cont = "<div class='form-check'>"+
                                                "    <input type='checkbox' id='attr' class='attr' value='idUsuario'>idUsuario <br>"+
                                                "    <input type='checkbox' id='attr'  class='attr' value='Nombre'>Nombre <br>"+
                                                "    <input type='checkbox' id='attr'  class='attr' value='Ap_Paterno'>Ap_Paterno <br>"+
                                                "    <input type='checkbox' id='attr'  class='attr' value='Ap_Materno'>Ap_Materno <br>"+
                                                "    <input type='checkbox' id='attr'  class='attr' value='Usuario'>Usuario <br>"+
                                                "    <input type='checkbox' id='attr'  class='attr' value='Contraseña'>Contraseña <br>"+
                                                "    <input type='checkbox' id='attr'  class='attr' value='Tipo'>Tipo <br>"+
                                                "    <input type='checkbox' id='attr'  class='attr' value='Codigo'>E-mail  <br>"+
                                                "</div> "; 
                                        
                                        document.getElementById("attrs").innerHTML = cont;
                                        break;
                                    case "8":
                                        table = "<table class='table table-bordered'  id = 'table'> <tr> <th>Atributo 1</th> <th>Atributo 2</th></tr>";
                                        table = table + "<tr> <td>idLista</td> <td>idCancion</td> </tr>  </table>";
                                        document.getElementById("ctabla").innerHTML = table;
                                        cont = "<div class='form-check'>"+
                                                "    <input type='checkbox' id='attr' class='attr' value='idLista'>idLista <br>"+
                                                "    <input type='checkbox' id='attr'  class='attr' value='idCancion'>idCancion <br>"+
                                                "</div> ";
                                        document.getElementById("attrs").innerHTML = cont;
                                        break;
                                }
                            }
                        </script>
                        <div class="col-md-4 ">
                            <div class="card">
                                <div class="card-header">
                                    Expresiones Algebraicas..
                                </div>                            
                                <div class="card-body">
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
                                    Seleccionar atributos
                                </div>                            
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-md-3">
                                            <p class="card-text">Atributo.</p>                                            
                                        </div>
                                        <div class="col-md-9">
                                            <div id="attrs">
                                                <div class="form-check">
                                                    <input type="checkbox" id="attr" class="attr" value="idAdministrador">idAdministrador <br>
                                                    <input type="checkbox" id="attr"  class="attr" value="Codigo">Codigo <br>
                                                    <input type="checkbox" id="attr"  class="attr" value="idUsuario">idUsuario <br>
                                                </div> 
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <button class="btn btn-dark" onclick="agregar();return false">Generar Expresión </button>
                                    </div>
                                </div>                   
                            </div>
                        </div>
                        <script>

                            pad = 1, par = 1, pc = 1, pca = 1, pcl = 1, pdp = 1, plr = 1, pu = 1;
                            mad = 1, mar = 1, mc = 1, mca = 1, mcl = 1, mdp = 1, mlr = 1, mu = 1;
                            predicadosS = [];
                            predicados_1 = "";
                            predicados_2 = "";
                            color = "";
                            predicadosM = [];
                            minitermino_m = "";
                            checks = [];  
                            total=0;
                            var checkedValue;                             
                            function agregar() {                                          
                             
                                var inputElements = document.getElementsByClassName('attr');
                                var relacion = document.getElementById("sell").value;
                                alert(relacion);
                                for(var i=0; inputElements[i]; ++i){
                                      if(inputElements[i].checked=== true){
                                          if(i===0){
                                                checkedValue = inputElements[i].value;
                                           }else{
                                               checkedValue += ","+inputElements[i].value ;
                                           }
                                       
                                      }
                                }
                                total+=1;
                                var v = "<div id='" + relacion + "" + i + "' style='color:" + color + ";' onclick = 'seleccionar(" + relacion + ", " + i +")'>p" + total + ": " + checkedValue.toString() + "</div>";
                                        $("#predicados").append(v);
                            }
                            
                            function seleccionar(relacion, i) {
                                var id = relacion + "" + i;
                                alert(id);
                                if (predicados_1 === id) {
                                    if (predicados_1 === id) {
                                        predicados_1 = "";
                                    } 
                                    document.getElementById(id).style.backgroundColor = "#FFFFFF";
                                } else {
                                    if (predicados_1 === "") {
                                        predicados_1 = id;
                                    }
                                    document.getElementById(id).style.backgroundColor = "#A9BCF5";
                                }

                            }
                            
                         

                            
                            function enviar(){
                                var sitio = document.getElementById("sitio").value;
                                alert("sitio: "+sitio+"  id: "+minitermino_m);
                                var minitermino = buscarMinitermino(minitermino_m);
                                alert("relacion=" + minitermino.relacion + "&atributo_1=" + minitermino.atributo_1 + "&operador_1=" + minitermino.operador_1 + "&valor_1=" + minitermino.valor_1 + "&atributo_2=" + minitermino.atributo_2 + "&operador_2=" + minitermino.operador_2 + "&valor_2=" + minitermino.valor_2+"&sitio="+sitio);
                                $.post("Fragmentacion?op=3&relacion=" + minitermino.relacion + "&atributo_1=" + minitermino.atributo_1 + "&operador_1=" + minitermino.operador_1 + "&valor_1=" + minitermino.valor_1 + "&atributo_2=" + minitermino.atributo_2 + "&operador_2=" + minitermino.operador_2 + "&valor_2=" + minitermino.valor_2+"&sitio="+sitio, function (data, status) {
                                    alert("respuesta del servidor: " + data);
                                    if (data === "1") {
                                        alert("Se envio correctamente al sitio 1");
                                    }
                                });
                            }
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
                                                <select class="form-control" id="sitio">
                                                    <option value="1">Sitio 1</option>
                                                    <option value="2">Sitio 2</option>
                                                    <option value="3">Sitio 3</option>
                                                </select>
                                            </div>                                             
                                        </div>
                                        <div class="col-md-2">
                                            <button onclick="enviar()" type="button" class="btn btn-success">Enviar</button>
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