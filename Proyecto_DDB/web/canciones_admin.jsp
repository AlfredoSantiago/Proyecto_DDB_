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
                        <a class="nav-link text-color-gris active" href="canciones_admin.jsp"><b>Canciones</b></a>	
                        <a class="nav-link text-color-gris" href="artistas_admin.jsp"><b>Artistas</b></a>
                        <a class="nav-link text-color-gris" href="FragmentacionHorizontal.jsp"><b>Fragmentaciónes.</b></a>
                        <li class="nav-link text-color-gris" ><%out.println(u.getNombre());%></li>		 
                    </nav>					    

                </div>				
                <div class="col-md-10 color-azul-fondo">
                    <ul class="nav justify-content-center margen">
                        <li class="nav-item">
                            <a class="nav-link text-color-gris active btn btn-success" href="agregar_cancion.jsp">AGREGAR</a>
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
                                        CancionDAO cDAO = new CancionDAO();
                                    List<Cancion> canciones = cDAO.getCanciones();
                                    for (int i = 0; i < canciones.size(); i++) {
                                    out.println(" <tr>\n"
                                               +" <th scope=\"row\">"+i+"</th>\n"
                                               +" <td><span class=\"text-color-gris\">" + canciones.get(i).getNombre() + "</span></td>\n"
                                               +" <td><p>"+canciones.get(i).getNo_reproducciones()+"</p></td>\n"
                                               +" <td><button type=\"button\" onclick='eliminarCancion("+canciones.get(i).getIdCancion()+")' class=\"btn btn-danger \">ELIMINAR</button>"
                                               + "<a type=\"button\" href='Actualizar?op=2&id=" + canciones.get(i).getIdCancion() + "' class=\"btn btn-warning\">EDITAR</a>"
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