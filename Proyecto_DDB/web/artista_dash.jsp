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
            Artista a = (Artista) session.getAttribute("artista");
            //Administrador a = (Administrador) session.getAttribute("admin");
            //out.println("hola: " + u.getNombre());
        %>
        <div class="container-fluid">
            <div class="row ">
                <div class="col-md-2 colo2"></div>
                <div class="col-md-2 colo margen-tabLeft" >				
                    <nav class="nav flex-column ">
                        <a class="nav-link text-color-gris " href="artista_dash.jsp"><b>Inicio</b></a>
                        <li class="nav-link text-color-gris" ><%out.println(u.getNombre());%></li>
                        <a class="nav-link text-color-gris" href="#.html"><b>Cerrar sesion</b></a>
                    </nav>					    

                </div>				
                <div class="col-md-10 color-azul-fondo">
                    <ul class="nav justify-content-center margen">
                        <li class="nav-item">
                            <a class="nav-link text-color-gris active btn btn-success" href="artista_dash_agregar.jsp">AGREGAR</a>
                        </li>
                    </ul>	
                     <div class="row">
                         <div class="col-md-12">
                             <table class="table table-dark">
                                <thead>
                                  <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Cancion</th>
                                    <th scope="col">No.Reproducciones</th>
                                    <th scope="col">Accion </th>
                                  </tr>
                                </thead>
                                <tbody>
                                    <%
                                    CancionArtistaDAO cDAO = new CancionArtistaDAO();
                                    List<CancionArtista> cancion_artista = cDAO.getListaCancionesArtista(a.getIdArtista());
                                    CancionDAO caDAO = new CancionDAO(); 
                                    for (int i = 0; i < cancion_artista.size(); i++) {
                                        Cancion canciones = caDAO.buscarCancion1(cancion_artista.get(i).getIdCancion());
                                    out.println(" <tr>\n"
                                               +" <th scope=\"row\">"+i+"</th>\n"
                                               +" <td><span class=\"text-color-gris\">" + canciones.getNombre() + "</span></td>\n"
                                               +" <td><p>"+canciones.getNo_reproducciones()+"</p></td>\n"
                                               +" <td><button type=\"button\" onclick='eliminarCancion("+canciones.getIdCancion()+")' class=\"btn btn-danger \">ELIMINAR</button>"
                                               + "<a type=\"button\" href='Actualizar?op=4&id=" + canciones.getIdCancion() + "' class=\"btn btn-warning\">EDITAR</a>"
                                               + "</td>\n"
                                               
                                              +"</tr> ");
                                    
                                    }
                                    

                                    %>
                                    
                                </tbody>
                             </table>
                                    <script>
                                    function eliminarCancion(id) {
                                        if (confirm('¿Estas seguro de querer eliminar la Canción?')) {
                                            //console.log('si');
                                            $.post("Eliminar?op=2&id=" + id, function (data, status) {
                                                window.location = "canciones_admin.jsp";
                                            });
                                        }
                                    }
                                </script> 
                         </div>                             
                     </div>            
                    
                </div>
            </div>
    </body>
</html>